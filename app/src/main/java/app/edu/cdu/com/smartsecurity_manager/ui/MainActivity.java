package app.edu.cdu.com.smartsecurity_manager.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import app.edu.cdu.com.smartsecurity_manager.R;
import app.edu.cdu.com.smartsecurity_manager.adapter.DrawerFragmentPagerAdapter;
import app.edu.cdu.com.smartsecurity_manager.adapter.DrawerItemsAdapter;
<<<<<<< Updated upstream
import app.edu.cdu.com.smartsecurity_manager.utils.CommonViewHolder;
=======
import app.edu.cdu.com.smartsecurity_manager.fragment.FlowManageFragment;
import app.edu.cdu.com.smartsecurity_manager.fragment.HistoryManageFragment;
import app.edu.cdu.com.smartsecurity_manager.fragment.NewsManageFragment;
import app.edu.cdu.com.smartsecurity_manager.fragment.PluginManageFragment;
>>>>>>> Stashed changes

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private static final int UN_CHOOSE_COLOR = 0xff3f51b5;
    private static final int CHOOSE_COLOR = 0xff47479f;
    private static final int DEVICE = 0;
    private static final int CONTACT = 1;
    private static final int MESSAGE = 2;
    private Fragment fragment;
    private FragmentManager fm = getSupportFragmentManager();
    private DrawerLayout mDrawerLayout;
    private ViewPager mViewPager;
    private ImageView mUserAvatarOnTopBar;
    private ImageView mUserAvatarIv;
    private RadioGroup mBottomBarRadioGroup;
    private TextView mCurrentFragmentNameTv;
    private SearchView mSearchView;
<<<<<<< Updated upstream
    private ExpandableListView mDrawerItemsElv;

=======
    private ExpandableListView mDrawerItemsExpandableListView;
>>>>>>> Stashed changes
    private int[] mFragmentName = new int[] {R.string.device, R.string.contact, R.string.message};
    private List<RadioButton> mRadioButtonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupAdapters();
        setupListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSearchView.clearFocus();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void initViews() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mUserAvatarOnTopBar = (ImageView) findViewById(R.id.userAvatarOnTopBar_ImageView);
        mUserAvatarIv = (ImageView) findViewById(R.id.userAvatar_ImageView);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        changeSearchViewStyle();

        mCurrentFragmentNameTv = (TextView) findViewById(R.id.currentFragmentName_textView);
        mCurrentFragmentNameTv.setText(R.string.device);

        mDrawerItemsElv =
                (ExpandableListView) findViewById(R.id.drawerItems_expandableListView);
        mDrawerItemsElv.setGroupIndicator(null);
        mDrawerItemsElv.setDivider(null);
        mBottomBarRadioGroup = (RadioGroup) findViewById(R.id.bottomBar_RadioGroup);

        RadioButton radioButton = (RadioButton) findViewById(R.id.device_radioButton);
        radioButton.setBackgroundColor(CHOOSE_COLOR);
        mRadioButtonList.add(DEVICE, radioButton);
        radioButton = (RadioButton) findViewById(R.id.contact_radioButton);
        mRadioButtonList.add(CONTACT, radioButton);
        radioButton = (RadioButton) findViewById(R.id.message_radioButton);
        mRadioButtonList.add(MESSAGE, radioButton);
    }

    private void setupAdapters() {
        DrawerItemsAdapter drawerItemsAdapter = new DrawerItemsAdapter(this);
        mDrawerItemsElv.setAdapter(drawerItemsAdapter);
        DrawerFragmentPagerAdapter drawerFragmentPagerAdapter =
                new DrawerFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(drawerFragmentPagerAdapter);
    }

    private void setupListeners() {

        mUserAvatarIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SingleFragmentActivity.class);
                startActivity(intent);
            }
        });

        mUserAvatarOnTopBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switchCurrentState(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBottomBarRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                int current;
                switch (i) {
                    case R.id.device_radioButton:
                        current = DEVICE;
                        break;
                    case R.id.contact_radioButton:
                        current = CONTACT;
                        break;
                    case R.id.message_radioButton:
                        current = MESSAGE;
                        break;
                    default:
                        current = DEVICE;
                        break;
                }
                switchCurrentState(current);
            }
<<<<<<< Updated upstream
        });
        mDrawerItemsElv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
=======
        });;

        mDrawerItemsExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
>>>>>>> Stashed changes
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                skipToChild(groupPosition, childPosition);
                return true;
            }
        });
    }

    private void skipToChild(int groupPosition, int childPosition) {
<<<<<<< Updated upstream
        if (groupPosition != DrawerItemsAdapter.EXPANDABLE_POSITION) {
            return;
        }
        Intent intent = SettingActivity.newInstance(this, childPosition);
        startActivity(intent);
=======
                switch (childPosition) {

                    case DrawerItemsAdapter.ACCOUNT_MANAGE:
                        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(intent);
                        break;

                    case DrawerItemsAdapter.MESSAGE_MANAGE:
                        setContentView(R.layout.activity_mysetting);
                        if (fragment == null) {
                            fragment = new NewsManageFragment();
                            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
                        }
                        break;

                    case DrawerItemsAdapter.DATA_MANAGE:
                        setContentView(R.layout.activity_mysetting);
                        if (fragment == null) {
                            fragment = new FlowManageFragment();
                            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
                        }
                        break;

                    case DrawerItemsAdapter.HISTORY_MANAGE:
                        setContentView(R.layout.activity_mysetting);
                        fragment = new HistoryManageFragment();
                        fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
                        break;

                    case DrawerItemsAdapter.PRIVACY_MANAGE:

                        break;

                    case DrawerItemsAdapter.PLUGIN_MANAGE:
                        setContentView(R.layout.activity_mysetting);
                        fragment = new PluginManageFragment();
                        fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
                        break;

                    default:
                        break;
                }
>>>>>>> Stashed changes
    }

    private void switchCurrentState(int current) {
        resetBackgroundColor();
        mRadioButtonList.get(current).setBackgroundColor(CHOOSE_COLOR);
        mCurrentFragmentNameTv.setText(mFragmentName[current]);
        mViewPager.setCurrentItem(current);
    }

    private void resetBackgroundColor() {
        for (int i = 0; i < mRadioButtonList.size(); i++) {
            mRadioButtonList.get(i).setBackgroundColor(UN_CHOOSE_COLOR);
        }
    }

    private void changeSearchViewStyle() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        mSearchView.setBackground(getDrawable(R.drawable.search_view));
        try {
            Class<?> searchViewClass = mSearchView.getClass();
            Field field = searchViewClass.getDeclaredField("mSearchPlate");
            field.setAccessible(true);
            View view = (View) field.get(mSearchView);
            view.setBackground(null);
            field.setAccessible(false);
        } catch (NoSuchFieldException ne) {
            Log.e(TAG, "get field ", ne);
        } catch (IllegalAccessException iae) {
            Log.e(TAG, "field.get() ", iae);
        }
    }
}
