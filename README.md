# Digitalcollections Model

[![Build Status](https://travis-ci.org/dbmdz/digitalcollections-model.svg?branch=master)](https://travis-ci.org/dbmdz/digitalcollections-model)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/digitalcollections-model.svg?maxAge=2592002)](https://github.com/dbmdz/digitalcollections-model/releases)
[![codecov](https://codecov.io/gh/dbmdz/digitalcollections-model/branch/master/graph/badge.svg)](https://codecov.io/gh/dbmdz/digitalcollections-model)
[![codebeat](https://codebeat.co/badges/3f937c39-9bbf-46ac-a7a2-e9565d117403)](https://codebeat.co/projects/github-com-dbmdz-digitalcollections-model-master)
[![Maven Central](https://img.shields.io/maven-central/v/de.digitalcollections.model/dc-model-parent.svg?maxAge=2592000)](https://search.maven.org/search?q=a:dc-model-parent)

Java library containing Domain Object classes of the Digital Collection's and Digital Humanities ecosystem.
Primarily started from the needs for [GLAM](https://en.wikipedia.org/wiki/GLAM_%28industry_sector%29)s (Galleries, Libraries, Archives, Museums) but not restricted to it.

Comes with separate modules for serializing the objects
- to JSON (dc-model-jackson module) using [Jackson](https://github.com/FasterXML/jackson)
- to XML (dc-model-xml module) using [XStream](http://x-stream.github.io/)
