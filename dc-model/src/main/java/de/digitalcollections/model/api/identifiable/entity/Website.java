package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.parts.Webpage;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

/** A Website. */
public interface Website extends Entity {

  List<? extends Webpage> getRootPages();

  void setRootPages(List<? extends Webpage> rootPages);

  LocalDate getRegistrationDate();

  void setRegistrationDate(LocalDate registrationDate);

  URL getUrl();

  void setUrl(URL url);
}
