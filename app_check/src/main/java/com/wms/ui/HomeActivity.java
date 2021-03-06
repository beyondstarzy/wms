package com.wms.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.wms.util.StatusBarUtil;

//
public class HomeActivity extends Activity implements View.OnClickListener {

   // private String mUpdateUrl = "https://raw.githubusercontent.com/xuexiangjys/XUpdate/master/jsonapi/update_test.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        StatusBarUtil.setRootViewFitsSystemWindows(this, true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        //if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
        //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
        //这样半透明+白=灰, 状态栏的文字能看得清

        //StatusBarUtil.setStatusBarColor(this,0x55000000);//00CCFF  #00CCFF
        StatusBarUtil.setStatusBarColor(this, Color.parseColor("#f6f6f6"));
        //}
        StatusBarUtil.getStatusBarLightMode(getWindow());

        CardView cardView = findViewById(R.id.cardView);
        CardView saleCardView = findViewById(R.id.saleCardView);

        CardView outTimeCardView = findViewById(R.id.outTimeCardView);
        CardView aboutCardView = findViewById(R.id.aboutCardView);
        //CardView rpakCardView = findViewById(R.id.retrivePackageCV);

        cardView.setOnClickListener(this);
        saleCardView.setOnClickListener(this);
        outTimeCardView.setOnClickListener(this);
        aboutCardView.setOnClickListener(this);
        //rpakCardView.setOnClickListener(this);
//        XUpdate.newBuild(this)
//                .updateUrl(mUpdateUrl)
//                .supportBackgroundUpdate(true)
//                .update();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardView:
                Intent areaIntent = new Intent().setClass(HomeActivity.this, StorgeCheckActitity.class);
                startActivity(areaIntent);
                break;
            case R.id.saleCardView:
                Intent outTimeIntent = new Intent().setClass(HomeActivity.this, SaleCheckActivity.class);
                startActivity(outTimeIntent);
                break;
            case R.id.outTimeCardView:
                Intent allAreacardViewIntent = new Intent().setClass(HomeActivity.this, ScheduleCheckActivity.class);
                startActivity(allAreacardViewIntent);
                break;
            case R.id.aboutCardView:
                Intent aboutIntent = new Intent().setClass(HomeActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
                break;
//            case R.id.retrivePackageCV:
//                Intent rpckIntent = new Intent().setClass(HomeActivity.this, RtivePackActivity.class);
//                startActivity(rpckIntent);
//                break;
            default:
                return;
        }
    }
}