package alvi17.mathformula.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import alvi17.mathformula.R;
import alvi17.mathformula.adapters.Custom_Drawer_Adapter;
import alvi17.mathformula.fragments.Definite_Exponential;
import alvi17.mathformula.fragments.Definite_Logarithmic;
import alvi17.mathformula.fragments.Definite_Rational;
import alvi17.mathformula.fragments.Definite_Trigonometry_Advanced;
import alvi17.mathformula.fragments.Definite_Trigonomteric;
import alvi17.mathformula.model.DrawerItem;

/**
 * Created by Alvi17 on 6/29/2015.
 */
public class DefiniteIntegrals extends AppCompatActivity{
    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    List<DrawerItem> dataList;
    Custom_Drawer_Adapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.functions_formula);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.function_frame, new Definite_Rational()).commit();
        }
        mDrawerList = (ListView)findViewById(R.id.function_navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.function_drawer_layout);
        mActivityTitle = getTitle().toString();
        dataList = new ArrayList<DrawerItem>();
        getSupportActionBar().setTitle("Definite Integrals");
        // addDrawerItems();
        dataList.add(new DrawerItem("Home",  R.drawable.ic_action_action_account_balance));

        // adding a header to the list
        dataList.add(new DrawerItem("Rational Funtions", R.drawable.ic_action_r));
        dataList.add(new DrawerItem("Trigonometric Funtions -Basic",  R.drawable.ic_action_t));
        dataList.add(new DrawerItem("Trigonometric Funtions -Advanced",  R.drawable.ic_action_t));
        dataList.add(new DrawerItem("Exponential Funtions",  R.drawable.ic_action_e));
        dataList.add(new DrawerItem("Logarithmic Funtions",R.drawable.ic_action_l ));


        adapter = new Custom_Drawer_Adapter(this, R.layout.custom_drawer_item,
                dataList);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Select");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle("Definite Integrals");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //     setupDrawer();
        adapter = new Custom_Drawer_Adapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Toast.makeText(getApplicationContext(), "Click top left icon for more details", Toast.LENGTH_LONG).show();
    }
    public void SelectItem(int position) {

        switch(position) {
            case 0:
                Intent intent=new Intent(DefiniteIntegrals.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case 1:
                getFragmentManager().beginTransaction().replace(R.id.function_frame, new Definite_Rational()).commit();
                break;
            case 2:
                getFragmentManager().beginTransaction().replace(R.id.function_frame, new Definite_Trigonomteric()).commit();
                break;
            case 3:
                getFragmentManager().beginTransaction().replace(R.id.function_frame, new Definite_Trigonometry_Advanced()).commit();
                break;

            case 4:
                getFragmentManager().beginTransaction().replace(R.id.function_frame, new Definite_Exponential()).commit();
                break;
            case 5:
                getFragmentManager().beginTransaction().replace(R.id.function_frame, new Definite_Logarithmic()).commit();
                break;

//            case 11:
//            {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/search?q=appsspacess&c=apps"));
//                startActivity(browserIntent);
//                break;
//            }
        }
        mDrawerList.setItemChecked(position, true);
        setTitle(dataList.get(position).getItemName());
        mDrawerLayout.closeDrawer(mDrawerList);

    }
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {

            //	Toast.makeText(getApplicationContext(), "Clicked",Toast.LENGTH_LONG).show();
            if (dataList.get(position).getTitle() == null) {
                SelectItem(position);
            }
        }
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(DefiniteIntegrals.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
