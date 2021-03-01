package de.digitalcollections.model.jackson.identifiable.entity.relation;

import de.digitalcollections.model.identifiable.entity.Article;
import de.digitalcollections.model.identifiable.entity.DigitalObject;
import de.digitalcollections.model.identifiable.entity.relation.EntityRelation;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class EntityRelationTest extends BaseJsonSerializationTest {

  private EntityRelation createObject() {
    EntityRelation entityRelation = new EntityRelation();
    Article subjectEntity = new Article();
    subjectEntity.setUuid(UUID.fromString("8a9c3c34-c36c-4671-8f2f-9d96a5fc32e4"));
    entityRelation.setSubject(subjectEntity);
    entityRelation.setPredicate("is_describing_provenience");
    DigitalObject objectEntity = new DigitalObject();
    objectEntity.setUuid(UUID.fromString("baf5a649-dd8a-43f2-8fac-f535b311af03"));
    entityRelation.setObject(objectEntity);
    return entityRelation;
  }

  @Test
  public void testSerializeDeserialize() throws Exception {
    EntityRelation entityRelation = createObject();
    checkSerializeDeserialize(
        entityRelation, "serializedTestObjects/identifiable/entity/relation/EntityRelation.json");
  }
}
