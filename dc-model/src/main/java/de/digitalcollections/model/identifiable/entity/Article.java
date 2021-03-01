package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/** Article is used to manage cultural articles and their hierarchy. */
public class Article extends Entity {

  private List<Agent> creators = new ArrayList<>();
  private LocalDate datePublished;
  private LocalizedStructuredContent text;
  private TimeValue timeValuePublished;

  public Article() {
    super();
    this.entityType = EntityType.ARTICLE;
  }

  public List<Agent> getCreators() {
    return creators;
  }

  public LocalDate getDatePublished() {
    return datePublished;
  }

  public LocalizedStructuredContent getText() {
    return text;
  }

  public TimeValue getTimeValuePublished() {
    return timeValuePublished;
  }

  public void setCreators(List<Agent> creators) {
    this.creators = creators;
  }

  public void setDatePublished(LocalDate datePublished) {
    this.datePublished = datePublished;
  }

  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  public void setTimeValuePublished(TimeValue timeValuePublished) {
    this.timeValuePublished = timeValuePublished;
  }
}
