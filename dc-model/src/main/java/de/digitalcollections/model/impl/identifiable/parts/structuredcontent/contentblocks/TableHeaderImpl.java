package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.TableHeader;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeWithAttributesImpl;

public class TableHeaderImpl extends ContentBlockNodeWithAttributesImpl implements TableHeader {

  public TableHeaderImpl() {
  }

  public TableHeaderImpl(String colspan, String rowspan, String colwidth) {
    super();
    addAttribute("colspan", colspan);
    addAttribute("rowspan", rowspan);
    addAttribute("colwidth", colwidth);
  }

}
