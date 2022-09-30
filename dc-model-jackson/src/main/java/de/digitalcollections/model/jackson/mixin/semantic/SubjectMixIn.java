package de.digitalcollections.model.jackson.mixin.semantic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.semantic.Subject;

@JsonDeserialize(as = Subject.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("SUBJECT")
public interface SubjectMixIn extends UniqueObjectMixIn {}
