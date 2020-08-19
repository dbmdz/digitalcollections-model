package de.digitalcollections.model.jackson.mixin.identifiable.entity.work;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.impl.identifiable.entity.work.ManifestationImpl;

@JsonDeserialize(as = ManifestationImpl.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("MANIFESTATION")
public interface ManifestationMixIn {}
