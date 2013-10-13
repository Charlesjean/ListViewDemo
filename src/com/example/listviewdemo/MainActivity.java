package com.example.listviewdemo;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView list;
	private ListAdapter listAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list =(ListView) this.findViewById(R.id.list);
		listAdapter = new ListAdapter(this, 0);
		this.initAdapter();
		list.setAdapter(listAdapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				listAdapter.updateSelection(arg2);
				listAdapter.notifyDataSetChanged();		
				 Toast.makeText(MainActivity.this, listAdapter.getAllSelectedItem(), 1).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void initAdapter()
	{
		RowModel row = new RowModel(R.drawable.china, "China");
		listAdapter.addRow(row);
		RowModel row2 = new RowModel(R.drawable.japan, "Japan");
		listAdapter.addRow(row2);
		RowModel row3 = new RowModel(R.drawable.korea, "Korea");
		listAdapter.addRow(row3);
		RowModel row4 = new RowModel(R.drawable.america, "America");
		listAdapter.addRow(row4);
		RowModel row5 = new RowModel(R.drawable.canada, "Canada");
		listAdapter.addRow(row5);
		RowModel row6 = new RowModel(R.drawable.england, "England");
		listAdapter.addRow(row6);
		RowModel row7 = new RowModel(R.drawable.france, "France");
		listAdapter.addRow(row7);
	}
}
