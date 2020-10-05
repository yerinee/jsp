
cd /e/A_TeachingMaterial/6.jspSpring/deploy/jsp2
git pull

mvn clean

mvn package

mv ./target/jsp-0.0.1-SNAPSHOT.war ./target/jsp.war

/e/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/shutdown.sh

rm /e/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp.war
rm -rf /e/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/jsp

cp ./target/jsp.war /e/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/webapps/

/e/B_Util/5.ApacheTomcat/apache-tomcat-7.0.73/bin/startup.sh