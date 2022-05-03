package de.digitalcollections.model.jackson.mixin.list.sorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.list.sorting.Sorting;

@JsonDeserialize(as = Sorting.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class SortingMixIn {}
