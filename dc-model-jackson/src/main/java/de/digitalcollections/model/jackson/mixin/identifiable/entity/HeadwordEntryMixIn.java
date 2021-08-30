package de.digitalcollections.model.jackson.mixin.identifiable.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.identifiable.entity.HeadwordEntry;

@JsonDeserialize(as = HeadwordEntry.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("HEADWORD_ENTRY")
public interface HeadwordEntryMixIn extends EntityMixIn {}
