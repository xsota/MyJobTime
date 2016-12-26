package activity;

import android.databinding.DataBindingUtil;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.anna.myjobtime.R;
import com.anna.myjobtime.databinding.ActivityMainBinding;

import util.WifiUtil;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);
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
}
