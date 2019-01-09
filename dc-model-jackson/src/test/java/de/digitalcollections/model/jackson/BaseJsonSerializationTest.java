package de.digitalcollections.model.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Set;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class BaseJsonSerializationTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(BaseJsonSerializationTest.class);

  protected <T> void checkSerializeDeserialize(T objectIn) throws Exception {
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
      LOGGER.warn(e.toString());
    }
    try {
      assertThat(objectOut).isEqualToComparingFieldByFieldRecursively(objectIn);
    } catch (Throwable e) {
      LOGGER.error("ERR: IN=" + dump(objectIn) + "\nOUT=" + dump(objectOut) + "\n\nERROR=" + e.getClass() + "=" + e.getMessage());
      throw e;
    }
  }

  private Object serializeDeserialize(Object o) throws JsonProcessingException, IOException {
    final ObjectMapper mapper = getMapper();
    String serializedObject = mapper.writeValueAsString(o);
    LOGGER.info("serialized object: '" + serializedObject + "'");
    Class valueType = o.getClass();
    Object deserializedObject = getMapper().readValue(serializedObject, valueType);
    return deserializedObject;
  }

  private String dump(Object o) throws JsonProcessingException {
    return getMapper().writeValueAsString(o);
  }

  protected ObjectMapper getMapper() {
    return new DigitalCollectionsObjectMapper();
  }

  protected String readFromResources(String filename) throws IOException {
    return Resources.toString(Resources.getResource(filename), Charset.defaultCharset());
  }
}
