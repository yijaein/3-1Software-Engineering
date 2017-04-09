package bscorp.appbase;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import telephony.AlarmActivity;


/**
 * Created by jan on 2017-01-24.
 */
public class Roller_Coaster extends AppCompatActivity {
    private ImageView img;
    Button reservation_btn,find_myloc,alarmBtn;
    TextView left_peopleview1,left_peopleview2,waiting_time1,waiting_time2;
    ImageView attImg,attMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roller_coaster);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        reservation_btn = (Button)findViewById(R.id.resrvation_att);//예약하기 버튼
        find_myloc = (Button)findViewById(R.id.find_myloc);//길찾기 버튼

        left_peopleview1=(TextView)findViewById(R.id.left_peopleview1);//대기인원 1
        left_peopleview2=(TextView)findViewById(R.id.left_peopleview2);//대기인원2

        waiting_time1 =(TextView)findViewById(R.id.wating_peopleview1);//남은 시간 1
        waiting_time2= (TextView)findViewById(R.id.wating_peopleview2);//남은시간 2

        attImg = (ImageView)findViewById(R.id.att_image1);//놀이기구 사진
        attMap =(ImageView)findViewById(R.id.att_map);//놀이기구 가는 지도 정보

        alarmBtn =(Button)findViewById(R.id.alarmBtn);

        alarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Roller_Coaster.this, AlarmActivity.class);
                startActivity(intent);
            }
        });

        find_myloc = (Button)findViewById(R.id.find_myloc);
        find_myloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent intent = new Intent(Roller_Coaster.this,Map.class);
                startActivity(intent);
            }
        });



    }//oncreadte end





    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }




}
