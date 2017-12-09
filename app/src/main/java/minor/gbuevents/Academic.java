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

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Academic extends Activity {
    String part_color="#EE0000";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    Intent i;
    // List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //Header carousel variables
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.acad_1, R.drawable.acad_2, R.drawable.acad_3, R.drawable.acad_4, R.drawable.acad_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhivyajana);
        i=new Intent(Academic.this,submit.class);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Initialize carousel variables
        carouselView = (CarouselView) findViewById(R.id.carouselView_abhi);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        TextView dirty = (TextView)findViewById(R.id.textView5);
        dirty.setText("There are various academic events which occur throughout the year for the skill enhancement ,personality development and many more, here is a list of them and a registration form to register.");
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, Links.acad_events, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                if(childPosition==3){
                    i.putExtra("category",2);
                    i.putExtra("event",Links.acad_events.get(groupPosition));
                    startActivity(i);
                }
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
        ArrayList<String>[] events = new ArrayList[Links.acad_events.size()];
        events[0]=new ArrayList<>(4);
        events[0].add("Makeathon is organized by the Programming Club of GBU");
        events[0].add("Faculty Coordinatory: Dr. pradeep Tomar and Dr. Arun Solanki.");
        events[0].add("Event organizer: RITIK CHANNA, General Secretory Programming Club");
        events[0].add("<font color='"+part_color+"'>Do you want to participate?</font>");


        events[1]=new ArrayList<>(4);
        events[1].add("The participant will be blind folded, Blind coded is organized by the Programming Club of GBU");
        events[1].add("Faculty Coordinatory: Dr. pradeep Tomar and Dr. Arun Solanki.");
        events[1].add("Event organizer: RITIK CHANNA, General Secretory Programming Club");
        events[1].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[2]=new ArrayList<>(4);
        events[2].add("It is organized by the Programming Club of GBU");
        events[2].add("Faculty Coordinatory: Dr. pradeep Tomar and Dr. Arun Solanki.");
        events[2].add("Event organizer: RITIK CHANNA, General Secretory Programming Club");
        events[2].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[3]=new ArrayList<>(4);
        events[3].add("It is organized by the Programming Club of GBU. The topic for poster making will be given on the spot.");
        events[3].add("Faculty Coordinatory: Dr. pradeep Tomar and Dr. Arun Solanki.");
        events[3].add("Event organizer: RITIK CHANNA, General Secretory Programming Club");
        events[3].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[4]=new ArrayList<>(4);
        events[4].add("A Workshop is being organized in university under the guidance of IOT and Electronics and Communication expert from DUCAT This workshop will be for 20 days.");
        events[4].add("Venue: School of Engineering");
        events[4].add("Contact School of ICT and School of Engineering office for the details.");
        events[4].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[5]=new ArrayList<>(4);
        events[5].add("A Workshop is being organized in university Under the guidance of an HR expert from Barclays. This workshop will be for 3 days.");
        events[5].add("Venue: SOM auditorium");
        events[5].add("Contact CRC office for the details.");
        events[5].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[6]=new ArrayList<>(4);
        events[6].add("A guest Lecture on Goods & Services Tax is being organized in university . The guest is finance minister associate.");
        events[6].add("The guest is finance minister associate.");
       events[6].add("Venue: Main auditorium");
        events[6].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[7]=new ArrayList<>(4);
        events[7].add("A guest Lectureon Nano Technology is being organized in university");
        events[7].add("The guest is The Technology Expert");
        events[7].add("Venue will be Biotech auditorium");
        events[7].add("<font color='"+part_color+"'>Do you want to participate?</font>");




        for(int i=0;i<Links.acad_events.size();i++) {
            listDataChild.put(Links.acad_events.get(i), events[i]); // Header, Child data

        }
    }
}
