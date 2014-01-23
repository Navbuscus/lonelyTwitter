package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {
	private Gson gson = new Gson();
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private LonelyTwitterActivity  twitter = this;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();	
				saveInFile(text);
				finish();				
				//adapter.notifyDataSetChanged();
			}
		});
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ArrayList<NormalTweetModel> tweets = loadFromFile();
		String[] tweetText = new String[tweets.size()];
		for(int i=0;i<tweets.size();i++){
			tweetText[i] = new String(tweets.get(i).getTimeStamp().toString() + " | " + tweets.get(i).getText());			
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweetText);
		oldTweetsList.setAdapter(adapter);
	}

	private ArrayList<NormalTweetModel> loadFromFile() {
		ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				NormalTweetModel tweet = gson.fromJson(line, NormalTweetModel.class);
				tweets.add(tweet);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets;
	}
	
	private void saveInFile(String text) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			NormalTweetModel newTweet = new NormalTweetModel(text);
			String json = gson.toJson(newTweet);
			fos.write(json.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}