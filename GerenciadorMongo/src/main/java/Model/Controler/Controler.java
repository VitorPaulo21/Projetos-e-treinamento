package Model.Controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import Model.ConectionDb.DAO;
import Model.Objects.Banca.Banca;
import Model.Objects.List.Ganho;
import Model.Objects.List.Ganhos;
import Model.Objects.Percents.Porcents;
import Model.Objects.Stops.Stops;
import Observers.Refreshers.Refresh;
import Observers.Refreshers.RefreshList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import newView.Balanca.Balanca;
import newView.Bottom.Buttons;
import newView.Bottom.GanhosDoDia;
import newView.Porcentagens.Percents;
import newView.Stops.StopGains;

public class Controler{

	private static ArrayList<Refresh> telas = new ArrayList<Refresh>();

	
	public static Date data = new Date();
	private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	public static String FormatedDate = format.format(data);
	
	public static Banca Banca = DAO.obterBanca();
	public static Ganhos Ganhos = DAO.obterGanhos(FormatedDate);
	public static Porcents Percents = DAO.obterPercents();
	public static Stops Stops = DAO.obterStops();
	
	public static RefreshList refreshList;
	
	public static Double total;
	
	private static boolean isStopWin = false;
	private static boolean askWIn = false;
	private static boolean isStopLoss = false;
	private static boolean askLoss = false;
	
	public static boolean isInitializated = false;
	public static boolean allowClicks = true;
	
	private Controler() {
		
	}
	
	public static void refreshAll() {
		
		telas.forEach(t -> {
			
			t.refreshN();
			
		});
		
	}

	public static void saveBanca(Banca banc) {
			
		Banca = banc;
		DAO.saveBanca(Banca);
		
		refreshAll();
		
	}
	public static void addBanca() {
		DAO.saveBanca(Banca);
		
		refreshBanca();
	}
	
	public static void saveGanho(Double valor) {
		
		  Ganhos.getGanhos().add(new Ganho(FormatedDate, valor));
		  saveGanhos(valor);
		
	}
	
	private static void saveGanhos(Double valor) {
		
		DAO.saveGanho(FormatedDate, valor);
		
		refreshGainList(valor);
		refreshPercents();
	}
	
	public static void saveInvPercs(Porcents inv) {
		
		Percents = inv;
		
		DAO.savePercents(Percents);
		
		refreshPercents();
	}
	
	public static void savePercents(Stops perc) {
		
		Stops = perc;
		
		DAO.saveStops(Stops);
		
		refreshStops();
	}

	
	public static void refreshStops() {
		
		telas.stream().filter(cl -> cl.getClass() == StopGains.class).forEach(cl -> cl.refreshN());
		
	}
	public static void refreshPercents() {
		
		telas.stream()
		.filter(cl -> cl.getClass() == Buttons.class || cl.getClass() == Percents.class )
		.forEach(cl -> cl.refreshN());
		
	}
	public static void refreshGanhosDoDia() {
		
		telas.stream().filter(cl -> cl.getClass() == GanhosDoDia.class).forEach(cl -> cl.refreshN());
		
	}
	
	public static void refreshBanca() {
		
		telas.stream().filter(cl -> cl.getClass() == Balanca.class).forEach(cl -> cl.refreshN());
		
	}
	
	public static void refreshGainList(double value) {
		
		refreshList.refreshL(value);
		
	}
	
	
	public static void addToList(Refresh toAdd) {
		
		telas.add(toAdd);
		
	}
	
	public static void showNumberException() {
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Entrada Invalida!");
		alert.setContentText("Voce digitou uma entrada invalida,\nInsira somente numeros,\nPor favor verifique a entrada");
		alert.show();
		
	}
	
	public static void destroy() {
		
	}
	
	public static int showOptionStop() {
		
		String stop = "";
		
		if (isStopWin) {
			
			stop = "Win";
			
		} else {
			
			stop = "Loss";
			
		}
		
		ButtonType sim = new ButtonType("sim", ButtonData.OK_DONE);
		ButtonType nao = new ButtonType("não", ButtonData.CANCEL_CLOSE);
		
		Alert alert = new Alert(AlertType.CONFIRMATION, "Seu stop " + stop + " foi atingido deseja continuar?", sim, nao);
		
		alert.setTitle("Stop's");
		alert.setHeaderText("Stop " + stop + " atingido");

		if (stopDecide()) {
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent()) {

				if (result.get() == sim) {

					if (isStopWin) {
						
						askWIn = true;
						
					} else {

						askLoss = true;
						
					}
					
					return 1;
				} else {

					if(isInitializated) {
						
						allowClicks = false;
						return 0;
					} else {
						
						destroy();
						System.exit(0);
						return 0;
						
					}
					
					
				}

			} 
		}
		return 0;
		
	}
	
	private static boolean stopDecide() {
		
		isStopped();
		
		if (isStopWin) {
			
			if (askWIn) {
				
				return false;
				
			} else {

				return true;
				
			}
			
		} else if (isStopLoss) {
			
			if (askLoss) {
				
				return false;
				
			} else {

				return true;
				
			}
			
		} else {
			
			return false;
			
		}
		
	}
	
	public static boolean isStopped() {
		
		if (total >= Banca.getInicial() * Stops.getStopGain()) {
			
			isStopWin = true;
			isStopLoss = false;
			askLoss = false;
			return true;
			
		} else if (total <= Banca.getInicial() * (Stops.getStopLoss() * (-1))) {
			
			isStopLoss = true;
			isStopWin = false;
			askWIn = false;
			return true;
			
		} else {
			
			isStopWin = false;
			isStopLoss = false;
			askWIn = false;
			askLoss = false;
			
			return false;
			
		}
		
	}
	
}
