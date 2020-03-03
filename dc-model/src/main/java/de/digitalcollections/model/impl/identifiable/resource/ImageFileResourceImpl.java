package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.api.identifiable.resource.enums.FileResourceType;
import java.net.URL;

public class ImageFileResourceImpl extends FileResourceImpl implements ImageFileResource {

  private int height;
  private URL iiifBaseUrl;
  private int width;

  public ImageFileResourceImpl() {
    super();
    this.fileResourceType = FileResourceType.IMAGE;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public URL getIiifBaseUrl() {
    return iiifBaseUrl;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public void setIiifBaseUrl(URL iiifBaseUrl) {
    this.iiifBaseUrl = iiifBaseUrl;
  }

  @Override
  public void setHeight(int height) {
    this.height = height;
  }
}
