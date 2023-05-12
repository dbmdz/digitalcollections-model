package de.digitalcollections.model.list.filtering;

import java.util.stream.Stream;

public enum FilterLogicalOperator {
  AND("$AND"),
  OR("$OR");

  private String operand;

  public static FilterLogicalOperator fromUrlOperand(String value) {
    return Stream.of(FilterLogicalOperator.values())
        .filter(lo -> lo.getUrlOperand().equalsIgnoreCase(value))
        .findFirst()
        .orElse(null);
  }

  FilterLogicalOperator(String operand) {
    this.operand = operand;
  }

  public String getUrlOperand() {
    return operand;
  }
}
