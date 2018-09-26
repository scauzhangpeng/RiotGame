package org.scau.riotgame.home.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xyz.riotcommon.CommonFragment;

import org.scau.riotgame.R;
import org.scau.riotgame.home.contract.NewVersionContract;
import org.scau.riotgame.home.presenter.NewVersionPresenter;

/**
 * Created by ZP on 2018/1/24.
 */

public class NewVersionFragment extends CommonFragment<NewVersionContract.View, NewVersionContract.Presenter> implements NewVersionContract.View {


    @Override
    protected void initViewsAndEvents(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_refresh;
    }

    @Override
    protected NewVersionContract.Presenter initPresenter() {
        return new NewVersionPresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint: ");
    }

    @Override
    protected void requestData() {
        super.requestData();
        Log.d(TAG, "requestData: ");
    }
}
