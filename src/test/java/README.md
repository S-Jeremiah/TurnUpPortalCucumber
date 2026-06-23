Perfect structure! The BDD layout is clear. Here's your ready-to-paste README:
Go to github.com/S-Jeremiah/TurnUpPortalCucumber → click README.md → click pencil icon → replace everything with this:

markdown# TurnUp Portal — Selenium Java BDD Cucumber Framework

## Overview
A Behaviour-Driven Development (BDD) automated test suite for the TurnUp 
web portal, built using Selenium WebDriver, Java, and Cucumber. 

This project demonstrates the same test coverage as the TestNG 
([TurnUpPortalProject](https://github.com/S-Jeremiah/TurnUpPortalProject)) 
and C# NUnit 
([ProjectTurnUp](https://github.com/S-Jeremiah/ProjectTurnUp)) versions, 
but implemented using BDD principles — making test scenarios readable by 
both technical and non-technical stakeholders.

## Tech Stack
| Tool | Purpose |
|------|---------|
| Java | Programming language |
| Selenium WebDriver | Browser automation |
| Cucumber | BDD framework |
| JUnit / TestNG | Test runner |
| Maven | Build and dependency management |
| Page Object Model | Design pattern |
| IntelliJ / Eclipse | IDE |

## Folder Structure
TurnUpPortalCucumber/

│

├── src/

│   ├── main/java/org/example/

│   │   └── Main.java

│   │

│   └── test/java/

│       ├── Feature/            → Gherkin feature files (.feature)

│       │   ├── Login.feature

│       │   ├── Employee.feature

│       │   ├── TMPage.feature

│       │   └── Homepage.feature

│       │

│       ├── Pages/              → Page Object classes

│       │   ├── LoginPage.java

│       │   ├── EmployeePage.java

│       │   ├── TMPage.java

│       │   └── HomePage.java

│       │

│       ├── StepDefinition/     → Cucumber step definitions

│       │   ├── LoginSteps.java

│       │   ├── EmployeeSteps.java

│       │   ├── TMPageSteps.java

│       │   └── HomepageSteps.java

│       │

│       └── Utilities/          → Base setup and helper classes

│           ├── BaseTest.java

│           ├── Hooks.java

│           └── DriverManager.java

│

├── pom.xml                     → Maven dependencies

└── .gitignore

## How BDD Works in This Project

Each test scenario is written in plain English using **Gherkin syntax**,
making it understandable to non-technical stakeholders like business 
analysts and product owners.

### Example Feature File
```gherkin
Feature: TurnUp Portal Login

  Scenario: Successful login with valid credentials
    Given the user is on the TurnUp login page
    When the user enters a valid username and password
    Then the user should be redirected to the homepage

  Scenario: Login fails with invalid credentials
    Given the user is on the TurnUp login page
    When the user enters an invalid username and password
    Then an error message should be displayed
```

### How It Maps to Code
Feature file (plain English)  →  StepDefinition (Java code)  →  Pages (Selenium actions)

Login.feature                 →  LoginSteps.java             →  LoginPage.java

## Test Coverage
| Module | Features Tested |
|--------|----------------|
| Login | Valid login, invalid credentials, empty fields |
| Employee Page | Employee listing, search, navigation |
| TM Page | TM page load, content validation |
| Homepage | Navigation, UI elements, links |

## Design Decisions
- **BDD with Cucumber** — test scenarios written in Gherkin make them
  accessible to non-technical stakeholders, supporting collaboration between
  QA, developers, and business teams.
- **Page Object Model (POM)** — separates page interaction logic from step
  definitions, improving maintainability when the UI changes.
- **Hooks.java** — centralised setup and teardown (browser open/close)
  before and after each scenario, keeping step definitions clean.
- **Three-framework portfolio** — this project is the BDD equivalent of
  [TurnUpPortalProject](https://github.com/S-Jeremiah/TurnUpPortalProject)
  (Java/TestNG) and
  [ProjectTurnUp](https://github.com/S-Jeremiah/ProjectTurnUp) (C#/NUnit),
  demonstrating the same application tested across three different 
  automation approaches.

## How to Run

### Prerequisites
- Java JDK 8 or later
- Maven installed
- Chrome browser installed
- IntelliJ IDEA or Eclipse

### Steps
1. Clone the repository
git clone https://github.com/S-Jeremiah/TurnUpPortalCucumber.git
2. Open project in IntelliJ or Eclipse
3. Install dependencies
mvn install
4. Run all tests
mvn test
5. View Cucumber HTML report in
target/cucumber-reports/

## Skills Demonstrated
- BDD automation using Cucumber and Gherkin
- Selenium WebDriver with Java
- Page Object Model design pattern
- Step definition mapping and Hooks management
- Maven dependency management
- Stakeholder-friendly test documentation
- Cross-framework implementation:
  same application tested in Selenium Java (TestNG),
  Selenium C# (NUnit), and Cucumber BDD
