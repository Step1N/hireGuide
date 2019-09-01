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

import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {


  @Autowired
  HireGuideRepository hireGuideRepository;


  @Override
  public HireGuideDetail readPDF(byte[] pdfContent) throws ResumeServiceException {
    HireGuideDetail hgd = new HireGuideDetail();
    try {
      PDDocument document = PDDocument.load(pdfContent);
      for (int i = 0; i < document.getPages().getCount(); i++) {
        PDFTextStripper reader = new PDFTextStripper();
        reader.setStartPage(i);
        reader.setEndPage(i);
        reader.getParagraphStart();
        reader.getParagraphEnd();
        String pageContent = reader.getText(document);
        if (i == 1) {
          String[] lines = pageContent.split(System.getProperty("line.separator"));
          String location = lines[getLineNumberWithFilter(lines, "Location")];
          hgd.setName(location);
          String mobile = lines[getLineNumberWithFilter(lines, "Mobile")];
          hgd.setContactNumber(mobile);
          String email = lines[getLineNumberWithFilter(lines, "Email")];
          hgd.setEmail(email);
        }
        hgd.getPages().add(new Page(pageContent));
        hireGuideRepository.save(hgd);
      }
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
