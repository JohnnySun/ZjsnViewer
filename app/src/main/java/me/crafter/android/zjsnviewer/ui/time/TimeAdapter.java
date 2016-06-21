package me.crafter.android.zjsnviewer.ui.time;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import me.crafter.android.zjsnviewer.R;
import me.crafter.android.zjsnviewer.ui.ViewHolder;
import me.crafter.android.zjsnviewer.util.JsonUtil;

/**
 * @author traburiss
 * @date 2016/6/17
 * @info ZjsnViewer
 * @desc
 */

public class TimeAdapter extends BaseExpandableListAdapter{

    private Context context;
    private ArrayList<Long> parent;
    private ArrayList<ArrayList<String>> child;
    public TimeAdapter(Context context, ArrayList<Long> parent, ArrayList<ArrayList<String>> child){

        this.context = context;
        this.parent = parent;
        this.child = child;
    }
    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(i).size();
    }

    @Override
    public Long getGroup(int i) {
        return parent.get(i);
    }

    @Override
    public String getChild(int i, int i1) {
        return child.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        if (null == view){

            view = LayoutInflater.from(context).inflate(R.layout.item_time, null);
        }

        ((TextView)ViewHolder.get(view, R.id.tv_time)).setText(JsonUtil.long2hms_digit(parent.get(i)));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        if (null == view){

            view = LayoutInflater.from(context).inflate(R.layout.item_name, null);
        }

        ((TextView)ViewHolder.get(view, R.id.tv_name)).setText(child.get(i).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
