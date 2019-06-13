package in.indilabz.skeleton.utils;

import org.greenrobot.eventbus.EventBus;

public class EventMessage {

    private int code;
    private String message;

    public EventMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void postEvent(int code, String value){

        EventBus.getDefault().postSticky(new EventMessage(code,
                value));
    }
}
