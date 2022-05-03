package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.web.Webpage;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import lombok.experimental.SuperBuilder;

/** A Website. */
@SuperBuilder
public class Website extends Entity {

  private LocalDate registrationDate;
  private List<? extends Webpage> rootPages;
  private URL url;

  public URL getUrl() {
    return url;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public Website() {
    super();
    this.entityType = EntityType.WEBSITE;
  }

  public Website(URL url) {
    this(null, url, null);
  }

  public Website(List<Webpage> rootPages, URL url, LocalDate registrationDate) {
    this();
    this.registrationDate = registrationDate;
    this.rootPages = rootPages;
    this.url = url;
  }
}
