package com.example.a10th_assignment.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryScreenEvents {
    private DaoScreenEvents daoScreenEvents;

    public RepositoryScreenEvents(Application app) {
        Database db = Database.getDatabase(app);
        daoScreenEvents = db.daoScreenEvents();
    }

    LiveData<List<EntityScreenEvents>> getScreenEvents() {
        return daoScreenEvents.getScreenEvents();
    }

    public void insert(EntityScreenEvents login) {
        new insertAsyncTask(daoScreenEvents).execute(login);
    }

    private static class insertAsyncTask extends AsyncTask<EntityScreenEvents, Void, Void> {
        private DaoScreenEvents mAsyncTaskDao;

        insertAsyncTask(DaoScreenEvents dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(EntityScreenEvents... entityLoginLogs) {
            mAsyncTaskDao.insert(entityLoginLogs[0]);
            return null;
        }
    }
}
