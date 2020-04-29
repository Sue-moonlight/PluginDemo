package com.example.plugin_core;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.DexClassLoader;

/**
 * Project Name: MoonlightUp
 * File Name:    ProxyActivity.java
 * ClassName:    ProxyActivity
 *
 * Description: TODO.
 *
 * @author 苏俊雄
 * @date 2020年04月28日 16:33
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
public class ProxyActivity extends Activity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String className = intent.getStringExtra("className");
        //通过类加载器去加载这个类
        try
        {
            Class<?>  aClass = PluginManager.getInstance().getDexClassLoader().loadClass(className);
            Object object = aClass.newInstance();
            if (object instanceof  PluginInterface)
            {
                PluginInterface pluginInterface = (PluginInterface)object;
                //调用
                pluginInterface.attach(this);
                //调用插件中的oncreat方法
              pluginInterface.onCreat(savedInstanceState);
            }
        }
        catch (Exception e)
        {

        }
    }


    @Override
    public Resources getResources()
    {
        return PluginManager.getInstance().getPluginResources();
    }

    @Override
    public ClassLoader getClassLoader()
    {
        return PluginManager.getInstance().getDexClassLoader();
    }
}
