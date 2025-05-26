package co.uceva.libcostos.lib;

public class CostosProceso {

    public native float calcularCosto(float[] costos, int numProcesos, float unidades, float[] costoUnitario);

    public CostosProceso() {
        try{
            System.loadLibrary("costosproceso");
            System.out.println("Libreria cargada");
        }catch(UnsatisfiedLinkError e){
            System.err.println("Error al cargar la libreria");
        }
    }
}
