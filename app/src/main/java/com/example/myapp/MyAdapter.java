package com.example.myapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * MyAdapter job is to put data into the row of the listview
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    String[] languages;
    LayoutInflater layoutInflater;
    public MyAdapter(Context context,String[] languagesData) {
        languages = languagesData;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * Oncreate viewHolder job is to buy woodenplanks
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MyAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowView = layoutInflater.inflate(R.layout.row_listview,parent,false);
        return new WordViewHolder(rowView);
    }

    /**
     * onBindViewHolder job is to write data on planks
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.WordViewHolder holder, int position) {
        holder.titleTextView.setText(languages[position]);

    }

    /**
     * job is to keep count of no of data items in the dataset
     * @return
     */
    @Override
    public int getItemCount() {
        return languages.length;
    }

    /**
     * WordViewHolder job is to hold the recycledview stock and new stock of woodenplanks
     */
    public class WordViewHolder extends RecyclerView.ViewHolder {
       public TextView titleTextView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textView);
        }
    }
}
