package de.digitalcollections.model.xml.xstream;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.MapConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;
import java.util.Map;
import java.util.Set;

public class MapToFlatConverter extends MapConverter {

  public MapToFlatConverter(Mapper mapper) {
    super(mapper);
  }

  @Override
  public boolean canConvert(Class type) {
    return Map.class.isAssignableFrom(type);
  }

  @Override
  public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    Map<Object, Object> map = (Map<Object, Object>) source;
    Set<Object> keySet = map.keySet();
    if (keySet != null && !keySet.isEmpty() && keySet.iterator().next() instanceof String) {
      for (Map.Entry<Object, Object> entry : map.entrySet()) {
        if (entry.getValue() != null) {
          writer.startNode(entry.getKey().toString());
          writer.setValue(entry.getValue().toString());
          writer.endNode();
        }
      }
    } else {
      super.marshal(source, writer, context);
    }
  }

  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    return null;
  }
}
