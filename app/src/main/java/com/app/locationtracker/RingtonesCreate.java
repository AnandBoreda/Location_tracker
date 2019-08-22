package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RingtonesCreate extends Activity implements OnInitListener {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
    private EditText words = null;
    private Button speakBtn = null;
    private EditText filename = null;
    private Button recordBtn = null;
    private Button playBtn = null;
    private EditText useWith = null;
    private Button assocBtn = null;
    private String soundFilename = null;
    private File soundFile = null;
    private static final int REQ_TTS_STATUS_CHECK = 0;
    private static final String TAG = "TTS Demo";
    private TextToSpeech mTts = null;
    private MediaPlayer player = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtones_create);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/1033173712");
        //ca-app-pub-3940256099942544/8691691433
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override public void onAdClosed()
            { mInterstitialAd.loadAd(new AdRequest.Builder().build()); } });

        //woohoo

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });


        words = (EditText)findViewById(R.id.wordsToSpeak);
        filename = (EditText)findViewById(R.id.filename);
        useWith = (EditText)findViewById(R.id.realText);

        speakBtn = (Button)findViewById(R.id.speakBtn);
        recordBtn = (Button)findViewById(R.id.recordBtn);
        playBtn = (Button)findViewById(R.id.playBtn);
        assocBtn = (Button)findViewById(R.id.assocBtn);
        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, REQ_TTS_STATUS_CHECK);


    }

    public void doButton(View view) {
        switch(view.getId()) {
            case R.id.speakBtn:
                mTts.speak(words.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                break;
            case R.id.recordBtn:
                soundFilename = filename.getText().toString();
                soundFile = new File(soundFilename);
                if (soundFile.exists())
                    soundFile.delete();

                if(mTts.synthesizeToFile(words.getText().toString(), null, soundFilename)== TextToSpeech.SUCCESS) {
                    Toast.makeText(getBaseContext(),"Sound file created",Toast.LENGTH_SHORT).show();
                    playBtn.setEnabled(true);
                    assocBtn.setEnabled(true);
                }
                else {
                    Toast.makeText(getBaseContext(),"Oops! Sound file not created",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.playBtn:
                try {
                    player = new MediaPlayer();
                    player.setDataSource(soundFilename);
                    player.prepare();
                    player.start();
                }
                catch(Exception e) {
                    Toast.makeText(getBaseContext(),"Hmmmmm. Can't play file",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                break;
            case R.id.assocBtn:
                mTts.addSpeech(useWith.getText().toString(), soundFilename);
                Toast.makeText(getBaseContext(),"Associated!",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_TTS_STATUS_CHECK) {
            switch (resultCode) {
                case TextToSpeech.Engine.CHECK_VOICE_DATA_PASS:
                    mTts = new TextToSpeech(this, this);
                    Log.v(TAG, "Pico is installed okay");
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_BAD_DATA:
                case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_DATA:
                case TextToSpeech.Engine.CHECK_VOICE_DATA_MISSING_VOLUME:
                    Intent installIntent = new Intent();
                    installIntent.setAction(
                            TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                    startActivity(installIntent);
                    break;
                case TextToSpeech.Engine.CHECK_VOICE_DATA_FAIL:
                default:
                    Log.e(TAG, "Got a failure. TTS apparently not available");
            }
        }
    }

    public void onInit(int status) {
        if( status == TextToSpeech.SUCCESS) {
            speakBtn.setEnabled(true);
            recordBtn.setEnabled(true);
        }
    }
    @Override
    public void onPause()
    {
        super.onPause();
        if(player != null) {
            player.stop();
        }
        if( mTts != null)
            mTts.stop();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        if(player != null) {
            player.release();
        }
        if( mTts != null) {
            mTts.shutdown();
        }
    }
    public void Intertialshow()
    { if (mInterstitialAd.isLoaded()) { mInterstitialAd.show(); }
    else
    { finish(); }

    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }
}
