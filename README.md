# Telecom API Automation Framework

[![Java](https://img.shields.io/badge/language-Java-blue.svg)](https://www.java.com/)
[![Test Automation](https://img.shields.io/badge/type-Test%20Automation-orange.svg)](https://github.com/Shardul13102001/Telecom)
[![Open Issues](https://img.shields.io/github/issues/Shardul13102001/Telecom.svg)](https://github.com/Shardul13102001/Telecom/issues)
[![Last Commit](https://img.shields.io/github/last-commit/Shardul13102001/Telecom.svg)](https://github.com/Shardul13102001/Telecom/commits/master)

---

> **A robust, modern, and extensible automation suite for Telecom user & contact management APIs. Built for quality, speed, and continuous delivery.**

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Running the Suite](#running-the-suite)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## ✨ Features

- **🔒 User Management:**  
  Automate sign-up, login, and logout processes with token-based authentication.

- **👥 Contact CRUD Automation:**  
  Effortlessly test adding, updating (PUT/PATCH), retrieving, and listing contact APIs.

- **🔄 Reusable & Scalable:**  
  Centralized test base, clean payload models, and modular test cases for easy expansion.

- **📊 Allure Reporting:**  
  Beautiful, interactive test reports with TestNG + Allure integration.

- **✅ Built-in Assertions:**  
  Automatic validation for status codes, response bodies, and error handling.

- **Continuous Integration Friendly:**  
  Ready hooks for CI/CD pipelines, including detailed reports and logs.

- **Customizable Configuration:**  
  Environment and test parameters easily adjustable via properties files.

---

## 🛠️ Tech Stack

- **Java 11+**
- **TestNG**
- **REST Assured**
- **Allure Reports**
- **Maven**

---

## 🗂️ Project Structure

```
Telecom/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/        # Test base, config, and setup
│       │   ├── payloads/    # Java models for API payloads (User, Contact)
│       │   └── tests/       # Automated TestNG test cases
│       └── resources/
│           └── config      # Configuration files
├── reports/                 # Generated test and build reports
├── .gitignore
├── pom.xml                  # Maven build config
└── README.md
```

---

## 🏁 Getting Started

### Prerequisites

- Java 11 or newer installed
- Maven
- Web browser (for viewing reports)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Shardul13102001/Telecom.git
   cd Telecom
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

### Configuration

- Adjust environment settings in the `src/test/resources/config/` directory.
- Update test data and parameters as needed in payloads or properties files.

### Running the Suite

- **Build the project:**
  ```bash
  mvn clean package
  ```
- **Execute tests:**
  ```bash
  mvn test
  ```
- **View reports:**
  - Generated reports are available in the `reports/` directory.
  - For Allure:
    ```bash
    allure serve target/allure-results
    ```

---

## 🔬 Usage

- **Automate Telecom APIs:** Integrate and test user and contact management endpoints.
- **Customize test scripts:** Add or edit tests in the `src/test/java/tests/` directory.
- **Integrate with CI/CD:** Add the provided scripts/commands to your pipeline for automated builds and testing.

---

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Commit your changes with clear messages.
4. Open a Pull Request describing your changes.

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## 📬 Contact

For any questions, suggestions, or issues, please open an issue in the repository or contact the maintainer:

- **GitHub:** [Shardul13102001](https://github.com/Shardul13102001)

---

## ⭐️ Show Your Support

If you like this project, please ⭐️ the repo and share it with your friends!

---
