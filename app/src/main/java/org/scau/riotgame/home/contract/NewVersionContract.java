package org.scau.riotgame.home.contract;

import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.mvp.BaseView;

/**
 * Created by ZP on 2018/1/24.
 */

public interface NewVersionContract {

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter<View> {

    }
}
