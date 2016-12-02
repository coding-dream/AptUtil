package com.ruoxu.aptutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ruoxu.anotation.BindView;
import com.ruoxu.anotation.OnClick;


@OnClick
@BindView
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
