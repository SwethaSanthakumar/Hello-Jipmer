package com.example.onlinejipmerhospitalappointments;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import java.util.Timer;
public class sliderAdapter extends PagerAdapter {
    Timer timer;
    Context context;
    int i=0;
    LayoutInflater layoutInflater;
    public sliderAdapter(Context context){
        this.context=context;
    }
    public int[] slide_images= {
            R.drawable.jipmer5,
            R.drawable.jipmer4,
    };
    public String[] slide_heading={
            "This mobile app is intended for helping the patients to easily call the appropriate contact for online appointment \nAPPOINTMENT TIMING | முன்பதிவு நேரம் \nMonday to Friday 9 AM to 4 PM \nSaturday 9 AM to 12 NOON \nதிங்கள் முதல் வெள்ளி வரை காலை 9 மணி முதல் மாலை 4 மணி வரை மற்றும்\nசனிக்கிழமைகளில் 9 மணி முதல் மதியம் 12 மணி வரை",
            "இந்த செயலி ஜிப்மர் மருத்துவமனைக்கு சிகிச்சைக்காக செல்லவிருக்கும் நோயாளிகளுக்கு அவர்கள் சிகிச்சை பெற விரும்பும் மருத்துவத்துறைக்கான தொலைபேசி எண்ணை எளிதாக காண்பிப்பதற்காகவும், அந்த எண்ணை தட்டச்சு செய்யாமலே (அந்த எண்ணை தொடுவதன் மூலம்) உடனடியாக தொடர்பு கொள்ளும் வண்ணம் உருவாக்கப்பட்டுள்ளது\n",

    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==(ConstraintLayout) o;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=(ImageView)view.findViewById(R.id.imageView);
        TextView slideHeading=(TextView)view.findViewById(R.id.textView);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        container.addView(view);
       return view;
    }
    @Override
    public void destroyItem(final ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }}


