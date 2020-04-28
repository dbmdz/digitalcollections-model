# Digitalcollections Model

[![Javadocs](https://javadoc.io/badge/de.digitalcollections.model/dc-model-parent.svg)](https://javadoc.io/doc/de.digitalcollections.model/dc-model-parent)
[![Build Status](https://img.shields.io/travis/dbmdz/digitalcollections-model/master.svg)](https://travis-ci.org/dbmdz/digitalcollections-model)
[![Codecov](https://img.shields.io/codecov/c/github/dbmdz/digitalcollections-model/master.svg)](https://codecov.io/gh/dbmdz/digitalcollections-model)
[![License](https://img.shields.io/github/license/dbmdz/digitalcollections-model.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/digitalcollections-model.svg)](https://github.com/dbmdz/digitalcollections-model/releases)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections.model/dc-model-parent.svg)](https://search.maven.org/search?q=a:dc-model-parent)

Java library containing Domain Object classes of the Digital Collection's and Digital Humanities ecosystem.
Primarily started from the needs for [GLAM](https://en.wikipedia.org/wiki/GLAM_%28industry_sector%29)s (Galleries, Libraries, Archives, Museums) but not restricted to it.

Comes with separate modules for serializing the objects
- to JSON (dc-model-jackson module) using [Jackson](https://github.com/FasterXML/jackson)
- to XML (dc-model-xml module) using [XStream](https://x-stream.github.io/)

## Filtering-Model

Model for passing filter params from frontend to backend.

Example usage (return only webpages with active publication time range):

```java
  public PageResponse<Webpage> findAll(
      @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
      @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize,
      @RequestParam(name = "sortField", required = false, defaultValue = "uuid") String sortField,
      @RequestParam(name = "sortDirection", required = false, defaultValue = "ASC") Direction sortDirection,
      @RequestParam(name = "nullHandling", required = false, defaultValue = "NATIVE") NullHandling nullHandling
  ) {
    OrderImpl order = new OrderImpl(sortDirection, sortField, nullHandling);
    Sorting sorting = new SortingImpl(order);

    LocalDate now = LocalDate.now();
    Filtering filtering = Filtering.defaultBuilder()
            .add(new FilterCriteriaImpl<>("publicationStart", FilterOperation.LESSTHAN_OR_EQUAL_TO, now))
            .add(new FilterCriteriaImpl<>("publicationEnd", FilterOperation.GREATER_THAN_OR_EQUAL_TO, now))
            .build();

    PageRequest pageRequest = new PageRequestImpl(pageNumber, pageSize, sorting, filtering);
  ...
```