package com.dpwallet.wallet.util;

import android.content.Context;

import com.dpwallet.wallet.Constants;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author John L. Jegutanis
 */
public class NetworkUtils {
    private static OkHttpClient httpClient;
    private static OkHttpClient httpClient2;

    public static OkHttpClient getHttpClient(Context context) {
        if (httpClient == null) {
            httpClient = new OkHttpClient();
            httpClient.setConnectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS));
            httpClient.setConnectTimeout(Constants.NETWORK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            // Setup cache
            File cacheDir = new File(context.getCacheDir(), Constants.HTTP_CACHE_NAME);
            Cache cache = new Cache(cacheDir, Constants.HTTP_CACHE_SIZE);
            httpClient.setCache(cache);
        }
        return httpClient;
    }

    public static OkHttpClient getHttpClientUsual(Context context) {
        if (httpClient2 == null) {
            httpClient2 = new OkHttpClient();
            httpClient2.setConnectionSpecs(Arrays.asList(ConnectionSpec.CLEARTEXT));
            httpClient2.setConnectTimeout(Constants.NETWORK_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            // Setup cache
            File cacheDir = new File(context.getCacheDir(), Constants.HTTP_CACHE_NAME+"2");
            Cache cache = new Cache(cacheDir, Constants.HTTP_CACHE_SIZE);
            httpClient2.setCache(cache);
        }
        return httpClient2;
    }
}
