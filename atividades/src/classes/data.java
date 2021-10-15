package classes;

public class data {
	
	int dia;
	int mes;
	int ano;
	
	data (){
		
		dia = 1;
		mes = 1;
		ano= 1970;
		
	}
	
	data (int day, int month, int year){
		
		dia = day;
		mes = month;
		ano = year;
		
	}
	
	String getData () {
		
		return String.format("%d/%d/%d", dia, mes, ano);
		
	}

}
