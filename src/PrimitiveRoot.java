import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PrimitiveRoot{
	public static BigInteger generateRoot() {
		Random rnd = new Random();
		BigInteger p,g,q;
		BigInteger x;
		BigInteger y;
		while (true) {
			q = LargePrime.generatePrime();
			p = q.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
			g = BigInteger.probablePrime(12, rnd);
			x = mod(p,q,g);
			y = g.multiply(g).mod(p);
			if (x.equals(BigInteger.valueOf(1)) == false && y.equals(BigInteger.valueOf(1)) == false) {
				break;
			}
		}
		return g;
	}
	
	private static BigInteger mod(BigInteger p, BigInteger q, BigInteger g) {
		// TODO Auto-generated method stub
		BigInteger pow=g.modPow(q,p);
		return pow;
	}

}

