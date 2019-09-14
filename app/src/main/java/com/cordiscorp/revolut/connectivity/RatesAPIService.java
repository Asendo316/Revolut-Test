package com.cordiscorp.revolut.connectivity;


import com.cordiscorp.revolut.connectivity.models.GetRates;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ibkunle Adeoluwa on 8/19/2019.
 */
public interface RatesAPIService {
    @GET("latest")
    Observable<GetRates> getRates(@Query("base") String base);
}
