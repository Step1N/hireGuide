package com.hireguide.service.Impl;

import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class FontRenderFilter extends RenderFilter {

  public boolean allowText(TextRenderInfo renderInfo) {
    String font = renderInfo.getFont().getPostscriptFontName();
    return font.endsWith("Bold");
  }
}
