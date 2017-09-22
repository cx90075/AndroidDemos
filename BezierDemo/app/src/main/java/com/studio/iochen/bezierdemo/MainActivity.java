package com.studio.iochen.bezierdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_bezier1)
    Button btn_bezier1;

    @InjectView(R.id.btn_bezier2)
    Button btn_bezier2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }


    @OnClick({R.id.btn_bezier1,R.id.btn_bezier2})
    public void onClick(View v){

        switch (v.getId()){

            case R.id.btn_bezier1:
                startActivity(new Intent(this,BezierActivity1.class));
                //test branch 1
                break;
            case R.id.btn_bezier2:

                startActivity(new Intent(this,BezierActivity2.class));
                break;
        }

    }
}
