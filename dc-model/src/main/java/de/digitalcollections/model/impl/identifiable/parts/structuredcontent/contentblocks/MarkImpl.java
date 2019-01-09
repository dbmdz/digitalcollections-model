package de.digitalcollections.model.impl.identifiable.parts.structuredcontent.contentblocks;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.contentblocks.Mark;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MarkImpl implements Mark {

  String type;

  Map<String, Object> attributes = null;

  public MarkImpl() {
  }

  public MarkImpl(String type) {
    this.type = type;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return attributes;
  }

  @Override
  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public void addAttribute(String key, Object value) {
    if (attributes == null) {
      attributes = new HashMap<>();
    }

    attributes.put(key, value);
  }

  @Override
  public Object getAttribute(String key) {
    if (attributes == null) {
      return null;
    }

    return attributes.get(key);
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MarkImpl)) {
      return false;
    }
    MarkImpl mark = (MarkImpl) o;
    return Objects.equals(type, mark.type);
  }

  @Override
  public int hashCode() {

    return Objects.hash(type);
  }

  @Override
  public String toString() {
    return "MarkImpl{"
            + "type='" + type + '\''
            + '}';
  }
}
