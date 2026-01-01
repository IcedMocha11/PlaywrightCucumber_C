To run feature files using the terminal/CLI use the command below:
mvn clean test "-Dcucumber.filter.tags=@Tc2" "-Dbrowser=chromium" "-Dthread.count=2"
~this mvn command works in PowerShell
