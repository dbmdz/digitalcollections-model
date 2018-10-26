package de.digitalcollections.model.api.identifiable.resource;

/**
 * An image file resource. Mimetype starts with "image/".
 */
public interface ImageFileResource extends FileResource {

  /**
   * @return width in pixel
   */
  int getWidth();

  /**
   * @return height in pixel
   */
  int getHeight();

  /**
   * @param width width in pixel
   */
  void setWidth(int width);

  /**
   * @param height height in pixel
   */
  void setHeight(int height);
}
