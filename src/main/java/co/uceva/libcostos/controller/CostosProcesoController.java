package co.uceva.libcostos.controller;

import co.uceva.libcostos.dto.CostosRequest;
import co.uceva.libcostos.dto.CostosResponse;
import co.uceva.libcostos.lib.CostosProceso;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/costos")
public class CostosProcesoController {

    private final CostosProceso costosProceso = new CostosProceso();

    @PostMapping
    public CostosResponse calcularCostoProduccion(@RequestBody CostosRequest request) {
        List<Float> listaCostos = request.getCostos();
        float unidades = request.getUnidades();

        int numProcesos = listaCostos.size();
        float[] costosArray = new float[numProcesos];
        for (int i = 0; i < numProcesos; i++) {
            costosArray[i] = listaCostos.get(i);
        }

        // Arreglo para devolver el costo unitario desde la función nativa
        float[] costoUnitarioArray = new float[1];

        float costoTotal = costosProceso.calcularCosto(costosArray, numProcesos, unidades, costoUnitarioArray);

        return new CostosResponse(costoTotal, costoUnitarioArray[0]);
    }
}
