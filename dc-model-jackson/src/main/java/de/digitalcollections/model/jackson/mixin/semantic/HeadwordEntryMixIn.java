package de.digitalcollections.model.jackson.mixin.semantic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.digitalcollections.model.jackson.mixin.identifiable.entity.EntityMixIn;
import de.digitalcollections.model.semantic.HeadwordEntry;

@JsonDeserialize(as = HeadwordEntry.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeName("HEADWORD_ENTRY")
public interface HeadwordEntryMixIn extends EntityMixIn {}
