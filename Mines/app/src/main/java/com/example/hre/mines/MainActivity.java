package com.example.hre.mines;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    private TextView[] cell = new TextView[25];
    private int[][] num;
    private int k=0;
    private ImageView Img;
    private Mine m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intialize();
        m = new Mine();
        m.add();
        /*for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Log.e("LOL",""+m.get(i,j));
            }
        }*/
        ArrayList<Integer> lol = m.counts();
        num = new int[5][5];
        int l=0;
        for(int i = 0;i<5;i++){
            for(int j=0;j<5;j++){
                num[i][j]=lol.get(l);
                l++;
            }
        }
        setTxt();
        Img = (ImageView) findViewById(R.id.imageView);
        Img.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
    private void setTxt(){
        int l=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(num[i][j]!=10)
                    cell[l].setText(""+num[i][j]);
                else
                    cell[l].setText("*");
                l++;
            }
        }
    }
    public void onClick(View view) {
        TextView txt = (TextView)findViewById(view.getId());
        String s = txt.getText().toString();
        String s1;
        if(s.charAt(0)=='*') {
            Img.setImageResource(R.drawable.lolo);
            txt.setBackgroundColor(Color.rgb(255, 0, 0));
            Toast.makeText(this,"You,ve Lost!!",Toast.LENGTH_LONG).show();
            for(int i=0;i<25;i++){
                s1 = cell[i].getText().toString();
                if(s1.charAt(0)=='*'){
                    cell[i].setBackgroundColor(Color.rgb(255, 0, 0));
                }
                cell[i].setEnabled(false);
            }

        }
        else {
            txt.setBackgroundColor(Color.rgb(255, 255, 255));
            k++;
            if(k==18){
                Img.setImageResource(R.drawable.lolol);
                Toast.makeText(this,"You,ve Won!!",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void intialize() {
        cell[0]=(TextView)findViewById(R.id.t1);
        cell[1]=(TextView)findViewById(R.id.t2);
        cell[2]=(TextView)findViewById(R.id.t3);
        cell[3]=(TextView)findViewById(R.id.t4);
        cell[4]=(TextView)findViewById(R.id.t5);
        cell[5]=(TextView)findViewById(R.id.t6);
        cell[6]=(TextView)findViewById(R.id.t7);
        cell[7]=(TextView)findViewById(R.id.t8);
        cell[8]=(TextView)findViewById(R.id.t9);
        cell[9]=(TextView)findViewById(R.id.t10);
        cell[10]=(TextView)findViewById(R.id.t11);
        cell[11]=(TextView)findViewById(R.id.t12);
        cell[12]=(TextView)findViewById(R.id.t13);
        cell[13]=(TextView)findViewById(R.id.t14);
        cell[14]=(TextView)findViewById(R.id.t15);
        cell[15]=(TextView)findViewById(R.id.t16);
        cell[16]=(TextView)findViewById(R.id.t17);
        cell[17]=(TextView)findViewById(R.id.t18);
        cell[18]=(TextView)findViewById(R.id.t19);
        cell[19]=(TextView)findViewById(R.id.t20);
        cell[20]=(TextView)findViewById(R.id.t21);
        cell[21]=(TextView)findViewById(R.id.t22);
        cell[22]=(TextView)findViewById(R.id.t23);
        cell[23]=(TextView)findViewById(R.id.t24);
        cell[24]=(TextView)findViewById(R.id.t25);
    }


}