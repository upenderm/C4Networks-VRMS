@echo off
rmdir /q /s rd "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\VideoRentalManagementWebServices"
del C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\VideoRentalManagementWebServices.war
copy "E:\GIT Codebase\C4Networks-VRMS-master\VideoRentalManagementWebServices\target\*.war" "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps"

rmdir /q /s rd "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\VideoRentalManagementUI"
del C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps\VideoRentalManagementUI.war
copy "E:\GIT Codebase\C4Networks-VRMS-master\VideoRentalManagementUI\target\*.war" "C:\Program Files\Apache Software Foundation\Tomcat 7.0\webapps"
pause