package co.uceva.libcostos.controller;

import co.uceva.libcostos.dto.PronosticoRequest;
import co.uceva.libcostos.dto.PronosticoResponse;
import co.uceva.libcostos.lib.PronosticoVentas;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pronostico")
public class PronosticoController {

    private final PronosticoVentas pronosticoVentas = new PronosticoVentas();

    @PostMapping
    public PronosticoResponse calcularPronostico(@RequestBody PronosticoRequest request) {
        List<Float> ventas = request.getVentasHistoricas();
        int n = ventas.size();
        int mesesPronosticar = request.getMesesPronosticar();

        float[] ventasArray = new float[n];
        for (int i = 0; i < n; i++) {
            ventasArray[i] = ventas.get(i);
        }

        float[] resultado = new float[mesesPronosticar];
        pronosticoVentas.calcularPronostico(ventasArray, n, mesesPronosticar, resultado);

        List<Float> resultadosList = new ArrayList<>();
        for (float v : resultado) {
            resultadosList.add(v);
        }

        return new PronosticoResponse(resultadosList);
    }
}
