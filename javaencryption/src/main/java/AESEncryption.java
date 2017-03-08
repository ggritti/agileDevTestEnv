import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 * Created by GG on 3/8/17.
 * <p>
 * This example program shows how AES encryption and decryption can be done in Java.
 * Please note that secret key and encrypted text is unreadable binary and hence
 * in the following program we display it in hexadecimal format of the underlying bytes.
 *
 * @author GG
 */
public class AESEncryption {

    public static void main(String args[]) throws Exception {
        String plainText = "Hello world";
        SecretKey secKey = getSecretEncryptionKey();
        byte[] cipherText = encryptText(plainText, secKey);
        String decryptedText = decryptText(cipherText, secKey);

        System.out.println("Original Text:" + plainText);
        System.out.println("AES Key (Hex Form):" + bytesToHex(secKey.getEncoded()));
        System.out.println("Encrypted Text (Hex Form):" + bytesToHex(cipherText));
        System.out.println("Descrypted Text:" + decryptedText);

    }

    /**
     * gets the AES encryption key. In your actual programs, this should be safely
     * stored.
     *
     * @return SecretKey
     * @throws Exception "general exception"
     */
    private static SecretKey getSecretEncryptionKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        return generator.generateKey(); // return the Security Key encrypted
    }

    /**
     * Encrypts plainText in AES using the secret key
     *
     * @param plainText "text to be encrypted"
     * @param secKey    "Secret key encrypted"
     * @return byte[] "encrypted key in byte"
     * @throws Exception "general exception"
     */
    private static byte[] encryptText(String plainText, SecretKey secKey) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        return aesCipher.doFinal(plainText.getBytes());
    }

    /**
     * Decrypts encrypted byte array using the key used for encryption.
     *
     * @param byteCipherText "text to decrypted"
     * @param secKey "Security key used to encrypt"
     * @return String "decrypted text"
     * @throws Exception "General exception"
     */
   private static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }

    /**
     * Convert a binary byte array into readable hex form
     *
     * @param hash "hash to be encoded"
     * @return String "encoding in HEX"
     */
    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    }
}
