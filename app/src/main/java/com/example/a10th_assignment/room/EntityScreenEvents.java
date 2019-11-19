package com.example.a10th_assignment.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "screen_events")
public class EntityScreenEvents {
    public String title;
    public Date timestamp;
    @PrimaryKey(autoGenerate = true)
    int id_login_log;

}
