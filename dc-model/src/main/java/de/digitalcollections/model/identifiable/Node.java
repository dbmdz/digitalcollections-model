package de.digitalcollections.model.identifiable;

import java.util.ArrayList;
import java.util.List;

/**
 * Node is used to structure cultural content hierarchically.
 *
 * @param <N> a node
 */
public class Node<N extends Identifiable> extends Identifiable {

  private List<N> children;

  private N parent;

  public void addChild(N child) {
    if (getChildren() == null) {
      setChildren(new ArrayList<>());
    }
    getChildren().add(child);
  }

  public List<N> getChildren() {
    return children;
  }

  public N getParent() {
    return parent;
  }

  public void setChildren(List<N> children) {
    this.children = children;
  }

  public void setParent(N parent) {
    this.parent = parent;
  }
}
