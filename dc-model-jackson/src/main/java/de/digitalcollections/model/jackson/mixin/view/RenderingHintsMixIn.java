package de.digitalcollections.model.jackson.mixin.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.view.RenderingHints;

@JsonDeserialize(as = RenderingHints.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("RENDERING_HINTS")
public class RenderingHintsMixIn {}
