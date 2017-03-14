package lofft.navigationdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
        TextView email = (TextView)hView.findViewById(R.id.textView_email);
        TinyDB tinyDB = new TinyDB(getApplicationContext());
        String emailstr = tinyDB.getString("email");
        email.setText(emailstr);

        int count = email.getLineCount();
        //Toast.makeText(MainActivity.this, "There are " + count + " lines", Toast.LENGTH_SHORT).show();

        String source = tinyDB.getString("Source");
        String change = tinyDB.getString("Change");


        switch(source) {

            case "login":

                HomeFragment homeFragment = new HomeFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relative_layout_for_fragment, homeFragment, homeFragment.getTag()).commit();
                break;

            case "settings":

                switch (change){

                    case "name":
                        ChangeNameFragment changeNameFragment = new ChangeNameFragment();
                        manager = getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.relative_layout_for_fragment,changeNameFragment,changeNameFragment.getTag()).commit();
                        break;
                    case "email":
                        ChangeEmailFragment changeEmailFragment = new ChangeEmailFragment();
                        manager = getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.relative_layout_for_fragment,changeEmailFragment,changeEmailFragment.getTag()).commit();
                        break;

                    case "password":
                        ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
                        manager = getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.relative_layout_for_fragment,changePasswordFragment,changePasswordFragment.getTag()).commit();
                        break;
                    default:
                        SettingsFragment settingsFragment = new SettingsFragment();
                        manager = getSupportFragmentManager();
                        manager.beginTransaction().replace(R.id.relative_layout_for_fragment,settingsFragment,settingsFragment.getTag()).commit();
                        break;
                }

                break;

            case "bid":

                BidFragment bidFragment = new BidFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relative_layout_for_fragment,bidFragment,bidFragment.getTag()).commit();

                break;

            case "Message":

                MessagesFragment messagesFragment = new MessagesFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relative_layout_for_fragment,messagesFragment,messagesFragment.getTag()).commit();
                break;

            default:
                Toast.makeText(this, "Default", Toast.LENGTH_SHORT).show();
                homeFragment = new HomeFragment();
                manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.relative_layout_for_fragment, homeFragment, homeFragment.getTag()).commit();




        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_addposting) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(1).setChecked(true);
            AddPostingFragment addPostingFragment = new AddPostingFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,addPostingFragment,addPostingFragment.getTag()).commit();


        } else if(id == R.id.nav_home) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(0).setChecked(true);
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,homeFragment,homeFragment.getTag()).commit();

        } else if (id == R.id.nav_register) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(2).setChecked(true);
            RegisterFragment registerFragment = new RegisterFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment, registerFragment,registerFragment.getTag()).commit();
        } else if (id == R.id.nav_profile) {

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(3).setChecked(true);
            FragmentManager manager = getSupportFragmentManager();
            ProfileFragment profileFragment = new ProfileFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment, profileFragment, profileFragment.getTag()).commit();




        } else if (id == R.id.nav_exchanges) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(4).setChecked(true);
            FragmentManager manager= getSupportFragmentManager();
            ExchangeFragment exchangeFragment = new ExchangeFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,exchangeFragment,exchangeFragment.getTag()).commit();
        } else if (id == R.id.nav_messages) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(5).setChecked(true);
            FragmentManager manager = getSupportFragmentManager();
            MessagesFragment messagesFragment = new MessagesFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,messagesFragment,messagesFragment.getTag()).commit();
        } else if (id == R.id.nav_postings) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(6).setChecked(true);
            FragmentManager manager = getSupportFragmentManager();
            PostingsFragment postingsFragment = new PostingsFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,postingsFragment,postingsFragment.getTag()).commit();

        } else if(id == R.id.nav_bids) {
            NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(7).setChecked(true);
            FragmentManager manager = getSupportFragmentManager();
            BidsFragment bidsFragment = new BidsFragment();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,bidsFragment,bidsFragment.getTag()).commit();





        } else if (id == R.id.nav_settings) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(8).setChecked(true);
            SettingsFragment settingsFragment = new SettingsFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.relative_layout_for_fragment,settingsFragment,settingsFragment.getTag()).commit();
        } else if (id == R.id.nav_group) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(9).setChecked(true);
            Toast.makeText(this, "My Groups", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_grppostings) {
            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.getMenu().getItem(10).setChecked(true);
            Toast.makeText(this, "Group Postings", Toast.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
