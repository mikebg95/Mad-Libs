package com.example.mike.studentname_pset2;

import com.example.mike.studentname_pset2.Story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mike.studentname_pset2.R;

import java.io.InputStream;

public class WordsActivity extends AppCompatActivity {

    String inputWord;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // create variables linked to textviews, editview and button
        final TextView wordsLeft = findViewById(R.id.wordsLeft);
        final EditText userWords = findViewById(R.id.getString);
        final TextView whatToType = findViewById(R.id.whatToType);
        Button submitWord = findViewById(R.id.submit);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("typestory");

//        Log.d("story", story.toString());

        // provide user with amount of words left to fill in
        wordsLeft.setText(story.getPlaceholderRemainingCount() + " words left");

        // provide user with type of word to fill in
        whatToType.setText("Please enter a " + story.getNextPlaceholder().toLowerCase());

        // when clicked on submit button
        submitWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!userWords.getText().toString().trim().equals("")) {
                    // save input as string and fill in placeholder
                    inputWord = userWords.getText().toString().trim().replaceAll("[^a-zA-Z]", "");
                    story.fillInPlaceholder(inputWord);

                    // empty edittext
                    userWords.setText("");

                    // update amount of words left
                    wordsLeft.setText(story.getPlaceholderRemainingCount() + " words left");

                    // update type of word to provide
                    whatToType.setText("Please enter a/an " + story.getNextPlaceholder().toLowerCase());

                    // when all words have been filled in
                    if (story.getPlaceholderRemainingCount() == 0) {

                        // remember story and go to story screen
                        Intent intent = new Intent(WordsActivity.this, StoryActivity.class);
                        intent.putExtra("finalstory", story);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
