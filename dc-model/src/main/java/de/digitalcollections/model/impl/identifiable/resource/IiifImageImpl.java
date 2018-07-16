package de.digitalcollections.model.impl.identifiable.resource;

import de.digitalcollections.model.api.identifiable.resource.IiifImage;
import de.digitalcollections.model.api.identifiable.resource.ResourceType;
import java.net.URL;

public class IiifImageImpl extends ResourceImpl implements IiifImage {

  private String iiifImageServiceUri;
  private URL url;

  public IiifImageImpl() {
    super();
    this.resourceType = ResourceType.IIIF_IMAGE;
  }

  public IiifImageImpl(String iiifImageServiceUri) {
    this();
    this.iiifImageServiceUri = iiifImageServiceUri;
  }

  public IiifImageImpl(URL url) {
    this();
    this.url = url;
  }

  @Override
  public String getIiifImageServiceUri() {
    return iiifImageServiceUri;
  }

  @Override
  public void setIiifImageServiceUri(String iiifImageServiceUri) {
    if (iiifImageServiceUri != null) {
      iiifImageServiceUri = iiifImageServiceUri.trim();
      if (iiifImageServiceUri.endsWith("/")) {
        iiifImageServiceUri = iiifImageServiceUri.substring(0, iiifImageServiceUri.lastIndexOf("/"));
      }
    }
    this.iiifImageServiceUri = iiifImageServiceUri;
  }

  @Override
  public URL getUrl() {
//    if (iiifImageServiceUri != null && iiifImageApiVersion != null) {
//      if (IiifImageApiVersion.V1_1 == iiifImageApiVersion) {
//        setUrl(iiifImageServiceUri + "/full/,90/0/native.jpg");
//      } else if (IiifImageApiVersion.V2 == iiifImageApiVersion) {
//        setUrl(iiifImageServiceUri + "/full/,90/0/default.jpg");
//      }
//    }
    return url;
  }

  @Override
  public void setUrl(URL url) {
    this.url = url;
  }
}
