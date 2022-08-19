package Method;

public class ChoseMethod {
    public static void ChoseMethod(String ScanIP,Integer start,Integer end){

        Tcp Scan=new Tcp();
        Scan.Tcp(ScanIP,start,end);

    }
}
