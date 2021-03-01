package de.digitalcollections.model.jackson.mixin.paging;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.paging.Sorting;

@JsonDeserialize(as = Sorting.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SortingMixIn {}
