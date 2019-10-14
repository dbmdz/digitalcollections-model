package de.digitalcollections.model.api.identifiable.parts.structuredcontent;

import java.util.Locale;
import java.util.Map;

/** LocalizedStructuredContent is used for formatted text content in multiple languages. */
public interface LocalizedStructuredContent extends Map<Locale, StructuredContent> {}
