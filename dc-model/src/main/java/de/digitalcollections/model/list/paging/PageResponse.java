package de.digitalcollections.model.list.paging;

import de.digitalcollections.model.list.ListResponse;
import de.digitalcollections.model.list.filtering.FilterCriterion;
import de.digitalcollections.model.list.filtering.FilterOperation;
import de.digitalcollections.model.list.filtering.Filtering;
import de.digitalcollections.model.list.sorting.Direction;
import de.digitalcollections.model.list.sorting.NullHandling;
import de.digitalcollections.model.list.sorting.Order;
import de.digitalcollections.model.list.sorting.Sorting;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Container for pagination information. See Spring Data Commons, but more flat design and
 * independent of Spring libraries.
 *
 * @param <T> object type listed in page
 */
public class PageResponse<T> extends ListResponse<T> {

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(Class c) {
    return new Builder(c);
  }

  private String executedSearchTerm;

  protected PageRequest pageRequest;

  public PageResponse() {
    super();
    this.pageRequest = null;
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
    this(content, pageRequest, total, null);
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
   * @param executedSearchTerm search term being effectively used (may bechanged/normalized in
   *     comparance to original sent request search term) on server side for some reason
   */
  public PageResponse(
      List<T> content, PageRequest pageRequest, long total, String executedSearchTerm) {
    super(content, null);

    this.pageRequest = pageRequest;
    this.total =
        !content.isEmpty()
                && pageRequest != null
                && pageRequest.getOffset() + pageRequest.getPageSize() > total
            ? pageRequest.getOffset() + content.size()
            : total;
    this.executedSearchTerm = executedSearchTerm;
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
    boolean executedSearchTermEqual =
        (this.executedSearchTerm == null
            ? that.executedSearchTerm == null
            : this.executedSearchTerm.equals(that.executedSearchTerm));

    return (this.total == that.total)
        && contentEqual
        && pageRequestEqual
        && executedSearchTermEqual;
  }

  public String getExecutedSearchTerm() {
    if (executedSearchTerm == null) {
      // no changes on original searchTerm
      return getPageRequest().getSearchTerm();
    }
    return executedSearchTerm;
  }

  /**
   * Returns the number of elements currently on this {@link PageResponse}.
   *
   * @return the number of elements currently on this {@link PageResponse}.
   */
  public int getNumberOfElements() {
    return content.size();
  }

  /**
   * Returns the number of the current {@link PageResponse}. Is always non-negative.
   *
   * @return the number of the current {@link PageResponse}.
   */
  public int getPageNumber() {
    return pageRequest == null ? 0 : pageRequest.getPageNumber();
  }

  /**
   * @return the PageRequest used to get this PageResponse
   */
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
    return getPageNumber() + 1 < getTotalPages();
  }

  /**
   * Returns if there is a previous {@link PageResponse}.
   *
   * @return if there is a previous {@link PageResponse}.
   */
  public boolean hasPrevious() {
    return getPageNumber() > 0;
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

  public void setExecutedSearchTerm(String changedSearchTerm) {
    this.executedSearchTerm = changedSearchTerm;
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
        "Page %s of %d containing %s instances", getPageNumber() + 1, getTotalPages(), contentType);
  }

  public static class Builder<T, B extends PageResponse<T>, C extends Builder> {

    B pageResponse;
    PageRequest pageRequest = new PageRequest();
    List<FilterCriterion> filterCriteria;
    List<Order> orders;

    public Builder() {
      pageResponse = (B) new PageResponse<T>();
    }

    public Builder(Class<T> clazz) {
      pageResponse = (B) new PageResponse<T>();
    }

    public B build() {
      if (filterCriteria != null && !filterCriteria.isEmpty()) {
        pageRequest.setFiltering(new Filtering(filterCriteria));
      }

      if (orders != null && !orders.isEmpty()) {
        Sorting sorting = new Sorting();
        sorting.setOrders(orders);
        pageRequest.setSorting(sorting);
      }

      if (pageResponse.getTotalElements() == 0
          && pageResponse.getContent() != null
          && !pageResponse.getContent().isEmpty()) {
        pageResponse.setTotalElements(pageResponse.getContent().size());
      }

      pageResponse.setPageRequest(pageRequest);
      return pageResponse;
    }

    public C withoutContent() {
      pageResponse.setTotalElements(0);
      pageResponse.setContent(List.of());
      return (C) this;
    }

    public C withExecutedSearchTerm(String executedSearchTerm) {
      pageResponse.setExecutedSearchTerm(executedSearchTerm);
      return (C) this;
    }

    public C withContent(List<T> content) {
      pageResponse.setContent(content);
      return (C) this;
    }

    public C withContent(T content) {
      pageResponse.setContent(List.of(content));
      return (C) this;
    }

    public C forRequestPage(int requestPage) {
      pageRequest.setPageNumber(requestPage);
      return (C) this;
    }

    public C forPageSize(int pageSize) {
      pageRequest.setPageSize(pageSize);
      return (C) this;
    }

    public C forStartDate(String expression, String startDate) {
      FilterCriterion filterCriterionStart =
          new FilterCriterion(
              expression,
              FilterOperation.LESS_THAN_OR_EQUAL_TO_AND_SET,
              LocalDate.parse(startDate));
      if (filterCriteria == null) {
        filterCriteria = new ArrayList<>();
      }
      filterCriteria.add(filterCriterionStart);
      return (C) this;
    }

    public C forEndDate(String expression, String endDate) {
      FilterCriterion filterCriterionEnd =
          new FilterCriterion(
              expression, FilterOperation.GREATER_THAN_OR_NOT_SET, LocalDate.parse(endDate));
      if (filterCriteria == null) {
        filterCriteria = new ArrayList<>();
      }
      filterCriteria.add(filterCriterionEnd);
      return (C) this;
    }

    public C forAscendingOrderedField(String expression, String subfield) {
      Order order =
          Order.builder()
              .direction(Direction.ASC)
              .ignoreCase(false)
              .nullHandling(NullHandling.NATIVE)
              .property(expression)
              .subProperty(subfield)
              .build();
      if (orders == null) {
        orders = new ArrayList<>();
      }
      orders.add(order);
      return (C) this;
    }

    public C forDescendingOrderedField(String expression, String subfield) {
      Order order =
          Order.builder()
              .direction(Direction.DESC)
              .ignoreCase(false)
              .nullHandling(NullHandling.NATIVE)
              .property(expression)
              .subProperty(subfield)
              .build();
      if (orders == null) {
        orders = new ArrayList<>();
      }
      orders.add(order);
      return (C) this;
    }

    public C forEqualPredicate(String expression, String predicate) {
      if (filterCriteria == null) {
        filterCriteria = new ArrayList<>();
      }
      filterCriteria.add(new FilterCriterion(expression, FilterOperation.EQUALS, predicate));
      return (C) this;
    }

    public C forAscendingOrderedField(String expression) {
      return forAscendingOrderedField(expression, "");
    }

    public C forDescendingOrderedField(String expression) {
      return forDescendingOrderedField(expression, "");
    }

    public C withTotalElements(long totalElements) {
      pageResponse.setTotalElements(totalElements);
      return (C) this;
    }
  }
}
