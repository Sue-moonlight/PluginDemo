package com.example.plugin_core;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Project Name: MoonlightUp
 * File Name:    PluginInterface.java
 * ClassName:    PluginInterface
 *
 * Description: TODO.
 *
 * @author 苏俊雄
 * @date 2020年04月28日 16:53
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
public interface PluginInterface
{
    /**
     * 注入上下文
     */
     void attach(Activity alipayActivity);
    /**
     * 模拟生命周期
     */
     void onCreat(Bundle saveInstanceState);
     void onStart();
     void onResume();
     void onPause();
     void onStop();
     void onDestory();

     void onSaveInstanceState(Bundle outState);
     boolean onTouchEvent(MotionEvent event);
     void onBackPress();
}
