package edreamz.mandoob;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import edreamz.mandoob.fragment.Aboutfragment;
import edreamz.mandoob.fragment.Calendarfragment;
import edreamz.mandoob.fragment.CancelPolicyfragment;
import edreamz.mandoob.fragment.Changepasswordfragment;
import edreamz.mandoob.fragment.Dashboardfragment;
import edreamz.mandoob.fragment.Faqfragment;
import edreamz.mandoob.fragment.Homefragment;
import edreamz.mandoob.fragment.Logoutfragment;
import edreamz.mandoob.fragment.Myprofilefragment;
import edreamz.mandoob.fragment.TermsandConditionfragment;
import edreamz.mandoob.fragment.Time_allocationfragment;
import edreamz.mandoob.fragment.ViewRequestfragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.WHITE));
        navigationView.setNavigationItemSelectedListener(this);
        displaySelectedScreen(R.id.home_page);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

    private void displaySelectedScreen(int id) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;

        if (id == R.id.home_page) {
            fragment = new Homefragment();

        } else if (id == R.id.dashboard) {
            fragment = new Dashboardfragment();

        } else if (id == R.id.view_request) {
            fragment = new ViewRequestfragment();

        } else if (id == R.id.my_profile) {
            fragment = new Myprofilefragment();

        } else if (id == R.id.change_password) {
            fragment = new Changepasswordfragment();

        } else if (id == R.id.terms_conditions) {
            fragment = new TermsandConditionfragment();

        } else if (id == R.id.privacy_policy) {
            fragment = new Calendarfragment();

        } else if (id == R.id.refund_policy) {
            fragment = new Time_allocationfragment();

        } else if (id == R.id.cancel_policy) {
            fragment = new CancelPolicyfragment();

        } else if (id == R.id.faqs) {
            fragment = new Faqfragment();

        } else if (id == R.id.about) {
            fragment = new Aboutfragment();

        } else if (id == R.id.logout) {
            fragment = new Logoutfragment();
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

}
