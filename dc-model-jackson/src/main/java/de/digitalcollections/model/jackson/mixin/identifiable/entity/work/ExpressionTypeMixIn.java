package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.work.ExpressionType;
import de.digitalcollections.model.jackson.mixin.MainSubTypeMixIn;

@JsonDeserialize(as = ExpressionType.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ExpressionTypeMixIn extends MainSubTypeMixIn {}
