package com.example.tm;
import android.os.Bundle;

import com.example.plugin_core.BaseActivity;

public class MainActivity extends BaseActivity
{

    @Override
    public void onCreat(Bundle saveInstanceState)
    {
        super.onCreat(saveInstanceState);
        setContentView(R.layout.activity_main);
    }
}
