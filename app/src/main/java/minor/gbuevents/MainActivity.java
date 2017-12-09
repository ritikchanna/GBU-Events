package minor.gbuevents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class MainActivity extends Activity {


    //Header carousel variables
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.abhi_1, R.drawable.shor_1, R.drawable.others_1, R.drawable.abhi_4, R.drawable.shor_3};
    //Button variables
    Button btn_toabhi,btn_toshor,btn_other,btn_toparticipate,btn_academic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialize carousel variables
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        //Initialize button variables
        btn_toabhi=(Button)findViewById(R.id.btn_toabhi);
        btn_toshor=(Button)findViewById(R.id.btn_toshor);
        btn_other=(Button)findViewById(R.id.btn_toother);
        btn_academic=(Button)findViewById(R.id.btn_toacadmic);
        btn_toparticipate=(Button)findViewById(R.id.btn_toparticipate);
        //Set onclicklistners for buttons

        btn_toabhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Abhivyajana.class));

            }
        });
        btn_toshor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Shoryautsav.class));
            }
        });
        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Other.class));

            }
        });
        btn_academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Academic.class));

            }
        });
        btn_toparticipate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,submit.class).putExtra("category",0).putExtra("event",Links.abhi_events.get(0)));
            }
        });
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/SqueakyChalkSound.ttf");

        btn_toabhi.setTypeface(custom_font);
        btn_toshor.setTypeface(custom_font);
        btn_other.setTypeface(custom_font);
        btn_academic.setTypeface(custom_font);
    }


    //Listner for crousel
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}
