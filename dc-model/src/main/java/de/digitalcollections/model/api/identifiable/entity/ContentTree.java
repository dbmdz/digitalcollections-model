package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.resource.ContentNode;
import java.util.List;

/**
 * A conent tree.
 */
public interface ContentTree extends Entity {

  List<ContentNode> getRootNodes();

  void setRootNodes(List<ContentNode> rootNodes);
}
