package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class ArticleImpl extends EntityImpl implements Article<Article> {

  private final NodeImpl<Article> node;
  private LocalizedStructuredContent text;

  public ArticleImpl() {
    super();
    this.entityType = EntityType.ARTICLE;
    this.node = new NodeImpl<>();
  }

  @Override
  public Article getParent() {
    return node.getParent();
  }

  @Override
  public void setParent(Article parent) {
    node.setParent(parent);
  }

  @Override
  public List<Article> getChildren() {
    return node.getChildren();
  }

  @Override
  public void setChildren(List<Article> children) {
    node.setChildren(children);
  }

  @Override
  public List<Identifiable> getContent() {
    return node.getContent();
  }

  @Override
  public void setContent(List<Identifiable> content) {
    node.setContent(content);
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
