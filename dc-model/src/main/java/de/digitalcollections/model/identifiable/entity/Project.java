package de.digitalcollections.model.identifiable.entity;

import de.digitalcollections.model.text.LocalizedStructuredContent;
import java.time.LocalDate;

/**
 * Project is used to describe a project (like a digitization project or an electronic publishing
 * project). See also https://schema.org/Project (Thing - Organization - Project)
 */
public class Project extends Entity {

  private LocalDate endDate;
  private LocalDate startDate;
  private LocalizedStructuredContent text;

  public Project() {
    super();
    this.entityType = EntityType.PROJECT;
  }

  /** @return date when project ended (null if still running) */
  public LocalDate getEndDate() {
    return endDate;
  }

  /** @return date when project was started */
  public LocalDate getStartDate() {
    return startDate;
  }

  /** @return localized formatted text describing project */
  public LocalizedStructuredContent getText() {
    return text;
  }

  /** @param endDate set date when project ended */
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  /** @param startDate set date when project starts/started (may be in the future) */
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  /** @param text set localized formatted text describing project */
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends Entity.Builder<Project, Builder> {

    @Override
    protected EntityType getEntityType() {
      return EntityType.PROJECT;
    }
  }

}
