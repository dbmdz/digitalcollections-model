package de.digitalcollections.model.api.identifiable.entity.parts;

import de.digitalcollections.model.api.identifiable.IdentifiablesContainer;
import de.digitalcollections.model.api.identifiable.Node;

public interface ContentNode<N extends Node> extends Node<N>, IdentifiablesContainer {
}
