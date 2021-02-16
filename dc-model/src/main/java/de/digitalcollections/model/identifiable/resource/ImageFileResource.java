package de.digitalcollections.model.identifiable.resource;

/** An image file resource. Mimetype starts with "image/". */
public class ImageFileResource extends FileResource {

  private int height;
  private int width;

  public ImageFileResource() {
    super();
    this.fileResourceType = FileResourceType.IMAGE;
  }

  /** @return height in pixel */
  public int getHeight() {
    return height;
  }

  /** @return width in pixel */
  public int getWidth() {
    return width;
  }

  /** @param height height in pixel */
  public void setHeight(int height) {
    this.height = height;
  }

  /** @param width width in pixel */
  public void setWidth(int width) {
    this.width = width;
  }
}
