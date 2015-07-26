package com.example.marcin.androidphonedialer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import java.util.regex.*;


public class AndroidPhoneDialer extends Activity {
    /** Called when activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_android_phone_dialer);

        final Button callButton = (Button) findViewById(R.id.callButton);
        final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        callButton.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {
                /** Create Intent to call the Dialer */
                if(validatePhoneNumber(phoneNumber.getText().toString())){
                    Intent DialIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber.getText()));
                    /** Use NEW_TASK_LAUNCH to launch the Dialer Activity */
                    DialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    /** Finally start the Activity */
                    startActivity(DialIntent);
                } else {
                    showAlert("Please enter a phone number in the X-XXX-XXX-XXXX format.", 0, "Format Error", "Re-enter Number", false);
                }
            }
        });


    }

    public boolean validatePhoneNumber (String number){
        Pattern phoneNumber = Pattern.compile("(\\d-)?(\\d{3}-)?\\d{3}\\d{4}"); //d stands for digit ? stands for "once, or not at all"
        Matcher matcher = phoneNumber.matcher(number);
        return matcher.matches();
    }

    public void showAlert()
    /**
     * Implement This:
     *
     * alertDialog alertDialog1 = new AlertDialog.Builder(
     4 AlertDialogActivity.this).create();
     5
     6 // Setting Dialog Title
     7 alertDialog1.setTitle("Alert Dialog");
     8
     9 // Setting Dialog Message
     10 alertDialog1.setMessage("Welcome to 9Android.net");
     11
     12 // Setting Icon to Dialog
     13 alertDialog1.setIcon(R.drawable.tick);
     14
     15 // Setting OK Button
     16 alertDialog1.setButton("OK", new DialogInterface.OnClickListener() {
     17
     18 public void onClick(DialogInterface dialog, int which) {
     19 // Write your code here to execute after dialog
     20 // closed
     21 Toast.makeText(getApplicationContext(),
     22 "You clicked on OK", Toast.LENGTH_SHORT).show();
     23 }
     24 });
     25
     26 // Showing Alert Message
     27 alertDialog1.show(); */


}
