package org.scau.riotgame.http;

import org.scau.riotgame.home.Club;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ZP on 2017/8/7.
 */

public interface ApiService {


    @GET("php_cgi/lol_mobile/club/varcache_team_entrancev2.php")
    Call<Club> getClubInfo(@Query("plat") String plat,
                           @Query("version") int version);
}
