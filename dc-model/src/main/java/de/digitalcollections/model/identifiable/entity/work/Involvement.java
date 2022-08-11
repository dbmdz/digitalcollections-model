package de.digitalcollections.model.identifiable.entity.work;

import de.digitalcollections.model.identifiable.entity.agent.Agent;
import de.digitalcollections.model.identifiable.entity.geo.location.HumanSettlement;
import java.util.List;
import java.util.Set;

public class Involvement {

  /** involved agent */
  private Agent agent;

  /**
   * true if agent is a creator of the related work, false if agent is not a creator of the related
   * work, null if role not clear
   */
  private Boolean isCreator;

  /** a human settlement (city, village, etc.) the involvement of the agent took place */
  private HumanSettlement involvementPlace;

  /** set of involvement roles the agent is involved in the related work */
  private Set<InvolvementRole> involvementRoles;

  /** to be used for displaying original involvement roles */
  private List<String> involvementRolesPresentation;

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  public Boolean getIsCreator() {
    return isCreator;
  }

  public void setIsCreator(Boolean isCreator) {
    this.isCreator = isCreator;
  }

  public HumanSettlement getInvolvementPlace() {
    return involvementPlace;
  }

  public void setInvolvementPlace(HumanSettlement involvementPlace) {
    this.involvementPlace = involvementPlace;
  }

  public Set<InvolvementRole> getInvolvementRoles() {
    return involvementRoles;
  }

  public void setInvolvementRoles(Set<InvolvementRole> involvementRoles) {
    this.involvementRoles = involvementRoles;
  }

  public List<String> getInvolvementRolesPresentation() {
    return involvementRolesPresentation;
  }

  public void setInvolvementRolesPresentation(List<String> involvementRolesPresentation) {
    this.involvementRolesPresentation = involvementRolesPresentation;
  }
}
