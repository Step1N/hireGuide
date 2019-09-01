package com.hireguide.service;

import com.hireguide.exception.ResumeServiceException;
import com.hireguide.model.HireGuideDetail;

public interface ResumeService {

  /**
   * To Read pdfContent
   * @param pdfContent
   * @throws ResumeServiceException
   */
  HireGuideDetail readPDF(byte[] pdfContent) throws ResumeServiceException;

  void processPDF() throws ResumeServiceException;

  void writePDF() throws ResumeServiceException;

}
