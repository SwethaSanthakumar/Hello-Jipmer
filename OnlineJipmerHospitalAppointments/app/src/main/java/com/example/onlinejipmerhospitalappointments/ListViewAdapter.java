package com.example.onlinejipmerhospitalappointments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context cont;
    LayoutInflater layinf;
    List<DeptName> deptlist;
    ArrayList<DeptName> deptarray;

    public ListViewAdapter(Context con, List<DeptName> dept){
        cont = con;
        deptlist = dept;
        this.layinf = LayoutInflater.from(cont);
        this.deptarray = new ArrayList<DeptName>();
        this.deptarray.addAll(dept);
    }

    public class ViewHolder {
        TextView textView;
    }
    @Override
    public int getCount() {
        return deptlist.size();
    }

    @Override
    public Object getItem(int i) {
        return deptlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = layinf.inflate(R.layout.dept_item, null);

            //locate the views in row.xml
            holder.textView =view.findViewById(R.id.fname);
            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.textView.setText(deptlist.get(postition).getName());
        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                    Intent intent = new Intent(cont, PopUp.class);
                String english=deptlist.get(postition).getName();
                String phone1=deptlist.get(postition).getph1();
                String phone2=deptlist.get(postition).getph2();
                intent.putExtra("english", english);
                intent.putExtra("ph1", phone1);
                intent.putExtra("ph2", phone2);

                    cont.startActivity(intent);
                }
        });

        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        deptlist.clear();
        if (charText.length()==0){
            deptlist.addAll(deptarray);
        }
        else {
            for (DeptName names : deptarray){
                if (names.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                   deptlist.add(names);
                }
            }
        }
        notifyDataSetChanged();
    }
}