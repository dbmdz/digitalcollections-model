package de.digitalcollections.model.identifiable.alias;

import static org.assertj.core.api.Assertions.assertThat;

import de.digitalcollections.model.identifiable.IdentifiableObjectType;
import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.EntityType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The UrlAlias")
class UrlAliasTest {

  @Test
  @DisplayName("fills the field targetEntityType for a collection")
  void fillTargetEntityTypeForColletion() {
    UrlAlias urlAlias =
        UrlAlias.builder()
            .targetType(
                IdentifiableObjectType.COLLECTION, IdentifiableType.ENTITY, EntityType.COLLECTION)
            .build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.COLLECTION);
  }

  @Test
  @DisplayName("fills the field targetEntityType with null for a webpage")
  void fillTargetEntityTypeForWebpage() {
    UrlAlias urlAlias =
        UrlAlias.builder()
            .targetType(IdentifiableObjectType.WEBPAGE, IdentifiableType.RESOURCE, null)
            .build();
    assertThat(urlAlias.getTargetEntityType()).isNull();
  }

  @Test
  @DisplayName("fills the field targetEntityType for a family")
  void fillTargetEntityTypeForFamily() {
    UrlAlias urlAlias =
        UrlAlias.builder()
            .targetType(IdentifiableObjectType.FAMILY, IdentifiableType.ENTITY, EntityType.FAMILY)
            .build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.FAMILY);
  }

  @Test
  @DisplayName("fills the field targetEntityType with null for an ApplicationFileResource")
  void fillTargetEntityTypeForFileResource() {
    UrlAlias urlAlias =
        UrlAlias.builder()
            .targetType(
                IdentifiableObjectType.APPLICATION_FILE_RESOURCE, IdentifiableType.RESOURCE, null)
            .build();
    assertThat(urlAlias.getTargetEntityType()).isNull();
  }

  @Test
  @DisplayName("fills the field targetEntityType with geolocation for a human settlement")
  void fillTargetEntityTypeForHumanSettlement() {
    UrlAlias urlAlias =
        UrlAlias.builder()
            .targetType(
                IdentifiableObjectType.HUMAN_SETTLEMENT,
                IdentifiableType.ENTITY,
                EntityType.GEOLOCATION)
            .build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.GEOLOCATION);
  }
}
