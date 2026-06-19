# Upgrade Plan: blog-api (20260618084655)

- **Generated**: 2026-06-18 08:46:55
- **HEAD Branch**: N/A
- **HEAD Commit ID**: N/A

## Available Tools

**JDKs**
- JDK 17: not available (baseline will be skipped)
- JDK 20: C:\Program Files\Java\jdk-20\bin (available, not used for baseline)
- JDK 21: **<TO_BE_INSTALLED>** (required by Step 3 and Step 5)

**Build Tools**
- Maven Wrapper 3.9.16: .mvn/wrapper/maven-wrapper.properties
- Maven installation: not found locally; will use Maven Wrapper

## Guidelines

> Note: You can add any specific guidelines or constraints for the upgrade process here if needed, bullet points are preferred.

## Options

- Working branch: appmod/java-upgrade-20260618084655
- Run tests before and after the upgrade: true

## Upgrade Goals

- Java runtime upgrade to latest LTS: Java 21

## Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- |
| Java | 17 | 21 | User requested latest LTS runtime upgrade |
| Spring Boot | 3.5.15 | 3.5.15 | Already compatible with Java 21 |
| Maven Wrapper | 3.9.16 | 3.9.0 | Compatible with Java 21; no upgrade required |
| maven-compiler-plugin | managed by Spring Boot 3.5.15 | 3.11.0 | Managed version supports Java 21 compilation |
| Lombok | managed via dependency | latest compatible | No explicit version override; existing setup should continue working |

## Derived Upgrades

- Java 21 requires a JDK 21 runtime for compilation and tests.
- No Spring Boot upgrade is required because Spring Boot 3.5.15 already supports Java 21.
- No build tool upgrade is required for Maven Wrapper 3.9.16.

## Impact Analysis

### Dependency Changes

| File | Dependency | Current | Action | Target | Reason |
|------|------------|---------|--------|--------|--------|
| pom.xml | java.version | 17 | upgrade | 21 | User requested latest LTS runtime |

### Source Code Changes

| File | Location | Current | Required Change | Reason |
|------|----------|---------|----------------|--------|
| None | N/A | N/A | None required | Spring Boot 3.5.15 already supports Java 21 and no source-level migration changes are needed for this project |

### Configuration Changes

| File | Property/Setting | Current | Required Change | Reason |
|------|------------------|---------|-----------------|--------|
| None | N/A | N/A | None | No application configuration changes are required for Java runtime upgrade |

### CI/CD Changes

| File | Location | Current | Required Change |
|------|----------|---------|-----------------|
| None | N/A | N/A | None | No CI/CD files were identified in the workspace to update |

### Risks & Warnings

- **Baseline skipped**: JDK 17 is not installed locally, so the pre-upgrade baseline compile/test cannot be run. This means validation will focus on the upgrade target environment.
- **JDK 21 installation required**: JDK 21 is not currently available on the host; Step 1 must install it before build verification.
- **No version control available**: Git is not initialized in this workspace, so changes will not be committed automatically and branch tracking is unavailable.

## Upgrade Steps

- Step 1: Setup Environment
  - **Rationale**: Java 21 is required for the requested runtime upgrade and is not installed locally.
  - **Changes to Make**: Install JDK 21 and verify the Maven Wrapper is usable.
  - **Verification**: `java --version` with JDK 21 in PATH or explicit path, Maven Wrapper available

- Step 2: Setup Baseline
  - **Rationale**: Confirm the pre-upgrade baseline if the current project JDK is available.
  - **Changes to Make**: None required in source code; run baseline compile/test only if JDK 17 is available.
  - **Verification**: `mvnw.cmd clean compile test-compile -q && mvnw.cmd clean test -q` or skipped if JDK 17 is unavailable

- Step 3: Upgrade Java runtime to 21
  - **Rationale**: Update the project configuration to target the requested Java LTS and verify compilation with the target runtime.
  - **Changes to Make**: Update `pom.xml` property `java.version` from `17` to `21`.
  - **Verification**: `mvnw.cmd clean test-compile -q` with JDK 21

- Step 4: CVE Validation & Fix
  - **Rationale**: Ensure no direct dependency CVEs remain after the upgrade.
  - **Changes to Make**: Scan direct dependencies, fix any reported CVEs by upgrading dependencies or BOM-managed versions, and verify compilation.
  - **Verification**: `mvnw.cmd clean test-compile -q` after fixes; re-run CVE scan

- Step 5: Final Validation
  - **Rationale**: Confirm the upgrade is complete and fully verified on Java 21.
  - **Changes to Make**: Resolve any test failures and confirm full test suite success.
  - **Verification**: `mvnw.cmd clean test -q` with JDK 21
