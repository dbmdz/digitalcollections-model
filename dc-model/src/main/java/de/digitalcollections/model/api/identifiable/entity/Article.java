package de.digitalcollections.model.api.identifiable.entity;

import de.digitalcollections.model.api.identifiable.entity.agent.Agent;
import de.digitalcollections.model.api.identifiable.parts.structuredcontent.LocalizedStructuredContent;
import java.time.LocalDate;
import java.util.List;
import org.wikidata.wdtk.datamodel.interfaces.TimeValue;

/**
 * Article is used to manage cultural articles and their hierarchy.
 *
 * @param <A> an article instance
 */
public interface Article<A extends Article> extends Entity {

  List<Agent> getCreators();

  void setCreators(List<Agent> creators);

  LocalDate getDatePublished();

  void setDatePublished(LocalDate datePublished);

  LocalizedStructuredContent getText();

  void setText(LocalizedStructuredContent text);

  TimeValue getTimeValuePublished();

  void setTimeValuePublished(TimeValue timeValuePublished);
}
