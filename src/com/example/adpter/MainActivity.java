package com.example.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.viewhoulder.MyadpterView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;
	private MyadpterView myadpter;
	private List<Student>list=new ArrayList<>();;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		data();
		init();
	
	}
	private void init() {
		// TODO Auto-generated method stub
		listView=(ListView) findViewById(R.id.listview);
		myadpter=new MyadpterView(this, list);
		listView.setAdapter(myadpter);
	}
	private void data() {
		// TODO Auto-generated method stub
		for(int i=0;i<50;i++){
		Student student=new Student("刘备"+i, 12+i);
		list.add(student);
		}
	}
}
