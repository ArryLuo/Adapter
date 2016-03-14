package com.example.adpter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Myadpter extends BaseAdapter {
	private List<Student> list;
	private LayoutInflater inflater;

	public Myadpter(Context context, List<Student> list) {
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Student student = list.get(position);
		View view = null;
		Viewhoeld viewhoeld = null;
		if (convertView == null) {
			viewhoeld = new Viewhoeld();
			view = inflater.inflate(R.layout.item, null);
			viewhoeld.name = (TextView) view.findViewById(R.id.name);
			viewhoeld.age = (TextView) view.findViewById(R.id.age);
			view.setTag(viewhoeld);
		} else {
			view = convertView;
			viewhoeld = (Viewhoeld) view.getTag();
		}
		viewhoeld.name.setText(student.getName());
		viewhoeld.age.setText(student.getAge() + "");
		return view;
	}

	class Viewhoeld {
		TextView name, age;
	}

}
