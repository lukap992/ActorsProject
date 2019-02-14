package com.example.actorsproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actorsproject.R;
import com.example.actorsproject.model.NavigationItem;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter {

    Context context;
    ArrayList<NavigationItem> navigationItem;

    public DrawerAdapter(Context context, ArrayList<NavigationItem> navigationItem) {
        this.context = context;
        this.navigationItem = navigationItem;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.drawer_item, null);

        TextView title = convertView.findViewById(R.id.drawer_title);
        TextView subTitle = convertView.findViewById(R.id.drawer_subTitle);
        ImageView icon = convertView.findViewById(R.id.drawer_icon);

        title.setText(navigationItem.get(position).getTitle());
        subTitle.setText(navigationItem.get(position).getSubTitle());
        icon.setImageResource(navigationItem.get(position).getIcon());

        return convertView;
    }
}
