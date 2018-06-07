package org.scau.riotgame.wallpaper;

import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xyz.basiclib.recyclerview.BasicAdapter;
import com.xyz.riotcommon.SimpleRefreshFragment;

import org.scau.riotgame.wallpaper.bean.WallPaperDetail;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperCollectionFragment extends SimpleRefreshFragment<WallPaperDetail, WallPaperContract.View, WallPaperContract.Presenter> {


    @Override
    protected BasicAdapter<WallPaperDetail> getAdapter() {
        return null;
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    protected WallPaperContract.Presenter initPresenter() {
        return new WallPaperPresenter("");
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
