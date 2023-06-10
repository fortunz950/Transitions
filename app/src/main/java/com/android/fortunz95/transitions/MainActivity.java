package com.android.fortunz95.transitions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.*;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private Scene scene1;
    private Scene scene2;
    private Scene currentScene;
    private Transition transition;
    private TransitionSet transitionSet;
    private FrameLayout sceneRootFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sceneRootFrameLayout = findViewById(R.id.sceneRootFrameLayout);
        sceneRootFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScene == scene1) {
                    TransitionManager.go(scene2, transition);
                    currentScene = scene2;
                } else {
                    TransitionManager.go(scene1, transition);
                    currentScene = scene1;
                }
            }
        });
        scene1 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene1, this);
        scene2 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene2, this);

        scene1.enter();
        currentScene = scene1;

        // Step 2: Create a Transition object to define what type of animation you want
        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_2);

        /*
        var cbTransition = new ChangeBounds();
        cbTransition.setDuration(500);
        cbTransition.setInterpolator(new LinearInterpolator());

        var fadeInTransition = new Fade(Fade.IN);
        fadeInTransition.setDuration(250);
        fadeInTransition.setStartDelay(400);
        fadeInTransition.addTarget(R.id.txvTitle);

        var fadeOutTransition = new Fade(Fade.OUT);
        fadeOutTransition.setDuration(50);
        fadeOutTransition.addTarget(R.id.txvTitle);

        transitionSet = new TransitionSet();
        transitionSet.setOrdering(TransitionSet.ORDERING_TOGETHER);

        transitionSet.addTransition(cbTransition);
        transitionSet.addTransition(fadeInTransition);
        transitionSet.addTransition(fadeOutTransition);
        */
    }
}