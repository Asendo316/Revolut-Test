package com.cordiscorp.revolut.contracts;

import com.cordiscorp.revolut.connectivity.models.GetRates;
import com.cordiscorp.revolut.connectivity.models.RatesModel;

import java.util.List;

/**
 * Created by Ibkunle Adeoluwa on 8/28/2019.
 */
public class RatesContracts {

    public interface Model {

        interface OnCompletedListener {
            void onSuccess(GetRates getRates);

            void onLoginError(String message);

            void onLoginFailure(Throwable t);
        }
    }

    public interface View {
        void showProgress();

        void hideProgress();

        void onInit();

        void showRates(List<RatesModel> getRates);

        void onFailed(Throwable throwable);

        void showError(String message);
    }

    public interface Presenter {

        void onDestroy();

        void onStart();

        void loadRates(String base);

    }
}
