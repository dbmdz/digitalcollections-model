package de.digitalcollections.model.impl.paging;

import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.PageResponse;
import de.digitalcollections.model.api.paging.Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PageResponseImpl<T> implements PageResponse<T> {

  private List<T> content = new ArrayList<>();
  private PageRequest pageRequest;
  private long total;

  public PageResponseImpl() {
    this.pageRequest = null;
    this.total = 0;
  }

  /**
   * Constructor of {@code PageResponseImpl} with the given content and the given governing {@link PageRequest}.
   *
   * @param content the content of this page, must not be {@literal null}.
   * @param pageRequest the paging information, can be {@literal null}.
   * @param total the total amount of items available. The total might be adapted considering the length of the content given, if it is going to be the content of the last page. This is in place to mitigate inconsistencies
   */
  public PageResponseImpl(List<T> content, PageRequest pageRequest, long total) {
    assert content != null : "content must not be null!";

    this.content.addAll(content);
    this.pageRequest = pageRequest;
    this.total = !content.isEmpty() && pageRequest != null && pageRequest.getOffset() + pageRequest.getPageSize() > total ? pageRequest.getOffset() + content.size() : total;
  }

  /**
   * Creates a new {@link PageResponseImpl} with the given content. This will result in the created {@link PageResponse} being identical to the entire {@link List}.
   *
   * @param content must not be {@literal null}.
   */
  public PageResponseImpl(List<T> content) {
    this(content, null, null == content ? 0 : content.size());
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }

    if (!(obj instanceof PageResponseImpl<?>)) {
      return false;
    }

    PageResponseImpl<?> that = (PageResponseImpl<?>) obj;

    boolean contentEqual = this.content.equals(that.content);
    boolean pageRequestEqual = this.pageRequest == null ? that.pageRequest == null : this.pageRequest.equals(that.pageRequest);

    return (this.total == that.total) && contentEqual && pageRequestEqual;
  }

  @Override
  public List<T> getContent() {
    return Collections.unmodifiableList(content);
  }

  @Override
  public void setContent(List<T> content) {
    this.content = content;
  }

  @Override
  public int getNumber() {
    return pageRequest == null ? 0 : pageRequest.getPageNumber();
  }

  @Override
  public int getNumberOfElements() {
    return content.size();
  }

  @Override
  public PageRequest getPageRequest() {
    return pageRequest;
  }

  public void setPageRequest(PageRequest pageRequest) {
    this.pageRequest = pageRequest;
  }

  @Override
  public int getSize() {
    return pageRequest == null ? 0 : pageRequest.getPageSize();
  }

  @Override
  public Sorting getSorting() {
    return pageRequest == null ? null : pageRequest.getSorting();
  }

  @Override
  public long getTotalElements() {
    return total;
  }

  public void setTotalElements(long totalElements) {
    this.total = totalElements;
  }

  @Override
  public int getTotalPages() {
    return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
  }

  @Override
  public boolean hasContent() {
    return !content.isEmpty();
  }

  @Override
  public boolean hasNext() {
    return getNumber() + 1 < getTotalPages();
  }

  @Override
  public boolean hasPrevious() {
    return getNumber() > 0;
  }

  @Override
  public int hashCode() {

    int result = 17;

    result += 31 * (int) (total ^ total >>> 32);
    result += 31 * (pageRequest == null ? 0 : pageRequest.hashCode());
    result += 31 * content.hashCode();

    return result;
  }

  @Override
  public boolean isFirst() {
    return !hasPrevious();
  }

  @Override
  public boolean isLast() {
    return !hasNext();
  }

  @Override
  public Iterator<T> iterator() {
    return content.iterator();
  }

  @Override
  public PageRequest nextPageRequest() {
    return hasNext() ? pageRequest.next() : null;
  }

  @Override
  public PageRequest previousPageRequest() {
    if (hasPrevious()) {
      return pageRequest.previousOrFirst();
    }
    return null;
  }

  @Override
  public String toString() {

    String contentType = "UNKNOWN";
    List<T> unmodifiableContent = getContent();

    if (unmodifiableContent.size() > 0) {
      contentType = unmodifiableContent.get(0).getClass().getName();
    }

    return String.format("Page %s of %d containing %s instances", getNumber() + 1, getTotalPages(), contentType);
  }

}
