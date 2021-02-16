package de.digitalcollections.model.paging;

public class PageItem {

  private final boolean current;
  private final int number;

  public PageItem(int number, boolean current) {
    this.number = number;
    this.current = current;
  }

  public int getNumber() {
    return this.number;
  }

  public boolean isCurrent() {
    return this.current;
  }

  @Override
  public String toString() {
    return "PageItem{" + "number=" + number + ", current=" + current + '}';
  }
}
