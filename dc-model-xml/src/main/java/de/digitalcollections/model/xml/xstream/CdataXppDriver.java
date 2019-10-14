package de.digitalcollections.model.xml.xstream;

import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import java.io.Writer;

public class CdataXppDriver extends XppDriver {

  @Override
  public HierarchicalStreamWriter createWriter(Writer out) {
    return new PrettyPrintWriter(out) {
      boolean cdata = false;

      @Override
      @SuppressWarnings(value = "rawtypes")
      public void startNode(String name, Class clazz) {
        cdata = "body".equalsIgnoreCase(name);
        super.startNode(name, clazz);
      }

      @Override
      protected void writeText(QuickWriter writer, String text) {
        if (cdata) {
          writer.write("<![CDATA[");
          writer.write(text);
          writer.write("]]>");
        } else {
          super.writeText(writer, text);
        }
      }
    };
  }
}
