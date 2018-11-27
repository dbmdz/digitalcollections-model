package de.digitalcollections.model.api.paging;

import java.util.List;

/**
 * Abstract interface for pagination information.
 * See Spring Data Commons, but more flat design and independent of Spring libraries.
 * TODO: add Builder, @see PageRequest
 * @param <T> object type listed in page
 */
public interface PageResponse<T> extends Iterable<T> {

  /**
   * @return the page content/objects as {@link List}.
   */
  List<T> getContent();

  /**
   * Allows to set the content (needed in case of content has to be converted/casted)
   * @param content list of content/objects of this page
   */
  void setContent(List<T> content);

  /**
   * Returns the number of the current {@link PageResponse}. Is always non-negative.
   *
   * @return the number of the current {@link PageResponse}.
   */
  int getNumber();

  /**
   * Returns the number of elements currently on this {@link PageResponse}.
   *
   * @return the number of elements currently on this {@link PageResponse}.
   */
  int getNumberOfElements();

  /**
   *  @return the PageRequest used to get this PageResponse
   */
  PageRequest getPageRequest();

  /**
   * Returns the size of the {@link PageResponse}.
   *
   * @return the size of the {@link PageResponse}.
   */
  int getSize();

  /**
   * @return the sorting parameters for the {@link PageResponse}.
   */
  Sorting getSorting();

  /**
   * Returns the total amount of elements.
   *
   * @return the total amount of elements
   */
  long getTotalElements();

  /**
   * Returns the number of total pages.
   *
   * @return the number of total pages
   */
  int getTotalPages();

  /**
   * Returns whether the {@link PageResponse} has content at all.
   *
   * @return whether the {@link PageResponse} has content at all.
   */
  boolean hasContent();

  /**
   * Returns if there is a next {@link PageResponse}.
   *
   * @return if there is a next {@link PageResponse}.
   */
  boolean hasNext();

  /**
   * Returns if there is a previous {@link PageResponse}.
   *
   * @return if there is a previous {@link PageResponse}.
   */
  boolean hasPrevious();

  /**
   * Returns whether the current {@link PageResponse} is the first one.
   *
   * @return whether the current {@link PageResponse} is the first one.
   */
  boolean isFirst();

  /**
   * Returns whether the current {@link PageResponse} is the last one.
   *
   * @return whether the current {@link PageResponse} is the last one.
   */
  boolean isLast();

  /**
   * Returns the {@link PageRequest} to request the next {@link PageResponse}. Can be {@literal null} in case the current
   * {@link PageResponse} is already the last one. Clients should check {@link #hasNext()} before calling this method to make
   * sure they receive a non-{@literal null} value.
   *
   * @return the {@link PageRequest} to request the next {@link PageResponse}
   */
  PageRequest nextPageRequest();

  /**
   * Returns the {@link PageRequest} to request the previous {@link PageResponse}. Can be {@literal null} in case the current
   * {@link PageResponse} is already the first one. Clients should check {@link #hasPrevious()} before calling this method make
   * sure receive a non-{@literal null} value.
   *
   * @return the {@link PageRequest} to request the previous {@link PageResponse}
   */
  PageRequest previousPageRequest();

}
