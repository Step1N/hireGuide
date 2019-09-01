package com.hireguide.service.Impl;

import com.itextpdf.text.pdf.parser.*;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

public class TextAsPara implements TextExtractionStrategy {

  private StringBuilder result = new StringBuilder();
  private Vector lastBaseLine;

  private List<String> strings = new ArrayList<>();
  private List<Float> baselines = new ArrayList<Float>();


  @Override
  public String getResultantText() {
    if (!Strings.isBlank(this.result.toString())) {
      this.baselines.add(this.lastBaseLine.get(Vector.I2));
      this.strings.add(this.result.toString());
    }
    return null;
  }

  @Override
  public void beginTextBlock() {

  }

  @Override
  public void renderText(TextRenderInfo renderInfo) {
    Vector curBaseline = renderInfo.getBaseline().getStartPoint();
    if ((this.lastBaseLine != null) && (curBaseline.get(Vector.I2) != lastBaseLine.get(Vector.I2))) {
      if (!Strings.isBlank(this.result.toString())) {
        this.baselines.add(this.lastBaseLine.get(Vector.I2));
        this.strings.add(this.result.toString());
      }
      this.result.setLength(0);
    }
    this.result.append(renderInfo.getText());
    this.lastBaseLine = curBaseline;
  }

  @Override
  public void endTextBlock() {

  }

  @Override
  public void renderImage(ImageRenderInfo imageRenderInfo) {

  }
}
