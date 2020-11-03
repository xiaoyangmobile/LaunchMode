package com.chengfayun.launchmode;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;

class GetActivityInfo {

    public static String get(Application app) {
        try {
            Class<Application> applicationClass = Application.class;
            Field mLoadedApkField = applicationClass.getDeclaredField("mLoadedApk");
            mLoadedApkField.setAccessible(true);
            Object mLoadedApk = mLoadedApkField.get(app);
            Class<?> mLoadedApkClass = mLoadedApk.getClass();
            Field mActivityThreadField = mLoadedApkClass.getDeclaredField("mActivityThread");
            mActivityThreadField.setAccessible(true);
            Object mActivityThread = mActivityThreadField.get(mLoadedApk);
            Class<?> mActivityThreadClass = mActivityThread.getClass();
            Field mActivitiesField = mActivityThreadClass.getDeclaredField("mActivities");
            mActivitiesField.setAccessible(true);
            Object mActivities = mActivitiesField.get(mActivityThread);
            ArrayList<Activity> list = new ArrayList<>();
            String stackInfo = "";
            if (mActivities instanceof ArrayMap) {
                for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) mActivities).entrySet()) {
                    Object value = entry.getValue();
                    Class<?> activityClass = value.getClass();
                    Field activityField = activityClass.getDeclaredField("activity");
                    activityField.setAccessible(true);
                    Object activity = activityField.get(value);
                    list.add((Activity) activity);
                    stackInfo += "=>" + ((Activity) activity).getLocalClassName() + ":" + ((Activity) activity).toString();
                }
            }
            return stackInfo;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
