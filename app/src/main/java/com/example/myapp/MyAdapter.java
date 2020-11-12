package com.example.myapp;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.database.FeedReaderContract;

/**
 * MyAdapter job is to put data into the row of the listview
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.WordViewHolder> {
    String[] languages;
    Cursor languagesCursor;
    int titleIndex,subtitleIndex;
    LayoutInflater layoutInflater;

//    public MyAdapter(Context context,String[] languagesData) {
//        languages = languagesData;
//        layoutInflater = LayoutInflater.from(context);
//    }
public MyAdapter(Context context, Cursor cursor){
    //String[] languagesData) {
    languagesCursor = cursor;
    layoutInflater = LayoutInflater.from(context);
    titleIndex = languagesCursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE);
    subtitleIndex = languagesCursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE);
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
       // holder.titleTextView.setText(languages[position]);
        if(position+1 < languagesCursor.getCount()) {
            languagesCursor.move(position + 1);
            String title = languagesCursor.getString(titleIndex);
            String subtitle = languagesCursor.getString(subtitleIndex);

            holder.titleTextView.setText(title);
            holder.subtitleTextView.setText(subtitle);
        }


    }

    /**
     * job is to keep count of no of data items in the dataset
     * @return
     */
    @Override
    public int getItemCount() {
       // return languages.length;
        return languagesCursor.getCount()+1;
    }

    /**
     * WordViewHolder job is to hold the recycledview stock and new stock of woodenplanks
     */
    public class WordViewHolder extends RecyclerView.ViewHolder {
       public TextView titleTextView;
        public  TextView subtitleTextView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textView);
            subtitleTextView = itemView.findViewById(R.id.textViewsubtitle);

        }
    }
}
