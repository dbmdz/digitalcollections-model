package de.digitalcollections.model.jackson.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.work.Work;
import de.digitalcollections.model.impl.TimeValueImpl;
import de.digitalcollections.model.impl.identifiable.entity.agent.PersonImpl;
import de.digitalcollections.model.impl.identifiable.entity.work.WorkImpl;
import de.digitalcollections.model.impl.identifiable.parts.LocalizedTextImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class WorkTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    Work work = new WorkImpl();
    work.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Zimmer-Gymnastik ohne Geräte"));

    PersonImpl person = new PersonImpl();
    person.setLabel(new LocalizedTextImpl(Locale.GERMAN, "Arnold Hiller"));
    work.setCreators(Arrays.asList(person));

    work.setDatePublished(LocalDate.parse("2020-04-28"));
    TimeValueImpl timeValuePublished =
        new TimeValueImpl(
            2020,
            (byte) 0,
            (byte) 0,
            (byte) 0,
            (byte) 0,
            (byte) 0,
            TimeValueImpl.PREC_YEAR,
            0,
            0,
            0,
            TimeValueImpl.CM_GREGORIAN_PRO);
    work.setTimeValuePublished(timeValuePublished);
    checkSerializeDeserialize(work);
  }
}
