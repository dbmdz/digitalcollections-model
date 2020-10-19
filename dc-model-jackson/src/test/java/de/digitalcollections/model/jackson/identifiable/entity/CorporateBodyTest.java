package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.agent.CorporateBody;
import de.digitalcollections.model.impl.identifiable.entity.agent.CorporateBodyImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CorporateBodyTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    CorporateBody corporateBody = new CorporateBodyImpl();
    corporateBody.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Bayerische Staatsbibliothek"));
    checkSerializeDeserialize(corporateBody);
  }
}
