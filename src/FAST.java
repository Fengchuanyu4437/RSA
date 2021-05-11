import java.math.BigInteger;
public class FAST
{
    public static BigInteger Fast(BigInteger a, BigInteger b, BigInteger m) {
        BigInteger r;                       // mark for b mod m in each step
        BigInteger q = BigInteger.ONE;      // mark the number that we need in the final step
        BigInteger T = new BigInteger("2");
        BigInteger M = new BigInteger("-1");
        BigInteger re = M;                     // mark the result for the a^2^i in each step
        while(true) {
            if(b.compareTo(BigInteger.ZERO) != 0) {
                r = b.mod(T);
                b = b.divide(T);
                if(re.compareTo(M) == 0) {               // a^2^0
                    re = a.mod(m);
                }
                else {
                    re = (re.multiply(re)).mod(m);        // a^2^i
                }
                if(r.compareTo(BigInteger.ONE)==0) {
                    q = q.multiply(re);
                }
                continue;
            }
            break;

        }
        return q.mod(m);

    }
}
