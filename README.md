# team1-app1

> "TODO" - Someone Nice

This is the app ap1 of team1 of ottos new plattform.


## Build

Intellij Java Compiler Settings:

Add following jvm parameter to be able to generate error messages from parameter names:

    $ -parameters

Build artefact:

    $ gradle build

## Startup
  
Start the server:

    $ java -jar -Dspring.profiles.active=local build/libs/team1-app1.jar

For starting the server in dev mode:

    $ gradle -Dspring.profiles.active=local bootRun [--debug-jvm]

Then open a browser and visit:

    ?

## Testing

### Test server

    $ gradle test

This also:

* runs checkstyle, findbugs, pmd
* creates coverage reports for server

## Dependency Update

For Java dependencies use gradle-versions-plugin command.

    $ gradle dependencyUpdates -Drevision=release

# Runbook & Handlungsanweisungen

?

## Incident-Priorität

?
