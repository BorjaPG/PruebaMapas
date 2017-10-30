package com.bp.pruebamapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declara y asocia el fragmento del mapa.
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        //Resgistra la escucha de onMapReadyCallBack.
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        //Crea una latitud y longitud.
        LatLng madrid = new LatLng(40.4893538421231,-3.6827461557); //Coordenadas de Madrid.
        //Con addMarker se añade un marcador en las coordenadas indicadas.
        googleMap.addMarker(new MarkerOptions()
                .position(madrid)
                .title("Madrid Capital")); //Se le puede añadir un título al marcador.

        //Configura la posición y zoom de la cámara.
        CameraPosition cameraPosition = CameraPosition.builder()
                .target(madrid) //Se centra en Madrid.
                .zoom(10)
                .build();

        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
