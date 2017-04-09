package bscorp.appbase;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jan on 2017-01-19.
 */
public class ActivityInfo extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList al = new ArrayList();//리스트뷰 담는 어레이리스트
    Button TimeSorting,NameSorting, LocSorting;// 위치순, 시간순 ,이름순 정렬하는 버튼


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


//네이게이터 툴바
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ATT at = new ATT();
        at.img = R.drawable.parbin;
        at.name = "top";
        at.run = true;
        at.ATTinfo = "롤러코스터 정보";
        //리스트 뷰 추가
        al.add(at);
        al.add(new ATT(R.drawable.parbin,"청룔열차",true,"말이 돌아감"));
        al.add(new ATT(R.drawable.parbin,"자이로드롭",true,"그래"));
        al.add(new ATT(R.drawable.parbin,"회전목마",true,"용이나옴"));
        al.add(new ATT(R.drawable.parbin,"범퍼카",true,"왕아ㅘㅘ아"));
        al.add(new ATT(R.drawable.parbin,"후룸라이드",true,"목이 돌아감"));




        ATTAdapter adapter = new ATTAdapter(
                getApplicationContext(),
                R.layout.row,
                al);
        ListView lv = (ListView)findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("test", "아이템클릭, postion : " + position +
                        ", id : " + id);
                if (id == 1) {
                    Intent intent = new Intent(ActivityInfo.this, Roller_Coaster.class);
                    startActivity(intent);
                }
            }
        });

    TimeSorting = (Button)findViewById(R.id.TimeSorting);
        findViewById(R.id.TimeSorting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //소팅하는 방법 찾아서 추가할 것
            }
        });//시간순 정렬
        LocSorting = (Button)findViewById(R.id.TimeSorting);
        findViewById(R.id.LocSorting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });// 위치순으로 정렬
        NameSorting = (Button)findViewById(R.id.NameSorting);
        findViewById(R.id.NameSorting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });//이름순으로 정렬



    }//oncreate end=====================================================================================================


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }//뒤로가기 버튼이 눌리면 한번 더 물어봐아아아

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {//액션바
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);



    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    class  ATTAdapter extends BaseAdapter{
        Context context;
        int layout;
        ArrayList al;
        LayoutInflater inf;

            public ATTAdapter(Context context, int layout, ArrayList al){
                this.context= context;
                this.layout= layout;
                this.al=al;
                this.inf= (LayoutInflater)context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }

        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return al.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null)
                convertView = inf.inflate(layout,null);
                ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
                TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
                TextView tvSex =(TextView)convertView.findViewById(R.id.tvOrigin);
                TextView tvBirthDay=(TextView)convertView.findViewById(R.id.tvShipDate);


            ATT at1 = (ATT) al.get(position);

            iv.setImageResource(at1.img);
            tvName.setText(at1.name);
            tvSex.setText(at1.run ? "운행" : "고장");
            tvBirthDay.setText(at1.ATTinfo);

            return convertView;
        }
    }

    class ATT { // 자바 빈 (java Bean)
        int img; // 사진 - res/drawable
        String name = "";
        boolean run;
        String ATTinfo = "";

        // 생성자가 있으면 객체 생성시 편리하다
        public ATT(int img, String name, boolean run, String ATTinfo) {
            this.img = img;
            this.name = name;
            this.run = run;
            this.ATTinfo = ATTinfo;
        }

        public ATT() {}


    }//att end


}










