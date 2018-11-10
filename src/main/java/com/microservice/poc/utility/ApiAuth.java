package com.microservice.poc.utility;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;

/**
 * Created by Lukman.Arogundade on 5/20/2015.
 */
public class ApiAuth {

    //https://connect.interswitchng.com/docs/api-security/
    //https://en.wikipedia.org/wiki/Secure_Hash_Algorithms

    private static final String TIMESTAMP = "TIMESTAMP";
    private static final String NONCE = "NONCE";
    //TODO In cryptography, a nonce is an arbitrary number that can be used just once.
    private static final String SIGNATURE_METHOD = "SIGNATURE_METHOD";
    //SHA (Secure Hash Algorithm):SHA-256, SHA-384, and SHA-512.
    private static final String SIGNATURE = "SIGNATURE";
    private static final String AUTHORIZATION = "AUTHORIZATION";

    private static final String AUTHORIZATION_REALM = "DeloitteAuth";//TODO Company name with auth or something
    private static final String ISO_8859_1 = "ISO-8859-1";

    public static HashMap<String, String> generateApiAuth(
            String httpMethod, String resourceUrl, String clientId,
            String clientSecretKey, String additionalParameters,
            String signatureMethod) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        HashMap<String, String> apiAuth = new HashMap<String, String>();

        //Timezone MUST be Africa/Lagos.
        TimeZone lagosTimeZone = TimeZone.getTimeZone("Africa/Lagos");//TODO change to US zone

        Calendar calendar = Calendar.getInstance(lagosTimeZone);


        // Timestamp must be in seconds.
        long timestamp = calendar.getTimeInMillis() / 1000;

        UUID uuid = UUID.randomUUID();
        String nonce = uuid.toString().replaceAll("-", "");

        String clientIdBase64 = new String(Base64.encodeBase64(clientId
                .getBytes()));
        String authorization = AUTHORIZATION_REALM + " " + clientIdBase64;

        String encodedResourceUrl = URLEncoder.encode(resourceUrl, ISO_8859_1);
        String signatureCipher = httpMethod + "&" + encodedResourceUrl + "&"
                + timestamp + "&" + nonce + "&" + clientId + "&"
                + clientSecretKey;
        if (additionalParameters != null && !"".equals(additionalParameters))
            signatureCipher = signatureCipher + "&" + additionalParameters;

        System.out.println("signatureCipher:" + signatureCipher);

        MessageDigest messageDigest = MessageDigest
                .getInstance(signatureMethod);
        byte[] signatureBytes = messageDigest
                .digest(signatureCipher.getBytes());

        // encode signature as base 64
        String signature = new String(Base64.encodeBase64(signatureBytes));

        apiAuth.put(AUTHORIZATION, authorization);
        apiAuth.put(TIMESTAMP, String.valueOf(timestamp));
        apiAuth.put(NONCE, nonce);
        apiAuth.put(SIGNATURE_METHOD, signatureMethod);
        apiAuth.put(SIGNATURE, signature);

        return apiAuth;
    }
}
