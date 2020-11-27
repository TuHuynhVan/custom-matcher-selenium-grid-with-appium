# Introduction
* To have flexibility on distinguish appium node via network based on 
Capabilities and unique device `udid`

# Usage
* `mvn -q install -DskipTests` and the jar file will be under `target` folder
* OR you can use the jar file in `3.149.build`
* hubConfig.json example:

```
{
  "host": "192.168.1.202",
  "port": 4444,
  "newSessionWaitTimeout": 60,
  "servlets": [],
  "withoutServlets": [],
  "custom": {},
  "capabilityMatcher": "com.sdetpro.appium.grid.matcher.CustomCapabilityMatcher",
  "registry": "org.openqa.grid.internal.DefaultGridRegistry",
  "throwOnCapabilityNotPresent": true,
  "cleanUpCycle": 5000,
  "role": "hub",
  "debug": false,
  "browserTimeout": 0,
  "timeout": 90,
  "sessionTimeout": 90
}

```
* Start Hub with command:

```java -cp selenium-server-standalone-3.141.59.jar:selenium-grid-custom-matcher-3.141.59.jar org.openqa.grid.selenium.GridLauncherV3 -role hub -hubConfig hubConfig.json```

# CREDIT
[selenium-grid-capability-matcher](https://github.com/mgrybyk/selenium-grid-capability-matcher)