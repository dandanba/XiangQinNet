package com.xq.main.fragment;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.common.library.fragment.PullToRefreshFragment;
import com.common.library.utils.DisplayUtils;
import com.common.library.utils.GsonUtils;
import com.common.library.widget.MyViewPager;
import com.common.library.widget.SimpleArrayAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.viewpagerindicator.CirclePageIndicator;
import com.xq.main.R;
import com.xq.main.XQActivity;
import com.xq.main.fragment.FeedbackFragment.DataHolder;

/**
 * 首页
 * 
 * @author wanggeng
 * 
 */
public class FeedbackFragment extends PullToRefreshFragment<DataHolder, ListView> implements OnClickListener {
	public static FeedbackFragment newInstance() {
		FeedbackFragment fragment = new FeedbackFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}
	private XQActivity mXQActivity;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mPullResfreshMode = Mode.DISABLED;
		return inflater.inflate(R.layout.fragment_ptr_list, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initView(view);
		update();
	}

	@Override
	public void initData(Activity activity) {
		super.initData(activity);
		mXQActivity = (XQActivity) activity;
		mAdapter = new SimpleArrayAdapter<DataHolder>(activity, 0, mDatas) {
			public int getItemViewType(int position) {
				return mDatas.get(position).mType;
			}

			public int getViewTypeCount() {
				return 5;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				final DataHolder data = getItem(position);
				final ViewHolder viewHolder;
				if (convertView == null) {
					viewHolder = new ViewHolder(data);
					convertView = viewHolder.mConvertView;
				} else {
					viewHolder = (ViewHolder) convertView.getTag();
				}
				viewHolder.handleView(position, convertView, parent);
				return convertView;
			}
		};
	}

	@Override
	public void update() {
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		final DataHolder dataHolder = mDatas.get(position);
	}

	private void initView(View view) {
	}

	class DataHolder {
		int mType;

		public DataHolder(int type) {
			mType = type;
		}
	}

	class ViewHolder {
		View mConvertView;

		public ViewHolder(DataHolder data) {
			mConvertView.setTag(this);
		}

		public void handleView(int position, View convertView, ViewGroup parent) {
		}
	}
}
