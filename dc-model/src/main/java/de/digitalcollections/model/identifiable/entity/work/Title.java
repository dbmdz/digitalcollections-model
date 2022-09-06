package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Title)) {
      return false;
    }
    Title title = (Title) o;
    return Objects.equals(text, title.text)
        && Objects.equals(textOriginalScript, title.textOriginalScript)
        && Objects.equals(titleType, title.titleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, textOriginalScript, titleType);
  }

  @Override
  public String toString() {
    return "Title{"
        + "text="
        + text
        + ", textOriginalScript="
        + textOriginalScript
        + ", titleType="
        + titleType
        + '}';
  }
}
