package com.example.mike.studentname_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // create variables for button and textview
        Button newStory = findViewById(R.id.newStory);
        TextView finalStory = findViewById(R.id.finalStory);

        // get story from WordsActivity
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("finalstory");

        // provide user with final story
        finalStory.setText(story.toString());

        // create onclicklistener for newStory button
        newStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newStoryButtonClicked();
            }
        });
    }

    // when new story button clicked, go to (resetted) wordsActivity screen
    private void newStoryButtonClicked() {
        Intent intent = new Intent(StoryActivity.this, ChooseActivity.class);
        startActivity(intent);
    }
}
