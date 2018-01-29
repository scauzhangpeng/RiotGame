package org.scau.riotgame.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by ZP on 2018/1/29.
 */

public interface DownloadService {

    @Streaming
    @GET
    Call<ResponseBody> downloadApk(@Url String url);
}
