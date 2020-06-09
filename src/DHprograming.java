import java.math.*;
import java.util.Scanner;

import javax.swing.JPanel;

public class DHprograming {
	static BigInteger AlicePrivateKey,BobPrivateKey,CarolPrivateKey;
	
    public static BigInteger generateSession() {
    	    	
    	 BigInteger g =PrimitiveRoot.generateRoot();
         BigInteger p=LargePrime.generatePrime();
         
         AlicePrivateKey =UI.getPrivateKey("Alice");        //Alice私钥
         BobPrivateKey =UI.getPrivateKey("Bob");            //Bob私钥
         CarolPrivateKey =UI.getPrivateKey("Carol");         //Carol私钥

         BigInteger AlicePublicKey = mod(g, AlicePrivateKey, p);      //Alice公钥
         BigInteger BobPublicKey = mod(g, BobPrivateKey, p);          //Bob公钥
         BigInteger CarolPublicKey = mod(g, CarolPrivateKey, p);      //Carol公钥
//         System.out.println("Alice算出的公钥是：" + AlicePublicKey);
//         System.out.println("Bob算出的公钥是：" + BobPublicKey);
//         System.out.println("Carol算出的公钥是：" + CarolPublicKey);

         BigInteger mAlice = mod(CarolPublicKey, AlicePrivateKey, p);
         BigInteger mBob = mod(AlicePublicKey, BobPrivateKey, p);
         BigInteger mCarol = mod(BobPublicKey, CarolPrivateKey, p);
//         System.out.println("Alice算出的z'是：" + mAlice);
//         System.out.println("Bob算出的x'是：" + mBob);
//         System.out.println("Carol算出的y'是：" + mCarol);
         
         BigInteger Ka = mod(mCarol,AlicePrivateKey,p);
         BigInteger Kb = mod(mAlice,BobPrivateKey,p);
         BigInteger Kc = mod(mBob,CarolPrivateKey,p);
//         System.out.println("Alice算出的会话密钥是：" + Ka);     /*Alice会话密钥Yc*/
//         System.out.println("Bob算出的会话密钥是：" + Kb);       /*Bob会话密钥Yc*/
//         System.out.println("Carol算出的会话密钥是：" + Kc);     /*Carol会话密钥Yc*/
//                                                           /*正确情况ka=kb=kc*/
         return Ka;
     
	}
               
    public static BigInteger mod(BigInteger g, BigInteger x, BigInteger p) { 
        BigInteger pow =g.modPow(x, p);
        return pow;                                     /*次方求余函数  g的x次方模p*/
    }
}