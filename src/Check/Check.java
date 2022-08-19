package Check;

import Main.MainApp;

public class Check {
    public static boolean Check(String ScanIP,Integer start,Integer end){
        //端口范围满足要求

        if(Ping.Ping(ScanIP)==false){
            MainApp.getText(ScanIP+"连接失败");
            return false;
        }

        if(end-start<0||start<=0||end<=0||start>65535||end>65535){
            MainApp.getText("端口输入范围有误");
            return false;
        }

        return true;
    }


}
