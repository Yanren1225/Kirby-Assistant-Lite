package com.kirby.runanjing.lite.activity;

import android.content.*;
import android.os.*;
import android.support.v7.widget.*;
import com.github.anzewei.parallaxbacklayout.*;
import com.kirby.runanjing.lite.*;
import com.kirby.runanjing.lite.adapter.*;
import com.kirby.runanjing.lite.bean.*;
import com.kirby.runanjing.lite.untils.*;
import java.util.*;

import com.kirby.runanjing.lite.R;


@ParallaxBack
public class GameListActivity extends BaseActivity
{
	private List<Console> gamelist=new ArrayList<>();
	private GameAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);
        Theme.setClassTheme(this);
		setContentView(R.layout.activity_gamelist);
		//配置toolbar
		Toolbar toolbar=(Toolbar)findViewById(R.id.标题栏);
		setSupportActionBar(toolbar);
		//配置列表
		RecyclerView r=(RecyclerView)findViewById(R.id.主机列表);
		GridLayoutManager layoutManager=new GridLayoutManager(this, 1);
		r.setLayoutManager(layoutManager);
		adapter = new GameAdapter(gamelist);
		r.setAdapter(adapter);
		//获取数据
		SharedPreferences console=getSharedPreferences("string", 0);
		String game= console.getString("主机名称", "");
		toolbar.setSubtitle(game);
		//判断数据然后处理列表
		if (game == "gba")
		{	
			Console[] 游戏 = {
				new Console("星之卡比 梦之泉DX", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/mengzhiquandx.jpg","gba_mzqdx"),
				new Console("星之卡比 镜之大迷宫", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/jingmi.jpg","gba_jm"),			
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "gb/gbc")
		{
			Console []游戏={		
				new Console("星之卡比 1", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/xing1.jpg","gb_x1"),
				new Console("星之卡比 2", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/xing2.jpg","gb_x2"),
				new Console("星之卡比 卡比宝石星", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/baoshixing.jpg","gb_bsx"),
				new Console("星之卡比 卡比打砖块", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/dazhuankuai.jpg","gb_dzk"),
				new Console("星之卡比 卡比弹珠台", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/danzhutai.jpg","gb_dzt"),
				new Console("星之卡比 滚滚卡比", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/gungun.jpg","gbc_gg"),
			};
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "sfc")
		{
			Console[] 游戏 = {
				new Console("星之卡比 3", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/xing3.jpg","sfc_x3"),
				new Console("星之卡比 超豪华版", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/kss.jpg","sfc_kss"),
				new Console("星之卡比 卡比梦幻都", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/menghuandu.jpg","sfc_mhd"),
				new Console("[仅美国]星之卡比 卡比魔方气泡", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/mofangqipao.jpg","sfc_mfqp"),
				new Console("[仅日本]星之卡比 卡比宝石星DX", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/banshixingdx.jpg","sfc_bsxdx"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "n64")
		{

			Console[] 游戏 = {
				new Console("星之卡比 64", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/k64.jpg","n64_k64"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "ngc")
		{

			Console[] 游戏 = {
				new Console("星之卡比 飞天赛车", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/feitian.jpg","ngc_ft"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "wii")
		{

			Console[] 游戏 = {
				new Console("星之卡比 重返梦幻岛", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/chongfan.jpg","wii_cf"),
				new Console("星之卡比 毛线卡比", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/maoxian.jpg","wii_mx"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "nds")
		{

			Console[] 游戏 = {
				new Console("星之卡比 触摸卡比", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/chumo.jpg","nds_cm"),
				new Console("星之卡比 超究豪华版", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/kssu.jpg","nds_kssu"),
				new Console("星之卡比 呐喊团", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/nahantuan.jpg","nds_nht"),
				new Console("星之卡比 集合！卡比", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/jihe.jpg","nds_jh"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
		if (game == "fc")
		{

			Console[] 游戏 = {
				new Console("星之卡比 梦之泉物语", "https://raw.githubusercontent.com/nihaocun/kirby_image/master/game/mengzhiquan.jpg","fc_jh"),
			}; 
			int index = 0;
			while (index < 游戏.length)
			{       	
				gamelist.add(游戏[index++]);
			}
		}
	}
}
