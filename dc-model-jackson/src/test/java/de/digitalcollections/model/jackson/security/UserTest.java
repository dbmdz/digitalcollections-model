package de.digitalcollections.model.jackson.security;

import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.api.paging.impl.PageRequestImpl;
import de.digitalcollections.model.api.paging.impl.PageResponseImpl;
import de.digitalcollections.model.impl.security.UserImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest extends BaseSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    List<UserImpl> content = createContent();
    PageResponseImpl pageResponse = new PageResponseImpl(content);

    PageRequest pageRequest = new PageRequestImpl(3, 15);
    pageResponse.setPageRequest(pageRequest);

    checkSerializeDeserialize(pageResponse);
    
    checkSerializeDeserialize(createUser1());
  }

  private List<UserImpl> createContent() {
    List<UserImpl> list = new ArrayList<>();
    UserImpl user1 = createUser1();
    list.add(user1);
    UserImpl user2 = new UserImpl();
    user2.setEmail("test2@user.de");
    list.add(user2);
    return list;
  }
  
  /*{
"email": "ralf.eichinger@gmail.com",
"enabled": true,
"firstname": "Ralf",
"lastname": "Eichinger",
"passwordHash": "$2a$10$b9tOSUNjxCeQiipFl/QhzeckLGCAOyQLgFs5teAVruvSkL3.tdGdO",
"roles": [
"ADMIN"
],
"uuid": "a8a7f05d-cf90-43d6-a404-3377766bdcbd"
}
  */

  public UserImpl createUser1() {
    UserImpl user1 = new UserImpl();
    user1.setEmail("test1@user.de");
    user1.setPasswordHash("$2a$10$bSUNjxCeQiipFl/QhzeckLGCAOyQLgFs5teAVruvSkL3.tdGdO");
    return user1;
  }
}
