package de.digitalcollections.model.jackson.identifiable.entity;

import de.digitalcollections.model.impl.identifiable.entity.ArticleImpl;
import de.digitalcollections.model.impl.identifiable.entity.DigitalObjectImpl;
import de.digitalcollections.model.impl.identifiable.entity.EntityRelationImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.Test;

public class EntityRelationTest extends BaseJsonSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    EntityRelationImpl entityRelation = new EntityRelationImpl();

    ArticleImpl subjectEntity = new ArticleImpl();
    entityRelation.setSubject(subjectEntity);

    entityRelation.setPredicate("is_describing_provenience");

    DigitalObjectImpl objectEntity = new DigitalObjectImpl();
    entityRelation.setObject(objectEntity);

    checkSerializeDeserialize(entityRelation);
  }

}
