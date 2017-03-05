package com.example.arihantjain.servicesassignment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Arihant Jain on 3/5/2017.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages  = null;
        Bundle data = intent.getExtras();
        if (data != null) {
            Object[] pdusObj = (Object[]) data.get("pdus");
            smsMessages = new SmsMessage[pdusObj.length];
            for (int i = 0; i < smsMessages.length; i++) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = data.getString("format");
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                } else {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                }
                Intent musicIntent = new Intent(context, MusicService.class);
                if (smsMessages[i].getMessageBody().contains("play_music")) {
                    musicIntent.putExtra("sms",true);
                    context.startService(musicIntent);
                }
            }
        }
    }
}
