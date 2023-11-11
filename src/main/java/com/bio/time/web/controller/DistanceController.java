package com.bio.time.web.controller;

import com.bio.time.domain.service.GoogleMapsDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    private final GoogleMapsDistanceService distanceService;

    @Autowired
    public DistanceController(GoogleMapsDistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/calculateTwoPoints")
    public String distanceCalculateTwoPoints(@RequestParam String origen, @RequestParam String destino) {
        try {
            long distanciaEnMetros = distanceService.calcularDistanciaEntreDosPuntos(origen, destino);
            return "La distancia entre los puntos es de " + distanciaEnMetros + " metros.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al calcular la distancia.";
        }
    }
    @GetMapping("/calculateMultiPoints")
    public String distanceCalculateMultiPoints(@RequestParam String origen, @RequestParam String[] destinos) {
        try {
            List<String> destinosList = Arrays.asList(destinos);
            return distanceService.calcularDistanciaEntrePuntos(origen, destinosList);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al calcular la distancia.";
        }
    }
}