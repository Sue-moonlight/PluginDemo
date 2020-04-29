package com.example.plugin_core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Project Name: MoonlightUp
 * File Name:    PluginManager.java
 * ClassName:    PluginManager
 *
 * Description: 插件管理.
 *
 * @author 苏俊雄
 * @date 2020年04月28日 16:10
 *
 * Copyright (c) 2020年, 4399 Network CO.ltd. All Rights Reserved.
 */
public class PluginManager
{
    private static PluginManager mPluginManager = new PluginManager();
    //上下文
    private Context mContext;
    //插件资源对象
    private Resources mPluginResources;
    // 包信息
    private PackageInfo mPackageInfo;
    //类加载器
    private DexClassLoader mDexClassLoader;

    private PluginManager() {}

    public static PluginManager getInstance()
    {
        return mPluginManager;
    }

    public void setContext(Context context)
    {
        mContext = context;
    }

    /**
     * 加载插件apk
     * @param pluginPath
     */
    public void loadPlugin(String pluginPath)
    {
        //获取包管理器
        PackageManager packageManager = mContext.getPackageManager();
        //获取到插件到包信息类
        try
        {
            mPackageInfo = packageManager.getPackageArchiveInfo(pluginPath,PackageManager.GET_ACTIVITIES);
        }catch (Exception e)
        {
        }
        //获取到插件的类加载器
        //获取到插件解压后的目录
        File pluginFile = mContext.getDir("plugin",Context.MODE_PRIVATE);
        mDexClassLoader = new DexClassLoader(pluginPath,pluginFile.getAbsolutePath(),null,mContext.getClassLoader());
        //获取插件的资源对象
        try
        {
            //创建assetManager对象
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = assetManager.getClass()
                                        .getDeclaredMethod("addAssetPath", String.class);
            method.invoke(assetManager,pluginPath);
            mPluginResources = new Resources(assetManager,mContext.getResources().getDisplayMetrics(),mContext.getResources().getConfiguration());
        }
        catch (Exception e)
        {

        }
    }

    public PluginManager(Context context, Resources pluginResources, PackageInfo packageInfo,
                         DexClassLoader dexClassLoader)
    {
        mContext = context;
        mPluginResources = pluginResources;
        mPackageInfo = packageInfo;
        mDexClassLoader = dexClassLoader;
    }

    public static PluginManager getmPluginManager()
    {
        return mPluginManager;
    }

    public Context getContext()
    {
        return mContext;
    }

    public Resources getPluginResources()
    {
        return mPluginResources;
    }

    public PackageInfo getPackageInfo()
    {
        return mPackageInfo;
    }

    public DexClassLoader getDexClassLoader()
    {
        return mDexClassLoader;
    }
}
