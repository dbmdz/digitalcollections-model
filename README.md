# Digitalcollections Model

[![Build Status](https://travis-ci.org/dbmdz/digitalcollections-model.svg?branch=master)](https://travis-ci.org/dbmdz/digitalcollections-model)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/digitalcollections-model.svg?maxAge=2592000)](https://github.com/dbmdz/digitalcollections-model/releases)
[![codecov](https://codecov.io/gh/dbmdz/digitalcollections-model/branch/master/graph/badge.svg)](https://codecov.io/gh/dbmdz/digitalcollections-model)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections/digitalcollections-model.svg?maxAge=2592000)](https://search.maven.org/search?q=a:digitalcollections-model)

Java library containing Domain Object classes of the Digital Collection's and Digital Humanities ecosystem.
Primarily started from the needs for [GLAM](https://en.wikipedia.org/wiki/GLAM_%28industry_sector%29)s (Galleries, Libraries, Archives, Museums) but not restricted to it.

Comes with separate modules for serializing the objects
- to JSON (dc-model-jackson module) using [Jackson](https://github.com/FasterXML/jackson)
- to XML (dc-model-xml module) using [XStream](http://x-stream.github.io/)
