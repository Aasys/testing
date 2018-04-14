# Testing

Valid chess moves testing using JUnit, jacoco, findbugs

### Requirement:

    Java 1.8
    Maven 3.x


### Build:

    mvn
    
The default goal "mvn clean install site", builds the project, runs test, and generates report

### Report Locations:

     junit + quick check --> target/surefire-reports
     jacoco --> target/report-jacoco
     findbugs --> target/site
     findbugs xml report --> target/report-findbugs

### Run with CommandLine Input:
    
    mvn exec:java

Sample Input:

    WHITE: Rf1, Kg1, Pf2, Ph2, Pg3
    BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5
    PIECE TO MOVE: Rf1

Example interaction with Sample Input:
    
    >mvn exec:java
    [INFO] Scanning for projects...
    [INFO]
    [INFO] --------------------------< aasys.chess:game >--------------------------
    [INFO] Building game 1.0-SNAPSHOT
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] >>> exec-maven-plugin:1.2.1:java (default-cli) > validate @ game >>>
    [INFO]
    [INFO] <<< exec-maven-plugin:1.2.1:java (default-cli) < validate @ game <<<
    [INFO]
    [INFO]
    [INFO] --- exec-maven-plugin:1.2.1:java (default-cli) @ game ---
    Enter commands line by line
    >WHITE: Rf1, Kg1, Pf2, Ph2, Pg3
    8| - - - - - - - -
    7| - - - - - - - -
    6| - - - - - - - -
    5| - - - - - - - -
    4| - - - - - - - -
    3| - - - - - - p -
    2| - - - - - p - p
    1| - - - - - r k -
      ________________
       a b c d e f g h
    OK
    >BLACK: Kb8, Ne8, Pa7, Pb7, Pc7, Ra5
    8| - K - - N - - -
    7| P P P - - - - -
    6| - - - - - - - -
    5| R - - - - - - -
    4| - - - - - - - -
    3| - - - - - - p -
    2| - - - - - p - p
    1| - - - - - r k -
      ________________
       a b c d e f g h
    OK
    >PIECE TO MOVE: Rf1
    LEGAL MOVES FOR Rf1: a1, c1, h1, e1, b1, d1,
