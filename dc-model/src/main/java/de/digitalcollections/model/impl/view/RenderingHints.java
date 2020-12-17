package de.digitalcollections.model.impl.view;

/** Contains hints for rendering a webpage */
public class RenderingHints {
  /** Defines if an in-page navigation (a TOC) is rendered */
  private boolean showInPageNavigation;

  /** Defines the name of the template to use for rendering */
  private String templateName;

  public boolean isShowInPageNavigation() {
    return showInPageNavigation;
  }

  public String getTemplateName() {
    return templateName;
  }

  public void setShowInPageNavigation(boolean showInPageNavigation) {
    this.showInPageNavigation = showInPageNavigation;
  }

  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }
}
