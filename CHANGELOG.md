# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- Added a less verbose domain model diagram

### Changed

## [9.1.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/9.1.0) - 2021-09-20

### Added 

- Added url aliases with the classes
  - [`UrlAlias`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/alias/UrlAlias.java)
  - [`LocalizedUrlAliases`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/alias/LocalizedUrlAliases.java)

### Changed

- Improved domain model documentation
- Refactored filtering model, see [here](https://github.com/dbmdz/digitalcollections-model/tree/main/dc-model/src/main/java/de/digitalcollections/model/filter)
- Refactored list query and result model

## [9.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/9.0.0) - 2021-06-05

### Added

- Added [`ToCEntry`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/view/ToCEntry.java)
- Added new breadcrumb navigation with the classes
  - [`BreadcrumbNavigation`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/view/BreadcrumbNavigation.java)
  - [`BreadcrumbNode`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/view/BreadcrumbNode.java)

### Changed

- Removed Api / Impl splitting
- Renamed model implementation classes
- Eliminated package names from serialization

## [8.2.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/8.2.1) - 2021-02-24

### Added

- Added wildcard mimetype for audios, videos and texts

## [8.2.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/8.2.0) - 2021-02-15

### Added

- Added [`FamilyName`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/agent/FamilyName.java)
- Added [`GivenName`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/agent/GivenName.java)

### Changed

- Improved filtering and sorting

## [8.1.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/8.1.0) - 2021-01-21

### Added

- Added [`GeoLocation`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/geo/location/GeoLocation.java)
- Added [`RenderingTemplate`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/impl/view/RenderingTemplate.java)

### Changed

- Fixed serialization
- Added rendering hints to `Webpage`

## [8.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/8.0.0) - 2020-10-20

### Added

- Added custom attributes to `Entity`
- Added documentation diagrams

### Changed

- Fixed serialization

## [7.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/7.0.0) - 2020-10-20

### Added

- Added model classes:
  - [`Item`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/work/Item.java)
  - [`Work`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/work/Work.java)
  - [`Expression`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/work/Expression.java)
  - [`Manifestation`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/work/Manifestation.java)
  - [`Person`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/agent/Person.java)
  - [`CorporateBody`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/agent/CorporateBody.java)
  - [`Family`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/agent/Family.java)
  - [`Agent`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/agent/Agent.java)
  - [`Predicate`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/relation/Predicate.java)
- Added stuff vor video content blocks

### Changed

- Fixed serialization

## [6.2.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/6.2.1) - 2020-09-07

### Changed

- Changed filename handling on `FileResouce` by cutting path if filename is created from uri

## [6.2.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/6.2.0) - 2020-07-22

### Added

- Added breadcrumb navigation

## [6.1.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/6.1.1) - 2020-05-11

### Changed

- Added type information as property instead of as wrapper on serialization

## [6.1.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/6.1.0) - 2020-05-11

### Added

- Added `refId` to `Identifiable`
- Added filtering model, see [here](https://github.com/dbmdz/digitalcollections-model/tree/main/dc-model/src/main/java/de/digitalcollections/model/filter)
- Added basic search page request/response model with paging, see [here](https://github.com/dbmdz/digitalcollections-model/tree/main/dc-model/src/main/java/de/digitalcollections/model/paging)

### Changed

- Updated and fixed serialization
- Renamed ContentTree to Topic
- Renamed ContentNode to Subtopic

## [4.0.3](https://github.com/dbmdz/digitalcollections-model/releases/tag/4.0.2) - 2019-11-25

### Changed

- Updated changelog

## [4.0.2](https://github.com/dbmdz/digitalcollections-model/releases/tag/4.0.2) - 2019-11-25

### Added

- Added xml aliases for table classes
- Added classes for `HorizontalRule`

### Changed

- Fixed possible NPE in accessing mimetype of unknown types

## [4.0.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/4.0.1) - 2019-11-08

### Changed

- Changed return type of `getLocales` in `LocalizedText` from `LinkedHashSet` to `ArrayList`

## [4.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/4.0.0) - 2019-10-23

### Added

- Added structured data navigation model
- Added table content block
- Added `DigitalObject`
- Added `EntityRelation`
- Added `Identifier` and `IdentifierType`
- Added `getIdentifierByNamespace` to `Identifiable`
- Added `ImageFileResource` as preview image to `Identifiable`
- Added entities and fileresources to `ContentNode`
- Added versioning of `DigitalObject`
- Added `License`
- Added `LinkedDataFileResource`
- Added `Corporation` and `Project`
- Added `FindParams` for paging

### Changed

- Added simplified version of `LocalizedStructuredContent`
- Refactored `LocalizedText` to a `HashMap`

### Removed

- Removed OracleJDK from build matrix
- Removed `IdentifiablesContainer` and introduce `EntityPart(Impl)` classes

## [3.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/3.0.0) - 2019-03-12

### Added

- Added static mimetype application/octet-stream

### Changed

- Upgraded dependencies

### Removed

- Deleted `FileResourcePersistenceType` (breaking change)

## [2.2.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/2.2.0) - 2019-01-09

### Added
- Introduced `WebpageFactory` for creating test webpage
- Versioned Model (V1 support)

### Changed

- Fixed badges in `README.md`
- Fixed checkstyle warnings
- Upgraded dependencies
- Migrated unit tests from JUnit 4 to JUnit 5
