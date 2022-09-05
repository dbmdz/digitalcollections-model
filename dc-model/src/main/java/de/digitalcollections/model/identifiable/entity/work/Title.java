package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Title {

  private LocalizedText text;
  private LocalizedText textOriginalScript;
  private TitleType titleType;

  public Title() {}

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

  public void setText(LocalizedText text) {
    this.text = text;
  }

  public void setTextOriginalScript(LocalizedText textOriginalScript) {
    this.textOriginalScript = textOriginalScript;
  }

  public void setTitleType(TitleType titleType) {
    this.titleType = titleType;
  }
}
