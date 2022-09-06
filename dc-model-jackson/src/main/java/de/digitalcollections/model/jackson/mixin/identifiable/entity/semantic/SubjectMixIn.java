package de.digitalcollections.model.jackson.mixin.identifiable.entity.semantic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.semantic.Subject;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;

@JsonDeserialize(as = Subject.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("SUBJECT")
public interface SubjectMixIn extends UniqueObjectMixIn {}
