package com.istl.utils;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class DisableSSLCertificateCheckUtil {

    public static void disableChecks() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] chain, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] chain, String authType) {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }
        };

        // Install the all-trusting trust manager
        SSLContext sslc = SSLContext.getInstance("TLS");
        sslc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sslc.getSocketFactory());

        // Install the all-trusting host name verifier
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    }
}
