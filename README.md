# Password Validator

This app contains a function who validate if a password matches with following rules:

- This regular expression should validate the maximum string length (passed as parameter); it should return a match if the string length is within the acceptable range and a non-match if it is not.
- This regular expression should also validate that the string contains at least one uppercase letter, one lowercase letter, one digit, and one special character from a predefined list: !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~. It should return a match if the criteria are met and a non-match if they are not.
- This regular expression should validate that the string does not contain any whitespace characters (spaces, tabs, or newlines). This should return a non-match if any whitespace characters are found.

## Regex implementation description

The implemented regex explanation is divided in five parts:

- `^` indicates the beginning of the string
- `$` indicates the end of the string
- `(?=.*[0-9])` allows to accept at least one digit
- `(?=.*?[a-z])` allows to accept at least one lower case letter
- `(?=.*?[A-Z])` allows to accept at least one upper case letter
- `(?=.*?[!\\\"#$%&'()*+,-\\.\\/:;<=>?@\\[\\\\\\]^_``{|}~])` allows to accept at least one of this special characters
- `(?!.*?[\\t\\s\\r])` avoid to accept different space characters
- `.{" + length + "}` indicates the string length (passed by parameter)

## Running test

```bash
./mvnw install
./mvnw test
```

## Local Environment

We are using java version 20.0.2

```
openjdk version "20.0.2" 2023-07-18
OpenJDK Runtime Environment Corretto-20.0.2.9.1 (build 20.0.2+9-FR)
OpenJDK 64-Bit Server VM Corretto-20.0.2.9.1 (build 20.0.2+9-FR, mixed mode, sharing)
```

If you want to manage java versions locally I suggest to install [sdkman](https://sdkman.io/).


## Code Quality

See the Sonar Cloud results [here](https://sonarcloud.io/summary/new_code?id=locoBit_regex)