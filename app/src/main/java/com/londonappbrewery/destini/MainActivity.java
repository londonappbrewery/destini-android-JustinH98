package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("storyIndex");
            if(mStoryIndex == 1){
                mStoryTextView.setText(R.string.T1_Story);
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);
            } else if(mStoryIndex == 2){
                mStoryTextView.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
            } else {
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
            }
        }



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValues(mTopButton);
            }
        });




        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateValues(mBottomButton);
            }
        });


    }

    public void updateValues(Button buttonClicked){
        if(mStoryIndex == 1){
            if(buttonClicked == mTopButton){
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
            } else {
                mStoryTextView.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                mStoryIndex = 2;
            }
        } else if(mStoryIndex == 2){
            if (buttonClicked == mTopButton){
                mStoryTextView.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
            } else {
                mStoryTextView.setText(R.string.T4_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                mStoryIndex = 1;
            }
        } else if(mStoryIndex == 3){
            if(buttonClicked == mTopButton){
                mStoryTextView.setText(R.string.T6_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                mStoryIndex = 1;
            } else {
                mStoryTextView.setText(R.string.T5_End);
                mTopButton.setVisibility(View.GONE);
                mBottomButton.setVisibility(View.GONE);
                mStoryIndex = 1;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("storyIndex", mStoryIndex);

    }
}
