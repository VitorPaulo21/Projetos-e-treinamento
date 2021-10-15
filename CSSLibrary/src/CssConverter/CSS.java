package CssConverter;

import java.awt.Color;

public class CSS {

	StringBuilder sb;

	public CSS() {

		sb = new StringBuilder();
	}

	public CSS fx() {

		sb.append("-fx");

		return this;

	}

	public CSS backGround() {

		sb.append("-background");
		return this;

	}

	public CSS opacity() {
		sb.append("-opacity");
		return this;

	}

	public CSS color() {
		sb.append("-color");
		return this;

	}

	public CSS radius() {
		sb.append("-radius");
		return this;

	}

	public CSS font() {

		sb.append("-font");
		return this;

	}

	public CSS family() {

		sb.append("-family");
		return this;
	}

	public CSS size() {

		sb.append("-size");
		return this;

	}

	public CSS text() {

		sb.append("-text");
		return this;

	}

	public CSS fill() {

		sb.append("-fill");
		return this;

	}

	public CSS min() {

		sb.append("-min");
		return this;

	}

	public CSS max() {

		sb.append("-max");
		return this;

	}

	public CSS height() {

		sb.append("-height");
		return this;

	}
	
	public CSS width() {

		sb.append("-width");
		return this;

	}
	
	public CSS padding() {

		sb.append("-padding");
		return this;

	}
	
	public CSS insets() {

		sb.append("-insets");
		return this;

	}
	
	public CSS border() {

		sb.append("-border");
		return this;

	}

	public CSS pref() {

		sb.append("-pref");
		return this;

	}
	
	public CSS set() {
		
		sb.append(":");
		return this;
		
	}
	
	public CSS dot() {
		
		sb.append(";");
		return this;
		
	}
	
	public CSS linearGradient(Gradient direction, Color initial, Color end) {
		
		StringBuilder pre = new StringBuilder();
		
		String direct = "";
		
		if (direction == Gradient.TO_TOP) {
			direct = "to top";
		} else if (direction == Gradient.TO_BOTTOM) {
			direct = "to bottom";
		} else if (direction == Gradient.TO_RIGHT) {
			direct = "to right";
		}else if (direction == Gradient.TO_LEFT) {
			direct = "to left";
		}
					
		pre.append("linear-gradient(");
		pre.append(direct);
		pre.append(", ");
		pre.append(colorToRgbValue(initial));
		pre.append(", ");
		pre.append(colorToRgbValue(end));
		pre.append(")");
		
		set();
		sb.append(pre.toString());
		dot();
		
		return this;
	}
	
	public static String colorToRGB(Color color) {
		
		int red = color.getRed();
		int green = color.getGreen();
		int blue = color.getBlue();
		
		return red + ", " + green + ", " + blue;
		
	}
	public static String hexToRGB(String hex) {
		
		return colorToRGB(hexToColor(hex));
	}
	public static String RGBtoHex(int red, int green, int blue) {
		
		int r = red;
		int g = green;
		int b = blue;
		String hex = String.format("#%02X%02X%02X", r, g, b);
		return hex;
		
	}
	public static Color RGBtoColor(int red, int green, int blue) {
		return new Color(red, green, blue);
	}
	public static String colorToHex(Color color) {
		
		return RGBtoHex(color.getRed(), color.getGreen(), color.getBlue());
		
	}
	public static Color hexToColor(String hex) {
		
		return Color.decode(hex);
		
	}
	
    public String colorToRgbValue(Color color) {
    	
    	return "rgb(" + colorToRGB(color) + ")";
    	
    }
    
    public String hexToRgbValue(String hex) {
    	
    	return "rgb(" + hexToRGB(hex) + ")";
    	
    }
    
	
	public CSS setRgbValue(Color color) {
		set();
		appendRgbValue(color);
		dot();
		return this;
		
	}
	
	public CSS appendRgbValue(Color color) {
		
		sb.append(colorToRgbValue(color));
		return this;
		
	}
	
	public CSS px(int px) {
		set();
		sb.append(pxValue(px));
		dot();
		
		return this;
		
	}
	
	public String pxValue (int px) {
		
		return Integer.toString(px) + "px";
	}
	
	public String hexValue(String Hex){
		
		return Hex;
		
	}
	
	public CSS setHex(String Hex) {
		set();
		sb.append(Hex);
		dot();
		
		return this;
	}
	
	public CSS appendHex(String Hex) {
		
		
		sb.append(Hex);
		
		return this;
	}
	
	public CSS virgula() {
		
		sb.append(",");
		
		return this;
		
	}
	
	public CSS appendIntValue(int value) {
		
		sb.append(Integer.toString(value));
		
		return this;
	}
	
	public CSS setIntValue(int value) {
		
		set();
		appendIntValue(value).dot();
		 return this;
	}
	
	public CSS appendDoubleValue(double value) {
		
		sb.append(Double.toString(value));
		
		return this;
	}
	
	public CSS setDoubleValue(double value) {
		set();
		appendDoubleValue(value).dot();
		return this;
	}
	
	public CSS setRadiusValue(int topLeft, int topRight, int bottomRight, int bottomLeft) {
		set();
		sb.append(topLeft);
		sb.append(" ");
		sb.append(topRight);
		sb.append(" ");
		sb.append(bottomRight);
		sb.append(" ");
		sb.append(bottomLeft);
		dot();
		return this;
		
	}
	
