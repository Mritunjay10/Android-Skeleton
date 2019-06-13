package in.indilabz.skeleton.rest;

/**
 * Created by mjdem on 22-05-2018.
 */

public interface RetrofitListener {

    void onDataReceived(int code, boolean success, String value, int method);
}
