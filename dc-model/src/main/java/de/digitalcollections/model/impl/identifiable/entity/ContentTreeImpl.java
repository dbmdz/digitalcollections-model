package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.ContentTree;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.resource.ContentNode;
import java.util.List;

/**
 * see {@link ContentTree}
 */
public class ContentTreeImpl extends EntityImpl implements ContentTree {

  private List<ContentNode> rootNodes;

  public ContentTreeImpl() {
    super();
    this.entityType = EntityType.CONTENT_TREE;
  }

  public ContentTreeImpl(List<ContentNode> rootNodes) {
    this();
    this.rootNodes = rootNodes;
  }

  @Override
  public List<ContentNode> getRootNodes() {
    return rootNodes;
  }

  @Override
  public void setRootNodes(List<ContentNode> rootNodes) {
    this.rootNodes = rootNodes;
  }

}
