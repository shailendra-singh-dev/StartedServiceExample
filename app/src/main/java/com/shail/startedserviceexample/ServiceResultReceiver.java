package com.shail.startedserviceexample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;

/**
 * Created by iTexico Developer on 7/5/2016.
 */
public class ServiceResultReceiver extends ResultReceiver {

    private Receiver receiver;

    // Constructor takes a handler
    public ServiceResultReceiver(Handler handler) {
        super(handler);
    }

    // Setter for assigning the receiver
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    // Defines our event interface for communication
    public interface Receiver {
        public void onReceiveResult(int resultCode, Bundle resultData);
    }

    // Delegate method which passes the result to the receiver if the receiver has been assigned
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        if (receiver != null) {
            receiver.onReceiveResult(resultCode, resultData);
        }
    }
}
