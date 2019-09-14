package com.cordiscorp.revolut;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.test.InstrumentationRegistry;

import com.cordiscorp.revolut.connectivity.ConnectionManager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ibkunle Adeoluwa on 8/20/2019.
 */
public class ConnectionManagerTest {
    Context context = InstrumentationRegistry.getTargetContext();

    @Test
    public void isNetworkAvailable() {
        ConnectionManager connectionManager = new ConnectionManager(context);
        assertEquals(connectionManager.isNetworkAvailable(), testIsNetworkAvailable());
    }

    public boolean testIsNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}