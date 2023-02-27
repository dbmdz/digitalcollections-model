package de.digitalcollections.model.jackson.mixin.semantic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.semantic.Headword;

@JsonDeserialize(as = Headword.class)
public interface HeadwordMixIn extends UniqueObjectMixIn {}
