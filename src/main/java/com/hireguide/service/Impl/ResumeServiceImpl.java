package com.hireguide.service.Impl;

import com.hireguide.exception.ResumeServiceException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import com.hireguide.service.ResumeService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {


  @Override
  public void readPDF(byte[] pdfContent) throws ResumeServiceException {

    PdfReader pdfReader = null;
    try {
      pdfReader = new PdfReader(pdfContent);
      int pages = pdfReader.getNumberOfPages();
      for (int i = 1; i <= pages; i++) {
        String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
        System.out.println("Content on Page " + i + ": " + pageContent);
      }
    } catch (IOException ex) {
      throw new ResumeServiceException("ResumeServiceImpl[readPDF]:Error while reading pdf: ", ex);
    }

  }

  @Override
  public void processPDF() throws ResumeServiceException {

  }

  @Override
  public void writePDF() throws ResumeServiceException {

  }
}
