package com.camartin.exchangemonedas.utils;

import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    //Se crea instancia de la clase JsonParser para poder mapear el Json de la respuesta
    JsonParser parser = new JsonParser();

    public double getPrecio (String moneda) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/857903ca15596fbb06afbc2d/latest/USD"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String respuesta = response.body();

        //Se convierte el string de la respuesta en un objeto del tipo JsonObject
        JsonObject jsonObj = parser.parse(respuesta).getAsJsonObject();
        //Se extraen los datos bajo la llave "conversion_rates" en un objeto del tipo JsonObject
        JsonObject cotizaciones = jsonObj.get("conversion_rates").getAsJsonObject();

        //Se devuelve el valor de la llave coincidente con nuestra "moneda"
        return cotizaciones.get(moneda).getAsDouble();
    }
}
