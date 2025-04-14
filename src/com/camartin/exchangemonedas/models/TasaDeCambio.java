package com.camartin.exchangemonedas.models;

public class TasaDeCambio {

    //Declaracion de variables
    private String monedaSolicitada;
    private String monedaOfrecida;
    private double precioUsd;

    //Constructor
    public TasaDeCambio(String monedaSolicitada, String monedaOfrecida, double precioUsd) {
        this.monedaSolicitada = monedaSolicitada;
        this.monedaOfrecida = monedaOfrecida;
        this.precioUsd = precioUsd;
    }

    //Override del metodo toString() para customizar la visualización del objeto
    @Override
    public String toString() {
        return "TasaDeCambio{" +
                "monedaSolicitada='" + monedaSolicitada + '\'' +
                ", monedaOfrecida='" + monedaOfrecida + '\'' +
                ", precioUsd=" + precioUsd +
                '}';
    }

    //Metodo que devuelve el valor de una moneda respecto al USD o su inversa según la direccion del canje
    public double getTasaDeCambio() {

        if (this.monedaOfrecida.equals("USD")) {
            return this.precioUsd;
        } else {
            return 1/this.precioUsd;
        }
    }
}
