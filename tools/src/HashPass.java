import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
public class HashPass {
    public static  int idGenerator(String string) {
        try {
            MessageDigest mesdig = MessageDigest.getInstance("SHA-256");
            byte[] bytesarray = mesdig.digest(string.getBytes());
            StringBuilder hexString = new StringBuilder();
            BigInteger integer = new BigInteger(1, bytesarray);
            return integer.intValue();
        }

        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return 0;}
    }
}
