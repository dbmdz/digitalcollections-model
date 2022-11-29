package de.digitalcollections.model.jackson.mixin.identifiable.entity.manifestation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.ProductionInfo;

@JsonDeserialize(as = ProductionInfo.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("PRODUCTION_INFO")
public interface ProductionInfoMixIn {}
