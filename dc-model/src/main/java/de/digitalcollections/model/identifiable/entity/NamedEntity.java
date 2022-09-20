package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import java.util.Set;

public interface NamedEntity {

  LocalizedText getName();

  void setName(LocalizedText name);

  Set<Locale> getNameLocalesOfOriginalScript();

  void setNameLocalesOfOriginalScript(Set<Locale> locales);
}
