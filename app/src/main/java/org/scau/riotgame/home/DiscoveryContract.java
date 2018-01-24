package org.scau.riotgame.home;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

import java.util.List;

/**
 * Created by ZP on 2018/1/24.
 */

public interface DiscoveryContract {

    interface View extends BaseView {
        void showClubs(List<Club.ClubsBean> clubs);
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void getClubs();
    }
}
