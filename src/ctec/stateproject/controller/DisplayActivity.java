package ctec.stateproject.controller;

import ctec.stateproject.model.AndroidState;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends Activity
{
	private TextView displayView;
	private Button homeButton;
	private AndroidState appState;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		displayView = (TextView)findViewById(R.id.resultsView);
		homeButton = (Button)findViewById(R.id.homeButton);
		appState = (AndroidState)this.getApplication();
		
		showTransferInput();
		
		setupListeners();
	}
	
	private void showTransferInput()
	{
		displayView.setText(appState.getName() + " says: " + appState.getPhrase() 
				+ " because they think " + appState.getBlather()
				+ " when they are " + appState.getAge());
	}
	
	private void setupListeners()
	{
		homeButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent returnIntent = new Intent();
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
