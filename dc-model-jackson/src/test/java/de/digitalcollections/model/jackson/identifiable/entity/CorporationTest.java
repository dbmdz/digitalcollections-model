package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Corporation;
import de.digitalcollections.model.impl.identifiable.entity.CorporationImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CorporationTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Corporation corporation = new CorporationImpl();
    corporation.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporation);
  }
}
