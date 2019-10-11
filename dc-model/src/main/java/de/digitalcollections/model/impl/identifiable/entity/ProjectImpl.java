package de.digitalcollections.model.impl.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.Project;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;

public class ProjectImpl extends EntityImpl implements Project {

  private LocalDate endDate;
  private LocalDate startDate;
  private LocalizedStructuredContent text;

  public ProjectImpl() {
    super();
    this.entityType = EntityType.PROJECT;
  }

  @Override
  public LocalDate getEndDate() {
    return endDate;
  }

  @Override
  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  @Override
  public LocalDate getStartDate() {
    return startDate;
  }

  @Override
  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  @Override
  public LocalizedStructuredContent getText() {
    return text;
  }

  @Override
  public void setText(LocalizedStructuredContent text) {
    this.text = text;
  }
}
