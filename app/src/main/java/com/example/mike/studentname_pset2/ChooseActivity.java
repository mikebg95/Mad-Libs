package com.example.mike.studentname_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.lang.reflect.Array;
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

        randomStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] stories = {"tarzan", "university", "clothes", "dance"};
//                int randomChoice = new Random().nextInt(stories.length);
                String randomStory = (stories[new Random().nextInt(stories.length)]);

                if (randomStory.equals("tarzan")) {
                    is = getResources().openRawResource(R.raw.madlib1_tarzan);
                }
                else if (randomStory.equals("university")) {
                    is = getResources().openRawResource(R.raw.madlib2_university);
                }
                else if (randomStory.equals("clothes")) {
                    is = getResources().openRawResource(R.raw.madlib3_clothes);
                }
                else if (randomStory.equals("dance")) {
                    is = getResources().openRawResource(R.raw.madlib4_dance);
                }

                story = new Story(is);

                Log.d("story", story.toString());

                intent = new Intent(ChooseActivity.this, WordsActivity.class);
                intent.putExtra("typestory", story);
                startActivity(intent);
            }
        });
    }
}
