package jegharaldrig.jegharaldrig.jegharaldrig.jegharaldrigspillet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.jegharaldrig.jegharaldrig.jegharaldrigspillet.R;


public class MainActivity extends AppCompatActivity{

    private Button button;
    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ads and shit like that u know
        MobileAds.initialize(this, "ca-app-pub-8256988727898497~9122979342");
        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);


        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDirtyActivity();
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRelationshipActivity();
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                schoolActivity();
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drinkingActivity();
            }
        });
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lawActivity();
            }
        });
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allActivity();
            }
        });
    }

    private void allActivity() {
        Intent intent = new Intent(this, AllActivity.class);
        startActivity(intent);
    }

    private void lawActivity() {
        Intent intent = new Intent(this, LawActivity.class);
        startActivity(intent);
    }

    private void drinkingActivity() {
        Intent intent = new Intent(this, DrinkingActivity.class);
        startActivity(intent);
    }

    private void schoolActivity() {
        Intent intent = new Intent(this, SchoolActivity.class);
        startActivity(intent);
    }

    private void openRelationshipActivity() {
        Intent intent = new Intent(this, RelationshipActivity.class);
        startActivity(intent);
    }

    private void openDirtyActivity() {
        Intent intent = new Intent(this, DirtyActivity.class);
        startActivity(intent);
    }
}
