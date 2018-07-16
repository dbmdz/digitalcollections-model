package de.digitalcollections.model.api.identifiable.resource;

import java.net.URL;

public interface IiifImage extends Resource {

  String getIiifImageServiceUri();

  URL getUrl();

  void setIiifImageServiceUri(String iiifImageServiceUri);

  void setUrl(URL url);
}
