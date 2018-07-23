package de.digitalcollections.model.api.identifiable.resource;

import de.digitalcollections.model.api.identifiable.Node;
import java.util.List;

public interface ContentNode extends Resource, Node<ContentNode> {

  List<ContentNode> getSubNodes();

  void setSubNodes(List<ContentNode> subNodes);

}
