package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Project;
import de.digitalcollections.model.impl.identifiable.entity.ProjectImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class ProjectTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Project project = new ProjectImpl();
    project.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Projekt XY"));
    checkSerializeDeserialize(project);
  }
}
