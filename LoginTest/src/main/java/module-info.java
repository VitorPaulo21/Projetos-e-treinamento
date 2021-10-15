module LoginTest {
	
	requires javafx.controls;
	requires antlr;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.sun.xml.fastinfoset;
	requires org.hibernate.commons.annotations;
	requires org.hibernate.orm.core;
	requires com.sun.istack.runtime;
	requires org.jboss.jandex;
	requires javassist;
	requires java.activation;
	requires java.xml.bind;
	requires java.transaction.xa;
	requires java.transaction;
	requires org.jvnet.staxex;
	requires com.sun.xml.txw2;
	requires java.logging;
	requires java.sql;
	requires org.jboss.logging;
	requires java.persistence;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.fxml;
	requires mysql.connector.java;
	
	opens Fxml;
	opens users;
}