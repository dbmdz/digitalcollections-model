package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.paging.PageResponse;
import de.digitalcollections.model.paging.Sorting;
import java.util.List;

@JsonDeserialize(as = PageResponse.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class PageResponseMixIn<T> extends PageResponse<T> {

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.CLASS,
      include = JsonTypeInfo.As.PROPERTY,
      property = "className",
      visible = true)
  @Override
  public abstract List<T> getContent();

  @JsonIgnore
  @Override
  public abstract int getNumber();

  @JsonIgnore
  @Override
  public abstract int getNumberOfElements();

  @JsonIgnore
  @Override
  public abstract int getSize();

  @JsonIgnore
  @Override
  public abstract Sorting getSorting();

  @JsonIgnore
  @Override
  public abstract int getTotalPages();

  @JsonIgnore
  @Override
  public abstract boolean isFirst();

  @JsonIgnore
  @Override
  public abstract boolean isLast();
}
