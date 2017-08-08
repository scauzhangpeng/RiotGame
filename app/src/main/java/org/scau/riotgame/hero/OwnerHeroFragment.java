package org.scau.riotgame.hero;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/7/27.
 */

public class OwnerHeroFragment extends Fragment {

    private View mView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_me, null);
        return mView;
    }
}
