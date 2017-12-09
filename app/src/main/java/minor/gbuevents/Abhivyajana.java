package minor.gbuevents;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//todo all event update
public class Abhivyajana extends Activity {
   String part_color="#EE0000";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    Intent i;
   // List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //Header carousel variables
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.abhi_1, R.drawable.abhi_2, R.drawable.abhi_3, R.drawable.abhi_4, R.drawable.abhi_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhivyajana);
        i=new Intent(Abhivyajana.this,submit.class);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //Initialize carousel variables
        carouselView = (CarouselView) findViewById(R.id.carouselView_abhi);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, Links.abhi_events, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                if(childPosition==3){
                    i.putExtra("category",0);
                    i.putExtra("event",Links.abhi_events.get(groupPosition));
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
//        listDataHeader.add("Skit: SHIVAAY");
//        listDataHeader.add("Main Street Play||Thappad");
//        listDataHeader.add("Main Play||Black Tiger");
//        listDataHeader.add("MONO-ACTING");
//        listDataHeader.add("Skit Competition");
//        listDataHeader.add("DUMBCHARADES");
//        listDataHeader.add("AD-MAD");
//        listDataHeader.add("English Extempore");
//        listDataHeader.add("Hindi Debate");
//        listDataHeader.add("Hindi Extempore");
//        listDataHeader.add("English Debate");
//        listDataHeader.add("Review Writing Competition");
//        listDataHeader.add("Creative Writing Competition");
//        listDataHeader.add("Reminiscenu(Sanssmaran)");
//        listDataHeader.add("Leaf Painting");
//        listDataHeader.add("Iconic Sculpture");
//        listDataHeader.add("Tribal Art");
//        listDataHeader.add("Painting Exibition");
//        listDataHeader.add("Speed Painting");
//        listDataHeader.add("Rangoli Competition");
//        listDataHeader.add("Solo Dance");
//        listDataHeader.add("Duet Dance");
//        listDataHeader.add("Group Dance");
//        listDataHeader.add("\"Beti Hai Toh Kal Hai\"");
//        listDataHeader.add("Poster Making||Beti Bachao Beti Padhao");
//        listDataHeader.add("Destruction Of Earth||Skit");
//        listDataHeader.add("GBU's Voice||Solo Singing");
//        listDataHeader.add("Fruit Sculpting");
//        listDataHeader.add("Card Tower");
//        listDataHeader.add("100 Earned Naturally");
//        listDataHeader.add("Wordsworth");
//        listDataHeader.add("Mehendi Competition");
//        listDataHeader.add("Prank Club");
//        listDataHeader.add("Collage Competition");
//        listDataHeader.add("Takeshi's Castle");
//        listDataHeader.add("Nutri Chef");
//        listDataHeader.add("GBU DI JODIYAN");
//        listDataHeader.add("Mid City Madness");
//        listDataHeader.add("Scavenger Hunt");
//        listDataHeader.add("Balls and Hop");
//        listDataHeader.add("KHICHAAK!!");
//        listDataHeader.add("Funniest Selfie Of Us All");
//        listDataHeader.add("LAN Gaming");
//        listDataHeader.add("Doodle Army 2: Mini Militia");

        // Adding child data
      //  List<List<String>> events=new ArrayList<>(100);
        ArrayList<String>[] events = new ArrayList[Links.abhi_events.size()];
        events[0]=new ArrayList<>(4);
        events[0].add("The power of Lord Shiva against the evils.");
        events[0].add("Faculty Co-ordinator: Dr. Sandeep Sharma");
        events[0].add("Event Manager and Coordinators : Rishabh Raj");
        events[0].add("<font color='"+part_color+"'>Do you want to participate?</font>");


        events[1]=new ArrayList<>(4);
        events[1].add("The Street Play \"Thappad\" is an event by \"AdhyaNukkad Group\" of GBU, showcasing the woman impowerment.");
        events[1].add("Faculty Co-ordinator: Dr. Sandeep Sharma");
        events[1].add("Event Manager and Coordinators : Ankit Sharma");
        events[1].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[2]=new ArrayList<>(4);
        events[2].add("Main Play \"Black Tiger\" is an main play organized by the general secretory of the dramatics club of GBU.");
        events[2].add("Faculty Co-ordinator: Dr. Sandeep Sharma");
        events[2].add("Event Manager and Coordinators : Rishabh Raj");
        events[2].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[3]=new ArrayList<>(4);
        events[3].add("Mono ACT is an event organized by the Dishayan club.");
        events[3].add("Faculty Co-ordinator: Dr. Sandeep Sharma");
        events[3].add("Event Manager and Coordinators : Ankit Sharma");
        events[3].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[4]=new ArrayList<>(4);
        events[4].add("Skit Competition, event organized by dishsyan lub every year.");
        events[4].add("Faculty Co-ordinator: Dr. Sandeep Sharma");
        events[4].add("Event Manager and Coordinators : Ankit Sharma");
        events[4].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[5]=new ArrayList<>(4);
        events[5].add("English Extempore is a public speaking event where speaker has given topic on the spot and he/she has to deliver in English only");
        events[5].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[5].add("Event Manager and Coordinators : Namita Singh Chauhan");
        events[5].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[6]=new ArrayList<>(4);
        events[6].add("Hindi Debate is the event where topic is given prior to the event");
        events[6].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[6].add("Event Manager and Coordinators : Vishal Mehta");
        events[6].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[7]=new ArrayList<>(4);
        events[7].add("Hindi extempore is a public speaking event where speaker has given topic on the spot and he/she has to deliver in Hindi only ");
        events[7].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[7].add("Event Manager and Coordinators : Shikhar Gupta");
        events[7].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[8]=new ArrayList<>(4);
        events[8].add("English Debate is the event where topic is given prior to the event ");
        events[8].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[8].add("Event Manager and Coordinators : Aryan Makhija");
        events[8].add("<font color='"+part_color+"'>Do you want to participate?</font>");


        events[9]=new ArrayList<>(4);
        events[9].add("Creative Writing Competiton is organized by the Literay Club, GBU ");
        events[9].add("Faculty Co-ordinator: Dr. Om Prakash");
        events[9].add("Event Manager and Coordinators : Shivangi Tiwari");
        events[9].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[10]=new ArrayList<>(4);
        events[10].add("leaf painting is organized by Art Club of GBU ");
        events[10].add("Faculty Co-ordinator: Dr. Priyadarshani Mitra");
        events[10].add("Event Manager and Coordinators : Aryan Makhija");
        events[10].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[11]=new ArrayList<>(4);
        events[11].add("Painting Exhibition is Organised by the Art Club of GBU ");
        events[11].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[11].add("Event Manager and Coordinators : prem lata");
        events[11].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[12]=new ArrayList<>(4);
        events[12].add("Speed Pinitng is Organised by the Art Club of GBU ");
        events[12].add("Faculty Co-ordinator: Dr. Subhashish bhadra");
        events[12].add("Event Manager and Coordinators : Hem lata");
        events[12].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[13]=new ArrayList<>(4);
        events[13].add("Duet Dance Competition is organized by the Dance Club of GBU");
        events[13].add("Faculty Co-ordinator: Dr. Vandana Singh");
        events[13].add("Event Manager and Coordinators : Yash Bhardwaj");
        events[13].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[14]=new ArrayList<>(4);
        events[14].add("");
        events[14].add("Faculty Co-ordinator: Dr. Vandana Singh ; Dr. Savneet Kaur ; Dr. Deepali Singh ; Dr. Deepti Goyal");
        events[14].add("Event Manager and Coordinators : Bhanvi Dudeja");
        events[14].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[15]=new ArrayList<>(4);
        events[15].add("\"Beti Hai toh kal Hai\" is a skit which is based on the reality of our society.");
        events[15].add("Faculty Co-ordinator: Dr. Sandhya Tarar");
        events[15].add("Event Manager and Coordinators : Vishal Mehta");
        events[15].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[16]=new ArrayList<>(4);
        events[16].add("");
        events[16].add("Faculty Co-ordinator: Dr. S Banerjee");
        events[16].add("Event Manager and Coordinators : Mohd Maaz Aziz");
        events[16].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[17]=new ArrayList<>(4);
        events[17].add("");
        events[17].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[17].add("Event Manager and Coordinators : Shivangi Saini");
        events[17].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[18]=new ArrayList<>(4);
        events[18].add("");
        events[18].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[18].add("Event Manager and Coordinators : Anant Kaushik ; Shivangi Saini");
        events[18].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[19]=new ArrayList<>(4);
        events[19].add("Theme \"Best Out Of Waste\".The most creative collage will win.");
        events[19].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[19].add("Event Manager and Coordinators : Zafar Iqbal ; Sanya Mittal");
        events[19].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[20]=new ArrayList<>(4);
        events[20].add("It is a competition between two teams.Participants has to save the paper loop tied on their head and simultaneously have to pick the flag");
        events[20].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[20].add("Event Manager and Coordinators : Vidushi Gupta ; Kshitiz Dabaur");
        events[20].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[21]=new ArrayList<>(4);
        events[21].add("");
        events[21].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[21].add("Event Manager and Coordinators : Rishika ; Kshitiz Dabaur");
        events[21].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[22]=new ArrayList<>(4);
        events[22].add("The Event \"GBU DI JODIYAN\" is pair based event, in which participants would come in jodi & perform in various categories like music/singig, dance & drama/comedy.");
        events[22].add("Faculty Co-ordinator: Ma'am Barkha Singhal & Jaya Maitra");
        events[22].add("Event Manager and Coordinators : Kavya");
        events[22].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[23]=new ArrayList<>(4);
        events[23].add("One of the member will navigate the other blind folded one, in such a way that he takes the least time and put the given object into the basket quickly by crossing all the obstacles in between. The team which does this first will win this game");
        events[23].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[23].add("Event Manager and Coordinators : Sanya Mittal ; Zafar Iqbal");
        events[23].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[24]=new ArrayList<>(4);
        events[24].add("Participants will be given a list of items for which they need to search and then click their pictures and summit them to organisers. List of items will be given on the spot.");
        events[24].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[24].add("Event Manager and Coordinators : Sanya Mittal ; Zafar Iqbal");
        events[24].add("<font color='"+part_color+"'>Do you want to participate?</font>");

        events[25]=new ArrayList<>(4);
        events[25].add("Riddles will be provided to the participants and accordingly they have to search for the different coloured balls, hidden near by the Sarovar Area.");
        events[25].add("Faculty Co-ordinator: Ma'am Vandana Singh");
        events[25].add("Event Manager and Coordinators : Kshitiz Dabur ; Vidushi Gupta ; Shivangi Anant");
        events[25].add("<font color='"+part_color+"'>Do you want to participate?</font>");


        for(int i=0;i<Links.abhi_events.size();i++) {
    listDataChild.put(Links.abhi_events.get(i), events[i]); // Header, Child data

}
    }
}
