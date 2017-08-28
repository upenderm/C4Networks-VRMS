@echo on
call mvn clean install
REM rmdir /q /s rd "C:\Apache\apache-tomcat-7.0.79\webapps\VideoRentalManagementWebServices"
REM del C:\Apache\apache-tomcat-7.0.79\webapps\VideoRentalManagementWebServices.war
REM copy "G:\Codebase\C4Networks-VRMS\VideoRentalManagementWebServices\target\*.war" "C:\Apache\apache-tomcat-7.0.79\webapps"

REM rmdir /q /s rd "C:\Apache\apache-tomcat-7.0.79\webapps\VideoRentalManagementUI"
REM del C:\Apache\apache-tomcat-7.0.79\webapps\VideoRentalManagementUI.war
REM copy "G:\Codebase\C4Networks-VRMS\VideoRentalManagementUI\target\*.war" "C:\Apache\apache-tomcat-7.0.79\webapps"
pause