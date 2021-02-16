package de.digitalcollections.model.jackson.security;

import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import de.digitalcollections.model.security.User;
import org.junit.jupiter.api.Test;

public class UserTest extends BaseJsonSerializationTest {

  public User createUser1() {
    User user1 = new User();
    user1.setEmail("test1@user.de");
    user1.setPasswordHash("$2a$10$bSUNjxCeQiipFl/QhzeckLGCAOyQLgFs5teAVruvSkL3.tdGdO");
    return user1;
  }

  @Test
  public void testSerialisationInBothWays() throws Exception {
    checkSerializeDeserialize(createUser1());
  }
}
