package com.codechacha.notificationlistener;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!permissionGrantred()) {
            Intent intent = new Intent(
                    "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
        }
    }

    private boolean permissionGrantred() {
        Set<String> sets = NotificationManagerCompat.getEnabledListenerPackages(this);
        if (sets != null && sets.contains(getPackageName())) {
            return true;
        } else {
            return false;
        }
    }

}
