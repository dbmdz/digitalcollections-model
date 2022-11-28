package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.manifestation.ExpressionType;
import de.digitalcollections.model.jackson.mixin.MainSubTypeMixIn;

@JsonDeserialize(as = ExpressionType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("EXPRESSION_TYPE")
public interface ExpressionTypeMixIn extends MainSubTypeMixIn {}
