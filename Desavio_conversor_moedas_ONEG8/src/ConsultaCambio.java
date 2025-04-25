import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ConsultaCambio extends Main{

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/e2c9c19d823f58e340ba9418/latest/USD";

    public static double converter(String moedaDestino, double valor) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            if (conexao.getResponseCode() == 200) {
                InputStreamReader reader = new InputStreamReader(conexao.getInputStream());
                Map<String, Object> json = new Gson().fromJson(reader, new TypeToken<Map<String, Object>>() {}.getType());

                Map<String, Double> taxas = (Map<String, Double>) json.get("conversion_rates");

                if (taxas.containsKey(moedaDestino)) {
                    return valor * taxas.get(moedaDestino);
                } else {
                    System.out.println("Moeda não encontrada.");
                    return 0;
                }
            } else {
                System.out.println("Erro ao conectar à API.");
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
