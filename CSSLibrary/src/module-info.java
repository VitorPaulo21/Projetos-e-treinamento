module CSSLibrary {
	
	requires java.base;
	requires java.desktop;
	
	opens CssConverter;
	
	exports CssConverter;
	
}