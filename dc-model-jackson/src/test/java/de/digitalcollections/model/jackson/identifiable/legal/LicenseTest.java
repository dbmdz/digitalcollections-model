package de.digitalcollections.model.jackson.identifiable.legal;

import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.impl.legal.LicenseImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class LicenseTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    LicenseImpl license = new LicenseImpl();
    license.setAcronym("CC0 1.0");
    license.setUuid(UUID.fromString("1e2d8b1e-c29d-475b-8f61-67b22ca6de89"));
    license.setCreated(LocalDateTime.now());
    license.setLabel(new LocalizedTextImpl(Locale.ENGLISH, "Public Domain"));
    license.setLastModified(LocalDateTime.now());
    license.setUrl(URI.create("http://rightsstatements.org/vocab/InC-NC/1.0/").toURL());

    checkSerializeDeserialize(license);
  }

}
