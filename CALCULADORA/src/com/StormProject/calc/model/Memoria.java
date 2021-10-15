package com.StormProject.calc.model;

import java.nio.Buffer;
import java.util.ArrayList;

public class Memoria {

	private enum TipoComando {
			
			ZERAR, NUMERO, DIV, MULT, SUB, SUM, IGUAL, VIRGULA, INVERT, PERCENT;
			
	};
	
	private static final Memoria instancia = new Memoria();
	
	private final ArrayList<MemoriaObserver> listeners = new ArrayList<MemoriaObserver>();
	
	private TipoComando LastOperator = null;
	private boolean substituir = false;
	private String textoAtual = "";
	private String textoBuffer = "";
	private String Operator = "";
	
	 private Memoria() {
	}

	public static Memoria getInstancia() {
		return instancia;
	}

	public String getTextoAtual() {
		
		return textoAtual.isEmpty() ? "0" : textoAtual ;
	}
	
	public void notifyMe(MemoriaObserver o) {
		
		listeners.add(o);
		
	}
	
	public void processCommand(String text) {
		
		TipoComando tipoComando = detectCommandTipe(text);
		if (textoAtual.equals("Erro div p 0")) {
			if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.ZERAR) {
				
			} else {

				return;
			}
		}
		
		 if (tipoComando == null) {
			 listeners.forEach(l -> l.valueChanged(getTextoAtual()));
			 return;
		}else if (tipoComando == TipoComando.NUMERO && LastOperator == null && !textoAtual.contains("%")) {
			if (textoAtual.equals("Erro div p 0")) {
				
				textoAtual = text;
				
			} else {
				textoAtual += text;
				
			}
			
		}else if (tipoComando == TipoComando.NUMERO && LastOperator != TipoComando.IGUAL ||
				tipoComando == TipoComando.NUMERO && textoAtual.contains("%")) {
			
			if (textoAtual.contains("%") && LastOperator == null) {
				
				LastOperator = TipoComando.MULT;
				
			}
			
			if (textoBuffer.isEmpty() ) {
				
				textoBuffer = textoAtual;            
//				System.out.println(textoBuffer);
				if (textoAtual.equals(textoBuffer)) {
					textoAtual = text;
					
				} else {

					textoAtual += text;
				}
			} else {

				if (textoAtual.equals("0") && text.equals("0")) {
					
				} else if (textoAtual.equals("0") && !text.equals("0")) {
					textoAtual = text;
					
				} else {

					textoAtual += text;
				}
				
			}
			
		} else if (tipoComando == TipoComando.DIV ) {
			
			LastOperator = TipoComando.DIV;
			if (textoAtual.isEmpty()) {
				textoAtual = "0";
			}
		} else if (tipoComando == TipoComando.MULT ) {
			
			LastOperator = TipoComando.MULT;
			if (textoAtual.isEmpty()) {
				textoAtual = "0";
			}
		} else if (tipoComando == TipoComando.PERCENT ) {
			
			textoAtual += "%";
		} else if (tipoComando == TipoComando.SUM ) {
			
			LastOperator = TipoComando.SUM;
//			System.out.println(LastOperator);
//			System.out.println(textoBuffer);
//			System.out.println(textoAtual);
			if (textoAtual.isEmpty()) {
				textoAtual = "0";
			}
		} else if (tipoComando == TipoComando.SUB ) {
			
			LastOperator = TipoComando.SUB;
			if (textoAtual.isEmpty()) {
				textoAtual = "0";
			}
		} else if (tipoComando == TipoComando.VIRGULA) {
//			System.out.println(textoAtual);
//			System.out.println(textoBuffer);
//			System.out.println(LastOperator);
			if (textoAtual.isEmpty()) {
//				System.out.println("empty");
				textoAtual = "0,";
				
			} else if (!textoAtual.contains(",") && LastOperator == null) {
//				System.out.println("Whrong");
				textoAtual += ",";
				
			}else if (!textoAtual.contains(",") && LastOperator != null && !textoBuffer.isEmpty()) {
//				System.out.println("Whrong");
				textoAtual += ",";
				
			} else if (LastOperator != null && textoBuffer.isEmpty()) {
//				System.out.println("other");
				textoBuffer = textoAtual;
				textoAtual = "0,";
				
			}
			
		} else if (tipoComando == TipoComando.IGUAL) {
//			System.out.println(LastOperator);
			if (textoAtual.contains("%")) {
				
				Double chng = Double.parseDouble(textoAtual.substring(0, textoAtual.indexOf("%")));
				
				chng /= 100;
				
				textoAtual = transform(chng);
				
			}
			if (textoBuffer.contains("%")) {
				
				Double chng = Double.parseDouble(textoBuffer.substring(0, textoBuffer.indexOf("%")));
				
				chng /= 100;
				
				textoBuffer = transform(chng);
				
			}
			if (textoAtual.isEmpty() || textoAtual.equals("0,")) {
				textoAtual = "0";
			} 
			if (textoBuffer.isEmpty() || textoBuffer.equals("0,")) {
				textoBuffer = "0";
			} 
			if (LastOperator == null) {
			} else if (LastOperator == TipoComando.SUM) {
				String num1 = textoBuffer.contains(",") ? textoBuffer.replaceAll(",", ".") : textoBuffer;
				String num2 = textoAtual.contains(",") ? textoAtual.replaceAll(",", ".") : textoAtual;
				
				Double result = Double.parseDouble(num1) +
						Double.parseDouble(num2);
				
				textoAtual = transform(result);
				textoBuffer = "";
				LastOperator = null;
			} else if (LastOperator == TipoComando.SUB) {
				String num1 = textoBuffer.contains(",") ? textoBuffer.replaceAll(",", ".") : textoBuffer;
				String num2 = textoAtual.contains(",") ? textoAtual.replaceAll(",", ".") : textoAtual;
				
				Double result = Double.parseDouble(num1) -
						Double.parseDouble(num2);
				
				textoAtual = transform(result);
				textoBuffer = "";
				LastOperator = null;
			} else if (LastOperator == TipoComando.DIV) {
				
				if (textoAtual == "0") {
					textoAtual = "Erro div p 0";
					textoBuffer = "";
					LastOperator = null;
					listeners.forEach(l -> l.valueChanged(getTextoAtual()));
					return;
				}
				
				String num1 = textoBuffer.contains(",") ? textoBuffer.replaceAll(",", ".") : textoBuffer;
				String num2 = textoAtual.contains(",") ? textoAtual.replaceAll(",", ".") : textoAtual;
				
				Double result = Double.parseDouble(num1) /
						Double.parseDouble(num2);
				
				textoAtual = transform(result);
				textoBuffer = "";
				LastOperator = null;
			} else if (LastOperator == TipoComando.MULT) {
				String num1 = textoBuffer.contains(",") ? textoBuffer.replaceAll(",", ".") : textoBuffer;
				String num2 = textoAtual.contains(",") ? textoAtual.replaceAll(",", ".") : textoAtual;
				
				
				Double result = Double.parseDouble(num1) *
						Double.parseDouble(num2);
				
				if (result < 0) {
					
					
					
				} else {

				}
				textoAtual = transform(result);
				textoBuffer = "";
				LastOperator = null;
			} 
			
			if (textoAtual.equals("0,") || textoAtual.equals("0")) {
				textoAtual = "";
			} 
			if (textoBuffer.equals("0,") || textoBuffer.equals("0")) {
				textoBuffer = "";
			} 
			
		}else if (tipoComando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			LastOperator = null;
			
		} else if (tipoComando == TipoComando.INVERT) {
			
			boolean emp = textoAtual.isEmpty(); 
			
			if (LastOperator != null && textoBuffer.isEmpty() && emp) {
				return;
			} else if (!textoAtual.isEmpty()) {

				Double inver = Double.parseDouble(textoAtual.replaceAll(",", "."));
				inver *= -1;
				
				textoAtual = transform(inver);
			}
			
			
		}
		
