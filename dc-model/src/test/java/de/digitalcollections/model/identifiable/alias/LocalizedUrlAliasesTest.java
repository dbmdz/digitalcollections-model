package de.digitalcollections.model.identifiable.alias;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import de.digitalcollections.model.identifiable.IdentifiableType;
import de.digitalcollections.model.identifiable.entity.Website;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class LocalizedUrlAliasesTest {

  @Test
  public void emptyConstructorTest() {
    LocalizedUrlAliases o = new LocalizedUrlAliases();
    assertThat(o).isEmpty();
  }

  @Test
  public void parameterizedConstructorTest() {
    UrlAlias urlAlias = createUrlAlias(null, null);
    LocalizedUrlAliases o = new LocalizedUrlAliases(urlAlias);
    assertThat(o).containsExactly(entry(Locale.GERMAN, List.of(urlAlias)));
  }

  @Test
  public void equalsTest() {
    UrlAlias u1 = createUrlAlias(Locale.ENGLISH, "something"),
        u2 = createUrlAlias(null, "something-else"),
        u3 = createUrlAlias(null, "another-something");
    LocalizedUrlAliases lua1 = new LocalizedUrlAliases(u1, u2, u3),
        lua2 = new LocalizedUrlAliases(u1);
    lua2.add(u3, u2);

    assertThat(lua1.equals(lua2)).isTrue();
  }

  @Test
  public void flattenTest() {
    UrlAlias u1 = createUrlAlias(Locale.ENGLISH, "something"),
        u2 = createUrlAlias(null, "something-else"),
        u3 = createUrlAlias(null, "another-something");
    LocalizedUrlAliases o = new LocalizedUrlAliases(u1, u2, u3);

    assertThat(o.flatten()).containsExactlyInAnyOrder(u1, u2, u3);
  }

  private UrlAlias createUrlAlias(Locale locale, String slug) {
    UrlAlias urlAlias = new UrlAlias();
    urlAlias.setCreated(LocalDateTime.now());
    urlAlias.setSlug(slug == null ? "test" : slug);
    urlAlias.setTargetIdentifiableType(IdentifiableType.RESOURCE);
    urlAlias.setTargetLanguage(locale == null ? Locale.GERMAN : locale);
    urlAlias.setTargetUuid(UUID.randomUUID());
    urlAlias.setUuid(UUID.randomUUID());
    Website website = new Website();
    website.setUuid(UUID.randomUUID());
    urlAlias.setWebsite(website);
    return urlAlias;
  }
}
