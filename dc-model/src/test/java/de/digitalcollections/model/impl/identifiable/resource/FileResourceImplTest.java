package de.digitalcollections.model.impl.identifiable.resource;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FileResourceImplTest {

  /**
   * Test of getFilenameExtension method, of class FileResourceImpl.
   */
  @Test
  public void testGetFilenameExtension() {
    System.out.println("getFilenameExtension");
    FileResourceImpl instance = new FileResourceImpl();
    
    instance.setFilename("image001.jpg");
    String expResult = "jpg";
    String result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename("image001.txt.jpg");
    expResult = "jpg";
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename(".bashrc");
    expResult = "bashrc";
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename("image.j");
    expResult = "j";
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename("image.");
    expResult = null;
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename("image");
    expResult = null;
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename(".");
    expResult = null;
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename("..");
    expResult = null;
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);

    instance.setFilename(null);
    expResult = null;
    result = instance.getFilenameExtension();
    assertEquals(expResult, result);
  }
}
