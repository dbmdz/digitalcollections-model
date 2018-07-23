package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.EntityType;
import java.util.List;

public class ArticleImpl extends EntityImpl implements Article {

  private Article parent;
  private List<Article> children;
  private List<Identifiable> content;

  public ArticleImpl() {
    super();
    this.entityType = EntityType.ARTICLE;
  }

  @Override
  public Article getParent() {
    return parent;
  }

  @Override
  public void setParent(Article parent) {
    this.parent = parent;
  }

  @Override
  public List<Article> getChildren() {
    return children;
  }

  @Override
  public void setChildren(List<Article> children) {
    this.children = children;
  }

  @Override
  public List<Identifiable> getContent() {
    return content;
  }

  @Override
  public void setContent(List<Identifiable> content) {
    this.content = content;
  }
}
