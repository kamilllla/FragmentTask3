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

public class SecondFragment extends Fragment {
    private TextView receiveData;
    private EditText dataToSend;
    private Button sendData;

    //нужный фрагменту интерфейс
    public interface SecondFragmentReceiver {
        public void secondReceive(String data);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_second, container, false);
        receiveData=view.findViewById(R.id.second_data);
        dataToSend=view.findViewById(R.id.second_text);
        sendData=view.findViewById(R.id.second_post);

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secondReceiver != null){
                    String data=dataToSend.getText().toString();
                    secondReceiver.secondReceive(data);
                }
            }
        });
        return view;
    }
    void dataReceived(String data){
        receiveData.setText(data);
    }
    private SecondFragmentReceiver secondReceiver;
    //ЖЦ выполняется когда фрагмент подсоединяется к активности
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SecondFragmentReceiver){
            secondReceiver=(SecondFragmentReceiver) context;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
