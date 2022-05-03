package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.identifiable.web.Webpage;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import lombok.experimental.SuperBuilder;

/** A Website. */
@SuperBuilder(buildMethodName = "prebuild")
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

  public List<? extends Webpage> getRootPages() {
    return rootPages;
  }

  public void setRootPages(List<? extends Webpage> rootPages) {
    this.rootPages = rootPages;
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

  public abstract static class WebsiteBuilder<
      C extends Website, B extends WebsiteBuilder<C, B>>
      extends EntityBuilder<C, B> {

    @Override
    public C build() {
      C c = prebuild();
      c.setEntityType(EntityType.WEBSITE);
      return c;
    }
  }
}
