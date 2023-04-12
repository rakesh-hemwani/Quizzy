package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class DashScreen extends AppCompatActivity {
    public CardView cardview1,cardview2,cardview3;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_screen);
        cardview1=findViewById(R.id.card_view1);
        cardview2=findViewById(R.id.card_view2);
        cardview3=findViewById(R.id.card_view3);


        View.OnClickListener changeln= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.card_view1){
                Intent mainIntent = new Intent(DashScreen.this,MainActivity.class);
                DashScreen.this.startActivity(mainIntent);}
                else{
                    Toast.makeText(DashScreen.this,"Comming soon", Toast.LENGTH_SHORT).show();

                }

            }
        };
        cardview1.setOnClickListener(changeln);
        cardview2.setOnClickListener(changeln);
        cardview3.setOnClickListener(changeln);



    }



}
