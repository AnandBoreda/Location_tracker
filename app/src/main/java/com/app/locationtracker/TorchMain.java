package com.app.locationtracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TorchMain extends AppCompatActivity {
    /**
     * Object for camera service
     */
    private CameraManager objCameraManager;
    /**
     * id of current camera
     */
    private String mCameraId;
    /**
     * imageview in design which controls the flash light
     */
    private ImageView ivOnOFF;
    /**
     * Object of medial player to play sound while flash on/off
     */
    private MediaPlayer objMediaPlayer;
    /**
     * for getting torch mode
     */
    private Boolean isTorchOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch_main);
        ivOnOFF = (ImageView) findViewById(R.id.ivOnOFF);
        isTorchOn = false;

        check();

        ivOnOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (isTorchOn) {
                        turnOffLight();
                        isTorchOn = false;
                    } else {
                        turnOnLight();
                        isTorchOn = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

/**
 * Check if device contains flashlight
 *
 * if not then exit from screen
 *
 */
public int

        Boolean isFlashAvailable = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!isFlashAvailable) {
            AlertDialog alert = new AlertDialog.Builder(TorchMain.this).create();
            alert.setTitle(getString(R.string.app_name));
            alert.setMessage(getString(R.string.msg_error));
            alert.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.lbl_ok), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
            return;
        }
    }
    objCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
try {
        mCameraId = objCameraManager.getCameraIdList()[0];
    } catch (
    CameraAccessException e) {
        e.printStackTrace();
    }



    /**
     * Method for turning light ON
     */
    public void turnOnLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                objCameraManager.setTorchMode(mCameraId, true);
                playOnOffSound();
                ivOnOFF.setImageResource(R.drawable.on);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for turning light OFF
     */
    public void turnOffLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                objCameraManager.setTorchMode(mCameraId, false);
                playOnOffSound();
                ivOnOFF.setImageResource(R.drawable.off);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void playOnOffSound() {
        objMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.flash_sound);
        objMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        objMediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isTorchOn) {
            turnOffLight();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (isTorchOn) {
            turnOffLight();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (isTorchOn) {
            turnOnLight();
        }
    }
}
