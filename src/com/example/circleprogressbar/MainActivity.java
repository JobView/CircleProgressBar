package com.example.circleprogressbar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	CircleImageProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		progressBar=(CircleImageProgressBar)findViewById(R.id.circleProgressbar);
		progressBar.setMaxProgress(1000);
		new Thread()
		{
			public void run()
			{
				int i=0;
				while(i<=1000)
				{
					i++;
					progressBar.setProgressNotInUiThread(i);
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			
			}
		}.start();
	}

}
