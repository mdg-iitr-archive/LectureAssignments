package com.rohan.musicplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class MessageReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle myBundle = intent.getExtras();
        SmsMessage[] messages = null;

        if (myBundle != null) {
            Object[] pdus = (Object[]) myBundle.get("pdus");

            //String strMessage[] = new String[pdus.length];
            messages = new SmsMessage[pdus.length];

            for (int i = 0; i < messages.length; i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = myBundle.getString("format");
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                } else {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                Intent x = new Intent(context, MyService.class);
                if (messages[i].getMessageBody().toLowerCase().trim().equals("play media")) {
                    context.startService(x);
                }

            }
        }
    }
}