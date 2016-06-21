package me.crafter.android.zjsnviewer.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import me.crafter.android.zjsnviewer.ui.widget.Widget_Build;
import me.crafter.android.zjsnviewer.ui.widget.Widget_Main;
import me.crafter.android.zjsnviewer.ui.widget.Widget_Make;
import me.crafter.android.zjsnviewer.ui.widget.Widget_Repair;
import me.crafter.android.zjsnviewer.ui.widget.Widget_Travel;

public class ScreenReceiver extends BroadcastReceiver {
    public ScreenReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)){
            Widget_Main.updateWidget(context);
            Widget_Travel.updateWidget(context);
            Widget_Repair.updateWidget(context);
            Widget_Build.updateWidget(context);
            Widget_Make.updateWidget(context);
        }
    }


}
