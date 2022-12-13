package com.dabee.tp04clickclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_main,layoutmain;
    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,start_btn;
    TextView main_tv,last_tv,main_tv2;

    int set=0;
    int set3=0;
    int set4=0;
    int n;
    long start,finish;
    RadioGroup rg1;
    RadioButton rb1, rb2;

    int[][] imgs = {{R.drawable.num01,
            R.drawable.num02,
            R.drawable.num03,
            R.drawable.num04,
            R.drawable.num05,
            R.drawable.num06,
            R.drawable.num07,
            R.drawable.num08,
            R.drawable.num09,
            R.drawable.num10,
            R.drawable.num11,
            R.drawable.num12},
                    {R.drawable.cha01,
                    R.drawable.cha02,
                    R.drawable.cha03,
                    R.drawable.cha04,
                    R.drawable.cha05,
                    R.drawable.cha06,
                    R.drawable.cha07,
                    R.drawable.cha08,
                    R.drawable.cha09,
                    R.drawable.cha10,
                    R.drawable.cha11,
                    R.drawable.cha12},
                                        {R.drawable.alpa01,
                                        R.drawable.alpa02,
                                        R.drawable.alpa03,
                                        R.drawable.alpa04,
                                        R.drawable.alpa05,
                                        R.drawable.alpa06,
                                        R.drawable.alpa07,
                                        R.drawable.alpa08,
                                        R.drawable.alpa09,
                                        R.drawable.alpa10,
                                        R.drawable.alpa11,
                                        R.drawable.alpa12},
                                                {R.drawable.card_spades_a,
                                                R.drawable.card_spades2,
                                                R.drawable.card_spades3,
                                                R.drawable.card_spades4,
                                                R.drawable.card_spades5,
                                                R.drawable.card_spades6,
                                                R.drawable.card_spades7,
                                                R.drawable.card_spades8,
                                                R.drawable.card_spades9,
                                                R.drawable.card_spades_j,
                                                R.drawable.card_spades_q,
                                                R.drawable.card_spades_k}};


    String[] tags=new String[]{
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"};

    int[] set5 = new int[imgs.length];
    int select1=0;
    int num=0;
    String s="";
    int count=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);


       last_tv=findViewById(R.id.lasttv);
       layoutmain=findViewById(R.id.main_layout);
       layout_main=findViewById(R.id.layout_btn);
       main_tv=findViewById(R.id.main_tv);
       main_tv2=findViewById(R.id.main_tv2);
       start_btn=findViewById(R.id.start_btn);
       btn1=findViewById(R.id.btn01);
       btn2=findViewById(R.id.btn02);
       btn3=findViewById(R.id.btn03);
       btn4=findViewById(R.id.btn04);
       btn5=findViewById(R.id.btn05);
       btn6=findViewById(R.id.btn06);
       btn7=findViewById(R.id.btn07);
       btn8=findViewById(R.id.btn08);
       btn9=findViewById(R.id.btn09);
       btn10=findViewById(R.id.btn10);
       btn11=findViewById(R.id.btn11);
       btn12=findViewById(R.id.btn12);
       rg1=findViewById(R.id.radio1);
       rb1=findViewById(R.id.rb1);
       rb2=findViewById(R.id.rb2);



       rg1.setOnCheckedChangeListener(changeListener);



       int[] rndnums= new int[tags.length];
        Random rnd= new Random();




       start_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(num==0){

                   rb1.setEnabled(false);
                   rb2.setEnabled(false);
                   start = System.currentTimeMillis();
                   s="";
                   set3=0;
                   start_btn.setImageResource(R.drawable.ing);
                   start_btn.setEnabled(false);
                   layout_main.setVisibility(View.VISIBLE);
                   last_tv.setVisibility(View.INVISIBLE);
                   main_tv2.setVisibility(View.VISIBLE);


                   for(int i = 0; i<imgs.length;i++){
                       n = rnd.nextInt(imgs.length);

                       set5[i]=n;

                       for(int j=0;j<i;j++){

                           if(set5[j]==set5[i]){
                               i--;
                               break;
                           }

                       }

                   }

                   if(rb1.isChecked())select1=0;
                   if(rb2.isChecked())select1=set5.length;



               }
               main_tv2.setText((num+1)+"/"+count);




               set=set5[num];

               int set2 =0;


               if(set==0){
                   layoutmain.setBackgroundResource(R.drawable.bg1);
                   s="숫자를";
               }
               if(set==1){
                   layoutmain.setBackgroundResource(R.drawable.bg2);
                   s="십이지신";
               }
               if(set==2){
                   layoutmain.setBackgroundResource(R.drawable.bg3);
                   s="알파벳";
               }
               if (set==3){
                   layoutmain.setBackgroundResource(R.drawable.bg1);
                   s="카드";
               }

               main_tv.setText(s + " 순서대로 누르세요");

               for(int i=0; i<tags.length;i++){
                   set2 = rnd.nextInt(tags.length);
                   rndnums[i]=set2;

                   if(i==0){
                       btn1.setImageResource(imgs[set][set2]);
                       btn1.setTag(tags[set2]);}
                   if(i==1){
                       btn2.setImageResource(imgs[set][set2]);
                       btn2.setTag(tags[set2]);}
                   if(i==2){
                       btn3.setImageResource(imgs[set][set2]);
                       btn3.setTag(tags[set2]);}
                   if(i==3){
                       btn4.setImageResource(imgs[set][set2]);
                       btn4.setTag(tags[set2]);}
                   if(i==4){
                       btn5.setImageResource(imgs[set][set2]);
                       btn5.setTag(tags[set2]);}
                   if(i==5){
                       btn6.setImageResource(imgs[set][set2]);
                       btn6.setTag(tags[set2]);}
                   if(i==6){
                       btn7.setImageResource(imgs[set][set2]);
                       btn7.setTag(tags[set2]);}
                   if(i==7){
                       btn8.setImageResource(imgs[set][set2]);
                       btn8.setTag(tags[set2]);}
                   if(i==8){
                       btn9.setImageResource(imgs[set][set2]);
                       btn9.setTag(tags[set2]);}
                   if(i==9){
                       btn10.setImageResource(imgs[set][set2]);
                       btn10.setTag(tags[set2]);}
                   if(i==10){
                       btn11.setImageResource(imgs[set][set2]);
                       btn11.setTag(tags[set2]);}
                   if(i==11){
                       btn12.setImageResource(imgs[set][set2]);
                       btn12.setTag(tags[set2]);}


                   for(int j=0;j<i;j++){

                       if(rndnums[j]==set2){
                           i--;
                           break;
                       }

                   }





               }



           }
       });






       btn1.setOnClickListener(listener);
       btn2.setOnClickListener(listener);
       btn3.setOnClickListener(listener);
       btn4.setOnClickListener(listener);
       btn5.setOnClickListener(listener);
       btn6.setOnClickListener(listener);
       btn7.setOnClickListener(listener);
       btn8.setOnClickListener(listener);
       btn9.setOnClickListener(listener);
       btn10.setOnClickListener(listener);
       btn11.setOnClickListener(listener);
       btn12.setOnClickListener(listener);



    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            for(int i=0;i<tags.length;i++){

                if(view.getTag()==tags[set3]&&set3==i){
                    view.setVisibility(View.INVISIBLE);
                    set3++;

                }

            }

            if((set3)==tags.length){

                if(select1>num){
                    num++;
                    set3=0;
                    if(select1>num)start_btn.callOnClick();
                }



                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);
                btn7.setVisibility(View.VISIBLE);
                btn8.setVisibility(View.VISIBLE);
                btn9.setVisibility(View.VISIBLE);
                btn10.setVisibility(View.VISIBLE);
                btn11.setVisibility(View.VISIBLE);
                btn12.setVisibility(View.VISIBLE);



                if(num==select1){

                    layout_main.setVisibility(View.INVISIBLE);
                    start_btn.setImageResource(R.drawable.start);
                    layoutmain.setBackgroundResource(R.drawable.bg4);
                    main_tv.setText("다시 하려면 Start 버튼을 누르세요");
                    start_btn.setEnabled(true);
                    main_tv2.setVisibility(View.INVISIBLE);
                    finish = System.currentTimeMillis();
                    rb1.setEnabled(true);
                    rb2.setEnabled(true);

                    last_tv.setVisibility(View.VISIBLE);
                    int time=(int)(finish-start)/1000;
                    int sec=time%60;
                    int min=time/60%60;
                    last_tv.setText(min+"분 "+sec+"초");
                    num=0;

                }


            }

        }
    };


    RadioGroup.OnCheckedChangeListener changeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            CoordinatorLayout containner =findViewById(R.id.snackbar_container);

            if(i==rb1.getId()){
                Snackbar.make(containner,rb1.getText()+"(단일) select", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.black)).setTextColor(getResources().getColor(R.color.white,null)).show();
//                Toast.makeText(MainActivity.this, rb1.getText()+" select", Toast.LENGTH_SHORT).show();
                count=1;
            }
            if(i==rb2.getId()){
                Snackbar.make(containner,rb2.getText()+"(연속) select", Snackbar.LENGTH_SHORT).setBackgroundTint(getResources().getColor(R.color.black)).setTextColor(getResources().getColor(R.color.white,null)).show();
//                Toast.makeText(MainActivity.this, rb2.getText()+" select", Toast.LENGTH_SHORT).show();
                count=imgs.length;
            }


        }
    };



}