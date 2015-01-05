EasyAdmin
=========

A base SmartAdmin(Bootstrap) template easy to use web admin system

## Development Environment
	a.jdk1.8  
	b.maven3  
	c.eclipse-jee-luna  
	d.tomcat7+  

## User Guide
  a.build  
		cd /yourpath/EasyAdmin/  
		mvn clean package -Pprod  
  b.create & init database(mysql5+)  
	  create a database named 'easy_admin'  
	  execute /yourpath/docs/db/easy_admin.sql  
  c.deploy  
		copy the easyadmin-web.war to tomcat webapps  
  d.init login user  
		account:admin  
		pasword:123456  

