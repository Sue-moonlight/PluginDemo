package com.example.plugin_core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * Project Name: MoonlightUp
 * File Name:    BaseActivity.java
 * ClassName:    BaseActivity
 *
 * Description: TODO.
 *
 * @author 苏俊雄
 * @date 2020年04月28日 17:12
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
public class BaseActivity extends Activity implements PluginInterface
{
    protected  Activity that;
    @Override
    public void attach(Activity alipayActivity)
    {
        that = alipayActivity;
    }

    @Override
    public void setContentView(View view)
    {
        if (that == null)
        {
            super.setContentView(view);
        }
        else
        {
            that.setContentView(view);
        }
    }

    @Override
    public void setContentView(int layoutResID)
    {
        that.setContentView(layoutResID);
    }

    @Override
    public <T extends View> T findViewById(int id)
    {
        return that.findViewById(id);
    }


    @Override
    public Intent getIntent()
    {
        return that.getIntent();
    }

    @Override
    public ClassLoader getClassLoader()
    {
        return that.getClassLoader();
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater()
    {
        return that.getLayoutInflater();
    }

    @Override
    public void startActivity(Intent intent)
    {
        Intent m = new Intent();
        m.putExtra("className",intent.getComponent().getClassName());
         that.startActivity(intent);
    }

    @Override
    public Resources getResources()
    {
        return that.getResources();
    }

    @Override
    public ApplicationInfo getApplicationInfo()
    {
        return that.getApplicationInfo();
    }

    @Override
    public Window getWindow()
    {
        return that.getWindow();
    }

    @Override
    public WindowManager getWindowManager()
    {
        return that.getWindowManager();
    }


    @Override
    public void onCreat(Bundle saveInstanceState)
    {
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart()
    {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume()
    {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onPause()
    {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStop()
    {

    }

    @Override
    public void onDestory()
    {

    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {

    }

    @Override
    public void onBackPress()
    {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return false;
    }

    @Override
    public void onBackPressed() {}
}
