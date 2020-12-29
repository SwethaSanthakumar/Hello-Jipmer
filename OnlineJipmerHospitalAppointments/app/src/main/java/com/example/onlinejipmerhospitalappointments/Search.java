package com.example.onlinejipmerhospitalappointments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Search extends AppCompatActivity  implements SearchView.OnQueryTextListener {

    SearchView editsearch;
    ListView listView;
    ListViewAdapter adapter;
    String[] Name;
    ArrayList<DeptName> nameArrayList = new ArrayList<DeptName>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView btm =findViewById(R.id.bottom_navigation);
        btm.setSelectedItemId(R.id.search);
        btm.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.search:
                        return true;
                    case R.id.reg:
                        startActivity(new Intent(getApplicationContext(),OnlineAppointment.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.credits:
                        startActivity(new Intent(getApplicationContext(),AppCredits.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        String[] Name={"General Medicine and General Surgery \nபொது மருத்துவம் மற்றும் பொது அறுவை சிகிச்சை",
                "Cardiology and Cardiothoracic Surgery \nஇருதயவியல் மற்றும் இருதய அறுவை சிகிச்சை",
                "Medical and Surgical Gastroenterology \nமருத்துவ மற்றும் அறுவை சிகிச்சை காஸ்ட்ரோஎன்டாலஜி",
                "Nephrology and Urology \nநெப்ராலஜி மற்றும் சிறுநீரகம்",
                "Neurology and Neurosurgery \nநரம்பியல் மற்றும் நரம்பியல் அறுவை சிகிச்சை",
                "Orthopaedics and Physical medicine and Rehabilitation \nஎலும்பியல் மற்றும் உடல் மருத்துவம் மற்றும் மறுவாழ்வு",
                "Medical, Surgical and Radiation Oncology \nமருத்துவ, அறுவை சிகிச்சை மற்றும் கதிர்வீச்சு புற்றுநோயியல்",
                "Obstetrics and Gynecology \nமகப்பேறியல் மற்றும் பெண்ணோயியல்",
                "Ear,Nose and Throat and Ophthalmology \nகாது, மூக்கு மற்றும் தொண்டை மற்றும் கண் மருத்துவம்",
                "Dermatology \nதோல் நோய்",
                "Neonatology and Paediatrics \nநியோனாட்டாலஜி மற்றும் குழந்தை மருத்துவம்",
                "Clinical Immunology and Endocrinology \nநியோனாட்டாலஜி மற்றும் குழந்தை மருத்துவம்",
                "Pulmonary Medicine \nமருத்துவ நோயெதிர்ப்பு மற்றும் உட்சுரப்பியல்",
                "Psychiatry \nஉளவியல்",
                "Dentistry \nபல் மருத்துவம்",
                "Plastic Surgery \nபிளாஸ்டிக் அறுவை சிகிச்சை",
                "Paediatric Surgery \nகுழந்தை அறுவை சிகிச்சை"};
        String[] ph1={"04132298200",
                "6384400741",
                "6384400743",
                "6384400745",
                "6384400747",
                "6384400749",
                "6384400751",
                "6384400753",
                "6384400755",
                "6384400757",
                "6384400759",
                "9787245034",
                "9787245082",
                "9787245020",
                "9787245024",
                "9787244988",
                "9787244983"};
        String[] ph2={"04132298303",
                "6384400742",
                "6384400744",
                "6384400746",
                "6384400748",
                "6384400750",
                "6384400752",
                "6384400754",
                "6384400756",
                "6384400758",
                "6384400760",
                "9787245094",
                "9787245087",
                "9787245021",
                "9787244996",
                "9787244989",
                "9787244978"};

        //Listview
        listView = (ListView) findViewById(R.id.list);
        for (int i = 0; i < Name.length; i++) {
            DeptName PN = new DeptName(Name[i],ph1[i],ph2[i]);
            nameArrayList.add(PN);
        }
        adapter = new ListViewAdapter(this, nameArrayList);

        //Listview
        listView.setAdapter(adapter);


        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
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