package com.hireguide.service;

import com.hireguide.exception.ResumeServiceException;

public interface ResumeService {

  /**
   * To Read pdfContent
   * @param pdfContent
   * @throws ResumeServiceException
   */
  void readPDF(byte[] pdfContent) throws ResumeServiceException;

  void processPDF() throws ResumeServiceException;

  void writePDF() throws ResumeServiceException;

}
