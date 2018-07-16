package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.OrderedList;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeWithAttributesImpl;

public class OrderedListImpl extends ContentBlockNodeWithAttributesImpl implements OrderedList {

  public OrderedListImpl() {
  }

  public OrderedListImpl(int order) {
    addAttribute("order", 1);
  }

}
