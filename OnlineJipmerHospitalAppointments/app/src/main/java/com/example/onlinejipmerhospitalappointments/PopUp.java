package com.example.onlinejipmerhospitalappointments;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class PopUp extends AppCompatActivity {
    private Button callBtn1,callBtn2;
    private TextView mResultTv,mResultTv1, mResultTv2,mResultTv3;
    private static final int REQUEST_CALL = 1;
    public int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);
        setTitle(null);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .9), (int) (height * .60));
        Intent intent = getIntent();
        String english = intent.getStringExtra("english");
        String ph1 = intent.getStringExtra("ph1");
        String ph2 = intent.getStringExtra("ph2");
        mResultTv = findViewById(R.id.resultTv);
        mResultTv.setText(english);
        mResultTv2 = findViewById(R.id.call1);
        mResultTv2.setText(ph1);
        mResultTv3 = findViewById(R.id.call2);
        mResultTv3.setText(ph2);
        callBtn1=findViewById(R.id.call1);
        callBtn2=findViewById(R.id.call2);
        callBtn1.setOnClickListener(new View.OnClickListener() {
            Calendar c=Calendar.getInstance();
            SimpleDateFormat get=new SimpleDateFormat("hh:mm:ss:a");
            String time=get.format(c.getTime());
            int hour = c.get(Calendar.HOUR_OF_DAY);
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    PopUp.this);
            @Override
            public void onClick(View v) {
                if ((hour >= 9 && hour < 18)) {
                    builder.setTitle("Are you sure you want to call?");
                    builder.setMessage("இந்த எண்ணை அழைக்க விரும்புகிறீர்களா?");
                    builder.setNegativeButton("NO | இல்லை",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getApplicationContext(), "Call Rejected", Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            });
                    builder.setPositiveButton("YES | சரி",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    CallButton();
                                }
                            });
                    builder.show();
                }else {
                    builder.setTitle("Oops!! It's " +time).setMessage("You can't call this number :( \nYou can book appointments only from 9.00 AM to 6.00 PM \nதொலைபேசி அழைப்பின் மூலம் காலை 9.00 மணி முதல் மாலை 6.00 மணி வரை மட்டுமே நீங்கள் முன்பதிவுகளை பதிவு செய்யலாம்").setPositiveButton("OK | சரி", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.show();
                }
            }
        });
        callBtn2.setOnClickListener(new View.OnClickListener() {
            Calendar c=Calendar.getInstance();
            SimpleDateFormat get=new SimpleDateFormat("hh:mm:ss:a");
            String time=get.format(c.getTime());
            int hour = c.get(Calendar.HOUR_OF_DAY);
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    PopUp.this);
            @Override
            public void onClick(View v) {
                if ((hour >= 9 && hour < 18)) {
                    builder.setTitle("Are you sure you want to call?");
                    builder.setMessage("இந்த எண்ணை அழைக்க விரும்புகிறீர்களா?");
                    builder.setNegativeButton("NO | இல்லை",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Toast.makeText(getApplicationContext(), "Call Rejected", Toast.LENGTH_LONG).show();
                                    finish();
                                }
                            });
                    builder.setPositiveButton("YES | சரி",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    CallButton();
                                }
                            });
                    builder.show();
                }else {
                    builder.setTitle("Oops!! It's " +time).setMessage("You can't call this number :( \nYou can book appointments only from 9.00 AM to 6.00 PM \nதொலைபேசி அழைப்பின் மூலம் காலை 9.00 மணி முதல் மாலை 6.00 மணி வரை மட்டுமே நீங்கள் முன்பதிவுகளை பதிவு செய்யலாம்").setPositiveButton("OK | சரி", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                                   }
                    });
                    builder.show();
                }
            }
        });
    }
    private void CallButton(){
        String number = mResultTv2.getText().toString();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(PopUp.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(PopUp.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else{
                String dial = "tel: " +number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                CallButton();
            }
            else
            {
                Toast.makeText(this,"Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
