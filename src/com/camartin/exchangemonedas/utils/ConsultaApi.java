package com.camartin.exchangemonedas.utils;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    JsonParser parser = new JsonParser();

    public double getPrecio (String moneda) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/857903ca15596fbb06afbc2d/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String respuesta = response.body();

        JsonObject jsonObj = parser.parse(respuesta).getAsJsonObject();
        JsonObject cotizaciones = jsonObj.get("conversion_rates").getAsJsonObject();

        return cotizaciones.get(moneda).getAsDouble();
    }
}
