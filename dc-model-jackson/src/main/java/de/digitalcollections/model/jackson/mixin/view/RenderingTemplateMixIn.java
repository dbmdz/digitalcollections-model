package de.digitalcollections.model.jackson.mixin.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.UniqueObjectMixIn;
import de.digitalcollections.model.view.RenderingTemplate;

@JsonDeserialize(as = RenderingTemplate.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("RENDERING_TEMPLATE")
public interface RenderingTemplateMixIn extends UniqueObjectMixIn {}
