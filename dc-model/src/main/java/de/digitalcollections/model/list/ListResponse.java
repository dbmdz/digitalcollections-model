package de.digitalcollections.model.list;

import de.digitalcollections.model.list.sorting.Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Container for list information.
 *
 * @param <T> object type of list items
 */
public class ListResponse<T> implements Iterable<T> {

  protected List<T> content;
  protected String executedSearchTerm;
  protected ListRequest listRequest;
  protected long total;

  public ListResponse() {
    init();
  }

  /**
   * Constructor with the given content and the given governing {@link ListRequest}.
   *
   * @param content the content of this list, must not be {@literal null}.
   * @param listRequest the request information, can be {@literal null}.
   */
  public ListResponse(List<T> content, ListRequest listRequest) {
    this();

    assert content != null : "content must not be null!";
    this.content.addAll(content);
    this.listRequest = listRequest;
    this.total = content.size();
  }

  /**
   * Constructor with the given content and the given governing {@link ListRequest}.
   *
   * @param content the content of this list, must not be {@literal null}.
   * @param listRequest the request information, can be {@literal null}.
   * @param executedSearchTerm finally executed search term based on given search term (e.g. after
   *     escaping special characters etc.)
   */
  public ListResponse(List<T> content, ListRequest listRequest, String executedSearchTerm) {
    this(content, listRequest);
    this.executedSearchTerm = executedSearchTerm;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ListResponse<?>)) {
      return false;
    }

    ListResponse<?> that = (ListResponse<?>) obj;

    boolean contentEqual = this.content.equals(that.content);
    boolean executedSearchTermEqual =
        (this.executedSearchTerm == null
            ? that.executedSearchTerm == null
            : this.executedSearchTerm.equals(that.executedSearchTerm));
    boolean listRequestEqual =
        this.listRequest == null
            ? that.listRequest == null
            : this.listRequest.equals(that.listRequest);

    return (this.total == that.total)
        && contentEqual
        && executedSearchTermEqual
        && listRequestEqual;
  }

  /**
   * @return the content as {@link List}.
   */
  public List<T> getContent() {
    return Collections.unmodifiableList(content);
  }

  public String getExecutedSearchTerm() {
    if (executedSearchTerm == null) {
      // no changes on original searchTerm
      return listRequest != null ? listRequest.getSearchTerm() : null;
    }
    return executedSearchTerm;
  }

  /**
   * @return the ListRequest used to get this ListResponse
   */
  public ListRequest getListRequest() {
    return listRequest;
  }

  /**
   * @return the sorting parameters for the {@link ListResponse}.
   */
  public Sorting getSorting() {
    return listRequest == null ? null : listRequest.getSorting();
  }

  /**
   * Returns the total amount of elements.
   *
   * @return the total amount of elements
   */
  public long getTotalElements() {
    return total;
  }

  /**
   * @return whether the {@link ListResponse} has content at all.
   */
  public boolean hasContent() {
    return !content.isEmpty();
  }

  @Override
  public int hashCode() {

    int result = 17;

    result += 31 * (int) (total ^ total >>> 32);
    result += 31 * (listRequest == null ? 0 : listRequest.hashCode());
    result += 31 * content.hashCode();
    result += 31 * executedSearchTerm.hashCode();

    return result;
  }

  protected void init() {
    if (content == null) {
      this.content = new ArrayList<>(0);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return content.iterator();
  }

  /**
   * Allows to set the content (needed in case of content has to be converted/casted)
   *
   * @param content list of content/objects
   */
  public void setContent(List<T> content) {
    this.content = content;
  }

  public void setExecutedSearchTerm(String executedSearchTerm) {
    this.executedSearchTerm = executedSearchTerm;
  }

  public void setListRequest(ListRequest listRequest) {
    this.listRequest = listRequest;
  }

  public void setTotalElements(long totalElements) {
    this.total = totalElements;
  }

  @Override
  public String toString() {

    String contentType = "UNKNOWN";
    List<T> unmodifiableContent = getContent();

    if (!unmodifiableContent.isEmpty()) {
      contentType = unmodifiableContent.get(0).getClass().getName();
    }

    return String.format(
        "List of %s containing %d instances", contentType, unmodifiableContent.size());
  }
}
