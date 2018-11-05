package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiablesContainer;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.IdentifiablesContainerImpl;
import java.util.List;

public class ArticleImpl extends EntityImpl implements Article<Article> {

  private final IdentifiablesContainer identifiablesContainer;
  private LocalizedStructuredContent text;

  public ArticleImpl() {
    super();
    this.entityType = EntityType.ARTICLE;
    this.identifiablesContainer = new IdentifiablesContainerImpl();
  }

  @Override
  public List<Identifiable> getIdentifiables() {
    return identifiablesContainer.getIdentifiables();
  }

  @Override
  public void setIdentifiables(List<Identifiable> identifiables) {
    identifiablesContainer.setIdentifiables(identifiables);
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
