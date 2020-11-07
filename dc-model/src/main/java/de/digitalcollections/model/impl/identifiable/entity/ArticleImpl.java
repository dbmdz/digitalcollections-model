package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.agent.Agent;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

public class ArticleImpl extends EntityImpl implements Article<Article> {

  private List<Agent> creators = new ArrayList<>();
  private LocalDate datePublished;
  private LocalizedStructuredContent text;
  private TimeValue timeValuePublished;

  public ArticleImpl() {
    super();
    this.entityType = EntityType.ARTICLE;
  }

  @Override
  public List<Agent> getCreators() {
    return creators;
  }

  @Override
  public LocalDate getDatePublished() {
    return datePublished;
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public TimeValue getTimeValuePublished() {
    return timeValuePublished;
  }

  @Override
  public void setCreators(List<Agent> creators) {
    this.creators = creators;
  }

  @Override
  public void setDatePublished(LocalDate datePublished) {
    this.datePublished = datePublished;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  @Override
  public void setTimeValuePublished(TimeValue timeValuePublished) {
    this.timeValuePublished = timeValuePublished;
  }
}
