package com.reversec.dz.activities;

import com.google.android.material.appbar.MaterialToolbar;
import com.reversec.dz.R;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
	
	private TextView description;
	
	private String getVersionName() {
		try {
			return this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
		}
		catch(NameNotFoundException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);

		// Set up MaterialToolbar with back navigation
		MaterialToolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		this.description = (TextView)this.findViewById(R.id.about_description);
		this.description.setText(String.format(this.getString(R.string.about_description), this.getVersionName()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
