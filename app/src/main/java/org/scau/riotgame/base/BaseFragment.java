package org.scau.riotgame.base;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by ZP on 2017/8/2.
 */

public class BaseFragment extends Fragment {


    protected void openActivity(Class<?> cls) {
        Intent intent = new Intent(getActivity(), cls);
        getActivity().startActivity(intent);
    }
}
