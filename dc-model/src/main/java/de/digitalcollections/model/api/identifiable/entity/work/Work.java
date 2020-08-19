package de.digitalcollections.model.api.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.api.identifiable.entity.agent.Agent;
import de.digitalcollections.model.api.identifiable.parts.LocalizedText;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/**
 * From https://web.library.yale.edu/cataloging/music/frbr-wemi-music#work:
 *
 * <p>A work is realized by an expression, which is embodied in a manifestation, which is
 * exemplified by an item.
 *
 * <p>A Work is an abstract idea or distinct intellectual creation that is created by a person or
 * corporate body. "A work is defined as a 'distinct intellectual or artistic creation,' is an
 * abstract entity in that there is no single physically or linguistically fixed object representing
 * that work. Rather, a work is the artistic and intellectual commonality of one or more resources
 * as they are multiplied through translation, abridgment, revision, or any other process which does
 * not substantially alter core content."
 *
 * <p>Attributes of a work: title, date, identifier (if it has one), intended audience, form of
 * work, medium of performance, numeric designation, key, etc.
 *
 * <p>°Author or composer is not an attribute for work or expression, because such information is
 * treated in FRBR as a relationship between the work or expression and a person or corporate body."
 *
 * <p>Die Zauberflöte by Mozart and J.S. Bach's Goldberg variations, apart from all ways of
 * expressing them, are works.
 */
public interface Work extends Entity {

  List<Agent> getCreators();

  void setCreators(List<Agent> creators);

  LocalDate getDatePublished();

  void setDatePublished(LocalDate datePublished);

  TimeValue getTimeValuePublished();

  void setTimeValuePublished(TimeValue timeValuePublished);

  default LocalizedText getTitle() {
    return getLabel();
  }

  default void setTitle(LocalizedText title) {
    setLabel(title);
  }

  default void setTitle(String title) {
    setLabel(new LocalizedTextImpl(Locale.ROOT, title));
  }
}
