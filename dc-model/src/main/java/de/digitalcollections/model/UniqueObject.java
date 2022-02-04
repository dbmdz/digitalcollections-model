package de.digitalcollections.model;

import java.time.LocalDateTime;
import java.util.UUID;

/** An unique model object being identifiable and referencable by its universal unique UUID. */
public abstract class UniqueObject {

  protected LocalDateTime created;
  protected LocalDateTime lastModified;
  protected UUID uuid;

  /** @return the creation date of the object */
  public LocalDateTime getCreated() {
    return created;
  }

  /** @return the date of last modification of the object */
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  /** @return the universal unique id of the object */
  public UUID getUuid() {
    return uuid;
  }

  /** @param created the creation date of the object */
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  /** @param lastModified the date of last modification of the object */
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  /** @param uuid the universal unique id of the object */
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
