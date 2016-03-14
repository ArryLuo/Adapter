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

public class MyadpterView extends CommonAdapter<Student> {
	public MyadpterView(Context context, List<Student> list) {
		super(context, list);
	}
	@Override
	public void convert(Viewhouder viewhouder, Student t) {
		viewhouder.setTexst(R.id.name, t.getName()).setTexst(R.id.age, t.getAge()+"");
	}


}
