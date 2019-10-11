package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;

/**
 * Project is used to describe a project (like a digitization project or an electronic publishing project).
 */
public interface Project extends Entity {

  /** @return localized formatted text describing project */
  LocalizedStructuredContent getText();

  /** @param text set localized formatted text describing project*/
  void setText(LocalizedStructuredContent text);

  /** @return date when project was started */
  LocalDate getStartDate();

  /** @param startDate set date when project starts/started (may be in the future) */
  void setStartDate(LocalDate startDate);

  /** @return date when project ended (null if still running) */
  LocalDate getEndDate();

  /** @param endDate set date when project ended */
  void setEndDate(LocalDate endDate);
}
