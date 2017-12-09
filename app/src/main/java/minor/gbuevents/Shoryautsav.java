package minor.gbuevents;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shoryautsav extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    ArrayList<String>[] events;
    HashMap<String, List<String>> listDataChild;
    Intent i;
    //Header carousel variables
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.shor_1, R.drawable.shor_2, R.drawable.shor_3, R.drawable.shor_4, R.drawable.shor_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoryautsav);
       events = new ArrayList[Links.shor_events.size()];
        i=new Intent(Shoryautsav.this,submit.class);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Initialize carousel variables
        carouselView = (CarouselView) findViewById(R.id.carouselView_shor);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp_shor);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, Links.shor_events, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                    i.putExtra("category",1);
                    i.putExtra("event",events[groupPosition].get(childPosition));
                    startActivity(i);

                return false;
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
        return true;

    }
    //Listner for crousel
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    private void prepareListData() {
        // listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();



        // Adding child data
        //  List<List<String>> events=new ArrayList<>(100);

        events[0]=new ArrayList<>(11);
        events[0].add("100m");
        events[0].add("200m");
        events[0].add("400m");
        events[0].add("800m");
        events[0].add("1600m");
        events[0].add("High jump");
        events[0].add("Long jump");
        events[0].add("Discus throw");
        events[0].add("Shot-put");
        events[0].add("Javelin throw");
        events[0].add("Chess");





        events[1]=new ArrayList<>(6);
        events[1].add("Basketball");
        events[1].add("Football");
        events[1].add("TT");
        events[1].add("Volleyball");
        events[1].add("4*100m relay");
        events[1].add("4*400m relay");




        for(int i=0;i<Links.shor_events.size();i++) {
            listDataChild.put(Links.shor_events.get(i), events[i]); // Header, Child data

        }
    }
}