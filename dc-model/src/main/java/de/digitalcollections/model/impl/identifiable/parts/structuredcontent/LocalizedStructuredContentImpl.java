package de.digitalcollections.model.impl.identifiable.parts.structuredcontent;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.StructuredContent;
import java.util.HashMap;
import java.util.Locale;

public class LocalizedStructuredContentImpl extends HashMap<Locale, StructuredContent>
    implements LocalizedStructuredContent {

  public LocalizedStructuredContentImpl() {
    super();
  }
}
