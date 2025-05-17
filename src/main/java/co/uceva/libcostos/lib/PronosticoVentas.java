package co.uceva.libcostos.lib;

public class PronosticoVentas {

    public native void calcularPronostico(float[] ventas, int numPeriodos, int numMesesPronosticar, float[] resultado);
    public PronosticoVentas() {
        try{
            System.loadLibrary("pronosticoventas");
            System.out.println("Libreria cargada");
        }catch(UnsatisfiedLinkError e){
            System.err.println("Error al cargar la libreria");
        }
    }
}
