# EDUCATIONAL PROJECT

## Installation

### 1. Install the Latest JDK
Download and install the Java Development Kit (JDK):  
- **Oracle JDK:** [https://www.oracle.com/java/technologies/javase-jdk.html](https://www.oracle.com/java/technologies/javase-jdk.html)  
- **OpenJDK (free & open-source):** [https://openjdk.org/install/](https://openjdk.org/install/)  

Verify the installation in your terminal/command prompt:

```bash
java -version
javac -version
```
### 2. Setup enviroment variable

#### Windows:
- Add JAVA_HOME pointing to your JDK installation folder.
- Add %JAVA_HOME%\bin to your PATH.

### 3. Clone the project
- git clone https://github.com/yourusername/yourproject.git
- cd yourproject

### 4. Compile the project
- javac -d bin src/*.java

### 5. Run it
- java -cp bin MainClass
