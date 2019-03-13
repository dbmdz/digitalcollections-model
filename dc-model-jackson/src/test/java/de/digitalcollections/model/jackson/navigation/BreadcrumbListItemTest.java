package de.digitalcollections.model.jackson.navigation;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.model.api.navigation.BreadcrumbList;
import de.digitalcollections.model.impl.navigation.BreadcrumbListImpl;
import de.digitalcollections.model.impl.navigation.ListItemImpl;
import de.digitalcollections.model.jackson.BaseJsonSerializationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadcrumbListItemTest extends BaseJsonSerializationTest {

  public ObjectMapper mapper;

  static final String JSON = "{\n"
      + "  \"@context\": \"https://schema.org\",\n"
      + "  \"@type\": \"BreadcrumbList\",\n"
      + "  \"itemListElement\": [{\n"
      + "    \"@type\": \"ListItem\",\n"
      + "    \"position\": 1,\n"
      + "    \"name\": \"Books\",\n"
      + "    \"item\": \"https://example.com/books\"\n"
      + "  },{\n"
      + "    \"@type\": \"ListItem\",\n"
      + "    \"position\": 2,\n"
      + "    \"name\": \"Authors\",\n"
      + "    \"item\": \"https://example.com/books/authors\"\n"
      + "  },{\n"
      + "    \"@type\": \"ListItem\",\n"
      + "    \"position\": 3,\n"
      + "    \"name\": \"Ann Leckie\",\n"
      + "    \"item\": \"https://example.com/books/authors/annleckie\"\n"
      + "  },{\n"
      + "    \"@type\": \"ListItem\",\n"
      + "    \"position\": 4,\n"
      + "    \"name\": \"Ancillary Justice\",\n"
      + "    \"item\": \"https://example.com/books/authors/ancillaryjustice\"\n"
      + "  }]\n"
      + "}";

  @BeforeEach
  public void setUp() {
    mapper = getMapper();
  }

  @Test
  /**
   * @see https://search.google.com/structured-data/testing-tool
   */
  public void testSerialization() throws Exception {
    BreadcrumbList breadcrumbList = new BreadcrumbListImpl();
    breadcrumbList.addListItem(new ListItemImpl(1, "Books", "https://example.com/books"));
    breadcrumbList.addListItem(new ListItemImpl(2, "Authors", "https://example.com/books/authors"));
    breadcrumbList.addListItem(new ListItemImpl(3, "Ann Leckie", "https://example.com/books/authors/annleckie"));
    breadcrumbList.addListItem(new ListItemImpl(4, "Ancillary Justice", "https://example.com/books/authors/ancillaryjustice"));

    checkSerializeDeserialize(breadcrumbList);

    String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(breadcrumbList);
    assertThat(json.replaceAll("\\s", "")).isEqualTo(JSON.replaceAll("\\s", ""));
  }

  @Test
  public void testDeserializationWithText() throws Exception {
    BreadcrumbList breadcrumbList = mapper.readValue(JSON, BreadcrumbList.class);
    assertThat(breadcrumbList).isNotNull();
    assertThat(breadcrumbList.getItemListElement()).hasSize(4);
    assertThat(breadcrumbList.getItemListElement().get(3).getName()).isEqualTo("Ancillary Justice");
  }
}
