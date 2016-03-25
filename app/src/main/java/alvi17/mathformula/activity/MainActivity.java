package alvi17.mathformula.activity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import alvi17.mathformula.R;
import alvi17.mathformula.adapters.Custom_Drawer_Adapter;
import alvi17.mathformula.adapters.ViewPagerAdapter;
import alvi17.mathformula.model.DrawerItem;
import alvi17.mathformula.model.SlidingTabLayout;


public class MainActivity extends AppCompatActivity{

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private ArrayAdapter<String> mAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    List<DrawerItem> dataList;
    Custom_Drawer_Adapter adapter;

    ViewPager pager;
    ViewPagerAdapter pageradapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Algebra","Functions","Geometry","Derivatives","Integrals","Series"};
    int Numboftabs =6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageradapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pageradapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        //   tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.ColorPrimary);
            }

            @Override
            public int getDividerColor(int position) {
                // TODO Auto-generated method stub

                return getResources().getColor(R.color.tabDivider);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

        mDrawerList = (ListView)findViewById(R.id.navList);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        dataList = new ArrayList<DrawerItem>();

         // addDrawerItems();

        dataList.add(new DrawerItem("  Details Sections"));

        // adding a header to the list
        dataList.add(new DrawerItem("Algebra Formulas",R.drawable.ic_action_a ));
        dataList.add(new DrawerItem("Functions Formulas", R.drawable.ic_action_f));
        dataList.add(new DrawerItem("Geometry  Formulas", R.drawable.ic_action_g));
        dataList.add(new DrawerItem("Limits and Derivatives ", R.drawable.ic_action_l));
        dataList.add(new DrawerItem("Indefinite Integrals ", R.drawable.ic_action_i));
        dataList.add(new DrawerItem("Definite Integrals ", R.drawable.ic_action_d));
        dataList.add(new DrawerItem("Series Formulas ", R.drawable.ic_action_s));

        adapter = new Custom_Drawer_Adapter(this, R.layout.custom_drawer_item,
                dataList);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Choose Section");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mActivityTitle);
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

        Toast.makeText(getApplicationContext(),"Click top left icon for more details",Toast.LENGTH_LONG).show();
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
    public void SelectItem(int position) {
        Intent intent;
        switch(position) {
            case 1:
                 intent=new Intent(MainActivity.this,AlgebraActivity.class);
                startActivity(intent);
                finish();
                break;
            case 2:
                 intent=new Intent(MainActivity.this,FunctionsFormulasActivity.class);
                startActivity(intent);
                finish();
                break;
            case 3:
                intent=new Intent(MainActivity.this,Geometry.class);
                startActivity(intent);
                finish();
                break;
            case 4:
                intent=new Intent(MainActivity.this,Limit.class);
                startActivity(intent);
                finish();
                break;
            case 5:
                intent=new Intent(MainActivity.this,IndifiniteIntegrals.class);
                startActivity(intent);
                finish();
                break;
            case 6:
                intent=new Intent(MainActivity.this,DefiniteIntegrals.class);
                startActivity(intent);
                finish();
                break;
            case 7:
                intent=new Intent(MainActivity.this,Series.class);
                startActivity(intent);
                finish();
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
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("Exit");
        alert.setMessage("Do you want to exit?");
        alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        alert.setNegativeButton("Cancel",null);

        alert.show();
    }
}
