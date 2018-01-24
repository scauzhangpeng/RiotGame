package org.scau.riotgame.home;

import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class DiscoveryPresenter extends DiscoveryContract.Presenter {

    @Override
    public void getClubs() {
        RequestManager.getInstance().getClubInfo("android", 9718, new HttpCallback<Club>() {
            @Override
            public void doOnSuccess(Response<Club> response) {
                Club club = response.body();
                List<Club.ClubsBean> clubs = club.getClubs();
                if (getView() != null) {
                    getView().showClubs(clubs);
                }
            }

            @Override
            public void doOnError(Response<Club> response, String statusCode, String message) {
//                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                if (getView() != null) {
                    getView().showToastLong(message);
                }
            }

            @Override
            public void doOnFailure(int httpCode, String message) {
//                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                if (getView() != null) {
                    getView().showToastLong(message);
                }
            }
        });
    }
}
