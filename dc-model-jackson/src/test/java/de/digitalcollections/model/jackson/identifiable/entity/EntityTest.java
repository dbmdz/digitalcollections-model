package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Entity;
import de.digitalcollections.model.impl.identifiable.entity.CorporationImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("The entity serialization")
public class EntityTest extends BaseJsonSerializationTest {

  @Test
  @DisplayName("works with a corporation as entity")
  public void testSerialisationForCorporationsInBothWays() throws Exception {
    Entity corporation = new CorporationImpl();
    corporation.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporation);
  }
}
