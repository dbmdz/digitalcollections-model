package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.identifiable.entity.Entity;
import de.digitalcollections.model.identifiable.entity.Project;
import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The entity serialization")
public class EntityTest extends BaseJsonSerializationTest {

  @Test
  @DisplayName("works with a corporate body as entity")
  public void testSerialisationForCorporationsInBothWays() throws Exception {
    Entity corporateBody = new CorporateBody();
    corporateBody.setLabel(new LocalizedText(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporateBody);
  }

  @Test
  @DisplayName("works with a project as entity")
  public void testSerialisationForProjectsInBothWays() throws Exception {
    Entity project = new Project();
    project.setLabel(new LocalizedText(Locale.GERMAN, "DAS Projekt"));
    checkSerializeDeserialize(project);
  }
}
