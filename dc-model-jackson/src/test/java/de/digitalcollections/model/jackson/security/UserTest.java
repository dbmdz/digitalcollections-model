package de.digitalcollections.model.jackson.security;

import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.security.User;
import de.digitalcollections.model.impl.security.UserImpl;
import org.junit.jupiter.api.Test;

public class UserTest extends BaseSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(createUser1());
  }

  public User createUser1() {
    User user1 = new UserImpl();
    user1.setEmail("test1@user.de");
    user1.setPasswordHash("$2a$10$bSUNjxCeQiipFl/QhzeckLGCAOyQLgFs5teAVruvSkL3.tdGdO");
    return user1;
  }
}
