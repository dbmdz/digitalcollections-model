package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.text.LocalizedText;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import lombok.experimental.SuperBuilder;

@SuperBuilder(buildMethodName = "prebuild")
public class Title {

  private LocalizedText text;
  private Set<Locale> textLocalesOfOriginalScript;
  private TitleType titleType;

  public Title() {
    init();
  }

  public Title(LocalizedText text, Set<Locale> textLocalesOfOriginalScript, TitleType titleType) {
    this();
    this.text = text;
    this.textLocalesOfOriginalScript = textLocalesOfOriginalScript;
    this.titleType = titleType;
  }

  protected void init() {
    if (textLocalesOfOriginalScript == null) {
      textLocalesOfOriginalScript = new HashSet<>(0);
    }
  }

  public LocalizedText getText() {
    return text;
  }

  public Set<Locale> getTextLocalesOfOriginalScript() {
    return textLocalesOfOriginalScript;
  }

  public TitleType getTitleType() {
    return titleType;
  }

  public void setText(LocalizedText text) {
    this.text = text;
  }

  public void setTextLocalesOfOriginalScript(Set<Locale> textLocalesOfOriginalScript) {
    this.textLocalesOfOriginalScript = textLocalesOfOriginalScript;
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
        && Objects.equals(textLocalesOfOriginalScript, title.textLocalesOfOriginalScript)
        && Objects.equals(titleType, title.titleType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text, textLocalesOfOriginalScript, titleType);
  }

  @Override
  public String toString() {
    return "Title{"
        + "text="
        + text
        + ", textLocalesOfOriginalScript="
        + textLocalesOfOriginalScript
        + ", titleType="
        + titleType
        + '}';
  }

  public abstract static class TitleBuilder<C extends Title, B extends TitleBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    public B textLocalesOfOriginalScript(Locale locale) {
      if (locale == null) {
        return self();
      }

      if (textLocalesOfOriginalScript == null) {
        textLocalesOfOriginalScript = new HashSet<>(1);
      }
      textLocalesOfOriginalScript.add(locale);
      return self();
    }
  }
}
