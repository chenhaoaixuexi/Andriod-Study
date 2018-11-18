package study.ch.helloworld;


import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;


public class ServiceTest extends Service {
    public ServiceTest()
    {
        outputMessage("service construct begin");
    }
    // 标识服务如果被杀死后的行为
    int mStratMode;

    // bind sock of client
    IBinder mBlinder;

    // mark a flag that OnReBind is permissible to used
    boolean mAllowReBind;

    // when service is create
//    @Override
//    public void onCreate(Bundle saveInstanceState){
//        super.onCreate(saveInstanceState);
//        outputMessage("onCreate");
//    }

    // run servicingFunction
    @Override
    public int onStartCommand(Intent intent, int flag, int startId){
        outputMessage("onStartCommand");
        return mStratMode;
    }

    // bind service by function : bindService()
    @Override
    public IBinder onBind(Intent intent){
        outputMessage("onBind");
        return mBlinder;
    }

    // unblind all binder by Function: unblindService()
    @Override
    public boolean onUnbind(Intent intent){
        outputMessage("onUnbind");
        return mAllowReBind;
    }

    @Override
    public void onRebind(Intent intent){
        outputMessage("onRebind");
    }

    // destroy service
    @Override
    public void onDestroy(){
        outputMessage("onDestory");
    }
    private void outputMessage(String message){
        System.out.println(message);
        System.out.println("+++++++++++++++++++++++++");
    }
}

