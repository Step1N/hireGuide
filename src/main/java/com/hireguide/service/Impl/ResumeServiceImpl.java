package com.hireguide.service.Impl;

import com.hireguide.exception.ResumeServiceException;

import com.hireguide.service.ResumeService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import java.awt.geom.Rectangle2D;
import java.io.IOException;

@Service
public class ResumeServiceImpl implements ResumeService {


  @Override
  public void readPDF(byte[] pdfContent) throws ResumeServiceException {
    try {
      PDDocument document = PDDocument.load(pdfContent);
      for (int i = 0; i < document.getPages().getCount(); i++) {
        System.out.println("Paras on Page " + i + ": \n\n\n\n");
        PDFTextStripperByArea pdfStripperByRegion = new PDFTextStripperByArea();
        Rectangle2D rec = new Rectangle2D.Double(0, 0, 800, 100);
        pdfStripperByRegion.addRegion("title", rec);
        Rectangle2D rec1 = new Rectangle2D.Double(0, 100, 800, 30);
        pdfStripperByRegion.addRegion("contact", rec1);
        Rectangle2D rec2 = new Rectangle2D.Double(0, 130, 800, 120);
        pdfStripperByRegion.addRegion("profileSummary", rec2);
        Rectangle2D rec3 = new Rectangle2D.Double(0, 250, 800, 220);
        pdfStripperByRegion.addRegion("academic", rec3);
        Rectangle2D rec4 = new Rectangle2D.Double(0, 470, 800, 300);
        pdfStripperByRegion.addRegion("experience", rec4);
        Rectangle2D rec5 = new Rectangle2D.Double(0, 770, 800, 300);
        pdfStripperByRegion.addRegion("achievements", rec5);
        pdfStripperByRegion.extractRegions(document.getPages().get(i));
        for (String pr : pdfStripperByRegion.getRegions()) {
          System.out.println("Region : " + pr + ": \n" + pdfStripperByRegion.getTextForRegion(pr) + "\n\n");
        }
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
