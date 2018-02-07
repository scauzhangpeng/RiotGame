package org.scau.riotgame.home;

import android.text.TextUtils;

import org.scau.riotgame.home.bean.DiscoveryMenu;
import org.scau.riotgame.home.bean.PageResponse;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.RequestManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Response;

/**
 * Created by ZP on 2018/1/24.
 */

public class DiscoveryPresenter extends DiscoveryContract.Presenter {

    @Override
    public void getClubs() {
        RequestManager.getInstance().getClubInfo(9718, new HttpCallback<Club>() {
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


    @Override
    public void getDiscoveryMenu() {
        RequestManager.getInstance().getDiscoveryMenu(new HttpCallback<PageResponse<DiscoveryMenu>>() {
            @Override
            public void doOnSuccess(Response<PageResponse<DiscoveryMenu>> response) {
                PageResponse<DiscoveryMenu> body = response.body();
                if (body != null) {
                    List<DiscoveryMenu> list = body.getList();
                    List<DiscoveryMenu> data = new ArrayList<DiscoveryMenu>();
                    for (DiscoveryMenu discoveryMenu : list) {
                        String section_index = discoveryMenu.getSection_index();
                        if (!"0".equals(section_index) && !"6".equals(section_index)
                                && !"100".equals(section_index)
                                && TextUtils.isEmpty(discoveryMenu.getSub_index())) {
                            data.add(discoveryMenu);
                        }
                    }

                    Collections.sort(data, new Comparator<DiscoveryMenu>() {
                        @Override
                        public int compare(DiscoveryMenu o1, DiscoveryMenu o2) {
                            int section1 = Integer.parseInt(o1.getSection_index());
                            int section2 = Integer.parseInt(o2.getSection_index());
                            if (section1 > section2) {
                                return 1;
                            } else if (section1 < section2) {
                                return -1;
                            } else {
                                int pos1 = Integer.parseInt(o1.getPos_index());
                                int pos2 = Integer.parseInt(o2.getPos_index());
                                if (pos1 > pos2) {
                                    return 1;
                                } else if (pos1 < pos2) {
                                    return -1;
                                } else {
                                    return 0;
                                }
                            }
                        }
                    });
                    if (getView() != null) {
                        getView().showDiscoveryMenu(data);
                    }
                }
            }

            @Override
            public void doOnError(Response<PageResponse<DiscoveryMenu>> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }
}
