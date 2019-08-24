package com.app.locationtracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TorchMain extends Activity {

    private CameraManager objCameraManager;
    private String mCameraId;
    private Button ivOnOFF;
    private MediaPlayer objMediaPlayer;

    /**
     * for getting torch mode
     */
    private Boolean isTorchOn;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch_main);
        ivOnOFF = findViewById(R.id.ivOnOFF);
        isTorchOn = false;

        /**
         * Check if device contains flashlight
         *
         * if not then exit from screen
         *
         */
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


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            objCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }
        try {
            assert objCameraManager != null;
            mCameraId = objCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

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


    }


    /**
     * Method for turning light ON
     */
    public void turnOnLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                objCameraManager.setTorchMode(mCameraId, true);
                //playOnOffSound();
               // ivOnOFF.setImageResource(R.drawable.clap_on);
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
                //playOnOffSound();
                //ivOnOFF.setImageResource(R.drawable.clap_off);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
