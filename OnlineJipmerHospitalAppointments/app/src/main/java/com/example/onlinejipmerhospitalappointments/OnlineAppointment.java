package com.example.onlinejipmerhospitalappointments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OnlineAppointment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online);
        BottomNavigationView btm =findViewById(R.id.bottom_navigation);
        btm.setSelectedItemId(R.id.reg);
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(),Search.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reg:
                        return true;
                    case R.id.credits:
                        startActivity(new Intent(getApplicationContext(),AppCredits.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    Button UrlOpen1,UrlOpen2;
            UrlOpen1 = (Button)findViewById(R.id.button1);
        UrlOpen2 = (Button)findViewById(R.id.button2);
            UrlOpen1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://covid19jipmer.org/online-patient-portal/"));
                    startActivity(Getintent);

                }
            });
        UrlOpen2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://his.jipmer.edu.in:8080/ors/(S(um2iu423zifxqsczsga5f3hs))/Startup/Login.aspx"));
                startActivity(Getintent);

            }
        });

        }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("EXIT APPLICATION | வெளியேறு");
        builder.setMessage("Do you want to exit the application ? \n" +
                "நீங்கள் பயன்பாட்டிலிருந்து வெளியேற விரும்புகிறீர்களா?");
        builder.setPositiveButton("Yes | சரி", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("Discard | இல்லை", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }
    }


