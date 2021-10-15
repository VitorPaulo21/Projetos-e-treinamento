module tetris {
	
	requires javafx.base;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires CSSLibrary;
	requires javafx.media;
	
	opens Model to javafx.fxml;
	opens Controler;
	opens TelaInicial;
	opens View.Grid;
	opens View.Header;
	opens View.Objects;
	
	exports Model;
	
}