package com.example.fragments3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstFragmentReceiver, SecondFragment.SecondFragmentReceiver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void firstReceive(String data){
        SecondFragment secondFragment=(SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_second);
        secondFragment.dataReceived(data);
    }
    @Override
    public void secondReceive(String data){
        FirstFragment firstFragment=(FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_first);
        firstFragment.dataReceived(data);
    }

}