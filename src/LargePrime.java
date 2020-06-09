import java.math.BigInteger;
import java.util.Random;

public class LargePrime {
	public static BigInteger generatePrime() {
		Random rnd = new Random();
		BigInteger q;
		q = BigInteger.probablePrime(34, rnd);
		return q;
	}
}