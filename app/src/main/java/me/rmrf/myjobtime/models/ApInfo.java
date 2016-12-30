package me.rmrf.myjobtime.models;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import static android.content.Context.WIFI_SERVICE;

/**
 * Created by kawanoanna on 2016/12/31.
 */

public class ApInfo {

    private String Ssid;
    private int IpAdr;
    private String MacAdr;
    private int Rssi;

    /* コンストラクタ */
    public ApInfo(Context context) {

        WifiManager manager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        WifiInfo info = manager.getConnectionInfo();

        //　SSIDを取得
        Ssid = info.getSSID();

        // IPアドレスを取得
        IpAdr = info.getIpAddress();
//        String.format("IP Adrress : %02d.%02d.%02d.%02d", (ipAdr >> 0) & 0xff, (ipAdr >> 8) & 0xff, (ipAdr >> 16) & 0xff, (ipAdr >> 24) & 0xff);

        // MACアドレスを取得
        MacAdr = info.getMacAddress();

        // 受信信号強度&信号レベルを取得
        Rssi = info.getRssi();
    }


    public String getSsid() {
        return Ssid;
    }

    public void setSsid(String ssid) {
        Ssid = ssid;
    }

    public int getIpAdr() {
        return IpAdr;
    }

    public void setIpAdr(int ipAdr) {
        IpAdr = ipAdr;
    }

    public String getMacAdr() {
        return MacAdr;
    }

    public void setMacAdr(String macAdr) {
        MacAdr = macAdr;
    }

    public int getRssi() {
        return Rssi;
    }

    public void setRssi(int rssi) {
        Rssi = rssi;
    }

}
