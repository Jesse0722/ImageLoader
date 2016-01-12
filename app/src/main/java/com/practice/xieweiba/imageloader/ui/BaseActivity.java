package com.practice.xieweiba.imageloader.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;

import com.practice.xieweiba.imageloader.R;
import com.romainpiel.shimmer.ShimmerTextView;
import com.romainpiel.shimmer.Shimmer;


/**
 * Created by jesse on 2016/1/12.
 */
public class BaseActivity extends FragmentActivity{
    protected ActionBar actionBar;
    private ShimmerTextView mActionBarTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    private void initActionBar() {
        actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View view = View.inflate(this, R.layout.actionbar_title,null);
        mActionBarTitle = (ShimmerTextView) view.findViewById(R.id.tv_shimmer);
        new Shimmer().start(mActionBarTitle);
        actionBar.setCustomView(view);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            //若是home键
            case android.R.id.home:
               //返回事件
                onBackPressed();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this, PreferenceActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
