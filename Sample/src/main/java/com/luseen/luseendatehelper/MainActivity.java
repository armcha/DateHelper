package com.luseen.luseendatehelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.luseen.datelibrary.DateHelper;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView currentDate,getDay,getMonthLongName,getHour,getDayOfTheWeek,getMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentDate = (TextView) findViewById(R.id.current_day);
        getMonthLongName = (TextView) findViewById(R.id.get_mont_long_name);
        getDay = (TextView) findViewById(R.id.get_day);
        getHour = (TextView) findViewById(R.id.get_hour);
        getDayOfTheWeek = (TextView) findViewById(R.id.get_day_of_week);
        getMonth = (TextView) findViewById(R.id.get_month);

        currentDate.setText(new Date().toString());

        DateHelper dateHelper = new DateHelper(new Date());
        getDay.setText(dateHelper.getDay());
        getMonthLongName.setText(dateHelper.getMonthLongName());
        getHour.setText(dateHelper.getHour());
        getDayOfTheWeek.setText(dateHelper.getDayOfTheWeek());
        getMonth.setText(dateHelper.getMonth());
    }
}
