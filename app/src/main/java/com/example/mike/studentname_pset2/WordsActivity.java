package com.example.mike.studentname_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class WordsActivity extends AppCompatActivity {

    Story story;

    TextView wordsLeft;
    EditText userWords;
    TextView whatToType;
    Button submitWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // link variables to layout views and button
        wordsLeft = findViewById(R.id.wordsLeft);
        userWords = findViewById(R.id.getString);
        whatToType = findViewById(R.id.whatToType);
        submitWord = findViewById(R.id.submit);

        // get story object from intent
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("typestory");

        // provide user with amount of words left to fill in
        setWordsLeft(story);

        // provide user with type of word to fill in
        setWord(story);

        // when clicked on submit button
        submitWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // if user inserted a word
                if (!userWords.getText().toString().trim().equals("")) {

                    // save input as string and fill in placeholder
                    String inputWord = userWords.getText().toString().trim().replaceAll("[^a-zA-Z]", "");
                    story.fillInPlaceholder(inputWord);

                    // clear editText
                    userWords.setText("");

                    // update amount of words left
                    setWordsLeft(story);

                    // when all words have been filled in
                    if (story.getPlaceholderRemainingCount() == 0) {

                        wordsLeft.setText("");

                        // send final story to StoryActivity through intent
                        Intent intent = new Intent(WordsActivity.this, StoryActivity.class);
                        intent.putExtra("finalstory", story);
                        startActivity(intent);
                    }
                    else {
                        // update type of word to provide
                        setWord(story);
                    }
                }
            }
        });
    }

    public void setWord(Story story) {
        String wordToType = "Please enter a/an " + story.getNextPlaceholder().toLowerCase();
        whatToType.setText(wordToType);
    }

    public void setWordsLeft(Story story) {
        String wordsRemaining = story.getPlaceholderRemainingCount() + " words left";
        wordsLeft.setText(wordsRemaining);
    }
}
