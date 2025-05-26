package co.uceva.libcostos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CostosResponse {
    private float costoTotal;
    private float costoUnitario;

    public CostosResponse(float costoTotal, float costoUnitario) {
        this.costoTotal = costoTotal;
        this.costoUnitario = costoUnitario;
    }

}
