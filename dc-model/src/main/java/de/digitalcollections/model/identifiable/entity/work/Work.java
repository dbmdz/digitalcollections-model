package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.text.LocalizedText;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
public class Work extends Entity {

  private List<Agent> creators = new ArrayList<>();
  private LocalDate datePublished;
  private TimeValue timeValuePublished;

  public Work() {
    super();
    this.entityType = EntityType.WORK;
  }

  public List<Agent> getCreators() {
    return creators;
  }

  public LocalDate getDatePublished() {
    return datePublished;
  }

  public TimeValue getTimeValuePublished() {
    return timeValuePublished;
  }

  public LocalizedText getTitle() {
    return getLabel();
  }

  public void setCreators(List<Agent> creators) {
    this.creators = creators;
  }

  public void setDatePublished(LocalDate datePublished) {
    this.datePublished = datePublished;
  }

  public void setTimeValuePublished(TimeValue timeValuePublished) {
    this.timeValuePublished = timeValuePublished;
  }

  public void setTitle(LocalizedText title) {
    setLabel(title);
  }

  public void setTitle(String title) {
    setLabel(title);
  }
}
