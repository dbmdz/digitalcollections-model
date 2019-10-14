package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.parts.ContentNode;
import java.util.List;

/** A content tree. */
public interface ContentTree extends Entity {

  List<ContentNode> getRootNodes();

  void setRootNodes(List<ContentNode> rootNodes);
}
