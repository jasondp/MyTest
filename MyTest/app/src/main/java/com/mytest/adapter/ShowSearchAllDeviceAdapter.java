package com.mytest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mytest.R;
import com.mytest.modle.SearchDeviceModel;

import java.util.List;

/**
 * Created by Jason on 2016/12/6.
 */

public class ShowSearchAllDeviceAdapter extends BaseAdapter {

    private Context context;
    private List<SearchDeviceModel> list;

    public ShowSearchAllDeviceAdapter(Context context, List<SearchDeviceModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.show_search_device_adapter_item,null);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name = (TextView) convertView.findViewById(R.id.name);
        viewHolder.address = (TextView) convertView.findViewById(R.id.address);
        SearchDeviceModel searchDeviceModel = list.get(position);
        if(searchDeviceModel != null){
            viewHolder.name.setText(searchDeviceModel.getName());
            viewHolder.address.setText(searchDeviceModel.getAddress());
        }
        return null;
    }

    static class ViewHolder {
        TextView name, address;
    }
}
