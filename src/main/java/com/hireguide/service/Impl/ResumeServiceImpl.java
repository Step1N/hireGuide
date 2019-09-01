package com.hireguide.service.Impl;

import com.hireguide.exception.ResumeServiceException;

import com.hireguide.service.ResumeService;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResumeServiceImpl implements ResumeService {


  @Override
  public void readPDF(byte[] pdfContent) throws ResumeServiceException {
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
          String mobile = lines[getLineNumberWithFilter(lines, "Mobile")];
          System.out.println("Phone Number Found:" + mobile);
          String email = lines[getLineNumberWithFilter(lines, "Email")];
          System.out.println("Email Found:" + email);
          System.out.println("Mobile:" + location);
        }
        System.out.println("\n\n\n");
        System.out.println(pageContent + "\n");
      }
    } catch (IOException ex) {
      throw new ResumeServiceException("ResumeServiceImpl[readPDF]:Error while reading pdf: ", ex);
    }

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
