package de.digitalcollections.model.identifiable.resource;

public class ImageFileResourceBuilder
    extends FileResourceBuilder<ImageFileResource, ImageFileResourceBuilder> {

  public ImageFileResourceBuilder withHeight(int height) {
    identifiable.setHeight(height);
    return this;
  }

  public ImageFileResourceBuilder withWidth(int width) {
    identifiable.setWidth(width);
    return this;
  }
}
