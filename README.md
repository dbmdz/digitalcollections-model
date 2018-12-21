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
