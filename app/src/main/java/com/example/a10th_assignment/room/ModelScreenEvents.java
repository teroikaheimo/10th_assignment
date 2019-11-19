package com.example.a10th_assignment.room;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ModelScreenEvents extends AndroidViewModel {

    private RepositoryScreenEvents mRepository;

    private LiveData<List<EntityScreenEvents>> mAllEvents;

    public ModelScreenEvents(Application application) {
        super(application);
        mRepository = new RepositoryScreenEvents(application);
        mAllEvents = mRepository.getScreenEvents();
    }

    public LiveData<List<EntityScreenEvents>> getScreenEvents() {
        return mAllEvents;
    }

    public void insert(EntityScreenEvents event) {
        mRepository.insert(event);
    }
}
