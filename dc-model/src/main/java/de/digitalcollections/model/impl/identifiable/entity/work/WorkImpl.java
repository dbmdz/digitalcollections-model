package de.digitalcollections.model.impl.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.agent.Agent;
import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.work.Work;
import de.digitalcollections.model.impl.identifiable.entity.EntityImpl;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

public class WorkImpl extends EntityImpl implements Work {

  private List<Agent> creators = new ArrayList<>();
  private LocalDate datePublished;
  private TimeValue timeValuePublished;

  public WorkImpl() {
    super();
    this.entityType = EntityType.WORK;
  }

  @Override
  public List<Agent> getCreators() {
    return creators;
  }

  @Override
  public void setCreators(List<Agent> creators) {
    this.creators = creators;
  }

  @Override
  public LocalDate getDatePublished() {
    return datePublished;
  }

  @Override
  public TimeValue getTimeValuePublished() {
    return timeValuePublished;
  }

  @Override
  public void setDatePublished(LocalDate datePublished) {
    this.datePublished = datePublished;
  }

  @Override
  public void setTimeValuePublished(TimeValue timeValuePublished) {
    this.timeValuePublished = timeValuePublished;
  }
}
