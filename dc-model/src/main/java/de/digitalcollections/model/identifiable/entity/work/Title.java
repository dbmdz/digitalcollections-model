package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Title {

  private LocalizedText text;
  private LocalizedText textOriginalScript;
  private TitleType titleType;

  public Title() {
    init();
  }

  public Title(LocalizedText text, LocalizedText textOriginalScript, TitleType titleType) {
    this();
    this.text = text;
    this.textOriginalScript = textOriginalScript;
    this.titleType = titleType;
  }

  public LocalizedText getText() {
    return text;
  }

  public LocalizedText getTextOriginalScript() {
    return textOriginalScript;
  }

  public TitleType getTitleType() {
    return titleType;
  }

  protected void init() {}

  public void setText(LocalizedText text) {
    this.text = text;
  }

  public void setTextOriginalScript(LocalizedText textOriginalScript) {
    this.textOriginalScript = textOriginalScript;
  }

  public void setTitleType(TitleType titleType) {
    this.titleType = titleType;
  }

  public abstract static class TitleBuilder<C extends Title, B extends TitleBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }
  }
}
