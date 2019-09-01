package com.hireguide.service.Impl;

import com.hireguide.exception.ResumeServiceException;

import com.hireguide.model.HireGuideDetail;
import com.hireguide.model.Page;
import com.hireguide.repository.HireGuideRepository;
import com.hireguide.service.ResumeService;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import sun.security.krb5.internal.PAData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {


  @Autowired
  HireGuideRepository hireGuideRepository;


  @Override
  public HireGuideDetail readPDF(byte[] pdfContent) throws ResumeServiceException {
    HireGuideDetail hgd= null;
    List<Page> pages = new ArrayList<Page>();
    try {
      PDDocument document = PDDocument.load(pdfContent);
      String location = "";
      String mobile = "";
      String email = "";
      for (int i = 0; i < document.getPages().getCount(); i++) {
        PDFTextStripper reader = new PDFTextStripper();
        reader.setStartPage(i);
        reader.setEndPage(i);
        reader.getParagraphStart();
        reader.getParagraphEnd();
        String pageContent = reader.getText(document);
        if (i == 1) {
          String[] lines = pageContent.split(System.getProperty("line.separator"));
          location = lines[getLineNumberWithFilter(lines, "Location")];
          mobile = lines[getLineNumberWithFilter(lines, "Mobile")];
          email = lines[getLineNumberWithFilter(lines, "Email")];
        }

        pages.add(new Page(pageContent));
      }
      System.out.println(pages.size());
      hgd = new HireGuideDetail(mobile, email, location, pages);
      hireGuideRepository.save(hgd);
    } catch (IOException ex) {
      throw new ResumeServiceException("ResumeServiceImpl[readPDF]:Error while reading pdf: ", ex);
    }

    return hgd;
  }

  private String getLine(String[] lines, int n) {
    return lines[n];
  }

  private int getLineNumberWithFilter(String[] lines, String filter) {
    int n = 0;
    for (String line : lines) {
      if (line.indexOf(filter) != -1) {
        return n;
      }
      n++;
    }
    return 0;
  }


  @Override
  public void processPDF() throws ResumeServiceException {

  }

  @Override
  public void writePDF() throws ResumeServiceException {

  }
}
