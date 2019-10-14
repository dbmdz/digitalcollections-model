package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.TableCell;
import de.digitalcollections.model.impl.identifiable.parts.structuredcontent.ContentBlockNodeWithAttributesImpl;

public class TableCellImpl extends ContentBlockNodeWithAttributesImpl implements TableCell {

  public TableCellImpl() {}

  public TableCellImpl(String colspan, String rowspan, String colwidth) {
    super();
    addAttribute("colspan", colspan);
    addAttribute("rowspan", rowspan);
    addAttribute("colwidth", colwidth);
  }
}
