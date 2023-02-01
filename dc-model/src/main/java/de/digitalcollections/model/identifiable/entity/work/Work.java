package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.IdentifiableObjectType;
import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.semantic.Subject;
import de.digitalcollections.model.text.Title;
import de.digitalcollections.model.time.LocalDateRange;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
  private List<Work> parents;
  private List<EntityRelation> relations;
  private Set<Subject> subjects;
  private List<Title> titles;

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

  public List<Work> getParents() {
    return parents;
  }

  public List<EntityRelation> getRelations() {
    return relations;
  }

  public Set<Subject> getSubjects() {
    return subjects;
  }

  public List<Title> getTitles() {
    return titles;
  }

  @Override
  protected void init() {
    super.init();
    if (creators == null) {
      this.creators = new ArrayList<>(0);
    }
    identifiableObjectType = IdentifiableObjectType.WORK;
    if (titles == null) {
      titles = new ArrayList<>();
    }
    if (relations == null) {
      relations = new ArrayList<>();
    }
    if (subjects == null) {
      subjects = new HashSet<>();
    }
  }

  public void addCreator(Agent creator) {
    if (this.creators == null) {
      this.creators = new ArrayList<>();
    }
    this.creators.add(creator);
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

  public void setParents(List<Work> parents) {
    this.parents = parents;
  }

  public void setRelations(List<EntityRelation> relations) {
    this.relations = relations;
  }

  public void setSubjects(Set<Subject> subjects) {
    this.subjects = subjects;
  }

  /**
   * Sets the label, not one of the titles!
   *
   * @param title the label string
   */
  public void setTitle(String title) {
    setLabel(title);
  }

  public void setTitles(List<Title> titles) {
    this.titles = titles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Work)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Work work = (Work) o;
    return Objects.equals(creationDateRange, work.creationDateRange)
        && Objects.equals(creationTimeValue, work.creationTimeValue)
        && Objects.equals(creators, work.creators)
        && Objects.equals(firstAppearedDate, work.firstAppearedDate)
        && Objects.equals(firstAppearedDatePresentation, work.firstAppearedDatePresentation)
        && Objects.equals(firstAppearedTimeValue, work.firstAppearedTimeValue)
        && Objects.equals(parents, work.parents)
        && Objects.equals(relations, work.relations)
        && Objects.equals(subjects, work.subjects)
        && Objects.equals(titles, work.titles);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        creationDateRange,
        creationTimeValue,
        creators,
        firstAppearedDate,
        firstAppearedDatePresentation,
        firstAppearedTimeValue,
        parents,
        relations,
        subjects,
        titles);
  }

  @Override
  public String toString() {
    return "Work{"
        + "creationDateRange="
        + creationDateRange
        + ", creationTimeValue="
        + creationTimeValue
        + ", creators="
        + creators
        + ", firstAppearedDate="
        + firstAppearedDate
        + ", firstAppearedDatePresentation='"
        + firstAppearedDatePresentation
        + '\''
        + ", firstAppearedTimeValue="
        + firstAppearedTimeValue
        + ", parents="
        + parents
        + ", relations="
        + relations
        + ", subjects="
        + subjects
        + ", titles="
        + titles
        + ", customAttributes="
        + customAttributes
        + ", navDate="
        + navDate
        + ", refId="
        + refId
        + ", notes="
        + notes
        + ", description="
        + description
        + ", identifiableObjectType="
        + identifiableObjectType
        + ", identifiers="
        + identifiers
        + ", label="
        + label
        + ", localizedUrlAliases="
        + localizedUrlAliases
        + ", previewImage="
        + previewImage
        + ", previewImageRenderingHints="
        + previewImageRenderingHints
        + ", tags="
        + tags
        + ", type="
        + type
        + ", created="
        + created
        + ", lastModified="
        + lastModified
        + ", uuid="
        + uuid
        + '}';
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
