package me.crafter.android.zjsnviewer.ui.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import me.crafter.android.zjsnviewer.util.DockInfo;
import me.crafter.android.zjsnviewer.R;
import me.crafter.android.zjsnviewer.service.service.TimerService;
import me.crafter.android.zjsnviewer.util.Worker;


/**
 * Implementation of App Widget functionality.
 */
public class Widget_Repair extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        context.startService(new Intent(context, TimerService.class));
        updateWidget(context, appWidgetManager);
    }


    @Override
    public void onEnabled(Context context) {
        context.startService(new Intent(context, TimerService.class));
    }

    @Override
    public void onDisabled(Context context) {

    }

    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId, Bundle newOptions) {
        context.startService(new Intent(context, TimerService.class));
    }

    public static void updateWidget(Context context){
        updateWidget(context, AppWidgetManager.getInstance(context));
    }

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager) {
        //Log.i("Widget_Repair", "updateWidget()");
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget__repair);
        String[] info = DockInfo.getRepairBoard();
        views.setTextViewText(R.id.textView1, info[0]);
        views.setTextViewText(R.id.textView2, info[1]);
        views.setTextViewText(R.id.textView3, info[2]);
        views.setTextViewText(R.id.textView4, info[3]);
        Worker.widgetSetTextSize(context, views);
        appWidgetManager.updateAppWidget(new ComponentName(context, Widget_Repair.class), views);
    }
}


