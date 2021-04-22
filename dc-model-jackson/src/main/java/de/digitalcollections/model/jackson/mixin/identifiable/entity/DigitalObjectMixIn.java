package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.resource.FileResource;
import java.util.LinkedHashSet;

@JsonDeserialize(as = DigitalObject.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("digitalObject")
public interface DigitalObjectMixIn extends EntityMixIn {

  @JsonIgnore
  LinkedHashSet<FileResource> addFileResource(FileResource fileResource);
}
