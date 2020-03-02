package de.digitalcollections.model.api.identifiable.resource;

import java.net.URL;

/** An image file resource. Mimetype starts with "image/". */
public interface ImageFileResource extends FileResource {

  /** @return width in pixel */
  int getWidth();

  /** @return the iiif base url */
  URL getIiifBaseUrl();

  /** @return height in pixel */
  int getHeight();

  /** @param width width in pixel */
  void setWidth(int width);

  /** @param iiifBaseUrl the iiif base url */
  void setIiifBaseUrl(URL iiifBaseUrl);

  /** @param height height in pixel */
  void setHeight(int height);
}
