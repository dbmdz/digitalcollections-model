package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.api.identifiable.resource.FileResource;
import de.digitalcollections.model.impl.identifiable.entity.DigitalObjectImpl;
import java.util.LinkedHashSet;

@JsonDeserialize(as = DigitalObjectImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("DIGITAL_OBJECT")
public interface DigitalObjectMixIn {

  @JsonIgnore
  LinkedHashSet<FileResource> addFileResource(FileResource fileResource);
}
