package de.digitalcollections.model.jackson.mixin.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.view.RenderingTemplate;

@JsonDeserialize(as = RenderingTemplate.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface RenderingTemplateMixIn {}
