package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.web.Webpage;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

/** A Website. */
public class Website extends Entity {

  private LocalDate registrationDate;
  private List<? extends Webpage> rootPages;
  private URL url;

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

  public static Builder builder() {
    return new Builder();
  }

  public LocalDate getRegistrationDate() {
    return registrationDate;
  }

  public List<? extends Webpage> getRootPages() {
    return rootPages;
  }

  public URL getUrl() {
    return url;
  }

  public void setRegistrationDate(LocalDate registrationDate) {
    this.registrationDate = registrationDate;
  }

  public void setRootPages(List<? extends Webpage> rootPages) {
    this.rootPages = rootPages;
  }

  public void setUrl(URL url) {
    this.url = url;
  }

  public static class Builder extends Entity.Builder<Website, Builder> {

    @Override
    protected IdentifiableType getIdentifiableType() {
      return IdentifiableType.ENTITY;
    }

    @Override
    protected EntityType getEntityType() {
      return EntityType.WEBSITE;
    }

    public Builder withUrl(String url) throws MalformedURLException {
      ((Website)identifiable).setUrl(new URL(url));
      return this;
    }

    @Deprecated
    public Builder withDescription(LocalizedStructuredContent description) {
      identifiable.setDescription(description);
      return this;
    }

    public Builder withRootPages(List<Webpage> rootPages) {
      ((Website)identifiable).setRootPages(rootPages);
      return this;
    }
  }
}
