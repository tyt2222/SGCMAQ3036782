package aulas.hash;

import framework.util.Hash;
import java.math.BigInteger;
import java.security.MessageDigest;
import framework.util.Hash;

public class Exemplo {
    public static void main(String[] args) throws Exception {
        
        String algorithm;
        algorithm = "SHA-1";
//        algorithm = "SHA-256";

        
        String s1 = "1234";
        String s2 = "1233";
        
        MessageDigest md = MessageDigest.getInstance( algorithm );
        
        String h1 = new BigInteger( 1, md.digest( s1.getBytes("UTF-8") ) ).toString(16);
        String h2 = new BigInteger( 1, md.digest( s2.getBytes("UTF-8") ) ).toString(16);
        
        System.out.println( s1 + " | " + h1 + " | " + h1.length() );
        System.out.println( s2 + " | " + h2 + " | " + h2.length() );
        System.out.println( "h1.equals(h2) " + h1.equals(h2) );
        
        s2 = "1234";
        h2 = new BigInteger( 1, md.digest( s2.getBytes("UTF-8") ) ).toString(16);
        System.out.println( s2 + " | " + h2 + " | " + h2.length() );
        System.out.println( "h1.equals(h2) " + h1.equals(h2) );
        
        System.out.println("###");
        
        String senha = "IFSP123";
        System.out.println(senha + Hash.stringToHash(senha, "SHA-256") + + Hash.stringToHash(senha, "SHA-256").length());
        
    }
}