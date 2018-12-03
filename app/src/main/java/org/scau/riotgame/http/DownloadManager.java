package org.scau.riotgame.http;

import com.xyz.riotcommon.net.ServiceFactory;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by ZP on 2018/1/29.
 */

public class DownloadManager {


    private static DownloadManager instance;
    private DownloadService mDownloadService;

    private DownloadManager() {
        mDownloadService = ServiceFactory.createServiceFrom(DownloadService.class, "https://www.jianshu.com/", ServiceFactory.getDownloadClient());
    }

    public static DownloadManager getInstance() {
        if (instance == null) {
            synchronized (DownloadManager.class) {
                if (instance == null) {
                    instance = new DownloadManager();
                }
            }
        }
        return instance;
    }

    public Call downloadApk(String url, Callback<ResponseBody> callback) {
        Call<ResponseBody> call = mDownloadService.downloadApk(url);
        call.enqueue(callback);
        return call;
    }
}
