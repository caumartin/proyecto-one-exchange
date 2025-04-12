package com.camartin.exchangemonedas.main;

import com.camartin.exchangemonedas.models.TasaDeCambio;
import com.camartin.exchangemonedas.utils.ConsultaApi;
import com.camartin.exchangemonedas.utils.Menu;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) {

        double precioUsd;
        String monedaSolicitada="";
        String monedaOfrecida="";
        ConsultaApi consulta = new ConsultaApi();
        Scanner teclado = new Scanner(System.in);

        Menu menu = new Menu();
        menu.getMenu();
        int opcion = teclado.nextInt();

        while (opcion!=7) {

            switch (opcion) {
                case 1:
                    monedaSolicitada="USD";
                    monedaOfrecida="ARS";
                    break;

                case 2:
                    monedaSolicitada="ARS";
                    monedaOfrecida="USD";
                    break;

                case 3:
                    monedaSolicitada="USD";
                    monedaOfrecida="BRL";
                    break;

                case 4:
                    monedaSolicitada="BRL";
                    monedaOfrecida="USD";
                    break;

                case 5:
                    monedaSolicitada="USD";
                    monedaOfrecida="COP";
                    break;

                case 6:
                    monedaSolicitada="COP";
                    monedaOfrecida="USD";
                    break;

            }
            try {
                if (monedaSolicitada=="USD") {
                    precioUsd = consulta.getPrecio(monedaOfrecida);
                } else {
                    precioUsd = consulta.getPrecio(monedaSolicitada);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            TasaDeCambio tasaDeCambio = new TasaDeCambio(monedaSolicitada, monedaOfrecida, precioUsd);
            System.out.println(tasaDeCambio);

            System.out.println("Cuantos " + monedaOfrecida + " desea convertir a " + monedaSolicitada + ":");
            double cantidad = teclado.nextDouble();

            System.out.println("Se cambian " + cantidad + monedaOfrecida + " por " + (double) round(cantidad*tasaDeCambio.getTasaDeCambio()*100)/100 + monedaSolicitada);

            menu.getMenu();
            opcion = teclado.nextInt();

        }
    }
}
