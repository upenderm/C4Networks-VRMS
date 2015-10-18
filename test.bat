@echo off
rmdir /q /s rd C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps\VideoRentalManagementWebServices
del C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps\VideoRentalManagementWebServices.war
copy C:\Codebase\VRMS\VideoRentalManagementWebServices\target\*.war C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps

rmdir /q /s rd C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps\VideoRentalManagementUI
del C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps\VideoRentalManagementUI.war
copy C:\Codebase\VRMS\VideoRentalManagementUI\target\*.war C:\Codebase\PaaS3.1.0\Servers\Tomcat\adp-tomcat\webapps