package com.anna.myjobtime;

import android.app.ListActivity;
import android.databinding.DataBindingUtil;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.anna.myjobtime.databinding.ActivityMainBinding;
import com.anna.myjobtime.databinding.ContentMainBinding;

import java.util.List;

public class MainActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "おした〜〜", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        WifiManager manager = (WifiManager)getSystemService(WIFI_SERVICE);
        if(manager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            // APをスキャン
            manager.startScan();
            // スキャン結果を取得
            List<ScanResult> apList = manager.getScanResults();
            String[] aps = new String[apList.size()];
            for(int i=0; i<apList.size(); i++) {
                aps[i] = "SSID:" + apList.get(i).SSID + "\n" + apList.get(i).frequency + "MHz " + apList.get(i).level + "dBm";
                binding.contentMain.text.setText(aps[i]);
            }
        }
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
}
