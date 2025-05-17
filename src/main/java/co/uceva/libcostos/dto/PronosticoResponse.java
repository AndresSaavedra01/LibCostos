package co.uceva.libcostos.dto;

import java.util.List;

public class PronosticoResponse {
    private List<Float> resultados;

    public PronosticoResponse(List<Float> resultados) {
        this.resultados = resultados;
    }

    public List<Float> getResultados() {
        return resultados;
    }

    public void setResultados(List<Float> resultados) {
        this.resultados = resultados;
    }
}
