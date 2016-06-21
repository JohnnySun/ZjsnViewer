package me.crafter.android.zjsnviewer.util;

import android.util.Log;

import com.jaredrummler.android.processes.AndroidProcesses;
import com.jaredrummler.android.processes.models.AndroidAppProcess;

import java.util.List;
/**
 * Created by JohnnySun on 2015/11/19.
 * Edit by PaleNeutron on 2016/5/25.
 */
public class ZjsnState {
//if running return 0
    public static int getZjsnState() {
        List<AndroidAppProcess> processes = AndroidProcesses.getRunningAppProcesses();
        for (int i = 0; i < processes.size(); i++) {
            String processName = processes.get(i).name;
            if (processName.startsWith("com.huanmeng.zhanjian2")||processName.startsWith("com.muka.shipwar")){
                Log.i("Zjsn_ACTIVE", "Zjsn is in processes");
                return 0;
            }
        }
        return 1;
    }
}