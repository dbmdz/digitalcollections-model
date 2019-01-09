package de.digitalcollections.model.impl.identifiable.resource;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileResourceImplTest {

  /**
   * Test of getFilenameExtension method, of class FileResourceImpl.
   */
  @Test
  public void testGetFilenameExtension() {
    FileResourceImpl instance = new FileResourceImpl();

    instance.setFilename("image001.jpg");
    String expResult = "jpg";
    String result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename("image001.txt.jpg");
    expResult = "jpg";
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename(".bashrc");
    expResult = "bashrc";
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename("image.j");
    expResult = "j";
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename("image.");
    expResult = null;
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename("image");
    expResult = null;
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename(".");
    expResult = null;
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename("..");
    expResult = null;
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);

    instance.setFilename(null);
    expResult = null;
    result = instance.getFilenameExtension();
    assertThat(result).isEqualTo(expResult);
  }
}
