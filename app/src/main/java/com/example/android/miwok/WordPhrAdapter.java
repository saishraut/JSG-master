package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by User on 05-01-2018.
 */

public class WordPhrAdapter extends ArrayAdapter<WordPhr> {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_phr_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        WordPhr currentWordPhr= getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwView = (TextView) listItemView.findViewById(R.id.miwok_name);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwView.setText(currentWordPhr.getmMiwPhr());


        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView engView= (TextView) listItemView.findViewById(R.id.english_name);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        engView.setText(currentWordPhr.getmEngPhr());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    public WordPhrAdapter(Activity context, ArrayList<WordPhr> WordPhr) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, WordPhr);
    }
}





