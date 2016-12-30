package activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import fragment.PageFragment;
import me.rmrf.myjobtime.R;
import me.rmrf.myjobtime.databinding.ActivityMainBinding;

import util.WifiUtil;
import views.adapters.FragmentPagerAdapter;

public class MainActivity  extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener, PageFragment.OnFragmentInteractionListener{

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

        setWifiStatus(WifiUtil.getWifi(this));

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
                setWifiStatus(WifiUtil.getWifi(this));
                Snackbar.make(view, "読んだ", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                break;
        }
    }

    private void setWifiStatus(String[] apInfo){
        if(apInfo.length == 0){return;}

        binding.contentMain.ssid.setText(apInfo[0]);
        binding.contentMain.ip.setText(apInfo[1]);
        binding.contentMain.mac.setText(apInfo[2]);
        binding.contentMain.rssi.setText(apInfo[3]);

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
