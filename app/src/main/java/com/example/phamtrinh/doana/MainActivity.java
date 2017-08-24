package com.example.phamtrinh.doana;


import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class MainActivity extends AppCompatActivity implements FragmentListener,FragmentData {

    FragmentManager fragmentManager = getFragmentManager();
    private FragmentListener listener;

    private DrawerLayout mDrawerLayout;

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private MenuItem itemNoti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListScreen();
        ConnServer cs = new ConnServer();
        cs.mSocket.connect();

        toolbar = (Toolbar) findViewById(R.id.tool_bar);


        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment seclectScreen = null;
                switch (item.getItemId()) {
                    case R.id.action_item_home:
                        seclectScreen = new ListScreen();
                        break;
                    case R.id.action_item_library:
                        seclectScreen = new LibraryScreen();
                        break;
                    case R.id.action_item_account:
                        seclectScreen = new UserScreen();
                        break;
                }


                FragmentTransaction fragmentTransactionList = fragmentManager.beginTransaction();
                fragmentTransactionList.replace(R.id.frameContent, seclectScreen);

                fragmentTransactionList.commit();
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar, menu);
        itemNoti = menu.findItem(R.id.action_noti);
        itemNoti.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_noti) {

            mDrawerLayout.openDrawer(Gravity.RIGHT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addListScreen() {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new ListScreen());
        fragmentTransaction.commit();

    }


    @Override
    public void changeFragment(int id) {
        switch (id) {
            case 1:

                FragmentTransaction fragmentTransactionList = fragmentManager.beginTransaction();
                fragmentTransactionList.replace(R.id.frameContent, new ListScreen());
                fragmentTransactionList.addToBackStack("listscreen");
                fragmentTransactionList.commit();
                break;
            case 2:
                FragmentTransaction fragmentTransactionUser = fragmentManager.beginTransaction();
                fragmentTransactionUser.replace(R.id.frameContent, new UserScreen());
                fragmentTransactionUser.addToBackStack("userscreen");
                fragmentTransactionUser.commit();
                break;
            case 3:

                FragmentTransaction fragmentTransactionSearch = fragmentManager.beginTransaction();
                fragmentTransactionSearch.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_right);
                fragmentTransactionSearch.replace(R.id.frameContent, new SearchScreen());
                fragmentTransactionSearch.addToBackStack("searchscreen");
                fragmentTransactionSearch.commit();


                break;
            case 4:
                FragmentTransaction fragmentTransactionLibrary = fragmentManager.beginTransaction();
                fragmentTransactionLibrary.replace(R.id.frameContent, new LibraryScreen());
                fragmentTransactionLibrary.addToBackStack("libraryscreen");
                fragmentTransactionLibrary.commit();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            toolbar.setNavigationIcon(R.drawable.ic_search_black_24dp);

            getFragmentManager().popBackStack();
        } else {

            super.onBackPressed();

        }
    }

    @Override
    public void transDataString(String dataString) {

        Bundle bundle = new Bundle();
        bundle.putString("databook", dataString);
        ReadBook readBook = new ReadBook();
        readBook.setArguments(bundle);
        FragmentTransaction fragmentTransactionRead = fragmentManager.beginTransaction();
        fragmentTransactionRead.replace(R.id.frameContent, readBook);
        fragmentTransactionRead.addToBackStack("readbook");
        fragmentTransactionRead.commit();


    }

    @Override
    public void transDataArray(final String[] dataArr) {
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                toolbar.setNavigationIcon(null);
//
//                Bundle bundle = new Bundle();
//                bundle.putStringArray("dataname",dataArr);
//                SearchScreen searchScreen = new SearchScreen();
//                searchScreen.setArguments(bundle);
//                FragmentTransaction fragmentTransactionSearch = fragmentManager.beginTransaction();
//                fragmentTransactionSearch.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_right);
//                fragmentTransactionSearch.replace(R.id.frameContent, searchScreen);
//                fragmentTransactionSearch.addToBackStack("searchscreen");
//                fragmentTransactionSearch.commit();
//            }
//        });


    }
}
