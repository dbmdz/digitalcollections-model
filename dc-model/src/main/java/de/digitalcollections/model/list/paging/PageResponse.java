package de.digitalcollections.model.list.paging;

import de.digitalcollections.model.list.ListResponse;
import java.util.List;

/**
 * Container for pagination information. See Spring Data Commons, but more flat design and
 * independent of Spring libraries. TODO: add Builder, @see PageRequest
 *
 * @param <T> object type listed in page
 */
public class PageResponse<T> extends ListResponse<T> {

  protected PageRequest pageRequest;

  public PageResponse() {
    super();
    this.pageRequest = null;
  }

  /**
   * Constructor of {@code PageResponse} with the given content and the given governing {@link
   * PageRequest}.
   *
   * @param content the content of this page, must not be {@literal null}.
   * @param pageRequest the paging information, can be {@literal null}.
   * @param total the total amount of items available. The total might be adapted considering the
   *     length of the content given, if it is going to be the content of the last page. This is in
   *     place to mitigate inconsistencies
   */
  public PageResponse(List<T> content, PageRequest pageRequest, long total) {
    super(content, null);

    this.pageRequest = pageRequest;
    this.total =
        !content.isEmpty()
                && pageRequest != null
                && pageRequest.getOffset() + pageRequest.getPageSize() > total
            ? pageRequest.getOffset() + content.size()
            : total;
  }

  /**
   * Creates a new {@link PageResponse} with the given content. This will result in the created
   * {@link PageResponse} being identical to the entire {@link List}.
   *
   * @param content must not be {@literal null}.
   */
  public PageResponse(List<T> content) {
    this(content, null, null == content ? 0 : content.size());
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PageResponse<?>)) {
      return false;
    }

    PageResponse<?> that = (PageResponse<?>) obj;

    boolean contentEqual = this.content.equals(that.content);
    boolean pageRequestEqual =
        this.pageRequest == null
            ? that.pageRequest == null
            : this.pageRequest.equals(that.pageRequest);

    return (this.total == that.total) && contentEqual && pageRequestEqual;
  }

  /**
   * Returns the number of the current {@link PageResponse}. Is always non-negative.
   *
   * @return the number of the current {@link PageResponse}.
   */
  public int getNumber() {
    return pageRequest == null ? 0 : pageRequest.getPageNumber();
  }

  /**
   * Returns the number of elements currently on this {@link PageResponse}.
   *
   * @return the number of elements currently on this {@link PageResponse}.
   */
  public int getNumberOfElements() {
    return content.size();
  }

  /** @return the PageRequest used to get this PageResponse */
  public PageRequest getPageRequest() {
    return pageRequest;
  }

  /**
   * Returns the size of the {@link PageResponse}.
   *
   * @return the size of the {@link PageResponse}.
   */
  public int getSize() {
    return pageRequest == null ? 0 : pageRequest.getPageSize();
  }

  /**
   * Returns the number of total pages.
   *
   * @return the number of total pages
   */
  public int getTotalPages() {
    return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
  }

  /**
   * Returns if there is a next {@link PageResponse}.
   *
   * @return if there is a next {@link PageResponse}.
   */
  public boolean hasNext() {
    return getNumber() + 1 < getTotalPages();
  }

  /**
   * Returns if there is a previous {@link PageResponse}.
   *
   * @return if there is a previous {@link PageResponse}.
   */
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

  /**
   * Returns whether the current {@link PageResponse} is the first one.
   *
   * @return whether the current {@link PageResponse} is the first one.
   */
  public boolean isFirst() {
    return !hasPrevious();
  }

  /**
   * Returns whether the current {@link PageResponse} is the last one.
   *
   * @return whether the current {@link PageResponse} is the last one.
   */
  public boolean isLast() {
    return !hasNext();
  }

  /**
   * Returns the {@link PageRequest} to request the next {@link PageResponse}. Can be {@literal
   * null} in case the current {@link PageResponse} is already the last one. Clients should check
   * {@link #hasNext()} before calling this method to make sure they receive a non-{@literal null}
   * value.
   *
   * @return the {@link PageRequest} to request the next {@link PageResponse}
   */
  public PageRequest nextPageRequest() {
    return hasNext() ? pageRequest.next() : null;
  }

  /**
   * Returns the {@link PageRequest} to request the previous {@link PageResponse}. Can be {@literal
   * null} in case the current {@link PageResponse} is already the first one. Clients should check
   * {@link #hasPrevious()} before calling this method make sure receive a non-{@literal null}
   * value.
   *
   * @return the {@link PageRequest} to request the previous {@link PageResponse}
   */
  public PageRequest previousPageRequest() {
    if (hasPrevious()) {
      return pageRequest.previousOrFirst();
    }
    return null;
  }

  public void setPageRequest(PageRequest pageRequest) {
    this.pageRequest = pageRequest;
  }

  @Override
  public String toString() {

    String contentType = "UNKNOWN";
    List<T> unmodifiableContent = getContent();

    if (unmodifiableContent.size() > 0) {
      contentType = unmodifiableContent.get(0).getClass().getName();
    }

    return String.format(
        "Page %s of %d containing %s instances", getNumber() + 1, getTotalPages(), contentType);
  }
}
