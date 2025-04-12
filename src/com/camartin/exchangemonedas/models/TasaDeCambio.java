package com.camartin.exchangemonedas.models;

import static java.lang.Math.round;

public class TasaDeCambio {

    private String monedaSolicitada;
    private String monedaOfrecida;
    private double precioUsd;

    public TasaDeCambio(String monedaSolicitada, String monedaOfrecida, double precioUsd) {
        this.monedaSolicitada = monedaSolicitada;
        this.monedaOfrecida = monedaOfrecida;
        this.precioUsd = precioUsd;
    }

    public double getPrecioUsd() {
        return precioUsd;
    }

    @Override
    public String toString() {
        return "TasaDeCambio{" +
                "monedaSolicitada='" + monedaSolicitada + '\'' +
                ", monedaOfrecida='" + monedaOfrecida + '\'' +
                ", precioUsd=" + precioUsd +
                '}';
    }

    public double getTasaDeCambio() {

        if (this.monedaOfrecida.equals("USD")) {
            return this.precioUsd;
        } else {
            return 1/this.precioUsd;
        }
    }
}
