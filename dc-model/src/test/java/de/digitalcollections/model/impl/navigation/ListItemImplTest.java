package de.digitalcollections.model.impl.navigation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ListItemImplTest {

  private ListItemImpl listItem;

  @BeforeEach
  public void beforeEach() {
    listItem = new ListItemImpl();
  }

  @Test
  public void testDefaultAttributes() {
    assertThat(listItem.getType()).isEqualTo("ListItem");
  }

  @Test
  public void testToIncreaseCoverage() {
    listItem = new ListItemImpl(1, "name", "item");
    assertThat(listItem.getItem()).isEqualTo("item");
    assertThat(listItem.getName()).isEqualTo("name");
    assertThat(listItem.getPosition()).isEqualTo(1);
  }
}