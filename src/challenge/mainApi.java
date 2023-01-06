package challenge;

import java.io.*;
import org.json.JSONObject;
import okhttp3.*;

public class mainApi {
	public static double recuperar(String from,String to, double monto) throws IOException {
		
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder()
				.url("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + monto)
				.addHeader("apikey", "7QSiLVMUC5CXSjBmDKuzmiOGQI1FaApM")
				.method("GET", null)
				.build();
		Response response = client.newCall(request).execute();
		String jsonString = response.body().string();
		JSONObject jsonObj = new JSONObject(jsonString);
//		System.out.println(jsonString);
//		System.out.println(jsonObj.getDouble("result"));  
		return jsonObj.getDouble("result");
	}
	
	public static String coincidirCodigo(String valor, String[] paraBuscar, String[] toMatch) {
		for (int i = 0; i < paraBuscar.length; i++) {
			if (valor == paraBuscar[i]) {
				return toMatch[i];
			}
		}
		return null;
	}
}
