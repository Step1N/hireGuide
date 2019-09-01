package com.hireguide.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import com.hireguide.dto.PDFScanDTO;
import com.hireguide.exception.ResumeServiceException;
import com.hireguide.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ResumeController {

  @Autowired
  ResumeService resumeService;

  org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ResumeService.class);

  private final Path resumePathValidator = null;

  @PostMapping("/scanPDFResume")
  public PDFScanDTO scanPDFResume(@RequestParam("file") MultipartFile file) {
    logger.trace("Entering ResumeController.scanPDF()");
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    try {

      resumeService.readPDF(file.getBytes());
    } catch (IOException ex) {
      logger.error("ResumeController[scanPDFResume]: Error while reading resume pdf");
      throw new ResumeServiceException("ResumeController[scanPDFResume]:Error while reading resume " + fileName + ".", ex);
    }

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(fileName)
        .toUriString();

    return new PDFScanDTO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
  }

  @PostMapping("/scanPDFResumes")
  public List<PDFScanDTO> scanPDFResumes(@RequestParam("files") MultipartFile[] files) {
    return Arrays.asList(files)
        .stream()
        .map(file -> scanPDFResume(file))
        .collect(Collectors.toList());
  }

}
