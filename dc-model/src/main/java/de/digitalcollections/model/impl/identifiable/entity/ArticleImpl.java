package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.Identifiable;
import de.digitalcollections.model.api.identifiable.IdentifiablesContainer;
import de.digitalcollections.model.api.identifiable.Node;
import de.digitalcollections.model.api.identifiable.entity.Article;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.impl.identifiable.IdentifiablesContainerImpl;
import de.digitalcollections.model.impl.identifiable.NodeImpl;
import java.util.List;

public class ArticleImpl extends EntityImpl implements Article<Article> {

  private final IdentifiablesContainer identifiablesContainer;
  private final Node<Article> node;
  private LocalizedStructuredContent text;

  public ArticleImpl() {
    super();
    this.entityType = EntityType.ARTICLE;
    this.identifiablesContainer = new IdentifiablesContainerImpl();
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
