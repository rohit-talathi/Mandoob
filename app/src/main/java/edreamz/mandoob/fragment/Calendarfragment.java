package edreamz.mandoob.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import edreamz.mandoob.R;

public class Calendarfragment extends android.support.v4.app.Fragment {
    String sel_month = "";
    String sel_Adapter = "Time";
    //SharedPreferences pref;
    ArrayList<String> data = new ArrayList<String>();
    ArrayList<String> monthslist = new ArrayList<String>();
    ArrayList<String> events = new ArrayList<String>();
    ArrayList<String> holidays = new ArrayList<String>();
    ArrayList<String> Weekends = new ArrayList<String>();
    Typeface tf_awesome;
    TextView txt_month,date;
    GridView Grid_Cal;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);



        //pref = getSharedPreferences("type", Context.MODE_PRIVATE);
        final TextView pre = (TextView) view.findViewById(R.id.btn_previous);
        txt_month = (TextView) view.findViewById(R.id.txt_month);
        date=(TextView)view.findViewById(R.id.date);
        final TextView next = (TextView)view. findViewById(R.id.btn_next);
        Grid_Cal = (GridView)view. findViewById(R.id.grid_cust_calendar);
        final Calendar c = Calendar.getInstance();
        txt_month.setText(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + "-" + c.get(Calendar.YEAR));
//        tf_awesome = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
//
//        pre.setTypeface(tf_awesome);
//        next.setTypeface(tf_awesome);
        pre.setText(R.string.icon_pre_arrow_circle);
        next.setText(R.string.icon_next_arrow_circle);
        initHolidays();
        initweekends();
        initData(txt_month.getText().toString(), c.getActualMaximum(Calendar.DAY_OF_MONTH));
        //sel_Adapter = pref.getString("sel_type", "Time");
        Grid_Cal.setAdapter(new TimeSheetCalendarAdapter(getActivity(), data, events, txt_month.getText().toString(), holidays,Weekends));

  /*findViewById(android.R.id.home).setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
    if (sel_Adapter.equals("Time")) {
     pref.edit().putString("sel_type", "Attend").commit();
     sel_Adapter = pref.getString("sel_type", "Time");
     Grid_Cal.setAdapter(new AttendanceCalendarAdapter(CalendarActivity.this, data, txt_month.getText().toString()));
    } else if (sel_Adapter.equals("Attend")) {
     pref.edit().putString("sel_type", "Time").commit();
     sel_Adapter = pref.getString("sel_type", "Time");
     Grid_Cal.setAdapter(new TimeSheetCalendarAdapter(CalendarActivity.this, data, txt_month.getText().toString()));
    }
   }
  });*/

        //String mm=txt_month.getText().toString();
        Calendar cp = Calendar.getInstance();
        cp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 01);
        cp.add(cp.MONTH, -6);
        for (int i = 0; i < 12; i++) {
            monthslist.add(cp.getDisplayName(cp.MONTH, Calendar.LONG, Locale.US) + "-" + cp.get(Calendar.YEAR));
            cp.add(cp.MONTH, 1);
        }

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.add(c.MONTH, -1);
                txt_month.setText(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + "-" + c.get(Calendar.YEAR));
                Log.d("month",txt_month.getText().toString());
                if (sel_Adapter.equals("Time"))
                    Grid_Cal.setAdapter(new TimeSheetCalendarAdapter(getActivity(), data, events, txt_month.getText().toString(), holidays, Weekends));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.add(c.MONTH, 1);
                txt_month.setText(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + "-" + c.get(Calendar.YEAR));
                Log.d("month",txt_month.getText().toString());
                if (sel_Adapter.equals("Time"))
                    Grid_Cal.setAdapter(new TimeSheetCalendarAdapter(getActivity(), data, events, txt_month.getText().toString(), holidays, Weekends));
            }
        });

        txt_month.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                monthslist.clear();
                String mm = txt_month.getText().toString();
                Calendar cp = Calendar.getInstance();
                cp.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), 01);
//                Toast.makeText(CalendarActivity.this, ""+c.get(Calendar.), Toast.LENGTH_SHORT).show();
                initData(txt_month.getText().toString(), c.getActualMaximum(Calendar.DAY_OF_MONTH));
                cp.add(cp.MONTH, -6);
                for (int i = 0; i < 12; i++) {
                    monthslist.add(cp.getDisplayName(cp.MONTH, Calendar.LONG, Locale.US) + "-" + cp.get(Calendar.YEAR));
                    cp.add(cp.MONTH, 1);
                }
            }
        });

//  txt_month.setOnClickListener(new View.OnClickListener() {
//   @Override
//   public void onClick(View v) {
//    //Write Jump Code Using Popup
//    String[] months = new String[monthslist.size()];
//    months = monthslist.toArray(months);
//    AlertDialog.Builder builder = new AlertDialog.Builder(CalendarActivity.this);
//    builder.setSingleChoiceItems(months,months.length/2, new DialogInterface.OnClickListener() {
//     @Override
//     public void onClick(DialogInterface dialog, int which) {
//      sel_month = monthslist.get(which).toString();
//     }
//    });
//    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//     @Override
//     public void onClick(DialogInterface dialog, int which) {
//      try {
//       c.setTime(new SimpleDateFormat("MMMM-yyyy", Locale.US).parse(sel_month));
//      txt_month.setText(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US)+"-"+c.get(Calendar.YEAR));
//      if (sel_Adapter.equals("Time"))
//       Grid_Cal.setAdapter(new TimeSheetCalendarAdapter(CalendarActivity.this, data,events,txt_month.getText().toString()));
//      else if (sel_Adapter.equals("Attend"))
//       Grid_Cal.setAdapter(new AttendanceCalendarAdapter(CalendarActivity.this, data,txt_month.getText().toString()));
//      }
//      catch (ParseException e) {e.printStackTrace();}
//     }
//    });
//    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//     @Override
//     public void onClick(DialogInterface dialog, int which) {
//      dialog.cancel();
//     }
//    });
//    builder.show();
//   }
//  });

  Grid_Cal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> parent, View view, final int pos, long id) {
       if(Grid_Cal.getAdapter().getClass()==TimeSheetCalendarAdapter.class &&
     Grid_Cal.getAdapter().getItem(pos).toString().contains(";"))
      { 
     Log.i("pos",""+pos);
     String date1=Grid_Cal.getAdapter().getItem(pos).toString().split(",")[0];
     String day_date=date1.split(";")[0];
     date.setText(day_date);
        Toast.makeText(getActivity(), ""+date1, Toast.LENGTH_SHORT).show();
    }
  }});

        return view;
    }

    private void initweekends() {
        Weekends.clear();
        Weekends.add("Fri");

    }

    void initHolidays() {
        holidays.clear();
        holidays.add("15-August-2018");
        holidays.add("26-January-2018");
        holidays.add("31-July-2018");
    }



    void initData(String monthStr, int maxDate) {
        data.clear();
        for (int i = 0; i < maxDate; i++) {
            Date dd = null;
            try {
                String stat = (i % 11 == 0) ? "Approved" : "No Entry";
                dd = new SimpleDateFormat("dd-MMMM-yyyy").parse((i + 1) + "-" + monthStr);
                String ss = new SimpleDateFormat("EEE dd-MMMM-yyyy").format(dd);
                //Log.i("ss",ss);
                //data.add((i+1)+"-"+monthStr+";"+"00:00"+";"+stat);
                data.add(ss + ";" + "00:00" + ";" + stat);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
