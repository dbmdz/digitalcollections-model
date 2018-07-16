package de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks;

import java.util.Map;

public interface Attributes {

  Map<String, Object> getAttributes();

  void setAttributes(Map<String, Object> attributes);

  void addAttribute(String key, Object value);

  Object getAttribute(String key);

}
