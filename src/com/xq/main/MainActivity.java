package com.xq.main;

import java.util.ArrayList;
import java.util.List;
import me.tabak.fragmentswitcher.FragmentStateArrayPagerAdapter;
import me.tabak.fragmentswitcher.FragmentSwitcher;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xq.main.fragment.FavoriteFragment;
import com.xq.main.fragment.FeedbackFragment;
import com.xq.main.fragment.HomeFragment;
import com.xq.main.fragment.MyFragment;
import com.xq.main.fragment.SearchFragment;

/**
 * 主界面
 * 
 * @author wanggeng
 * 
 */
public class MainActivity extends XQActivity implements OnClickListener {
	private final List<Fragment> mFragments = new ArrayList<Fragment>();
	private int mClickedTabId = R.id.home_button;
	private FragmentSwitcher mFragmentSwitcher;
	private FragmentStateArrayPagerAdapter mFragmentAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
	}

	@Override
	public void initData() {
		mFragments.add(HomeFragment.newInstance());
		mFragments.add(FavoriteFragment.newInstance());
		mFragments.add(FeedbackFragment.newInstance());
		mFragments.add(SearchFragment.newInstance());
		mFragments.add(MyFragment.newInstance());
	}

	@Override
	public void initView() {
		super.initView();
		mFragmentSwitcher = (FragmentSwitcher) findViewById(R.id.content_layout);
		mFragmentAdapter = new FragmentStateArrayPagerAdapter(getSupportFragmentManager());
		mFragmentSwitcher.setAdapter(mFragmentAdapter);
		mFragmentAdapter.addAll(mFragments);
		findViewById(R.id.home_button).setOnClickListener(this);
		findViewById(R.id.favorite_button).setOnClickListener(this);
		findViewById(R.id.feedback_button).setOnClickListener(this);
		findViewById(R.id.search_button).setOnClickListener(this);
		findViewById(R.id.my_button).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		final int id = v.getId();
		TextView button;
		if (id != mClickedTabId) {
			button = (TextView) findViewById(mClickedTabId);
			button.setTextColor(Color.parseColor("#969696"));
			switch (mClickedTabId) {
			case R.id.home_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_grey, 0, 0);
				break;
			case R.id.favorite_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.favorite_grey, 0, 0);
				break;
			case R.id.feedback_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.feedback_grey, 0, 0);
				break;
			case R.id.search_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.search_grey, 0, 0);
				break;
			case R.id.my_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.my_grey, 0, 0);
				break;
			default:
				break;
			}
			button = (TextView) v;
			button.setTextColor(Color.parseColor("#E2A300"));
			mClickedTabId = id;
			switch (id) {
			case R.id.home_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_red, 0, 0);
				mFragmentSwitcher.setCurrentItem(0);
				break;
			case R.id.favorite_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.favorite_red, 0, 0);
				mFragmentSwitcher.setCurrentItem(1);
				break;
			case R.id.feedback_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.feedback_red, 0, 0);
				mFragmentSwitcher.setCurrentItem(2);
				break;
			case R.id.search_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.search_red, 0, 0);
				mFragmentSwitcher.setCurrentItem(3);
				break;
			case R.id.my_button:
				button.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.my_red, 0, 0);
				mFragmentSwitcher.setCurrentItem(4);
				break;
			default:
				break;
			}
		}
	}
}
