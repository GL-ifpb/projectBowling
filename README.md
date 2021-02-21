# projectBowling
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project was developed as a Jobsity selection test, so that my knowledge can be evaluated.

Some good practices were used, such as reusability, dependency inversion principle, loose coupling, architectural pattern and others.
	
## Technologies
Project is created with:
* SpringBoot: 2.4.3
* JUnit: 5.7.1
* JDK: 1.8
* Maven: 3
	
## Setup
To build and run this project, follow these steps:

Step 1:
```
$ git clone https://github.com/GL-ifpb/projectBowling
$ cd bowling
$ mvn clean package
```

Step 2:
```
$ cd bowling-game/target
$ java -jar bowling-0.0.1-SNAPSHOT.jar /file-folder/commonSample.txt
```
