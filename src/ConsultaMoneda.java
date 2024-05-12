import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    String codigoBusquedaMoneda = "NA";
    String codigoValorMoneda = "NA";

    public Moneda busquedaMoneda(String opcionMoneda) {

        try {
            String ApiKey = "0dc924d7b44180e5b1f27966";

            switch (opcionMoneda){
                case "1":
                    codigoBusquedaMoneda = "USD";
                    codigoValorMoneda = "COP";
                    break;
                case "2":
                    codigoBusquedaMoneda = "COP";
                    codigoValorMoneda = "USD";
                    break;
                case "3":
                    codigoBusquedaMoneda = "USD";
                    codigoValorMoneda = "ARS";
                    break;
                case "4":
                    codigoBusquedaMoneda = "ARS";
                    codigoValorMoneda = "USD";
                    break;
                case "5":
                    codigoBusquedaMoneda = "USD";
                    codigoValorMoneda = "CLP";
                    break;
                case "6":
                    codigoBusquedaMoneda = "CLP";
                    codigoValorMoneda = "USD";
                    break;
            }

            String direccionApi = "https://v6.exchangerate-api.com/v6/" + ApiKey + "/latest/" + codigoBusquedaMoneda;
            URI direccion = URI.create(direccionApi);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            throw new RuntimeException("\n**** Ocurrió un ERROR en el método 'busquedaMoneda' **** \n" + e.getMessage() + '\n');
        }

    }


    public String tranformarMoneda(String opcionMoneda, Double cantidadConvertir) {

        Moneda moneda = busquedaMoneda(opcionMoneda);
        //Moneda[time_last_update_utc=Mon, 06 May 2024 00:00:01 +0000, time_next_update_utc=Tue, 07 May 2024 00:00:01 +0000, conversion_rates={USD=1.0, AED=3.6725,..

        String tiempoUltimaActualizacion;
        String tiempoProximaActualizacion;
        double tasaCambio;

        try {
            tiempoUltimaActualizacion = moneda.time_last_update_utc().substring(0, 25);
            tiempoProximaActualizacion = moneda.time_next_update_utc().substring(0, 25);
            tasaCambio = moneda.conversion_rates().get(codigoValorMoneda);

            double valorTotal = cantidadConvertir * tasaCambio;

            return "El valor de " + cantidadConvertir + " " + codigoBusquedaMoneda + " es " + valorTotal + " " + codigoValorMoneda +
                    ".\n|----> Fecha / Hora (UTC) de actualización: " + tiempoUltimaActualizacion + " <----|";

        } catch (Exception e){
            throw new RuntimeException("\n**** Ocurrió un ERROR en el método 'tranformarMoneda' **** \n" + e.getMessage() + '\n');
        }
    }
}
