package de.digitalcollections.model.impl.navigation;

import de.digitalcollections.model.api.navigation.ListItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BreadcrumbListImplTest {

  private BreadcrumbListImpl breadcrumbList;

  @BeforeEach
  private void beforeEach() {
    breadcrumbList = new BreadcrumbListImpl();
  }

  @Test
  private void testEmptyListItems() {
    assertThat(breadcrumbList.getItemListElement()).isNotNull();
    assertThat(breadcrumbList.getItemListElement()).hasSize(0);
    assertThat(breadcrumbList.getType()).isEqualTo("BreadcrumbList");
    assertThat(breadcrumbList.getContext()).isEqualTo("http://schema.org");
  }

  @Test
  private void ensureThatItemsAreSortedAccordingToTheirPosition() {
    breadcrumbList.addListItem(new ListItemImpl(2,"name2","item2"));
    breadcrumbList.addListItem(new ListItemImpl(1,"name1","item1"));

    ListItem item1 = breadcrumbList.getItemListElement().get(0);
    assertThat(item1.getPosition()).isEqualTo(1);
    assertThat(item1.getName()).isEqualTo("name1");
    assertThat(item1.getItem()).isEqualTo("item1");
    assertThat(item1.getType()).isEqualTo("ListItem");
    ListItem item2 = breadcrumbList.getItemListElement().get(1);
    assertThat(item2.getPosition()).isEqualTo(2);
    assertThat(item2.getName()).isEqualTo("name2");
    assertThat(item2.getItem()).isEqualTo("item2");
  }

}