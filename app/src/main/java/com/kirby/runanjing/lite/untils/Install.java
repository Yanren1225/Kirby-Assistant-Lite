package com.kirby.runanjing.lite.untils;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import java.io.File;

public class Install
{
	public static void installApk(Context context, String apkPath) {
		if (context == null || TextUtils.isEmpty(apkPath)) {
			return;
		}
		File file = new File(apkPath);
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
		context.startActivity(intent);
	}
}
