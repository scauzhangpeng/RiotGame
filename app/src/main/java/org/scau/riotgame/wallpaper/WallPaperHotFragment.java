package org.scau.riotgame.wallpaper;

import com.xyz.basiclib.mvp.MvpButterKnifeFragment;
import com.xyz.riotcommon.CommonFragment;

/**
 * Created by ZP on 2018/1/29.
 */

public class WallPaperHotFragment extends CommonFragment<WallPaperContract.View, WallPaperContract.Presenter> {


    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected WallPaperContract.Presenter initPresenter() {
        return new WallPaperPresenter();
    }
}
