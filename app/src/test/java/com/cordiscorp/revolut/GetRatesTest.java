package com.cordiscorp.revolut;

import com.cordiscorp.revolut.connectivity.RatesAPIUtils;
import com.cordiscorp.revolut.connectivity.models.GetRates;

import org.junit.Test;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ibkunle Adeoluwa on 9/14/2019.
 */
public class GetRatesTest {
    @Test
    public void getRates() {

        RatesAPIUtils.getRatesAPIInstance()
                .getRates("USD")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetRates>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(GetRates getRates) {
                        assertTrue(getRates.getBase() == "USD");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }
}
