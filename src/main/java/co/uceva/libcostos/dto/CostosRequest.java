package co.uceva.libcostos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CostosRequest {
    private List<Float> costos;
    private float unidades;

}
