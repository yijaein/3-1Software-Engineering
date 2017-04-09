package bscorp.appbase;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jan on 2017-01-26.
 */
public class Payment_app extends AppCompatActivity {//슬롯확장 버튼을 누르면 나오는 결제창
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);

    }
}
