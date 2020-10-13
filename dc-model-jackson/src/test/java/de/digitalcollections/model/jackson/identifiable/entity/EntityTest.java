package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.impl.identifiable.entity.ProjectImpl;
import de.digitalcollections.model.impl.identifiable.entity.agent.CorporateBodyImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The entity serialization")
public class EntityTest extends BaseJsonSerializationTest {

  @Test
  @DisplayName("works with a corporate body as entity")
  public void testSerialisationForCorporationsInBothWays() throws Exception {
    Entity corporateBody = new CorporateBodyImpl();
    corporateBody.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporateBody);
  }

  @Test
  @DisplayName("works with a project as entity")
  public void testSerialisationForProjectsInBothWays() throws Exception {
    Entity project = new ProjectImpl();
    project.setLabel(new LocalizedTextImpl(Locale.GERMAN, "DAS Projekt"));
    checkSerializeDeserialize(project);
  }
}