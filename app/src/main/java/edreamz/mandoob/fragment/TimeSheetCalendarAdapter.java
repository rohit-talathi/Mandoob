package edreamz.mandoob.fragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import edreamz.mandoob.R;

/**
 * Created by root on 3/9/16.
 */
public class  TimeSheetCalendarAdapter extends BaseAdapter {
 ArrayList<String> data = new ArrayList<String>();
 ArrayList<String> events = new ArrayList<String>();
 ArrayList<String> cal= new ArrayList<String>();
 ArrayList<String> holiday= new ArrayList<String>();
 ArrayList<String> Weekdaylist= new ArrayList<String>();

 Context context;
 Calendar cc,c;
 final static String[]weekdays={"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
 public int extraCount=0;

 TimeSheetCalendarAdapter(Context context, ArrayList<String> data, ArrayList<String> events, String month, ArrayList<String> holidays, ArrayList<String> weekends){
  this.context=context;this.data=data;this.events=events;this.holiday=holidays;
  this.Weekdaylist=weekends;
  //Current Date
  cc= Calendar.getInstance();
  //Set to 1day of Selected Month
  c= Calendar.getInstance();
  try {
   c.setTime(new SimpleDateFormat("dd-MMMM-yyyy", Locale.US).parse("01-"+month));
  }
  catch (ParseException e){e.printStackTrace();}
  //Calculate Index of WeekDay of 1st Date of Month and Add Weekday's to Top Calendar
  int wdindex=-1;
  for(int i=0;i<weekdays.length;i++) {
   if(weekdays[i].equalsIgnoreCase(c.getDisplayName(c.DAY_OF_WEEK, Calendar.SHORT, Locale.US)))
    wdindex=i;
   cal.add(weekdays[i]);
  }
  //Depending on Weekday of 1st Day of Month add Spaces
  for(int i=0;i<wdindex;i++)
  cal.add("");
  Log.i("Max Date",""+c.getActualMaximum(Calendar.DAY_OF_MONTH));
  Log.i("Month",""+c.get(Calendar.MONTH));
  Log.i("Year",""+c.get(Calendar.YEAR));
  //Add rest of the Calender Days
  /*for(int i=1;i<=c.getActualMaximum(Calendar.DAY_OF_MONTH);i++)
   cal.add(String.valueOf(i));*/
  for(int i=0;i<data.size();i++)
   cal.add(data.get(i));
  //Calculate no of Rows (Dividing BY 7)
  int rows=(cal.size())/7;
  //If Rows are less then Actual Size add 1 more row
  if(rows*7<cal.size())
   rows=rows+1;
  //Calculate Difference in Actual Size & Expected Size & Accordingly add spaces
  int mod=rows*7-cal.size();
  for(int i=0;i<mod;i++)
  cal.add("");

  extraCount=weekdays.length+wdindex;
 }

 @Override
 public int getCount() {
  return cal.size();
 }

 @Override
 public Object getItem(final int pos) {
  return cal.get(pos);
 }

 @Override
 public long getItemId(int position) {
  return 0;
 }

 @Override
 public View getView(final int pos, View convertView, ViewGroup parent) {
  LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  //Header Row
  if(pos<=6){
   convertView=inflater.inflate(R.layout.view_cal_weekdays,null);
   final TextView cal_weekday=(TextView) convertView.findViewById(R.id.txt_cal_weekday);
   cal_weekday.setText(getItem(pos).toString().split(";")[0]);
  }
  else {
   convertView = inflater.inflate(R.layout.view_cal_timesheet_date, null);
   final TextView cal_date = (TextView) convertView.findViewById(R.id.txt_cal_timesheet_date);
//   final TextView hours = (TextView) convertView.findViewById(R.id.txt_cal_timesheet_hours);
//   final TextView status = (TextView) convertView.findViewById(R.id.txt_cal_timesheet_status);
   if(getItem(pos).toString().length() == 0)
    cal_date.setText("");
   else
    cal_date.setText(getItem(pos).toString().split(";")[0].split("-")[0].split(" ")[1]);
   //Don't Show Image & Status If Blank or Header Row
   if(getItem(pos).toString().length() == 0) {
//    hours.setVisibility(View.INVISIBLE);
//    status.setVisibility(View.INVISIBLE);
   }
   else {
//    hours.setVisibility(View.VISIBLE);
//    status.setVisibility(View.VISIBLE);
//    hours.setText(getItem(pos).toString().split(";")[1]);
//    status.setText(getItem(pos).toString().split(";")[2]);
    /*if(pos%13==0)
    status.setText("Approved");*/
//    status.setTextColor(context.getResources().getColor(context.getResources().getIdentifier(status.getText().toString().replaceAll(" ","")+"Color","color",context.getPackageName())));
    //Code To HighLight Today's Date
    if(cc.get(Calendar.MONTH)==c.get(Calendar.MONTH) && cc.get(Calendar.YEAR)==c.get(Calendar.YEAR) &&
     cc.get(Calendar.DATE)== Integer.parseInt(getItem(pos).toString().split(";")[0].split("-")[0].split(" ")[1])){
     convertView.setBackgroundResource(R.drawable.cal_bg_orange);

//   cal_date.setTextColor(Color.WHITE);
//     hours.setTextColor(Color.WHITE);
//     status.setShadowLayer(3,2,1,Color.WHITE);
    }
    else if(checkEvent(getItem(pos).toString().split(";")[0].trim())){
//     convertView.setBackgroundResource(R.drawable.cal_bg_green);
     cal_date.setTextColor(Color.RED);
//     hours.setTextColor(Color.WHITE);
//     status.setShadowLayer(3,2,1,Color.WHITE);
    }
    else if(checkEvent1(getItem(pos).toString().split(";")[0].trim())){
     convertView.setBackgroundResource(R.drawable.cal_bg_yellow);
     cal_date.setTextColor(Color.WHITE);
//     hours.setTextColor(Color.WHITE);
//     status.setShadowLayer(3,2,1,Color.WHITE);
    }else if(checkEvent2(getItem(pos).toString().split(";")[0].trim())){
//     convertView.setBackgroundResource(R.drawable.cal_bg_blue);
     cal_date.setTextColor(Color.RED);
//     hours.setTextColor(Color.WHITE);
//     status.setShadowLayer(3,2,1,Color.WHITE);
    }
   }
  }
  return convertView;
 }

  boolean checkEvent1(String trim) {
  for(int i=0;i<holiday.size();i++)
   if(trim.contains(holiday.get(i)))
    return true;
  return false;
 }

 boolean checkEvent(String s){
  for(int i=0;i<events.size();i++)
  if(s.contains(events.get(i)))
  return true;
  return false;
 }

 boolean checkEvent2(String s){
  for(int i=0;i< Weekdaylist.size();i++)
   if(s.contains(Weekdaylist.get(i)))
    return true;
  return false;
 }
}