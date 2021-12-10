package com.example.entrenamiento2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adapter  extends ArrayAdapter<Model> {

    private Context mContext;
    private List<Model> mDessertListList = new ArrayList<>();

    public Adapter(@NonNull Context context, @LayoutRes ArrayList<Model> list) {
        super(context, 0, list);
        mContext = context;
        mDessertListList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);

        Model currentDessert = mDessertListList.get(position);

        ImageView image = (ImageView) listItem.findViewById(R.id.imageView_poster);
        image.setImageResource(currentDessert.getImageId());

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentDessert.getTitle());

        return listItem;
    }

}
