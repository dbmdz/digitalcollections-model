package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.agent.Person;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import de.digitalcollections.model.identifiable.entity.work.Involvement;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The Involvement")
public class InvolvementTest extends BaseJsonSerializationTest {

  @DisplayName("can be serialized and deserialized")
  @Test
  public void testSerializeDeserialize() throws Exception {
    Involvement involvement =
        Involvement.builder()
            .isCreator(null)
            .agent(Person.builder().label(Locale.GERMAN, "Karl Ranseier").build())
            .involvementPlace(HumanSettlement.builder().label(Locale.GERMAN, "Köln").build())
            .involvementRoles(List.of("Autor", "Verleger"))
            .involvementRolesPresentation(
                List.of("erfolglosester Autor", "erfolglosester Verleger"))
            .build();

    checkSerializeDeserialize(
        involvement, "serializedTestObjects/identifiable/entity/work/Involvement.json");
  }
}
