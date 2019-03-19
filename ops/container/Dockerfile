FROM tomcat:9.0.16-jre8

MAINTAINER Cai, Te
#ARG APP_ENV=test
#ENV APP_ENV ${APP_ENV}

EXPOSE 8080

RUN rm -rf /user/local/tomcat/webapps/ROOT
COPY ./*.war /user/local/tomcat/webapps/ROOT.war
COPY ./setenv.sh /user/local/tomcat/bin/setenv.sh