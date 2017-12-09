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

public class Other extends Activity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String part_color="#EE0000";
    Intent i;
    //Header carousel variables
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.others_1, R.drawable.others_2, R.drawable.others_3, R.drawable.others_4, R.drawable.others_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        i=new Intent(Other.this,submit.class);
        //Initialize carousel variables
        carouselView = (CarouselView) findViewById(R.id.carouselView_other);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp_other);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, Links.other_events, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                    i.putExtra("category",3);
                    i.putExtra("event",Links.other_events.get(groupPosition));
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
        ArrayList<String>[] events = new ArrayList[Links.other_events.size()];
        events[0]=new ArrayList<>(2);
        events[0].add("Dawat-E-GBU on the occasion of Holi 2017 . This event is all set to be organized on 8th of march, 2017 at grand walk, near sarovar. The food fest will feature food stall from famous vendors of greater noida including few big names like Dominos, Kathi junction etc.");
        events[0].add("<font color='"+part_color+"'>Do you want to participate?</font>");


        events[1]=new ArrayList<>(2);
        events[1].add("eco friendly way of celebration and is organised for the diwali celebration which includes food stall from famous vendors of greater noida including few big names like Dominos, Kathi junction etc. along with stalls by students for various events and tasks.");
        events[1].add("<font color='"+part_color+"'>Do you want to participate?</font>");



        for(int i=0;i<Links.other_events.size();i++) {
            listDataChild.put(Links.other_events.get(i), events[i]); // Header, Child data

        }
    }
}