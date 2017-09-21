package com.studio.iochen.bezierdemo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class BezierActivity2 extends AppCompatActivity {
    @InjectView(R.id.my_bezier2)
    BezierCurveView2 bezierCurveView ;
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier2);
        ButterKnife.inject(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.btn_1:
                        bezierCurveView.setControl(true);
                        break;

                    case R.id.btn_2:
                        bezierCurveView.setControl(false);
                        break;
                }
            }
        });

    }

}
