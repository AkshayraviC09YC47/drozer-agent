package com.reversec.dz.views;

import com.reversec.dz.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckListItemView extends LinearLayout {

	private TextView label = null;
	private View statusDot = null;
	
	public CheckListItemView(Context context) {
		super(context);
		
		this.setUpView();
	}

	public CheckListItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this.setUpView();
		
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.CheckListItemView);
		
		this.setLabel(a.getString(R.styleable.CheckListItemView_text));
		this.setStatus(a.getBoolean(R.styleable.CheckListItemView_defaultValue, false));
		
		a.recycle();
	}
	
	public void setLabel(int resId) {
		this.setLabel(this.getContext().getString(resId));
	}
	
	public void setLabel(String text) {
		this.label.setText(text);
	}
	
	public void setStatus(boolean status) {
		this.statusDot.setBackgroundResource(status ? R.drawable.status_dot_on : R.drawable.status_dot_off);
	}

	private void setUpView() {
		this.addView(View.inflate(this.getContext(), R.layout.check_list_item, null));
		
		this.label = (TextView)this.findViewById(R.id.check_list_item_label);
		this.statusDot = this.findViewById(R.id.check_list_item_status);
	}
	
}
