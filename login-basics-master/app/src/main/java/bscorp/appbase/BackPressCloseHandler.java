package bscorp.appbase;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by jan on 2017-01-24.
 */
public class BackPressCloseHandler {// 액티비티에서 뒤로가기 누르면 종료됨
    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressCloseHandler(Activity context){
        this.activity = context;
    }

    public  void onBackPressed(){
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }
        if (System.currentTimeMillis()<=backKeyPressedTime +2000){
            activity.finish();
            toast.cancel();
        }
    }

    public void showGuide(){
        toast = Toast.makeText(activity," 뒤로 버튼을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT);
        toast.show();
    }

}
