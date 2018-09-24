package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.PageItem;

public class PageItemImpl implements PageItem {

  private final int number;
  private final boolean current;

  public PageItemImpl(int number, boolean current) {
    this.number = number;
    this.current = current;
  }

  @Override
  public int getNumber() {
    return this.number;
  }

  @Override
  public boolean isCurrent() {
    return this.current;
  }

  @Override
  public String toString() {
    return "PageItemImpl{"
            + "number=" + number
            + ", current=" + current
            + '}';
  }

}
