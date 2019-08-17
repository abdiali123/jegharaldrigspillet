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

import java.util.Random;

public class DirtyActivity extends AppCompatActivity {

    private Button button;
    private Button nextButton;
    private String[] names;
    AdView mAdview;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dirty);

        //ads and shit like that u know
        MobileAds.initialize(this, "ca-app-pub-8256988727898497~9122979342");
        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

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
                int randomIndex = new Random().nextInt(names.length);
                String randomList = names[randomIndex];
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(randomList);
            }
        };

        nextButton = (Button) findViewById(R.id.button1);
        nextButton.setOnClickListener(listener);


        //End game
        button = (Button) findViewById(R.id.button);
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
}