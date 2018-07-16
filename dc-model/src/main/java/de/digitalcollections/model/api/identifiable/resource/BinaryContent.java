package de.digitalcollections.model.api.identifiable.resource;

import java.net.URL;

/**
 * BinaryContent is used for binary content like PDF, video, audio, image.
 */
public interface BinaryContent extends Resource {

  long getSizeInBytes();

  void setSizeInBytes(long sizeInBytes);

  URL getPreviewUrl();

  void setPreviewUrl(URL previewUrl);

  MimeType getMimeType();

  void setMimeType(MimeType mimeType);
}
