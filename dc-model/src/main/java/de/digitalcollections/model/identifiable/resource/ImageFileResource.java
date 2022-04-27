package de.digitalcollections.model.identifiable.resource;

import de.digitalcollections.model.file.MimeType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ImageFileResource)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ImageFileResource that = (ImageFileResource) o;
    return height == that.height && width == that.width;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), height, width);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends FileResource.Builder<ImageFileResource, Builder> {

    public Builder withHeight(int height) {
      identifiable.setHeight(height);
      return this;
    }

    public Builder withWidth(int width) {
      identifiable.setWidth(width);
      return this;
    }
  }

  public static PreviewImageBuilder previewImageBuilder() {
    return new PreviewImageBuilder();
  }

  public static class PreviewImageBuilder {

    ImageFileResource previewImage;

    public PreviewImageBuilder() {
      previewImage = new ImageFileResource();
      previewImage.setFileResourceType(FileResourceType.IMAGE);
      previewImage.setMimeType(MimeType.MIME_IMAGE);
    }

    public PreviewImageBuilder(String uuid) {
      this();
      previewImage.setUuid(UUID.fromString(uuid));
    }

    public ImageFileResource build() {
      previewImage.setFileResourceType(FileResourceType.IMAGE);
      if (previewImage.getMimeType() == null) {
        previewImage.setMimeType(MimeType.MIME_IMAGE);
      }
      return previewImage;
    }

    public PreviewImageBuilder withFileName(String fileName) {
      previewImage.setFilename(fileName);
      return this;
    }

    public PreviewImageBuilder withUri(String uri) {
      previewImage.setUri(URI.create(uri));
      return this;
    }

    public PreviewImageBuilder withMimeType(MimeType mimeType) {
      previewImage.setMimeType(mimeType);
      return this;
    }

    public PreviewImageBuilder withHttpBaseUrl(String httpBaseUrl) {
      try {
        previewImage.setHttpBaseUrl(new URL(httpBaseUrl));
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
      return this;
    }

    public PreviewImageBuilder withSize(int width, int height) {
      previewImage.setWidth(width);
      previewImage.setHeight(height);
      return this;
    }

    public PreviewImageBuilder withUuid(UUID uuid) {
      previewImage.setUuid(uuid);
      return this;
    }

    public PreviewImageBuilder withUuid(String uuid) {
      previewImage.setUuid(UUID.fromString(uuid));
      return this;
    }
  }
}
