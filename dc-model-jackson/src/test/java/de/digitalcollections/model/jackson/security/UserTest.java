package de.digitalcollections.model.jackson.security;

import de.digitalcollections.cudami.model.jackson.BaseSerializationTest;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.impl.paging.PageRequestImpl;
import de.digitalcollections.model.impl.paging.PageResponseImpl;
import de.digitalcollections.model.impl.security.UserImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class UserTest extends BaseSerializationTest {

  @Test
  public void testSerialisationInBothWays() throws Exception {
    List<UserImpl> content = createContent();
    PageResponseImpl pageResponse = new PageResponseImpl(content);

    PageRequest pageRequest = new PageRequestImpl(3, 15);
    pageResponse.setPageRequest(pageRequest);

    checkSerializeDeserialize(pageResponse);
  }

  private List<UserImpl> createContent() {
    List<UserImpl> list = new ArrayList<>();
    UserImpl user1 = new UserImpl();
    user1.setEmail("test1@user.de");
    list.add(user1);
    UserImpl user2 = new UserImpl();
    user2.setEmail("test2@user.de");
    list.add(user2);
    return list;
  }
}
