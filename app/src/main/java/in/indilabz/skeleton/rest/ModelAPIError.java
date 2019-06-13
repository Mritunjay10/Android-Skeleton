package in.indilabz.skeleton.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAPIError {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private Object result;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
