package com.xq.main;

import android.os.Bundle;
import com.common.library.activity.BaseActivity;
import com.umeng.analytics.MobclickAgent;

public class XQActivity extends BaseActivity {
	private static final String TAG = "display";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}
}
