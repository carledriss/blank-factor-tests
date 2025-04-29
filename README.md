#blank-factor-test

###Environment requirements
* Java 17+
* Chrome or Firefox browser.
* Gradle.

###Run automated tests
You can use the following command to execute the automated tests:
By default it will be run in Chrome.

```shell script
./gradlew clean test -Pbrowser=chrome
./gradlew clean test -Pbrowser=headless
./gradlew clean test -Pbrowser=firefox
```
