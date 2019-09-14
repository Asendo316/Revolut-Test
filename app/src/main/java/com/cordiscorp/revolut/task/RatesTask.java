package com.cordiscorp.revolut.task;

import com.cordiscorp.revolut.callback.Callback;
import com.cordiscorp.revolut.connectivity.RatesAPIUtils;
import com.cordiscorp.revolut.connectivity.models.GetRates;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Ibkunle Adeoluwa on 9/11/2019.
 */
public class RatesTask {

    public static void getRates(final Callback<GetRates> callback, String base) {

        RatesAPIUtils.getRatesAPIInstance()
                .getRates(base)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<GetRates>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetRates getRates) {
                        callback.returnResult(getRates);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.returnError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
