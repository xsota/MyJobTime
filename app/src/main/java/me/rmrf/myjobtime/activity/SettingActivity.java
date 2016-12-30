package me.rmrf.myjobtime.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.rmrf.myjobtime.R;
import me.rmrf.myjobtime.databinding.ActivitySettingBinding;
import me.rmrf.myjobtime.models.ApInfo;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

        ApInfo apInfo = new ApInfo(this);
        binding.setApInfo(apInfo);

    }


}
