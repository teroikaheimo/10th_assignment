package com.example.a10th_assignment;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10th_assignment.room.ModelScreenEvents;

/*
 * Make an application which listens to whether the screen is turned on/off with a BroadcastReceiver.
 * The exact time for opening and closing the screen is recorded in the application database in an
 * separate IntentService, not in BroadcastReceiver.
 *
 * The application has only a single screen which shows in a list all the timestamps when user had
 * opened or closed the device screen.
 * */
public class MainActivity extends AppCompatActivity {
    ModelScreenEvents eventsModel;
    ScreenEventReceiver screenEventReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Database
        eventsModel = new ViewModelProvider(this).get(ModelScreenEvents.class);

        // Broadcast receiver
        screenEventReceiver = new ScreenEventReceiver();
        IntentFilter screenStateFilter = new IntentFilter();
        screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenEventReceiver, screenStateFilter);

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final RwAdapterScreenEvent adapter = new RwAdapterScreenEvent(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Data Observer. Updates the view when data changes.
        eventsModel.getScreenEvents().observe(this, adapter::setEvents);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(screenEventReceiver);
    }
}
