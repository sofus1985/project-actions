cd C:\Users\sofiane\IdeaProjects\project-actions
mvn clean install



@echo off
REM Navigate to the project directory
cd C:\Users\sofiane\IdeaProjects\project-actions

REM Set up ChromeDriver path (ensure chromedriver.exe is in the specified path or adjust accordingly)
set CHROME_DRIVER_PATH=C:\\Users\\sofiane\\Web Drivers

REM Add ChromeDriver to the system PATH
set PATH=%PATH%;%CHROME_DRIVER_PATH%

REM Run Maven clean install
mvn clean install

REM Run Maven tests with browser parameter
mvn test -Dbrowser=localChrome



