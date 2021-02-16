package de.digitalcollections.model.jackson.mixin.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.web.BreadcrumbNavigation;

@JsonDeserialize(as = BreadcrumbNavigation.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface BreadcrumbNavigationMixIn {}
