package com.example.listviewdemo;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter {

	ArrayList<RowModel> model;
	Context mContext;
	
	ArrayList<Integer> selections;
	
	static class ViewHolder
	{
		TextView text;
		ImageView indicator;
		ImageView image;
	}
	
	public ListAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
		mContext = context;
		model = new ArrayList<RowModel>();
		selections = new ArrayList<Integer>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View row = convertView;
		if(row == null)
		{
			LayoutInflater inflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.list_row, null);
			ViewHolder holder = new ViewHolder();
			holder.text = (TextView) row.findViewById(R.id.row_txt);
			holder.image = (ImageView)row.findViewById(R.id.row_img);
			holder.indicator = (ImageView)row.findViewById(R.id.row_indicator);
			ColorDrawable cd = new ColorDrawable(Color.parseColor("#FF007d7b"));
			holder.indicator.setImageDrawable(cd);
			row.setTag(holder);
		}
		
		ViewHolder vh = (ViewHolder)row.getTag();
		vh.image.setImageResource(model.get(position).resID);
		vh.text.setText(model.get(position).country);
		if(this.isSelected(position) != -1)
		{
			vh.indicator.setAlpha(1.0f);
		}
		else
		{
			vh.indicator.setAlpha(0.0f);
		}

		
		
		return row;
	}
	
	public void addRow(RowModel row)
	{
		model.add(row);
	}

	@Override
	public int getCount() {
		return model.size();
	}

	@Override
	public RowModel getItem(int position) {
		return model.get(position);
	}
	
	public int isSelected(int pos)
	{
		for(int i = 0; i < this.selections.size(); ++i)
		{
			if (this.selections.get(i).intValue() == pos)
				return i;
		}
		return -1;
	}
	
	public void updateSelection(int pos)
	{
		int index = this.isSelected(pos);
		if(index == -1)
		{
			this.selections.add(pos);
		}
		else
		{
			this.selections.remove(index);
		}
	}
	
	public String getAllSelectedItem()
	{
		String result = " ";
		for(int i = 0; i < this.selections.size(); ++i)
			result += this.model.get(this.selections.get(i).intValue()).country + " ";
		
		return result;
	}
	
}
