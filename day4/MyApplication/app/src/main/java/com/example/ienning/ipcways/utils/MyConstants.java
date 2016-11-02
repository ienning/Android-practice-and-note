package com.example.ienning.ipcways.utils;

import android.os.Environment;

/**
 * Created by ienning on 16-11-2.
 */

public class MyConstants {
    public static final String USE_PATH = Environment
            .getExternalStorageDirectory().getPath()
            + "/ienning/ipclearning";
    public static final String CACHE_FILE_PATH = USE_PATH + "usercache";

    public static final int MSG_FROM_CLIENT = 0;
    public static final int MSG_FROM_SERVICE = 1;
}
