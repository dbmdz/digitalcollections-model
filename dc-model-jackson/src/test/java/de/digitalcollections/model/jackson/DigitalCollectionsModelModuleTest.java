package de.digitalcollections.model.jackson;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.paging.PageRequest;
import de.digitalcollections.model.impl.paging.PageRequestImpl;
import de.digitalcollections.model.impl.paging.PageResponseImpl;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DigitalCollectionsModelModuleTest {

  ObjectMapper mapper;

  private List<UserImpl> createContent() {
    List<UserImpl> list = new ArrayList<>();
    UserImpl user = new UserImpl("test@user.de");
    list.add(user);
    return list;
  }

  @BeforeEach
  public void setUp() {
    mapper = new ObjectMapper();
    mapper.registerModule(new DigitalCollectionsModelModule());
  }

  @Test
  public void testSerializeDeserializePageResponse() throws Exception {
    // List<T> content, PageRequest pageRequest, long total
    List<UserImpl> content = createContent();
    PageResponseImpl pageResponse = new PageResponseImpl(content);

    PageRequest pageRequest = new PageRequestImpl(3, 15);
    pageResponse.setPageRequest(pageRequest);

    checkSerializeDeserialize(pageResponse);

  }

//  @Test
//  public void testSerializeDeserializeContentInDefaultLocale() throws Exception {
//    Text content = new TextImpl("de", "test");
//
//    checkSerializeDeserialize(content);
//  }
//
//  @Test
//  public void testSerializeDeserializeEmptyContent() throws Exception {
//    Text content = new TextImpl();
//
//    checkSerializeDeserialize(content);
//  }
//
//  @Test
//  public void testSerializeDeserializeContentInSeveralLanguages() throws Exception {
//    Text content = new TextImpl("de", "test");
//    content.setText("it", "testo");
//
//    checkSerializeDeserialize(content);
//  }
  // -------------------------------------------------------------------------------------------------------
  private <T> void checkSerializeDeserialize(T objectIn) throws Exception {
    T objectOut = (T) serializeDeserialize(objectIn);

    try {
      Set<String> keys = BeanUtils.describe(objectIn).keySet();
      for (String key : keys) {
        if ("UUID".equals(key)) {
          BeanUtils.setProperty(objectIn, key, null);
          BeanUtils.setProperty(objectOut, key, null);
        } else {
          BeanUtils.setProperty(objectIn, key + ".UUID", null);
          BeanUtils.setProperty(objectOut, key + ".UUID", null);
        }
      }
    } catch (InvocationTargetException e) {
      System.out.println(e);
    }

    /*
     * try { Method methodGetUuid = objectIn.getClass().getMethod("getUUID"); UUID uuid = (UUID)
     * methodGetUuid.invoke(objectIn); Method methodSetUUid = objectOut.getClass().getMethod("setUUID", UUID.class);
     * methodSetUUid.invoke(objectOut, uuid); } catch (NoSuchMethodException ignore) { }
     */
    try {
      assertThat(objectOut).isEqualToComparingFieldByFieldRecursively(objectIn);
      // System.out.println("IN=" + dump(objectIn) + "\nOUT=" + dump(objectOut) + "\n\n");
    } catch (Throwable e) {
      System.err.println("ERR: IN=" + dump(objectIn) + "\nOUT=" + dump(objectOut) + "\n\nERROR=" + e.getClass() + "=" + e.getMessage());
      throw e;
    }
  }

  private Object serializeDeserialize(Object o) throws JsonProcessingException, IOException {
    String serializedObject = mapper.writeValueAsString(o);
    Class valueType = o.getClass();
    Object deserializedObject = mapper.readValue(serializedObject, valueType);
    return deserializedObject;
  }

  private String dump(Object o) throws JsonProcessingException {
    return mapper.writeValueAsString(o);
  }
}
