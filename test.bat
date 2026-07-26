@echo on
call mvn clean install
rmdir /q /s rd "C:\Apache\apache-tomcat-9.0.82\webapps\VideoRentalManagementWebServices"
del C:\Apache\apache-tomcat-9.0.82\webapps\VideoRentalManagementWebServices.war
copy "C:\Codebase\C4Networks-VRMS\VideoRentalManagementWebServices\target\*.war" "C:\Program Files\Apache\apache-tomcat-9.0.82\webapps"

rmdir /q /s rd "C:\Apache\apache-tomcat-9.0.82\webapps\VideoRentalManagementUI"
del C:\Apache\apache-tomcat-9.0.82\webapps\VideoRentalManagementUI.war
copy "C:\Codebase\C4Networks-VRMS\VideoRentalManagementUI\target\*.war" "C:\Program Files\Apache\apache-tomcat-9.0.82\webapps"
pause