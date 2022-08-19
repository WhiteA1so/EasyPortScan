package Method;

import Main.MainApp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Tcp {


    //传入IP地址
    public void Tcp(String ScanIP,int StartPort,int EndPort){

        TcpMethod TcpRun=new TcpMethod();
        TcpRun.get(ScanIP,StartPort,EndPort);

        //多线程设置，之所以不使用线程池是发现根本没有必要。
        for(int i=0;i<=10;i++) {
            new Thread(TcpRun).start();

        }

    }



    public class TcpMethod implements Runnable{

        public String ScanIP;
        public Integer start;
        public Integer end;

        public void get(String ScanIP,int StratPort,int EndPort){
            this.ScanIP=ScanIP;
            this.start=StratPort;
            this.end=EndPort;

        }



    @Override
    public void run() {

            int Scanport;
        long stime = System.currentTimeMillis();
        while (true){
            if(end<=start){
                break;
            }

            synchronized(this){ Scanport=end;
                end--;}

            IsPortTrue(ScanIP,Scanport);

        }
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d毫秒.", (etime - stime));

        }

    boolean IsPortTrue(String ip,Integer port){

        Socket socket=new Socket();

        try{
            socket.connect(new InetSocketAddress(ip,port),1000);
        }catch (IOException error){
            return false;
        }finally {
            try {
                socket.close();
            }catch (IOException error){
                System.out.println(error);
            }
        }

        MainApp.getText(ip+":"+port+"Open");
        return true;
    }


    }
}
