# starter
A starter template for Java-based Spring Boot projects.

### Docker Build
The *dockerfile-maven-plugin* is used to build a container image and push it to Docker Hub.  It deploys a container image tagged with the maven artifact version as weel as one tagged as **latest**.
This is executed as part of the **deploy** phase of the build and can be triggered with a **mvn deploy** command.

Credentials for Docker Hub are taken from the local maven settings.xml by setting *useMavenSettingsForAuth* to true.

The *maven-deploy-plugin* is configured to abstain from attempting to push artifacts to a remote repository by setting the *skip* setting to true.


