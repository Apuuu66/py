package com.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/29
 */
public class State implements Serializable {
    private boolean success;
    private String message;

    public State(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
