import java.math.*;
import java.util.Scanner;

import javax.swing.JPanel;

public class DHprograming {
	static BigInteger AlicePrivateKey,BobPrivateKey,CarolPrivateKey;
	
    public static BigInteger generateSession() {
    	    	
    	 BigInteger g =PrimitiveRoot.generateRoot();
         BigInteger p=LargePrime.generatePrime();
         
         AlicePrivateKey =UI.getPrivateKey("Alice");        //Alice˽Կ
         BobPrivateKey =UI.getPrivateKey("Bob");            //Bob˽Կ
         CarolPrivateKey =UI.getPrivateKey("Carol");         //Carol˽Կ

         BigInteger AlicePublicKey = mod(g, AlicePrivateKey, p);      //Alice��Կ
         BigInteger BobPublicKey = mod(g, BobPrivateKey, p);          //Bob��Կ
         BigInteger CarolPublicKey = mod(g, CarolPrivateKey, p);      //Carol��Կ
//         System.out.println("Alice����Ĺ�Կ�ǣ�" + AlicePublicKey);
//         System.out.println("Bob����Ĺ�Կ�ǣ�" + BobPublicKey);
//         System.out.println("Carol����Ĺ�Կ�ǣ�" + CarolPublicKey);

         BigInteger mAlice = mod(CarolPublicKey, AlicePrivateKey, p);
         BigInteger mBob = mod(AlicePublicKey, BobPrivateKey, p);
         BigInteger mCarol = mod(BobPublicKey, CarolPrivateKey, p);
//         System.out.println("Alice�����z'�ǣ�" + mAlice);
//         System.out.println("Bob�����x'�ǣ�" + mBob);
//         System.out.println("Carol�����y'�ǣ�" + mCarol);
         
         BigInteger Ka = mod(mCarol,AlicePrivateKey,p);
         BigInteger Kb = mod(mAlice,BobPrivateKey,p);
         BigInteger Kc = mod(mBob,CarolPrivateKey,p);
//         System.out.println("Alice����ĻỰ��Կ�ǣ�" + Ka);     /*Alice�Ự��ԿYc*/
//         System.out.println("Bob����ĻỰ��Կ�ǣ�" + Kb);       /*Bob�Ự��ԿYc*/
//         System.out.println("Carol����ĻỰ��Կ�ǣ�" + Kc);     /*Carol�Ự��ԿYc*/
//                                                           /*��ȷ���ka=kb=kc*/
         return Ka;
     
	}
               
    public static BigInteger mod(BigInteger g, BigInteger x, BigInteger p) { 
        BigInteger pow =g.modPow(x, p);
        return pow;                                     /*�η����ຯ��  g��x�η�ģp*/
    }
}