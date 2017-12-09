package minor.gbuevents;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;





import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView.OnItemSelectedListener;
//TODO spinner color update

public class submit extends Activity implements OnItemSelectedListener {



    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //URL derived from form URL
   // public static final String URL=Links.google_form;
    //input element ids found from the live form page
    //public static final String EMAIL_KEY="entry_313227136";
    //public static final String SUBJECT_KEY="entry_1834657755";
    //public static final String MESSAGE_KEY="entry_1110317093";

    private  Context context;
    private EditText nameEditText;
    private EditText rollnoEditText;
    private Spinner eventSpinner;
    private Spinner schoolSpinner;
    private Spinner mainSpinner;
    private List<String> events;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        intent = getIntent();

        //save the activity in a context variable to be used afterwards
        context =this;
    events=new ArrayList<>(1);
        //Get references to UI elements in the layout
        Button sendButton = (Button)findViewById(R.id.btn_submit);
        nameEditText = (EditText)findViewById(R.id.nameEditText);
        rollnoEditText = (EditText)findViewById(R.id.rollnoEditText);
        eventSpinner = (Spinner) findViewById(R.id.eventSpinner);
        schoolSpinner=(Spinner)findViewById(R.id.schoolSpinner);
        mainSpinner=(Spinner)findViewById(R.id.mainSpinner);



        // Spinner click listener

       mainSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                events=Links.abhi_events;
            }
            else if(position==1){
                events=Links.shor_events_all;
            }
            else if(position==2){
                    events=Links.acad_events;
            }
            else {
                events=Links.other_events;
            }
                ArrayAdapter<String> eventadapter = new ArrayAdapter<String>(submit.this, R.layout.spinner_item, events);
            eventSpinner.setAdapter(eventadapter);
            int pos=geteventpos(intent.getStringExtra("event"),intent.getIntExtra("category",0));
            if(pos<events.size()&&pos>-1)
            eventSpinner.setSelection(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Spinner Drop down elements
        List<String> schools = new ArrayList<String>();
        schools.add("School of ICT");
        schools.add("School of Vocational and Science Studies");
        schools.add("School of Engineering 1");
        schools.add("School of Engineering 2");
        schools.add("School of Management");
        schools.add("School of Biotech");
        schools.add("School of Law");
        schools.add("School of Buddhist studies");





        List<String> main = new ArrayList<String>();
        main.add("Abhivyanjana");
        main.add("Shoryautsav");
        main.add("Academic");
        main.add("Other events");





        // Creating adapter for spinner
        ArrayAdapter<String> schooladapter = new ArrayAdapter<String>(this, R.layout.spinner_item, schools);
        ArrayAdapter<String> eventadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, events);
        ArrayAdapter<String> mainadapter = new ArrayAdapter<String>(this, R.layout.spinner_item, main);

        // Drop down layout style - list view with radio button
        schooladapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eventadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        schoolSpinner.setAdapter(schooladapter);
        eventSpinner.setAdapter(eventadapter);
        mainSpinner.setAdapter(mainadapter);
        mainSpinner.setSelection(intent.getIntExtra("category",0));

        //eventSpinner.setSelection(geteventpos(intent.getStringExtra("event"),intent.getIntExtra("category",0)));


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Make sure all the fields are filled with values
                if(TextUtils.isEmpty(nameEditText.getText().toString()) ||
                        TextUtils.isEmpty(rollnoEditText.getText().toString()) )
                {
                    Toast.makeText(context,"All fields are mandatory.",Toast.LENGTH_LONG).show();
                    return;
                }
                //TODO check if roll_no valid

                //Create an object for PostDataTask AsyncTask
                PostDataTask postDataTask = new PostDataTask();

                //execute asynctask
                postDataTask.execute(Links.google_form, nameEditText.getText().toString(),
                        rollnoEditText.getText().toString(),
                        eventSpinner.getSelectedItem().toString(),schoolSpinner.getSelectedItem().toString(),mainSpinner.getSelectedItem().toString());
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        finish();
        return true;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    //AsyncTask to send data as a http POST request
    private class PostDataTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... contactData) {
            Boolean result = true;
            String url = contactData[0];
            String name = contactData[1];
            String roll_no = contactData[2];
            String event = contactData[3];
            String school = contactData[4];
            String main = contactData[5];
            String postBody="";

            try {
                //all values must be URL encoded to make sure that special characters like & | ",etc.
                //do not cause problems
                postBody = Links.name+"=" + URLEncoder.encode(name,"UTF-8") +
                        "&" + Links.school + "=" + URLEncoder.encode(school,"UTF-8") +
                        "&" + Links.roll_no + "=" + URLEncoder.encode(roll_no,"UTF-8") +
                        "&" + Links.main + "=" + URLEncoder.encode(main,"UTF-8") +
                        "&" + Links.event + "=" + URLEncoder.encode(event,"UTF-8");
            } catch (UnsupportedEncodingException ex) {
                result=false;
            }

            /*
            //If you want to use HttpRequest class from http://stackoverflow.com/a/2253280/1261816
            try {
			HttpRequest httpRequest = new HttpRequest();
			httpRequest.sendPost(url, postBody);
		}catch (Exception exception){
			result = false;
		}
            */

            try{
                //Create OkHttpClient for sending request
                OkHttpClient client = new OkHttpClient();
                //Create the request body with the help of Media Type
                RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
                //Send the request
                Response response = client.newCall(request).execute();
            }catch (IOException exception){
                result=false;
            }
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result){
            //Print Success or failure message accordingly
            Toast.makeText(context,result?"Message successfully sent!":"There was some error in sending message. Please try again after some time.",Toast.LENGTH_LONG).show();
        }



    }
    private int geteventpos(String eventname,int main){
        if(main==0){
            return Links.abhi_events.indexOf(eventname);
        }
        else if(main==1){
            return Links.shor_events_all.indexOf(eventname);
        }
        else if(main==2){
            return Links.acad_events.indexOf(eventname);
        }
        else{
            return Links.other_events.indexOf(eventname);
        }
    }
}
