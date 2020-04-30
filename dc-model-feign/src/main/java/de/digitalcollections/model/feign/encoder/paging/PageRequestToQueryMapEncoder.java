package de.digitalcollections.model.feign.encoder.paging;

import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.feign.encoder.filter.FilteringToQueryMapEncoder;
import feign.QueryMapEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link QueryMapEncoder} encoding a {@link PageRequest} into a map of query parameter names and
 * values.
 *
 * @see <a href="https://github.com/OpenFeign/feign#dynamic-query-parameters">Dynamic Query
 *     Parameters</a>
 */
public class PageRequestToQueryMapEncoder implements QueryMapEncoder {

  private FilteringToQueryMapEncoder filteringToQueryMapEncoder = new FilteringToQueryMapEncoder();
  private SortingToQueryMapEncoder sortingToQueryMapEncoder = new SortingToQueryMapEncoder();

  @Override
  public Map<String, Object> encode(Object object) {
    if (object == null) {
      return null;
    }
    Map<String, Object> queryMap = new HashMap<>();

    PageRequest pageRequest = (PageRequest) object;
    queryMap.put("pageNumber", pageRequest.getPageNumber());
    queryMap.put("pageSize", pageRequest.getPageSize());

    Map<String, Object> queryMapSorting = sortingToQueryMapEncoder.encode(pageRequest.getSorting());
    queryMap.putAll(queryMapSorting);

    Map<String, Object> queryMapFiltering =
        filteringToQueryMapEncoder.encode(pageRequest.getFiltering());
    queryMap.putAll(queryMapFiltering);

    return queryMap;
  }
}
