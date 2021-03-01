package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.text.LocalizedText;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface INode<N extends Identifiable> {

  default void addChild(N child) {
    if (getChildren() == null) {
      setChildren(new ArrayList<>());
    }
    getChildren().add(child);
  }

  List<N> getChildren();

  LocalizedText getLabel();

  N getParent();

  UUID getUuid();

  void setChildren(List<N> children);

  void setParent(N parent);
}
