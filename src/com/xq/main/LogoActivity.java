package com.xq.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * logo页面
 * 
 * @author wanggeng
 * 
 */
public class LogoActivity extends XQActivity {
	protected static final String TAG = LogoActivity.class.getSimpleName();
	private final Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			removeMessages(msg.what);
			finish();
			startActivity(new Intent(LogoActivity.this, MainActivity.class));
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		mHandler.sendEmptyMessageDelayed(1, 3000);
	}
}
