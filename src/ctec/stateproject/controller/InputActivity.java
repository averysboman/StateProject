package ctec.stateproject.controller;

import ctec.stateproject.model.AndroidState;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;

public class InputActivity extends Activity
{
	private EditText ageField, nameField, phraseField, blatherField;
	private Button transferButton;
	private AndroidState appState;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);
		
		ageField = (EditText)findViewById(R.id.ageTextField);
		nameField = (EditText)findViewById(R.id.nameTextField);
		phraseField = (EditText)findViewById(R.id.phraseTextField);
		blatherField = (EditText)findViewById(R.id.blatherField);
		transferButton = (Button)findViewById(R.id.transferButton);
		
		appState = (AndroidState)this.getApplication();
		
		setupListeners();
	}
	
	private void setupListeners()
	{
		transferButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View currentView)
			{
				gatherInformation();
				
				Intent transferIntent = new Intent(currentView.getContext(), DisplayActivity.class);
				startActivityForResult(transferIntent, 0);
			}
		});
	}
	
	private void gatherInformation()
	{
		appState.setAge(ageField.getText().toString());
		appState.setName(nameField.getText().toString());
		appState.setPhrase(phraseField.getText().toString());
		appState.setBlather(blatherField.getText().toString());
	}
}
