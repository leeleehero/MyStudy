package lee.chapter1;



import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String str = "123456";
        byte[] bytes = str.getBytes();
        String s = encoder.encodeToString(bytes);
        System.out.println(s);
        byte[] decode = decoder.decode(s);
        String name = new String(decode,"UTF-8");
        System.out.println(name);
    }
}
