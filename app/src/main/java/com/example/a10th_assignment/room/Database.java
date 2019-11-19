package com.example.a10th_assignment.room;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@androidx.room.Database(entities = {EntityScreenEvents.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class Database extends RoomDatabase {
    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract DaoScreenEvents daoScreenEvents();
}
