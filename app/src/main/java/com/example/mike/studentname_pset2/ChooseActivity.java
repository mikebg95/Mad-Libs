package com.example.mike.studentname_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.Random;

public class ChooseActivity extends AppCompatActivity {

    Story story;
    Intent intent;
    InputStream is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // create variables for different buttons
        Button tarzanStory = findViewById(R.id.tarzan);
        Button uniStory = findViewById(R.id.university);
        Button clothesStory = findViewById(R.id.clothes);
        Button danceStory = findViewById(R.id.dance);
        Button randomStory = findViewById(R.id.random);


        /*
        when a story gets chosen, the story gets sent to the wordsActivity through an intent
        */

        tarzanStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is = getResources().openRawResource(R.raw.madlib1_tarzan);
                story = new Story(is);
                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });

        uniStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is = getResources().openRawResource(R.raw.madlib2_university);
                story = new Story(is);
                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });

        clothesStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is = getResources().openRawResource(R.raw.madlib3_clothes);
                story = new Story(is);
                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });

        danceStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is = getResources().openRawResource(R.raw.madlib4_dance);
                story = new Story(is);
                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });

        // when random story is chosen
        randomStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store story names in an array
                String[] stories = {"tarzan", "university", "clothes", "dance"};

                // choose random story name from array
                String randomStory = (stories[new Random().nextInt(stories.length)]);

                // random story get's chosen
                switch (randomStory) {
                    case "tarzan":
                        is = getResources().openRawResource(R.raw.madlib1_tarzan);
                        break;
                    case "university":
                        is = getResources().openRawResource(R.raw.madlib2_university);
                        break;
                    case "clothes":
                        is = getResources().openRawResource(R.raw.madlib3_clothes);
                        break;
                    case "dance":
                        is = getResources().openRawResource(R.raw.madlib4_dance);
                        break;
                }

                // start new story object
                story = new Story(is);

                // send story object to WordsActivity through intent
                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });
    }
}
