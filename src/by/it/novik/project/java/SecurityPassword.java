package by.it.novik.project.java;



import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

/**
 * Created by Kate Novik.
 */
public class SecurityPassword {

    /**
     * Получение хэш-кода в 16-ричной системе для пароля с добавлением "соли"
     * @param password Пароль
     * @param salt "Соль"
     * @return Захэшированный пароль
     */
    public static String getHash (String password, String salt) {
        //Получение хэша пароля с солью
        return DigestUtils.md5Hex(password.concat(salt));
    }

//    private static String getSecurePassword(String passwordToHash)
//    {
//        String generatedPassword = null;
//        try {
//            // Create MessageDigest instance for MD5
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            //Add password bytes to digest
//            md.update(getSalt());
//            //Get the hash's bytes
//            byte[] bytes = md.digest(passwordToHash.getBytes());
//            //This bytes[] has bytes in decimal format;
//            //Convert it to hexadecimal format
//            StringBuilder sb = new StringBuilder();
//            for(int i=0; i< bytes.length ;i++)
//            {
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            //Get complete hashed password in hex format
//            generatedPassword = sb.toString();
//        }
//        catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return generatedPassword;
//    }


    /**
     * Получение "соли" для пароля
     * @return Массив байтов
     */
    public static String getSalt() {
        String saltStr = null;
        //Создаем массив для "соли"
        byte[] salt = new byte[16];
        try {
        //Получаем объект SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");

        //Получаем рандом "соли"
        sr.nextBytes(salt);
        saltStr = new String(salt,"windows-1251");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return saltStr;
    }
}
