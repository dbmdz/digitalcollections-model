package de.digitalcollections.model.identifiable.alias;

import static org.assertj.core.api.Assertions.assertThat;

import de.digitalcollections.model.identifiable.entity.Collection;
import de.digitalcollections.model.identifiable.entity.EntityType;
import de.digitalcollections.model.identifiable.entity.agent.Family;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.identifiable.resource.ApplicationFileResource;
import de.digitalcollections.model.identifiable.web.Webpage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The UrlAlias")
class UrlAliasTest {

  @Test
  @DisplayName("fills the field targetEntityType for a collection")
  void fillTargetEntityTypeForCollection() {
    UrlAlias urlAlias = UrlAlias.builder().target(Collection.builder().build()).build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.COLLECTION);
  }

  @Test
  @DisplayName("fills the field targetEntityType with null for a webpage")
  void fillTargetEntityTypeForWebpage() {
    UrlAlias urlAlias = UrlAlias.builder().target(Webpage.builder().build()).build();
    assertThat(urlAlias.getTargetEntityType()).isNull();
  }

  @Test
  @DisplayName("fills the field targetEntityType for a family")
  void fillTargetEntityTypeForFamily() {
    UrlAlias urlAlias = UrlAlias.builder().target(Family.builder().build()).build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.FAMILY);
  }

  @Test
  @DisplayName("fills the field targetEntityType with null for an ApplicationFileResource")
  void fillTargetEntityTypeForFileResource() {
    UrlAlias urlAlias =
        UrlAlias.builder().target(ApplicationFileResource.builder().build()).build();
    assertThat(urlAlias.getTargetEntityType()).isNull();
  }

  @Test
  @DisplayName("fills the field targetEntityType with geolocation for a human settlement")
  void fillTargetEntityTypeForHumanSettlement() {
    UrlAlias urlAlias = UrlAlias.builder().target(HumanSettlement.builder().build()).build();
    assertThat(urlAlias.getTargetEntityType()).isEqualTo(EntityType.GEOLOCATION);
  }
}
