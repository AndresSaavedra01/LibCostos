package co.uceva.libcostos;

import co.uceva.libcostos.lib.PronosticoVentas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedir historial de ventas
        System.out.print("¿Cuántos meses de ventas históricas tienes?: ");
        int numPeriodos = sc.nextInt();
        float[] ventas = new float[numPeriodos];

        System.out.println("Ingresa las ventas de cada mes:");
        for (int i = 0; i < numPeriodos; i++) {
            System.out.printf("Mes %d: ", i + 1);
            ventas[i] = sc.nextFloat();
        }

        // Pedir meses a pronosticar
        System.out.print("¿Cuántos meses desea pronosticar?: ");
        int numMesesPronosticar = sc.nextInt();

        // Arreglo para almacenar resultados
        float[] resultado = new float[numMesesPronosticar];

        // Crear instancia de la clase que usa JNI
        PronosticoVentas pv = new PronosticoVentas();

        // Llamar función nativa
        pv.calcularPronostico(ventas, numPeriodos, numMesesPronosticar, resultado);

        // Mostrar resultados
        System.out.println("Pronóstico de ventas para los próximos meses:");
        for (int i = 0; i < numMesesPronosticar; i++) {
            System.out.printf("Mes %d: %.2f\n", numPeriodos + i + 1, resultado[i]);
        }
    }
}