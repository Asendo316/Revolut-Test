package com.cordiscorp.revolut.callback;

/**
 * Created by Ibkunle Adeoluwa on 9/11/2019.
 */

public abstract class Callback<T> {
    public abstract void returnResult(T t);
    public abstract void returnError(String message);
}
