package jegharaldrig.jegharaldrig.jegharaldrig.jegharaldrigspillet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.jegharaldrig.jegharaldrig.jegharaldrigspillet.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AllActivity extends AppCompatActivity {

    private String[] names;
    private String[] names1;
    private String[] names2;
    private String[] names3;
    private String[] names5;

    private InterstitialAd interstitialAd;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        //ads and shit like that u know
        MobileAds.initialize(this, "ca-app-pub-8256988727898497~9122979342");
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //ADS
        MobileAds.initialize(this, "ca-app-pub-8256988727898497~9122979342");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-8256988727898497/4116450272");
        AdRequest request = new AdRequest.Builder().build();
        interstitialAd.loadAd(request);
        interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }
        });



        //show next "i have never" after button click.
        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Get next index
                names = getResources().getStringArray(R.array.dirty);
                names1 = getResources().getStringArray(R.array.relationships);
                names2 = getResources().getStringArray(R.array.school);
                names3 = getResources().getStringArray(R.array.drinking);
                names5 = getResources().getStringArray(R.array.law);

                String[] addAll = concatenateAllArrays(names, names1, names2, names3, names5);

                int randomIndex = new Random().nextInt(addAll.length);
                String randomList = addAll[randomIndex];
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(randomList);
            }
        };

        Button nextButton = (Button) findViewById(R.id.button1);
        nextButton.setOnClickListener(listener);


        //End game
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    private void openMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    // Custom method to concatenate all String arrays
    protected String[] concatenateAllArrays(String[] name, String[] name1, String[] name2, String[] name3,
                                             String[] name5){

        List<String> allArray = new ArrayList<>();

        // Add all array elements to list
        Collections.addAll(allArray, name);
        Collections.addAll(allArray, name1);
        Collections.addAll(allArray, name2);
        Collections.addAll(allArray, name3);
        Collections.addAll(allArray, name5);

        // Convert list to array
        String[] result = allArray.toArray(new String[allArray.size()]);

        //Return result
        return result;
    }

}
