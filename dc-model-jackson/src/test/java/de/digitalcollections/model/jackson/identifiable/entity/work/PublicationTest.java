package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlementType;
import de.digitalcollections.model.identifiable.entity.work.Publication;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Publication")
public class PublicationTest extends BaseJsonSerializationTest {

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Publication publication =
        Publication.builder()
            .publicationLocations(
                List.of(
                    HumanSettlement.builder()
                        .humanSettlementType(HumanSettlementType.CITY)
                        .title(Locale.GERMAN, "München")
                        .label(Locale.GERMAN, "Stadt: München")
                        .build(),
                    HumanSettlement.builder()
                        .humanSettlementType(HumanSettlementType.CITY)
                        .title(Locale.GERMAN, "Hamburg")
                        .label(Locale.GERMAN, "Stadt: Hamburg")
                        .build()))
            .publishers(
                List.of(
                    Person.builder()
                        .title(Locale.GERMAN, "Karl Ranseier")
                        .label(
                            Locale.GERMAN,
                            "Karl Ranseier, der erfolgloseste Herausgeber aller Zeiten")
                        .build(),
                    Person.builder()
                        .title(Locale.GERMAN, "Hans Dampf")
                        .label(Locale.GERMAN, "Herausgeber: Hans Dampf")
                        .build()))
            .publishersPresentation(List.of("Karl Ranseier", "Hans Dampf"))
            .build();

    checkSerializeDeserialize(
        publication, "serializedTestObjects/identifiable/entity/work/Publication.json");
  }
}
