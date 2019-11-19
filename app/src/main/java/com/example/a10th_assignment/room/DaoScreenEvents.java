package com.example.a10th_assignment.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoScreenEvents {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EntityScreenEvents listItem);

    @Query("SELECT * FROM screen_events;")
    LiveData<List<EntityScreenEvents>> getScreenEvents();
}
