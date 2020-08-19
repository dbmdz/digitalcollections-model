package de.digitalcollections.model.impl.identifiable.entity.work;

import de.digitalcollections.model.api.identifiable.entity.enums.EntityType;
import de.digitalcollections.model.api.identifiable.entity.work.Expression;
import de.digitalcollections.model.impl.identifiable.entity.EntityImpl;

public class ExpressionImpl extends EntityImpl implements Expression {

  public ExpressionImpl() {
    super();
    this.entityType = EntityType.EXPRESSION;
  }
}
