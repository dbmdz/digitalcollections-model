package de.digitalcollections.model.api.filter;

/** Use this class for uninterpreted filter values. Given String should be used "as is". */
public class FilterValuePlaceholder {

  private final String placeholder;

  /** @param placeholder uninterpreted filter value */
  public FilterValuePlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  @Override
  public String toString() {
    return placeholder;
  }
}
