package com.cordiscorp.revolut.connectivity;

/**
 * Created by Ibkunle Adeoluwa on 9/11/2019.
 */
public class RatesAPIUtils {
    private static RatesAPIService ratesAPIService;

    public static RatesAPIService getRatesAPIInstance() {
        if (ratesAPIService == null)
            ratesAPIService = RatesAPIClient.getInstance().create(RatesAPIService.class);

        return ratesAPIService;
    }
}
