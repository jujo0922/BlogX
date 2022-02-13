package resources;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class Md5 {
    public static String createMd5(String password) {

        String result = "";

        try {
            byte[] bytesOfMessage = password.getBytes("UTF-8");

            MessageDigest md = MessageDigest.getInstance("MD5");

            StringBuilder sb = new StringBuilder();

            byte[] bytes = md.digest(bytesOfMessage);

            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            result = sb.toString();

        } catch (UnsupportedEncodingException e) {

            System.err.println(e.getMessage());

        } catch (NoSuchAlgorithmException e) {

            System.err.println(e.getMessage());

        }

        return result;
    }
}
