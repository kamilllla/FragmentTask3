package com.example.fragments3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;

public class FirstFragment extends Fragment {
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    //нужный фрагменту интерфейс
    public interface FirstFragmentReceiver {
        public void firstReceive(String data);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_first, container, false);
       receiveData=view.findViewById(R.id.first_data);
       dataToSend=view.findViewById(R.id.first_text);
       sendData=view.findViewById(R.id.first_post);

       sendData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (firstReceiver != null){
                   String data=dataToSend.getText().toString();
                   firstReceiver.firstReceive(data);
               }
           }
       });
        return view;
    }
    void dataReceived(String data){
        receiveData.setText(data);
    }
    private FirstFragmentReceiver firstReceiver;
//ЖЦ выполняется когда фрагмент подсоединяется к активности
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FirstFragmentReceiver){
            firstReceiver=(FirstFragmentReceiver) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
