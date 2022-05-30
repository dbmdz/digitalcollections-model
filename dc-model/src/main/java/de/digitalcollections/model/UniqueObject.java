package de.digitalcollections.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.experimental.SuperBuilder;

/** An unique model object being identifiable and referencable by its universal unique UUID. */
@SuperBuilder(buildMethodName = "prebuild")
public abstract class UniqueObject {

  protected LocalDateTime created;
  protected LocalDateTime lastModified;
  protected UUID uuid;

  public UniqueObject() {
    init();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof UniqueObject)) {
      return false;
    }
    UniqueObject other = (UniqueObject) obj;
    return Objects.equals(created, other.created)
        && Objects.equals(lastModified, other.lastModified)
        && Objects.equals(uuid, other.uuid);
  }

  /**
   * @return the creation date of the object
   */
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * @return the date of last modification of the object
   */
  public LocalDateTime getLastModified() {
    return lastModified;
  }

  /**
   * @return the universal unique id of the object
   */
  public UUID getUuid() {
    return uuid;
  }

  @Override
  public int hashCode() {
    return Objects.hash(created, lastModified, uuid);
  }

  /** Use to initialize member variables, used by default constructor and builder */
  protected void init() {}

  /**
   * @param created the creation date of the object
   */
  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  /**
   * @param lastModified the date of last modification of the object
   */
  public void setLastModified(LocalDateTime lastModified) {
    this.lastModified = lastModified;
  }

  /**
   * @param uuid the universal unique id of the object
   */
  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public abstract static class UniqueObjectBuilder<
      C extends UniqueObject, B extends UniqueObjectBuilder<C, B>> {

    public C build() {
      C c = prebuild();
      c.init();
      return c;
    }

    public B created(String created) {
      this.created = LocalDateTime.parse(created);
      return self();
    }

    public B created(LocalDateTime created) {
      this.created = created;
      return self();
    }

    public UUID getUuid() {
      return uuid;
    }

    public B lastModified(String lastModified) {
      this.lastModified = LocalDateTime.parse(lastModified);
      return self();
    }

    public B lastModified(LocalDateTime lastModified) {
      this.lastModified = lastModified;
      return self();
    }

    public B randomUuid() {
      this.uuid = UUID.randomUUID();
      return self();
    }

    public B uuid(String uuid) {
      this.uuid = UUID.fromString(uuid);
      return self();
    }

    public B uuid(UUID uuid) {
      this.uuid = uuid;
      return self();
    }
  }
}
