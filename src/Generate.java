import java.math.BigInteger;
import java.util.Random;

public class Generate {
    public static BigInteger uniformRandom(BigInteger number1, BigInteger number2) {
        Random rnd = new Random();
        BigInteger res;
        do {
            res = new BigInteger(number2.bitLength(), rnd);
        } while (res.compareTo(number1) < 0 || res.compareTo(number2) > 0);
        return res;
    }
    public static BigInteger generatenumber(BigInteger number1, BigInteger number2) {
        BigInteger p;
        while (true) {
            p = Generate.uniformRandom(number1, number2);
            if (MillerRobin.checkPrime(p, 10)) {
                break;
            }
        }
        return p;
    }
}
