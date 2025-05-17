package co.uceva.libcostos.dto;

import java.util.List;

public class PronosticoRequest {
    private List<Float> ventasHistoricas;
    private int mesesPronosticar;

    public List<Float> getVentasHistoricas() {
        return ventasHistoricas;
    }

    public void setVentasHistoricas(List<Float> ventasHistoricas) {
        this.ventasHistoricas = ventasHistoricas;
    }

    public int getMesesPronosticar() {
        return mesesPronosticar;
    }

    public void setMesesPronosticar(int mesesPronosticar) {
        this.mesesPronosticar = mesesPronosticar;
    }
}
