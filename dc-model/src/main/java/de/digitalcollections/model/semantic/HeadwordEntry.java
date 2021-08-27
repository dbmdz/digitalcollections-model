package de.digitalcollections.model.semantic;

import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.EntityType;

/**
 * The textual body to a specified headword (encyclopedia) or lemma (dictionary).
 *
 * <p>"A headword, lemma, or catchword is the word under which a set of related dictionary or
 * encyclopaedia entries appears. The headword is used to locate the entry, and dictates its
 * alphabetical position. Depending on the size and nature of the dictionary or encyclopedia, the
 * entry may include alternative meanings of the word, its etymology, pronunciation and inflections,
 * compound words or phrases that contain the headword, and encyclopedic information about the
 * concepts represented by the word." (Wikipedia, https://en.wikipedia.org/wiki/Headword)
 *
 * @see Headword
 */
public class HeadwordEntry extends Article {

  private Headword headword;

  public HeadwordEntry() {
    super();
    this.entityType = EntityType.HEADWORD_ENTRY;
  }

  public HeadwordEntry(Headword headword) {
    this();
    this.headword = headword;
  }

  public Headword getHeadword() {
    return headword;
  }

  public void setHeadword(Headword headword) {
    this.headword = headword;
  }
}
