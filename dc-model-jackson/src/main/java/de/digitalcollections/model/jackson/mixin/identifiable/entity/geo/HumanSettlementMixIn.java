package de.digitalcollections.model.jackson.mixin.identifiable.entity.geo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.geo.HumanSettlementImpl;

@JsonDeserialize(as = HumanSettlementImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("HUMAN_SETTLEMENT")
public interface HumanSettlementMixIn {}
