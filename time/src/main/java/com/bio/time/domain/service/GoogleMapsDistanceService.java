package com.bio.time.domain.service;

import com.google.maps.DirectionsApi;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleMapsDistanceService {
    private final GeoApiContext geoApiContext;

    public GoogleMapsDistanceService() {
        // Configura la clave de API de Google Maps
        geoApiContext = new GeoApiContext.Builder()
                .apiKey("AIzaSyB_cB__Mh2Awo3fkcZhRoaa6W1sCncb21U")
                .build();
    }

    public long calcularDistanciaEntreDosPuntos(String origen, String destino) throws Exception {
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(geoApiContext);

        DistanceMatrix matrix = request
                .origins(origen)
                .destinations(destino)
                .mode(TravelMode.DRIVING) // Modo de viaje (puede ser DRIVING, WALKING, etc.)
                .await(); // Realiza la solicitud

        // Extrae la distancia en metros desde la respuesta
        long distanciaEnMetros = matrix.rows[0].elements[0].distance.inMeters;

        return distanciaEnMetros;
    }

    public String calcularDistanciaEntrePuntos(String origen, List<String> destinos) {
        try {
            // Crear una lista de LatLng para los destinos intermedios
            List<LatLng> waypoints = new ArrayList<>();
            for (String destino : destinos) {
                LatLng waypoint = new LatLng(Double.parseDouble(destino.split(",")[0]), Double.parseDouble(destino.split(",")[1]));
                waypoints.add(waypoint);
            }

            // Realizar la solicitud de direcciones con los destinos intermedios
            DirectionsResult result = DirectionsApi.newRequest(geoApiContext)
                    .origin(origen)
                    .destination(origen) // El destino final es igual al origen para cerrar el ciclo
                    .waypoints(waypoints.toArray(new LatLng[0]))
                    .mode(TravelMode.DRIVING)
                    .await();

            DirectionsRoute[] routes = result.routes;

            long distance = 0;
            long time = 0;
            long timeTraffic = 0;
            if (routes != null && routes.length > 0) {
                for (int x = 0; x <= waypoints.size()-1; x++ ){
                //for (DirectionsRoute route : routes) {
                    distance += routes[0].legs[x].distance.inMeters;
                    time += routes[0].legs[x].duration.inSeconds;
                    timeTraffic += (routes[0].legs[x].durationInTraffic == null) ? 0 : routes[0].legs[x].durationInTraffic.inSeconds ;
                }
                return "La distancia es de " + distance + "y un tiempo estimado de " + time + "y un tiempo de trafico " + timeTraffic;
            } else {
                return "No se encontraron rutas.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al calcular la distancia.";
        }
    }

}
