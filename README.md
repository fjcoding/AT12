# AT12

# Code review

1. Build passes
1. Goal accomplished (meet targets)
1. Code coverage > 80%
1. Good commits
1. Code quality

# Steps for to run

## Run test and CheckStyle
```bash
./gradlew test
```
If **BUILD FAILED**  
open the file **checkstyle.html** 
```bash
build/reports/checkstyle/checkstyle.html
```
Solve the problems and try again **gradle test**


## Run only CheckStyle
```bash
./gradlew checkstyle
```

## Only Run
```bash
./gradlew run
```

# How to create build ?

## Run
```bash
./gradlew build
```
# Test Coverage 
```bash
./gradlew build jacocoTestReport
```
Open the file **index.html**

```bash
build/reports/jacoco/test/html/index.html
``` 
