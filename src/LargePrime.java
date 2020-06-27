import java.math.BigInteger;
import java.util.Random;

public class LargePrime {
	public static BigInteger generatePrime() {
		Random rnd = new Random();
		BigInteger q;
		q = BigInteger.probablePrime((int) (UI.getBit()*3.322), rnd);
		return q;
	}
}