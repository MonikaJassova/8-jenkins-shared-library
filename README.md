# Jenkins Shared Library

This repo showcases extracting common build logic to a separate Jenkins shared library, that can be used in Jenkinsfiles for pipelines across an organization.

## Technologies

Jenkins, Groovy, Docker, Git, Java, Maven

## Structure of the repo

```
.
├── README.md
├── src
│   └── com
│       └── example
│           └── Docker.groovy
└── vars
    ├── buildImage.groovy 
    ├── buildJar.groovy
    ├── dockerLogin.groovy
    └── dockerPush.groovy
```

## Steps:

1. Identified common steps for a specific technology (Docker, Maven) that can be defined in one place and reused
2. Extracted them to a separate Git repo, following https://www.jenkins.io/doc/book/pipeline/shared-libraries/
