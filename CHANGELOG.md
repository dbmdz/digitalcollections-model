# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [12.2.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/12.2.1) - 2023-09-15

### Fixed

- Buuilders don't reset the `identifiableObjectType` anymore, if previously set


## [12.2.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/12.2.0) - 2023-09-12

### Added

- Added missing builders and missing `hashCode`, `equals`, `toString` methods
- Added mapping logic for table elements to `HtmlMapper`
- Added possibility to define a custom parser in `HtmlMapper`
- Added builder for `RenderingHints`

## [12.1.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/12.1.0) - 2023-08-01

### Added

- Add field `labelNormalized` to `Headword` to allow language independent sorting and searching in a normalized version of `label`.

## [12.0.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/12.0.1) - 2023-07-06

### Fixed

- LocalizedUrlAliases must contain a `targetLanguage`, also in builder

### Changed

- Dependency updates

## [12.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/12.0.0) - 2023-06-06

### Added

- New fields in `Work`
- New fields in `Manifestation`
- New models: `Subject`, `Publisher`, `Title`, `Tag`, `LocalDateRange`, `TimeValueRange`, `PublicationInfo`, `DistributionInfo`, `ProductionInfo`,
- New models: Interface `ManagedContent` and Enumeration `PublicationStatus` for content being managed in a content management system and having different states of publication ("online visibility")
- New subtypes `MainSubType`, `ExpressionType`, `TitleType`, `WorkType`
- Add field `tags` to `Identifiable`
- Bucket-Handling: Bucket (Sublist/Range of UniqueObjects), BucketRequest/Response and List of Bucket-Objects-Handling added
- `EntityRelation` can contain additional predicates
- **Breaking**: Jackson-MixIns (type info `objectType`) for classes directly extending `UniqueObject` (`Headword, Identifiable, Identifier, IdentifierType, License, Predicate, RenderingTemplate, User`)
- **Breaking**: Predicate's description field changed from LocalizedText to LocalizedStructuredContent
- Add submodule "mappings" with submodule "html" for mapping HTML code (currently supporting ul, li, a) to DC-Model StructuredContent
- Add convenience method addLocalizedUrlAlias(UrlAlias urlAlias) to Identifiable
- ValidationError/ValidationException classes for providing field specific validation errors over system borders (e.g. via REST)
- Property `subjects` to `Identifiable`
- Add `EntityToFileResourceRelation`, `IdentifiableToEntityRelation`, `IdentifiableToFileResourceRelation`

### Changed

- Deprecated `PagingInfo` after adding paging util method `List<PageItem> getNavItems(int maxNumberOfItems)` to `PageResponse`.
- `Collection` implements `ManagedContent`
- **Breaking**: Moved WEMI classes into new packaged structure
- Set "ignore unknown properties" as default (removes several `JsonIgnoreProperties` annotations)
- Fix `FilterCriterion.Builder` for native expressions (no longer setting native expression flag at the beginning necessary)
- Updated `FilerCriterion` example documentation in `README.md`
- **Breaking**: Replace flat uuid members with targeted objects instead: Replace DB-oriented fields targetIdentitfiableType, targetIdentifiableObjectType, targetUuid in UrlAlias with target Identifiable holding these data
- Use Builders for test creation of objects
- **Breaking**: remove error prone Identifier-constructor with two strings (namespace, id) - use Builder instead
- **Breaking**: introduce lombok for all (uniqueobject) model objects (replacing other builders). access now by `.builder()`

### Removed

- **Breaking**: Removed `Expression` (which is now part of `Manifestation`) including corresponding `IdentifiableObjectType`
- **Breaking**: Removed `title` attribute from `Work` (which is now part of `Manifestation`)
- **Breaking**: Removed `WorkType` and `creators` from `Work`
- **Breaking**: In `UniqueObject` and its descendants empty collections and strings are not serialized (no empty brackets) except for `identifiers` and `User#roles`
- `Work` and `Manifestation`: Subjects are inherited from `Identifiable` instead of being their own properties
- remove test specific `PreviewImageBuilder` from model
- **Breaking**: remove `Identifiable` member from Identifier (as it always comes in pair with the related Identifiable), caused recursion.
- **Breaking**: remove deprecated getTargetEntityType from UrlAlias

## [11.0.3](https://github.com/dbmdz/digitalcollections-model/releases/tag/11.0.3) - 2023-04-14

### Fixed

- Fixed deserialization (unknown `objectType` and `listRequestType`)

## [11.0.2](https://github.com/dbmdz/digitalcollections-model/releases/tag/11.0.2) - 2023-03-29

### Fixed

- Do not serialize empty collections (empty JSON array)
- Initialised properties of a collection type with empty collections, with capacity of `0`

## [11.0.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/11.0.1) - 2022-08-22

### Changed

- Fixed deserialization of `CorporateBody`

## [11.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/11.0.0) - 2022-07-18

### Added

- New fields in `Item`
- Ability to remove an Identifier of an (inherited) `Identifiable`
- Builder for `Identifier`

### Changed

- **Breaking**: Changed the type of `numberOfBinaryResources` in `DigitalObject` from `int` to `Integer`, so it can also be `null`

### Removed

- **Breaking**: Removed obsolete fields `language`, `publicationDate`,
  `publicationPlace`, `publisher` and `version` in `Item` since they
  belong to the Manifestation/Expression.

## [10.0.2](https://github.com/dbmdz/digitalcollections-model/releases/tag/10.0.2) - 2022-06-21

### Removed

- Removed setter of field `targetEntityType` in `UrlAlias`
- Removed field `targetEntityType` from `equals` in `UrlAlias`

## [10.0.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/10.0.1) - 2022-06-20

### Changed

- Fixed getter of field `targetEntityType`

## [10.0.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/10.0.0) - 2022-06-07

### Added

- Added `IdentifiableObjectType` enumeration to specify all types of `Identifiable`s
- Added `identifiableObjectType` field to `Identifiable` (and all inherited classes)
- Added `targetIdentifiableObjectType` field to `UrlAlias`
- Added `searchTerm` to `ListRequest` and `executedSearchTerm` to `ListResponse`

### Changed

- **Breaking**: Refactored Builder classes into inner classes of their belonging model classes and made their API consistent
- **Breaking**: Set ignore case as default for sorting order
- **Breaking**: If Mimetype can not be detected for a filename (or extension) "application/octet-stream" (instead of null) is returned.
- **Breaking**: Refactored `ListRequest`, `ListResponse`, `PageRequest` and `PageResponse` packages

### Removed

- Removed build with Java 8
- Removed `Entity.entityType` field (deprecated `getEntityType` method)
- **Breaking**: Removed `SearchPageRequest` and `SearchPageResponse`

## [9.2.0](https://github.com/dbmdz/digitalcollections-model/releases/tag/9.2.0) - 2022-04-06

### Added

- Added some more builders
- Added new domain model diagram
- Added missing geo location domain classes: Canyon, Cave, Continent, Country, Creek, Lake, Mountain, Ocean, River, Sea, StillWaters, Valley
- Added (de)serialization tests for all geo location types
- Added a less verbose domain model diagram
- Added new attributes to
  - [`DigitalObject`](https://github.com/dbmdz/digitalcollections-model/blob/main/dc-model/src/main/java/de/digitalcollections/model/identifiable/entity/DigitalObject.java)
- Introduced `navDate` to `Entity` to make positioning entities on a timeline possible.

## [9.1.1](https://github.com/dbmdz/digitalcollections-model/releases/tag/9.1.1) - 2022-03-17

### Added

- Added convenience methode for url aliases: `getPrimaryUrlAlias`

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