	public CSS setInsetsValue(int top, int right, int bottom, int left) {
		set();
		sb.append(top);
		sb.append(" ");
		sb.append(right);
		sb.append(" ");
		sb.append(bottom);
		sb.append(" ");
		sb.append(left);
		dot();
		
		return this;
	}
	
	public CSS appendStringValue(String str) {
		sb.append("\"");
		sb.append(str);
		sb.append("\"");
		return this;
		
	}
	
	public CSS setStringValue(String str) {
		
		set();
		appendStringValue(str);
		dot();
		
		return this;
		
	}
	
	public CSS setBackgroundColor(Color color) {
		
		fx().backGround().color().setHex(colorToHex(color));
		
		return this;
	}
	
	public CSS setBackgroundColorGradient(Gradient direction, Color inicial, Color end) {
		
		fx()
		.backGround()
		.color()
		.linearGradient(direction, inicial, end);
		
		return this;
	}
	public CSS setBackgroundColorGradient(Gradient direction, String HexInicial, String HexFinal) {
		
		fx().backGround().color().linearGradient(direction, hexToColor(HexInicial), hexToColor(HexFinal));
		
		return this;
	}

	public CSS setOpacy(double opacy) {
		fx().opacity().setDoubleValue(opacy);
		
		return this;
	}
	
	public CSS setBackgroundRadius(int degrees) {
		
		fx().backGround().radius().setIntValue(degrees);
		return this;
	}
	
	public CSS setBackgroundRadiusPX(int PX) {
		
		fx().backGround().radius().px(PX);
		return this;
	}
	
	public CSS setBackgroundRadius(int topLeft, int topRight, int bottomRight, int bottomLeft) {
		
		fx().backGround().radius().setRadiusValue(topLeft, topRight, bottomRight, bottomLeft);
		return this;
	}
	public CSS setBorderRadius(int degrees) {
		
		fx().border().radius().setIntValue(degrees);
		return this;
	}
	
	public CSS setBorderRadiusPX(int PX) {
		
		fx().border().radius().px(PX);
		return this;
	}
	
	public CSS setBorderRadius(int topLeft, int topRight, int bottomRight, int bottomLeft) {
		
		fx().border().radius().setRadiusValue(topLeft, topRight, bottomRight, bottomLeft);
		return this;
	}
	
	public CSS setFontFamily(String FontFamily) {
		
		fx().font().family().setStringValue(FontFamily);
		
		return this;
		
	}
	
	public CSS setFontSize(int px) {
		
		fx().font().size().px(px);
		 return this;
	}
	
	
	public CSS setTextColor(String Hex) {
		
		fx().text().fill().setHex(Hex);
		
		return this;
	}
	public CSS setTextColor(Color color) {
		
		setTextColor(colorToHex(color));
		
		return this;
	}
	
	public CSS setMinHeight(int px) {
		
		fx().min().height().px(px);
		
		return this;
	}
	
	public CSS setMinWidth(int px) {
		
		fx().min().width().px(px);
		
		return this;
	}
	public CSS setMaxHeight(int px) {
		
		fx().max().height().px(px);
		
		return this;
	}
	
	public CSS setMaxWidth(int px) {
		
		fx().max().width().px(px);
		
		return this;
	}
	public CSS setMinHeight(double px) {
		
		fx().min().height().setDoubleValue(px);
		
		return this;
	}
	
	public CSS setMinWidth(double px) {
		
		fx().min().width().setDoubleValue(px);
		
		return this;
	}
	public CSS setMaxHeight(double px) {
		
		fx().max().height().setDoubleValue(px);
		
		return this;
	}
	
	public CSS setMaxWidth(double px) {
		
		fx().max().width().setDoubleValue(px);
		
		return this;
	}
	public CSS setPrefHeight(int px) {
		
		fx().pref().height().px(px);
		
		return this;
	}
	
	public CSS setPrefWidth(int px) {
		
		fx().pref().width().px(px);
		
		return this;
	}
	
	public CSS setPrefHeight(double px) {
		
		fx().pref().height().setDoubleValue(px);
		
		return this;
	}
	
	public CSS setPrefWidth(double px) {
		
		fx().pref().width().setDoubleValue(px);
		
		return this;
	}
	
	public CSS setPadding(int padding) {
		
		fx().padding().setIntValue(padding);
		
		return this;
		
	}
	public CSS setPadding(int top, int right, int bottom, int left) {
		
		fx().padding().setInsetsValue(top, right, bottom, left);
		
		return this;
		
	}
	
	public CSS setBackgroundInsets(int Insets) {
		
		fx().backGround().insets().setIntValue(Insets);
		
		return this;
	}
	
	public CSS setBackgroundInsets(int top, int right, int bottom, int left) {
		
		fx().backGround().insets().setInsetsValue(top, right, bottom, left);
		
		return this;
	}
	
	public String get() {
		
		return sb.toString();
		
	}
	
	public void clean() {
		
		sb = new StringBuilder();
		
	}
	
	public CSS init(String name) {
		
		sb.append("." + name + " {");
		return this;
		
	}
	
	public CSS commit() {
		
		sb.append("}");
		
		return this;
		
	}
	
}


