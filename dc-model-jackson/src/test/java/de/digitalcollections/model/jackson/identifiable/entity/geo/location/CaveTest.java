package de.digitalcollections.model.jackson.identifiable.entity.geo.location;

import de.digitalcollections.model.geo.CoordinateLocation;
import de.digitalcollections.model.identifiable.entity.geo.location.Cave;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.text.LocalizedText;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class CaveTest extends BaseJsonSerializationTest {

  private Cave createObject() {
    Cave obj = new Cave();
    obj.setLabel(new LocalizedText(Locale.ENGLISH, "Cave"));
    obj.setCoordinateLocation(new CoordinateLocation(48.15093479009475, 11.52559973769878, 0d, 6d));
    return obj;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    Cave geoLocation = createObject();
    checkSerializeDeserialize(
        geoLocation, "serializedTestObjects/identifiable/entity/geo/location/Cave.json");
  }
}
