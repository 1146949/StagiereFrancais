package ca.qc.cstjean.francais.stages.francaisgo;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description : Classe de hashage
 * @author Alexis Richer
 * Date de création : 7 décembre 2016
 * Date de dernière modification : 7 décembre 2016
 */
public class Hashage {

    /**
     * Constructeur privé pour empêcher la création d'instances d'un utilitaire
     */
    private Hashage() { }

    /**
     * Fonction permettant de hasher une string
     *
     * @param p_password la string à hasher
     * @return un char[]
     * @throws NullPointerException
     * @link https://docs.oracle.com/javase/7/docs/api/java/math/BigInteger.html
     */
    public static char[] HasherPasswordMD5(String p_password) throws NullPointerException {
        if (p_password == null)
            return null;

        byte[] mdpHash;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            mdpHash = md.digest(p_password.getBytes("UTF-8"));

            BigInteger bigInt = new BigInteger(1, mdpHash);
            return bigInt.toString(16).toCharArray();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

        throw new NullPointerException();
    }

    /**
     * TODO METTRE CETTE FONCTIONS DANS LA CLASSE VALIDATION
     * Convertis un array de caractères en string
     *
     * @param p_array array de caractères à convertir
     * @return chaine de caractères que représente l'array de caractères.
     */
    public static String CharArrayToString(char[] p_array) {
        if (p_array == null || p_array.length == 0)
            return "";

        StringBuilder texte = new StringBuilder();
        for (char caractere : p_array) {
            texte.append(caractere);
        }

        return texte.toString();
    }

    /**
     * TODO METTRE CETTE FONCTIONS DANS LA CLASSE VALIDATION
     * Convertis un string en array de caractères
     * @param p_string le string à convertir
     * @return la chaine de caractère représentant la string passé en paramètre.
     */
    public static char[] StringToCharArray(String p_string) {
        char[] stringToCharArray = p_string.toCharArray();

        for (char output : stringToCharArray) {
            System.out.println(output);
        }
        return stringToCharArray;
    }
}