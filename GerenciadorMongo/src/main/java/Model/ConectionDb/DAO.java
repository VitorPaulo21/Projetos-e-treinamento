package Model.ConectionDb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import Model.Objects.Banca.Banca;
import Model.Objects.List.Ganho;
import Model.Objects.List.Ganhos;
import Model.Objects.Percents.Porcents;
import Model.Objects.Stops.Stops;


public class DAO {

	private DAO() {
		
	}
	
	private static String get(String patch) {

		
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(URI.create("http://localhost:8080/inv/" + patch))
					.build();
			
			HttpResponse<String> response = httpClient.send(httpRequest,
					HttpResponse.BodyHandlers.ofString());
			return response.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
	}
	private static void post(HashMap<String, String> params, String patch) {
		
		StringJoiner sj = new StringJoiner("&");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			
				try {
					sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
					         + URLEncoder.encode(entry.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(URI.create("http://localhost:8080/inv/" + patch + "?" + sj.toString()))
					.POST(HttpRequest.BodyPublishers.ofByteArray(sj.toString().getBytes()))
					.build();
	
		try {
			httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void saveBanca(Banca banca) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("inicial", "" + banca.getInicial());
		params.put("finall", "" + banca.getFinall());
		
		post(params, "saveBanca");
		
	}
	
	public static void savePercents(Porcents percents) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("toInv", "" + percents.getToInvest());
		params.put("payout", "" + percents.getPayout());
		
		post(params, "savePercent");
		
	}
	
	public static void saveStops(Stops percents) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("stopGain", Double.toString(percents.getStopGain()));
		params.put("stopLoss", Double.toString(percents.getStopLoss()));
		
		post(params, "saveStops");
		
	}
	
	public static void saveGanho(String data, Double valor) {
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("data", data);
		params.put("valor", valor.toString());
		
		post(params, "saveGanho");
		
	}
	
	public static Banca obterBanca() {
		
		HashMap<String, Object> data = toHashMap(get("getBanca"));
		Banca banc = new Banca();
		banc.setId(data.get("id").toString());
		banc.setInicial((double) data.get("inicial"));
		banc.setFinall((double) data.get("finall"));
		banc.setIdent(1);
		
		return banc;
	}
	
	public static Porcents obterPercents() {
		Porcents percents = new Porcents();
		HashMap<String, Object> data = toHashMap(get("getPercent"));
		
		percents.setId(data.get("id").toString());
		percents.setToInvest((double) data.get("toInvest"));
		percents.setPayout((double) data.get("payout"));
		percents.setIdent(1);
		
		return percents;
	}
	
	public static Stops obterStops() {
		Stops stops = new Stops();
		HashMap<String, Object> data = toHashMap(get("getStops"));
		
		stops.setId(data.get("id").toString());
		stops.setStopGain(Double.parseDouble(data.get("stopGain").toString()));
		stops.setStopLoss(Double.parseDouble(data.get("stopLoss").toString()));
		stops.setIdent(1);
		
		return stops;
	}
	
	public static Ganhos obterGanhos(String date) {
		Ganhos ganhos = new Ganhos();
		HashMap<String, Object> data = toHashMap(get("getGanhos/" + date.replace("/", "-")));
		
		if (data == null) {
			
			return new Ganhos();
			
		}
		
		ganhos.setId(data.get("id").toString());
		ganhos.setData(data.get("data").toString());
		objectInside(data.get("ganhos").toString()).forEach(g -> {
			
			Ganho ganho = new Ganho();
			ganho.setId(null);
			ganho.setData(g.get("data").toString());
			ganho.setValor((double) g.get("valor"));
			
			ganhos.getGanhos().add(ganho);
			
		});
		
		
		return ganhos;
	}
	
	
	private static HashMap<String, Object> toHashMap(String str){
		
		
		if (str.isEmpty()) {
			return null;
		}
		
		String[] param = {};
		boolean isGanho = false;
		String keeper = null;
		String get = str;
		
		if (get.contains("\"ganhos\":")) {
			param = get
					.substring(1, get.length() - 1)
					.split("\"ganhos\":");
			
			keeper = param[1].substring(1, param[1].length() - 1)
					.replaceAll("null", "\"null\"");
			
			param = param[0].substring(0, param[0].length()-1).split(",");
			
			isGanho = true;
					
		}
		
		if (!isGanho) {
			param = get.substring(1, get.length() - 1).split(",");
		}
			
		HashMap<String, Object> values = new HashMap<String, Object>();

		for (String string : param) {
			String[] keys = string.split(":");
			
			String key = keys[0];
			Object value = keys [1];
			
			
			values.put(key.substring(1, key.length() - 1), value.toString().startsWith("\"")
					&& value.toString().endsWith("\"") ? 
							value.toString().substring(1, value.toString().length() - 1) : 
								Double.parseDouble(value.toString()));
			
		}
		
		if (isGanho) {
			values.put("ganhos", keeper);
		}
		
		return values;
		
	}
	
	private static ArrayList<HashMap<String, Object>> objectInside(String str){
		ArrayList<HashMap<String, Object>> data = new ArrayList<>(); 
		
		String[] get = str.split("},");
		
		
		for (String string : get) {
			string = string.replace("{", "");
			string = string.replace("}", "");
			data.add(toHashMap("{" + string + "}"));
		}
		
		return data;
	}
	
}
