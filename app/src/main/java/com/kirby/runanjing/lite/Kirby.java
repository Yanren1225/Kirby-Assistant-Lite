/*
*这个App的代号
*This App code
*KEMUL
*/
package com.kirby.runanjing.lite;
import android.app.*;
import com.github.anzewei.parallaxbacklayout.*;
import android.widget.*;
import android.os.*;
import com.king.thread.nevercrash.*;
import android.util.*;
import android.content.*;
import com.kirby.runanjing.lite.activity.*;
import com.kirby.runanjing.lite.untils.*;
//import android.support.multidex.*;

public class Kirby extends Application
{
	private static Kirby instance;
	@Override
    public void onCreate()
	{
        super.onCreate();
		Theme.setClassTheme(this);
		registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());
	    NeverCrash.init(new NeverCrash.CrashHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e)
				{		
					toCrashActivity(e);
				}
			});
    }
	public static Context getCtx(){
		return instance;
	}
	/*@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}*/
    public void toCrashActivity(final Throwable crash)
	{
        new Handler(Looper.getMainLooper()).post(new Runnable() {
				@Override
				public void run()
				{
					Intent crash_=new Intent(Kirby.this, KirbyCrashActivity.class);
					crash_.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					crash_.putExtra("crash",crash);
					startActivity(crash_);	
					android.os.Process.killProcess(android.os.Process.myPid());  
				}
			});
	}
}

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖保佑             永无BUG 
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？ 
