package org.scau.riotgame.hero;

import android.os.Bundle;
import android.widget.TextView;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;
import org.scau.riotgame.http.HttpCallback;
import org.scau.riotgame.http.OSSWebManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 * Created by ZP on 2018/2/26.
 */

public class HeroDetailActivity extends SimpleTopBarActivity {

    @Bind(R.id.tv_hero_background)
    TextView mTvHeroBackground;
    @Bind(R.id.tv_hero_use_skill)
    TextView mTvHeroUseSkill;
    @Bind(R.id.tv_hero_ag_skill)
    TextView mTvHeroAgSkill;

    private int mHeroId;


    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mHeroId = extras.getInt("hero_id");
        }
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_hero_detail;
    }

    @Override
    protected void onResume() {
        super.onResume();
        OSSWebManager.getInstance().getHeroDetail(mHeroId, 9740, new HttpCallback<HeroDetailBean>() {
            @Override
            public void doOnSuccess(Response<HeroDetailBean> response) {
                HeroDetailBean body = response.body();
                if (body != null) {
                    String story = body.getStory();
                    mTvHeroBackground.setText(story);
                    String use_skill1 = body.getUse_skill1() + "\n";
                    String use_skill2 = body.getUse_skill2() + "\n";
                    String use_skill3 = body.getUse_skill3();
                    mTvHeroUseSkill.setText(use_skill1 + use_skill2 + use_skill3);
                    String ag_skill1 = body.getAg_skill1() + "\n";
                    String ag_skill2 = body.getAg_skill2() + "\n";
                    String ag_skill3 = body.getAg_skill3();
                    mTvHeroAgSkill.setText(ag_skill1 + ag_skill2 + ag_skill3);
                }
            }

            @Override
            public void doOnError(Response<HeroDetailBean> response, String statusCode, String message) {

            }

            @Override
            public void doOnFailure(int httpCode, String message) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
