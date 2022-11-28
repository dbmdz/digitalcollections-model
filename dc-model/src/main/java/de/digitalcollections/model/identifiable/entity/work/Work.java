package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.IdentifiableObjectType;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.manifestation.Title;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.time.LocalDateRange;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.SuperBuilder;
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
@SuperBuilder(buildMethodName = "prebuild")
public class Work extends Entity {

  private LocalDateRange creationDateRange;
  private TimeValue creationTimeValue;
  private List<Agent> creators;
  private LocalDate firstAppearedDate;
  private String firstAppearedDatePresentation;
  private TimeValue firstAppearedTimeValue;
  private List<EntityRelation> relations;
  private List<Title> titles;
  protected WorkType workType;

  public Work() {
    super();
  }

  public LocalDateRange getCreationDateRange() {
    return creationDateRange;
  }

  public TimeValue getCreationTimeValue() {
    return creationTimeValue;
  }

  public List<Agent> getCreators() {
    return creators;
  }

  public LocalDate getFirstAppearedDate() {
    return firstAppearedDate;
  }

  public String getFirstAppearedDatePresentation() {
    return firstAppearedDatePresentation;
  }

  public TimeValue getFirstAppearedTimeValue() {
    return firstAppearedTimeValue;
  }

  public List<EntityRelation> getRelations() {
    return relations;
  }

  public List<Title> getTitles() {
    return titles;
  }

  public WorkType getWorkType() {
    return workType;
  }

  @Override
  protected void init() {
    super.init();
    workType = WorkType.SINGLE; // default type
    if (creators == null) {
      this.creators = new ArrayList<>(0);
    }
    identifiableObjectType = IdentifiableObjectType.WORK;
  }

  public void setCreationDateRange(LocalDateRange creationDateRange) {
    this.creationDateRange = creationDateRange;
  }

  public void setCreationTimeValue(TimeValue timeValueCreation) {
    this.creationTimeValue = timeValueCreation;
  }

  public void setCreators(List<Agent> creators) {
    this.creators = creators;
  }

  public void setFirstAppearedDate(LocalDate firstAppearedDate) {
    this.firstAppearedDate = firstAppearedDate;
  }

  public void setFirstAppearedDatePresentation(String firstAppearedDatePresentation) {
    this.firstAppearedDatePresentation = firstAppearedDatePresentation;
  }

  public void setFirstAppearedTimeValue(TimeValue firstAppearedTimeValue) {
    this.firstAppearedTimeValue = firstAppearedTimeValue;
  }

  public void setRelations(List<EntityRelation> relations) {
    this.relations = relations;
  }

  public void setTitle(String title) {
    setLabel(title);
  }

  public void setTitles(List<Title> titles) {
    this.titles = titles;
  }

  public void setWorkType(WorkType workType) {
    this.workType = workType;
  }

  public abstract static class WorkBuilder<C extends Work, B extends WorkBuilder<C, B>>
      extends EntityBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.init();
      setInternalReferences(c);
      return c;
    }

    public B creator(Agent creator) {
      if (creators == null) {
        creators = new ArrayList<>(1);
      }
      creators.add(creator);
      return self();
    }

    public B relation(EntityRelation relation) {
      if (relations == null) {
        relations = new ArrayList<>(1);
      }
      relations.add(relation);
      return self();
    }

    public B title(Title title) {
      if (titles == null) {
        titles = new ArrayList<>(1);
      }
      titles.add(title);
      return self();
    }
  }
}
