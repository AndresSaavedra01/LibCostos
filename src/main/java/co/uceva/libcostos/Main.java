package co.uceva.libcostos;

import co.uceva.libcostos.lib.CostosProceso;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CostosProceso cp = new CostosProceso();
        float[] procesos = {0.2f, 0.3f, 0.5f};
        float[] unitario = {0.0f}; // donde se guardará el costo unitario

        float total = cp.calcularCosto(procesos, procesos.length, 1000f, unitario);

        System.out.printf("Costo unitario: %.2f\n", unitario[0]);
        System.out.printf("Costo total: %.2f\n", total);
    }
}