module Gerenciador2 {
	
//		exports Model.Controler;
//		exports View.Bottom;
//		exports Model.Objects.Banca;
//		exports Observers;
//		exports View.Stops;
//		exports Model.ConectionDb;
//		exports View.Center;
//		exports Model.Events;
////		exports Model.Porcentagens.Payout;
//		exports View.Banca;
//		exports View;
////		exports Model.Payout;
//		exports Model.Objects.Stops;
//		exports View.Data;
//		exports View.InvestList;
//		exports Model.Objects.List;

		opens Model.Objects.Banca;
		opens Model.Objects.List;
		opens Model.Objects.Percents;
		opens Model.Objects.Stops;
		opens newView;
		opens newView.Top;
		opens Model to javafx.fxml;
		
		exports Model;
//		exports Observers.percents;
//		exports Observers.Bottom;
//		exports Observers.Stops;
//		exports View.Porcentagens;
//		exports Observers.Banca;
//		exports Model.Objects.Percents;

		requires java.desktop;
		requires java.logging;
		requires java.persistence;
		requires java.sql;
		requires org.jboss.logging;
		requires mysql.connector.java;
		requires CSSLibrary;
		requires javafx.base;
		requires javafx.controls;
		requires javafx.fxml;
		requires java.transaction;
		requires transitive javafx.graphics;
		requires javafx.media;
		requires javafx.swing;
		requires javafx.swt;
		requires javafx.web;
		requires org.json;
		requires org.hibernate.orm.core;
		requires java.net.http;
	
}