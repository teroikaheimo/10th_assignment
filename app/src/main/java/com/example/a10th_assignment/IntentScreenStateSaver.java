package com.example.a10th_assignment;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.example.a10th_assignment.room.Database;
import com.example.a10th_assignment.room.EntityScreenEvents;

import java.util.Date;

public class IntentScreenStateSaver extends IntentService {
    Database db = Database.getDatabase(this);

    public IntentScreenStateSaver() {
        super("IntentScreenStateSaver");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        boolean status;
        if (intent != null) {
            status = intent.getBooleanExtra("screenStatus", true);
            insertEvent(status);
        }
    }

    private void insertEvent(Boolean status) {
        EntityScreenEvents event = new EntityScreenEvents();
        if (status) {
            event.title = "SCREEN ON";
        } else {
            event.title = "SCREEN OFF";
        }
        event.timestamp = new Date();
        db.daoScreenEvents().insert(event);
    }
}
