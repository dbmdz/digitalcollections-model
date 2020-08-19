package de.digitalcollections.model.impl.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.work.Item;
import de.digitalcollections.model.impl.identifiable.entity.EntityImpl;
import java.util.Locale;

public class ItemImpl extends EntityImpl implements Item {

  private Locale language;
  private String publicationDate;
  private String publicationPlace;
  private String publisher;
  private String version;

  public ItemImpl() {
    super();
    this.entityType = EntityType.ITEM;
  }

  @Override
  public Locale getLanguage() {
    return language;
  }

  @Override
  public void setLanguage(Locale language) {
    this.language = language;
  }

  @Override
  public String getPublicationDate() {
    return publicationDate;
  }

  @Override
  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  @Override
  public String getPublicationPlace() {
    return publicationPlace;
  }

  @Override
  public void setPublicationPlace(String publicationPlace) {
    this.publicationPlace = publicationPlace;
  }

  @Override
  public String getPublisher() {
    return publisher;
  }

  @Override
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  @Override
  public String getVersion() {
    return version;
  }

  @Override
  public void setVersion(String version) {
    this.version = version;
  }
}
