package com.theradikalsoftware.week2_mapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPFA = findViewById(R.id.main_activity_plazafiestaanahuac);
        Button buttonPB = findViewById(R.id.main_activity_plazabella);
        Button buttonUANL = findViewById(R.id.main_activity_uanl);
        Button buttonSBUX = findViewById(R.id.main_activity_starbucks);

        buttonPFA.setOnClickListener(this);
        buttonPB.setOnClickListener(this);
        buttonUANL.setOnClickListener(this);
        buttonSBUX.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("Tocado -> ", String.valueOf(view.getId()));
        switch(view.getId()){
            case R.id.main_activity_plazafiestaanahuac:
                GoToLocation("Plaza Fiesta Anahuac", new LatLng(25.743128, -100.313431));
                break;
            case R.id.main_activity_plazabella:
                GoToLocation("Plaza Bella", new LatLng(25.771001, -100.274481));
                break;
            case R.id.main_activity_uanl:
                GoToLocation("UANL", new LatLng(25.726036, -100.311955));
                break;
            case R.id.main_activity_starbucks:
                GoToLocation("Starbucks (Centro Morelos)", new LatLng(25.667147, -100.312009));
                break;
            default:
        }
    }


    private void GoToLocation(String name, LatLng location){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("location", location);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}