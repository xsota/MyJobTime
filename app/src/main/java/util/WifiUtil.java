package util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by kawanoanna on 2016/12/27.
 */

public class WifiUtil {


    /**
     * 現在接続しているwifi取得
     * @return
     */
    public static String[] getWifi(Context context) {
        WifiManager manager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        String[] apInfo = new String[4];
        //　SSIDを取得
        apInfo[0] = String.format("SSID : %s", info.getSSID());
        // IPアドレスを取得
        int ipAdr = info.getIpAddress();
        apInfo[1] = String.format("IP Adrress : %02d.%02d.%02d.%02d",
                (ipAdr >> 0) & 0xff, (ipAdr >> 8) & 0xff, (ipAdr >> 16) & 0xff, (ipAdr >> 24) & 0xff);
        // MACアドレスを取得
        apInfo[2] = String.format("MAC Address : %s", info.getMacAddress());
        // 受信信号強度&信号レベルを取得
        int rssi = info.getRssi();
        int level = WifiManager.calculateSignalLevel(rssi, 5);
        apInfo[3] = String.format("RSSI : %d / Level : %d/4", rssi, level);

        return apInfo;
    }
}
