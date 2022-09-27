package de.digitalcollections.model.identifiable.agent;

import de.digitalcollections.model.identifiable.Identifiable;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.Identifier;
import de.digitalcollections.model.text.LocalizedText;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * see Wikidata https://www.wikidata.org/wiki/Q101352: "Part of a naming scheme for individuals,
 * used in many cultures worldwide."
 */
public class FamilyName extends Identifiable {

  LocalizedText name;
  List<Locale> nameÓriginalScriptLocales;

  public FamilyName() {
    super();
    init();
  }

  public FamilyName(LocalizedText label, Set<Identifier> identifiers) {
    this();
    this.label = label;
    getIdentifiers().addAll(identifiers);
  }

  @Override
  protected void init() {
    super.init();
    this.type = IdentifiableType.RESOURCE;
  }
}
