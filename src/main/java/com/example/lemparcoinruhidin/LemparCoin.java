package com.example.lemparcoinruhidin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LemparCoin extends Activity implements View.OnClickListener {
    private Button buttonLempar;
    private Button buttonUlang;
    private Button buttonkeluar;
    private Random acak;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acak= new Random();
        setContentView(R.layout.activity_lemparcoin);
        buttonLempar=(Button)findViewById(R.id.buttonLempar);
        buttonUlang=(Button)findViewById(R.id.buttonUlang);
        buttonkeluar=(Button)findViewById(R.id.buttonKeluar);
        buttonLempar.setOnClickListener(this);
        buttonUlang.setOnClickListener(this);
        buttonkeluar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if ( view==buttonLempar){

            Log.d("CLICK_EVENT","Lempar button diClick");
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imageView);

            if (acak.nextDouble()< 0.5){
                tw.setText("kepala");
                iw.setImageResource(R.drawable.head);
            } else {
                tw.setText("cross");
                iw.setImageResource(R.drawable.tail);
            }
            buttonLempar.setVisibility(view.INVISIBLE);
            buttonUlang.setVisibility(view.VISIBLE);
            buttonkeluar.setVisibility(view.VISIBLE);
        }
        else if (view==buttonUlang){
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imageView);

            buttonLempar.setVisibility(view.VISIBLE);
            buttonUlang.setVisibility(view.INVISIBLE);
            buttonkeluar.setVisibility(view.INVISIBLE);

        }else if (view==buttonkeluar){
            this.finish();
        }

    }
}
