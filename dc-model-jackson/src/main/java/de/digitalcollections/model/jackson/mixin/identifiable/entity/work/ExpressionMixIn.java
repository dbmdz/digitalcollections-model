package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.work.ExpressionImpl;

@JsonDeserialize(as = ExpressionImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("EXPRESSION")
public interface ExpressionMixIn {}
