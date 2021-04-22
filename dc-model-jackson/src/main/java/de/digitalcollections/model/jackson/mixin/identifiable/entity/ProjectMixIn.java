package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.Project;

@JsonDeserialize(as = Project.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("project")
public interface ProjectMixIn extends EntityMixIn {}
