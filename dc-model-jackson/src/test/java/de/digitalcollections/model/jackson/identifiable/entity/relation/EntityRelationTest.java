package de.digitalcollections.model.jackson.identifiable.entity.relation;

import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class EntityRelationTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    EntityRelation entityRelation = new EntityRelation();

    Article subjectEntity = new Article();
    subjectEntity.setUuid(UUID.randomUUID());
    entityRelation.setSubject(subjectEntity);

    entityRelation.setPredicate("is_describing_provenience");

    DigitalObject objectEntity = new DigitalObject();
    objectEntity.setUuid(UUID.randomUUID());
    entityRelation.setObject(objectEntity);

    checkSerializeDeserialize(entityRelation);
  }
}
