package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CorporateBodyTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    CorporateBody corporateBody = new CorporateBody();
    corporateBody.setLabel(new LocalizedText(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporateBody);
  }
}
