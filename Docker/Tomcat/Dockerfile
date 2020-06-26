#La images que se descarga de Docker hub
FROM tomcat:8-jre8

#Comandos
RUN apt-get update && apt-get install -y nano && apt-get install -y procps

#Archivos settings.xml y tomcat-users.xml
#que se copian a la ruta dentro del contenedor TOMCAT
ADD settings.xml /usr/local/tomcat/conf
ADD tomcat-users.xml /usr/local/tomcat/conf