		listeners.forEach(l -> l.valueChanged(getTextoAtual()));
		
	}

	private TipoComando detectCommandTipe(String valor) {
		
		if (textoAtual.isEmpty() && valor.equals("0")) {
			return null;
		}
		
		try {
			Integer.parseInt(valor);
			return TipoComando.NUMERO;
		} catch (NumberFormatException e) {
			
			if ("C".equalsIgnoreCase(valor)) {
				
				return TipoComando.ZERAR;
				
			} else if ("/".equals(valor)) {
				
				return TipoComando.DIV;
				
			} else if ("*".equals(valor)) {
				
				return TipoComando.MULT;
				
			} else if ("+".equals(valor)) {
				
				return TipoComando.SUM;
				
			} else if ("-".equals(valor)) {
				
				return TipoComando.SUB;
				
			} else if (",".equals(valor)) {
				
				return TipoComando.VIRGULA;
				
			} else if ("=".equals(valor)) { 
				
				return TipoComando.IGUAL;
				
			} else if ("\u00B1".equals(valor)) {
				
				return TipoComando.INVERT;
				
			} else if ("%".equals(valor)) {
				
				return TipoComando.PERCENT;
				
			}
			
		}
		return null;
	}

	public void setTextoAtual(String textoAtual) {
		this.textoAtual = textoAtual;
	}
	
	private String transform(Double result) {
		
		String answr2 = "";
		String answr = result.toString();
		String answr1 = answr.contains(".") ? answr.replace('.', ',') : answr;
		if (answr1.contains(",")) {
			
			if (answr.substring(answr.indexOf(".")).length() >= 7) {
				
				String one = String.format("%.6f", result).replaceAll(",", ".");
				Double d1 = Double.parseDouble(one);
				answr = d1.toString();
			    answr1 = answr.contains(".") ? answr.replace('.', ',') : answr;
				answr2 = answr1;
			} else {

				answr2 = answr1;
				
			}
			
		} else {
			
			answr2 = answr1;

		}
		String end = answr2.substring(answr2.indexOf(",")).equals(",0") ?
				answr2.substring(0,  answr2.indexOf(",")) : answr2;
		return end;
	}
}
