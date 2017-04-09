package bscorp.appbase;

import android.app.Activity;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;

/**
 * Created by jan on 2017-04-09.
 */
public class WeatherAc extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        Geocoder t_Geocoder = new Geocoder(this);
        // for getFromLocation()
        // getFromLocation()함수를 이용하여 GeoPoint값을 지역 값으로 가져오는데 필요하다.
        // 오버로딩된 생성자의 두 번째 인자를 사용하여 언어 선택 가능하다(Locale).

        GeoPoint t_GeoPoint = new GeoPoint(37517292, 127037187);
        // location value for transform
        // 변환하고자 하는 GeoPoint 값이다.
        // http://www.mygeoposition.com/ 에서 값을 얻을 수 있다.


        GeoToWeather gtw = new GeoToWeather(t_Geocoder, t_GeoPoint);
        // for getWeather()


        Weather t_Weather = gtw.getWeather();
        // GeoPoint를 GeoCoder로 Reverse Geocoding한다.
        // 해당 지역의 날씨 정보를 Google API를 이용하여 Parsing한 후 Weather형으로 반환한다.

        String tStr = "날씨 = " + t_Weather.m_sCurrentState
                + "\n화씨 = " + t_Weather.m_nTempF
                + "\n섭씨 = " + t_Weather.m_nTempC
                + "\n지역 = " + t_Weather.m_sRegion
                + "\n습도 = " + t_Weather.m_sHumidity
                + "\n바람 = " + t_Weather.m_sWindCondition;


        TextView t_textview = new TextView(this);
        t_textview.setText(tStr);
        t_textview.setTextSize(30);

        setContentView(t_textview);


    }






}
