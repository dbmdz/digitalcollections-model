package de.digitalcollections.model.list;

import de.digitalcollections.model.paging.Sorting;
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

  protected List<T> content = new ArrayList<>();
  protected ListRequest listRequest;
  protected long total;

  public ListResponse() {
    this.listRequest = null;
    this.total = 0;
  }

  /**
   * Constructor with the given content and the given governing {@link ListRequest}.
   *
   * @param content the content of this list, must not be {@literal null}.
   * @param listRequest the request information, can be {@literal null}.
   */
  public ListResponse(List<T> content, ListRequest listRequest) {
    assert content != null : "content must not be null!";

    this.content.addAll(content);
    this.listRequest = listRequest;
    this.total = content.size();
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
    boolean listRequestEqual =
        this.listRequest == null
            ? that.listRequest == null
            : this.listRequest.equals(that.listRequest);

    return (this.total == that.total) && contentEqual && listRequestEqual;
  }

  /**
   * @return the content as {@link List}.
   */
  public List<T> getContent() {
    return Collections.unmodifiableList(content);
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

    return result;
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

    if (unmodifiableContent.size() > 0) {
      contentType = unmodifiableContent.get(0).getClass().getName();
    }

    return String.format(
        "List of %s containing %d instances", contentType, unmodifiableContent.size());
  }
}
