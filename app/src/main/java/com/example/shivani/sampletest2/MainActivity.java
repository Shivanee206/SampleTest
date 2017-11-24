package com.example.shivani.sampletest2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(android.R.id.list);
        final LinearLayout layoutOne = (LinearLayout) findViewById(R.id.layout1);
        final LinearLayout layoutTwo = (LinearLayout) findViewById(R.id.layout2);

        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            arrayList1.add("Bonus " + i);
            arrayList2.add(i + "");
            arrayList3.add((i * 100) + "");
        }
        final CustomAdapter adapter = new CustomAdapter(MainActivity.this, arrayList1, arrayList2, arrayList3);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              /*  View view1 = layoutOne.getRootView();
                View view2=layoutTwo.getRootView();
                final LinearLayout linear1 = view1.findViewById(R.id.layout1);
                final LinearLayout linear2 = view2.findViewById(R.id.layout2);
                if(linear2.getVisibility()==View.VISIBLE){
                    linear2.setVisibility(View.GONE);
                    linear1.setVisibility(View.VISIBLE);
                }else
                    {
                        linear1.setVisibility(View.VISIBLE);

                }*/

            }
        });

    }

    public class CustomAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;
        private ArrayList<String> arrayList1, arrayList2, arrayList3;
        

        public CustomAdapter(Context context, ArrayList<String> arrayList1, ArrayList<String> arrayList2,
                             ArrayList<String> arrayList3) {
            this.context = context;
            this.arrayList1 = arrayList1;
            this.arrayList2 = arrayList2;
            this.arrayList3 = arrayList3;


        }

        @Override
        public int getCount() {
            return arrayList1.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList1.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final LinearLayout layoutOne, layoutTwo;
            TextView text1, text2, text3;
            Button btn;
            
            if (inflater == null)
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) convertView = inflater.inflate(R.layout.list_items, null);

            text1 = convertView.findViewById(R.id.text1);
            text2 = convertView.findViewById(R.id.text2);
            text3 = convertView.findViewById(R.id.text3);
            btn = convertView.findViewById(R.id.btn);

            layoutOne = convertView.findViewById(R.id.layout1);
            layoutTwo = convertView.findViewById(R.id.layout2);

            text1.setText(arrayList1.get(position));
            text2.setText(arrayList2.get(position));
            text3.setText(arrayList3.get(position));
         
            //if(layoutTwo.getVisibility()==View.VISIBLE) {
            layoutTwo.setOnClickListener(new LinearLayout.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutTwo.setVisibility(View.GONE);
                    // Log.d("VIEW", String.valueOf(layoutTwo.getVisibility()));
                    layoutOne.setVisibility(View.VISIBLE);
                }
            });
           // }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layoutOne.setVisibility(View.GONE);
                    layoutTwo.setVisibility(View.VISIBLE);
                    layoutTwo.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_in));
                }
            });

            return convertView;
        }
    }

}
