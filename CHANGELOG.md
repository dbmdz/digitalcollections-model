# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

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
