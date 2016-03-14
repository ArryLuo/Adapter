package com.example.viewhoulder;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Viewhouder {
	private SparseArray<View> mviews;
	private int mPosion;
	private View mConverView;

	public Viewhouder(Context context, ViewGroup parent, int layoutid,
			int postion) {
		this.mPosion = postion;
		this.mviews = new SparseArray<>();
		mConverView = LayoutInflater.from(context).inflate(layoutid, parent,
				false);
		mConverView.setTag(this);

	}

	// 入口方法判断viewgroup是否为空
	public static Viewhouder get(Context context, View converView,
			ViewGroup parent, int layoutid, int postion) {
		if (converView == null) {
			return new Viewhouder(context, parent, layoutid, postion);
		} else {
			Viewhouder viewhouder = (Viewhouder) converView.getTag();
			// 记得更新下;
			viewhouder.mPosion = postion;
			return viewhouder;
		}
	}

	// 拿到view的控件
	// 通过viewid获取控件
	public <T extends View> T getview(int viewid) {
		View view = mviews.get(viewid);
		// 判断是否存储过view
		if (view == null) {
			view = mConverView.findViewById(viewid);
			mviews.put(viewid, view);
		}
		return (T) view;
	}

	// 用于返回view；
	public View getCoView() {
		return mConverView;
	}

	// 优化ui控件
	public Viewhouder setTexst(int viewid, String txt) {
		TextView tx = getview(viewid);
		tx.setText(txt);
		return this;
	}
}
