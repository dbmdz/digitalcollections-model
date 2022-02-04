package de.digitalcollections.model.identifiable;

import de.digitalcollections.model.UniqueObject;
import de.digitalcollections.model.identifiable.alias.LocalizedUrlAliases;
import de.digitalcollections.model.identifiable.resource.ImageFileResource;
import de.digitalcollections.model.text.LocalizedStructuredContent;
import de.digitalcollections.model.text.LocalizedText;
import de.digitalcollections.model.view.RenderingHintsPreviewImage;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/**
 * An Identifiable is an uniquely identifiable {@link
 * de.digitalcollections.model.api.identifiable.entity.Entity} or {@link
 * de.digitalcollections.model.api.identifiable.resource.FileResource}, having one or more unique
 * {@link Identifier}(s).<br>
 *
 * <ul>
 *   <li>FileResources have one (or more) technical (system wide) Identifiers (e.g. an UUID)
 *   <li>Entities additionally have one (or more) “domain-specific” (system independent) Identifiers
 *       (e.g. GND-ID, VIAF-ID)
 * </ul>
 */
public class Identifiable extends UniqueObject {

  protected LocalizedStructuredContent description;
  protected Set<Identifier> identifiers = new HashSet<>();
  protected LocalizedText label;
  protected LocalizedUrlAliases localizedUrlAliases;
  protected ImageFileResource previewImage;
  protected RenderingHintsPreviewImage previewImageRenderingHints;
  protected IdentifiableType type;

  public void addIdentifier(Identifier identifier) {
    identifiers.add(Objects.requireNonNull(identifier));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Identifiable)) {
      return false;
    }
    Identifiable that = (Identifiable) o;
    return Objects.equals(created, that.created)
        && Objects.equals(description, that.description)
        && Objects.equals(identifiers, that.identifiers)
        && Objects.equals(label, that.label)
        && Objects.equals(lastModified, that.lastModified)
        && Objects.equals(localizedUrlAliases, that.localizedUrlAliases)
        && Objects.equals(previewImage, that.previewImage)
        && Objects.equals(previewImageRenderingHints, that.previewImageRenderingHints)
        && type == that.type
        && Objects.equals(uuid, that.uuid);
  }

  public LocalizedStructuredContent getDescription() {
    return description;
  }

  public Identifier getIdentifierByNamespace(String namespace) {
    if (namespace == null || identifiers == null || identifiers.isEmpty()) {
      return null;
    }
    for (Identifier identifier : identifiers) {
      if (namespace.equals(identifier.getNamespace())) {
        return identifier;
      }
    }
    return null;
  }

  public Set<Identifier> getIdentifiers() {
    return identifiers;
  }

  public LocalizedText getLabel() {
    return label;
  }

  public LocalizedUrlAliases getLocalizedUrlAliases() {
    return localizedUrlAliases;
  }

  public ImageFileResource getPreviewImage() {
    return previewImage;
  }

  public RenderingHintsPreviewImage getPreviewImageRenderingHints() {
    return previewImageRenderingHints;
  }

  public IdentifiableType getType() {
    return this.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        created,
        description,
        identifiers,
        label,
        lastModified,
        localizedUrlAliases,
        previewImage,
        previewImageRenderingHints,
        type,
        uuid);
  }

  public void setDescription(LocalizedStructuredContent description) {
    this.description = description;
  }

  public void setIdentifiers(Set<Identifier> identifiers) {
    this.identifiers = identifiers;
  }

  public void setLabel(String label) {
    this.label = new LocalizedText(Locale.ROOT, label);
  }

  public void setLabel(LocalizedText label) {
    this.label = label;
  }

  public void setLocalizedUrlAliases(LocalizedUrlAliases localizedUrlAliases) {
    this.localizedUrlAliases = localizedUrlAliases;
  }

  public void setPreviewImage(ImageFileResource previewImage) {
    this.previewImage = previewImage;
  }

  public void setPreviewImageRenderingHints(RenderingHintsPreviewImage previewImageRenderingHints) {
    this.previewImageRenderingHints = previewImageRenderingHints;
  }

  public void setType(IdentifiableType identifiableType) {
    this.type = identifiableType;
  }
}
