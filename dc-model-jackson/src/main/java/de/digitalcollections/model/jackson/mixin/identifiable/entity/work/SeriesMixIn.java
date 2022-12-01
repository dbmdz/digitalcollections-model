package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.Series;

@JsonDeserialize(as = Series.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("SERIES")
public interface SeriesMixIn extends WorkMixIn {}
