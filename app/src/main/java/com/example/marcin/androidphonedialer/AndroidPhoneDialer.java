package com.example.marcin.androidphonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


public class AndroidPhoneDialer extends Activity {
    /** Called when activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_android_phone_dialer);
        /** Create Intent to call the Dialer */
        /** Pass the Dialer the number +4366488915200 */
        Intent DialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+4366488915200"));
        /** Use NEW_TASK_LAUNCH to launch the Dialer Activity */
        DialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        /** Finally start the Activity */
        startActivity(DialIntent);

    }

}
