package bscorp.appbase;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jan on 2017-01-26.
 */
public class Buy_Utilize extends AppCompatActivity {//이용권구매

    Button buy_ticket_Btn,cancle_buy_ticket;// 결제하기 , 취소하기 버튼
    ImageButton ticketBtn1,ticketBtn2,ticketBtn3,ticketBtn4;// 슬롯
    TextView buying_ticket_info;// 이용구너구매에 대한 약관 공시
    ImageView buying_ticket_main;//이용권 구매 메인 이미지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_utilize);


        int i = 0;
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        buy_ticket_Btn = (Button)findViewById(R.id.buy_ticket_btn);
        cancle_buy_ticket = (Button)findViewById(R.id.cancle_buy_ticket);
        ticketBtn1 = (ImageButton)findViewById(R.id.ticketBtn1);//결제시 기본적으로 열리 defalt
        ticketBtn2= (ImageButton)findViewById(R.id.ticketBtn2);//결제시 기본적으로 열리 defalt
        ticketBtn3 = (ImageButton)findViewById(R.id.ticketBtn3);// 누르면 추가적으로 돈을 받고 슬롯을 연다.
        ticketBtn4= (ImageButton)findViewById(R.id.ticketBtn4);// 클릭시 결제창

        buying_ticket_info =(TextView)findViewById(R.id.buy_ticket_info_txt);
        buying_ticket_main = (ImageView)findViewById(R.id.buy_ticket_main);

        ticketBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //구매하기 기능(액티비티)가 나오고 구매가 완료되면 이미지가 바뀐다.
                DialogHtmlView();
            }
        });

        ticketBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이것도 누르면 구매하기 기능이 나오고 이미지가 바뀐다? 추가된다 ?
                DialogHtmlView1();
            }
        });

        buy_ticket_Btn.setOnClickListener(new View.OnClickListener() {//티켓사기 버튼
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Buy_Utilize.this, "complete buying ticket", Toast.LENGTH_SHORT);
                toast.show();// 확인 버튼을 눌렀을 때 구입됬다는 토스트 메시지 출력
                Intent intent = new Intent(Buy_Utilize.this,MainActivity.class);
                startActivity(intent);

            }
        });

        cancle_buy_ticket.setOnClickListener(new View.OnClickListener() {// 티켓 취소 버튼
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Buy_Utilize.this, "cancel buying ticket", Toast.LENGTH_SHORT);
                toast.show();// 확인 버튼을 눌렀을 때 구입됬다는 토스트 메시지 출력
                Intent intent = new Intent(Buy_Utilize.this,MainActivity.class);
                startActivity(intent);

            }
        });


    }//end oncreate




    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
               // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void DialogHtmlView() {//슬롯 구매 다이얼로그
        AlertDialog.Builder ab = new AlertDialog.Builder(Buy_Utilize.this);
        ab.setMessage(Html.fromHtml("<strong><font color=\"#ff0000\"> " + "Html 표현여부 "
                + "</font></strong><br>Do you want to buy this slot?"));
        ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(Buy_Utilize.this, "complete buying slot", Toast.LENGTH_LONG);
                toast.show();// 확인 버튼을 눌렀을 때 구입됬다는 토스트 메시지 출력
                ticketBtn3.setImageResource(R.drawable.parbin3);

            }
        });

        ab.show();
    }
    private void DialogHtmlView1() {//슬롯 구매 다이얼로그
        AlertDialog.Builder ab = new AlertDialog.Builder(Buy_Utilize.this);
        ab.setMessage(Html.fromHtml("<strong><font color=\"#ff0000\"> " + "Html 표현여부 "
                + "</font></strong><br>Do you want to buy this slot?"));
        ab.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast = Toast.makeText(Buy_Utilize.this, "complete buying slot", Toast.LENGTH_LONG);
                toast.show();// 확인 버튼을 눌렀을 때 구입됬다는 토스트 메시지 출력
                ticketBtn4.setImageResource(R.drawable.parbin3);
            }
        });

        ab.show();
    }
}//end class
