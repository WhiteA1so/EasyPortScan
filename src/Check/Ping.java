package Check;

import java.io.IOException;
import java.net.InetAddress;

public class Ping {
    public static boolean Ping(String ScanIP){

        int timeOut=3000;

        boolean status;
        try {
            status = InetAddress.getByName(ScanIP).isReachable(timeOut);
        } catch (IOException e) {
            return false;
        }
        // 当返回值是true时，说明host是可用的，false则不可。
        return status;

    }
}
