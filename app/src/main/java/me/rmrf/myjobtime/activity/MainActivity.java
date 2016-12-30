package me.rmrf.myjobtime.activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import me.rmrf.myjobtime.fragment.CallenderFragment;
import me.rmrf.myjobtime.fragment.JobTimeFragment;
import me.rmrf.myjobtime.R;
import me.rmrf.myjobtime.databinding.ActivityMainBinding;

import me.rmrf.myjobtime.fragment.CallenderFragment;
import me.rmrf.myjobtime.fragment.JobTimeFragment;
import me.rmrf.myjobtime.views.adapters.FragmentPagerAdapter;

public class MainActivity  extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener,
        JobTimeFragment.OnFragmentInteractionListener, CallenderFragment.OnFragmentInteractionListener {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());

        setSupportActionBar(binding.toolbar);

        // ViewPagerにページを設定
        binding.pager.setAdapter(adapter);
        binding.pager.addOnPageChangeListener(this);

        // ViewPagerをTabLayoutを設定
        binding.tabs.setupWithViewPager(binding.pager);

        setUpClickListener();

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpClickListener(){
        binding.fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Snackbar.make(view, "読んだ", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                break;
        }
    }




    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }


}
