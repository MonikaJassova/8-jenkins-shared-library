# Jenkins Shared Library

This repo showcases extracting common build logic from Jenkins pipelines to a separate Jenkins shared library, that can be utilized in Jenkinsfiles across multiple teams/whole organization.

## Technologies

Jenkins, Groovy, Docker, Git, Java, Maven

## Project Structure

```
.
├── README.md
├── src // helper code, classes for organizing methods
│   └── com
│       └── example 
│           └── Docker.groovy
└── vars // individual files for each extracted function called from Jenkinsfiles
    ├── buildImage.groovy 
    ├── buildJar.groovy
    ├── dockerLogin.groovy
    └── dockerPush.groovy
```

## Steps:

1. Identified common steps for a specific technology (Docker, Maven) that can be defined in one place and reused in Jenkinsfiles
2. Extracted them to a separate Git repo, following https://www.jenkins.io/doc/book/pipeline/shared-libraries/
3. For usage in Jenkinsfiles, see https://github.com/MonikaJassova/8-jenkins-pipeline
