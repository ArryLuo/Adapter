package com.example.viewhoulder;

import java.util.List;

import com.example.adpter.R;
import com.example.adpter.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class CommonAdapter<T> extends BaseAdapter {
	protected Context context;
	protected List<T> data;
	protected LayoutInflater inflater;

	public CommonAdapter(Context context, List<T> data) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Viewhouder viewhouder = Viewhouder.get(context, convertView, parent,
				R.layout.item, position);
		convert(viewhouder, getItem(position));
		return viewhouder.getCoView();
	}
	public abstract void convert(Viewhouder viewhouder,T t);
}
