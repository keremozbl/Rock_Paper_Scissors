package com.kerem.takatmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button tas,kagıt,makas;
    TextView CompScore, UserScore,sonuc,PcSecim;

    int compScr=0,userScr=0,compChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tas=findViewById(R.id.tas);
        kagıt=findViewById(R.id.kagıt);
        makas=findViewById(R.id.makas);
        CompScore=findViewById(R.id.CompScore);
        UserScore=findViewById(R.id.UserScore);
        sonuc=findViewById(R.id.sonuc);
        PcSecim=findViewById(R.id.PcSecim);


        UserScore.setText(String.valueOf(userScr));
        CompScore.setText(String.valueOf(compScr));
    }



    public void Butonlar(View view) {

        switch(view.getId())
        {
            case R.id.tas:     CompChoiceMethod(1);  break;
            case R.id.kagıt:   CompChoiceMethod(2);  break;
            case R.id.makas:   CompChoiceMethod(3);  break;
        }

    }
    public void CompChoiceMethod(int userChoice) {

        compChoice = (int) (Math.random() * 3 + 1);

        if (compChoice==1) PcSecim.setText("Bilgisayar seçimi :  TAŞ");
        if (compChoice==2) PcSecim.setText("Bilgisayar seçimi : KAĞIT");
        if (compChoice==3) PcSecim.setText("Bilgisayar seçimi : MAKAS");


        if ((compChoice == 1 && userChoice == 1) || (compChoice == 2 && userChoice == 2) || (compChoice == 3 && userChoice == 3)) {
            sonuc.setText("Berabere");

        }

        else if ((compChoice == 1 && userChoice == 2) || (compChoice == 2 && userChoice == 3) || (compChoice == 3 && userChoice == 1)) {

            sonuc.setText("Kazandın");
            userScr++; UserScore.setText(String.valueOf(userScr));
        }

        else {

            sonuc.setText("PC Kazandı");
            compScr++; CompScore.setText(String.valueOf(compScr));
        }
    }

}