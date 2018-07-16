package com.kirby.runanjing.lite.activity;

import android.os.*;
import android.support.v7.widget.*;
import com.github.anzewei.parallaxbacklayout.*;
import com.kirby.runanjing.lite.*;
import com.kirby.runanjing.lite.fragment.preference.*;
import com.kirby.runanjing.lite.untils.*;

import com.kirby.runanjing.lite.R;

@ParallaxBack
public class AboutActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
        Theme.setClassTheme(this);
		setContentView(R.layout.activity_about);
		Toolbar toolbar=(Toolbar)findViewById(R.id.标题栏);
		setSupportActionBar(toolbar);
		getFragmentManager().beginTransaction().replace(R.id.about_fragment, new AboutPreferenceFragment()).commit();
	}
}
		
