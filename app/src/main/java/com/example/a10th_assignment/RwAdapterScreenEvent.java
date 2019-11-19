package com.example.a10th_assignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10th_assignment.room.EntityScreenEvents;

import java.util.List;

public class RwAdapterScreenEvent extends RecyclerView.Adapter<RwAdapterScreenEvent.itemHolder> {

    private final LayoutInflater mInflater;
    private List<EntityScreenEvents> mEvents;

    RwAdapterScreenEvent(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.rw_listitem, parent, false);
        return new itemHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull itemHolder holder, int position) {
        if (mEvents != null) {
            EntityScreenEvents current = mEvents.get(position);
            holder.titleView.setText(current.title);
            holder.timeView.setText(current.timestamp.toString());
        } else {
            holder.titleView.setText("No EntityScreenEvents");
            holder.timeView.setText("No EntityScreenEvents");
        }
    }

    void setEvents(List<EntityScreenEvents> events) {
        mEvents = events;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mEvents != null)
            return mEvents.size();
        else return 0;
    }

    class itemHolder extends RecyclerView.ViewHolder {
        private final TextView titleView;
        private final TextView timeView;


        private itemHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.eventTitle);
            timeView = itemView.findViewById(R.id.eventTime);

        }
    }
}