package de.digitalcollections.model.identifiable;

import static org.assertj.core.api.Assertions.assertThat;

import de.digitalcollections.model.identifiable.alias.LocalizedUrlAliases;
import de.digitalcollections.model.identifiable.alias.UrlAlias;
import de.digitalcollections.model.identifiable.alias.UrlAliasBuilder;
import de.digitalcollections.model.identifiable.entity.Website;
import de.digitalcollections.model.identifiable.entity.WebsiteBuilder;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class IdentifiableTest {
  @Test
  public void getPrimaryUrlAliasTest() {
    Identifiable identifiable = new Identifiable();

    // there are no url aliases at all (null)
    UrlAlias found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, null);
    assertThat(found).isNull();

    // there are no url aliases for the given language
    Website website = new WebsiteBuilder().withUuid(UUID.randomUUID()).build();
    UrlAlias urlAlias =
        new UrlAliasBuilder()
            .isPrimary()
            .withSlug("this-is-a-test")
            .withTargetLanguage(Locale.GERMAN)
            .withWebsite(website)
            .build();
    LocalizedUrlAliases localizedUrlAliases = new LocalizedUrlAliases(urlAlias);
    identifiable.setLocalizedUrlAliases(localizedUrlAliases);
    found = identifiable.getPrimaryUrlAlias(Locale.ENGLISH, null);
    assertThat(found).isNull();

    // there are url aliases for the given language, but not without website
    found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, null);
    assertThat(found).isNull();

    // there are url aliases for the given language, but not the given website or without website
    Website otherWebsite = new WebsiteBuilder().withUuid(UUID.randomUUID()).build();
    found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, otherWebsite);
    assertThat(found).isNull();

    // there are url aliases for the given language, the one without website should be returned
    UrlAlias urlAliasWithoutWebsite =
        new UrlAliasBuilder()
            .isPrimary()
            .withSlug("this-is-a-test-without-website")
            .withTargetLanguage(Locale.GERMAN)
            .build();
    localizedUrlAliases.add(urlAliasWithoutWebsite);
    found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, null);
    assertThat(found).isNotNull();
    assertThat(found.getSlug()).isEqualTo("this-is-a-test-without-website");

    // there are url aliases for the given language, but not with the given website - the one without website should be returned
    found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, otherWebsite);
    assertThat(found).isNotNull();
    assertThat(found.getSlug()).isEqualTo("this-is-a-test-without-website");

    found = identifiable.getPrimaryUrlAlias(Locale.GERMAN, website);
    assertThat(found).isNotNull();
    assertThat(found.getSlug()).isEqualTo("this-is-a-test");
  }
}
