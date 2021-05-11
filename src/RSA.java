import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;

public class RSA {
    static BigInteger number1 = BigInteger.valueOf(2);
    static BigInteger number2 = BigInteger.valueOf(2).pow(512);
    public static void main(String[] args) {

//  Random r1= new Random(System.currentTimeMillis());
//        Random r2= new Random(System.currentTimeMillis()*10);
//
//        BigInteger p = BigInteger.probablePrime(1024, r1);
//        BigInteger q = BigInteger.probablePrime(1024, r2);
       BigInteger p=Generate.generatenumber(number1, number2);
       BigInteger q=Generate.generatenumber(number1, number2);
       System.out.println("p:"+p);
        System.out.println("q:"+q);
        BigInteger n= p.multiply(q);//n in RSA
        BigInteger p1= p.subtract(new BigInteger("1"));
        BigInteger q1= q.subtract(new BigInteger("1"));
        BigInteger Fn= p1.multiply(q1);//(p-1)*(q-1)

        BigInteger publicKey= new BigInteger("2");
        BigInteger a= new BigInteger("1");

        publicKey=publicKey.add(a);  //找到e
        while(true){
            BigInteger gcd=Fn.gcd(publicKey);
            if(gcd.equals(BigInteger.ONE)){
                break;
            }
            publicKey=publicKey.add(a);
        }

      // BigInteger privateKey=publicKey.modInverse(Fn);//Calculate d
         BigInteger privateKey=GCD.MulInv(publicKey,Fn);
        System.out.println("Public key is"+publicKey+n);
        System.out.println("Private key is"+privateKey+","+n);

        //Encryption and Decryption
        System.out.println("Enter the message to be encrypted");
        Scanner sc= new Scanner(System.in);
        String msg= sc.nextLine();
        sc.close();
        ArrayList<BigInteger> encryptedArrayList = new ArrayList<BigInteger>();
        ArrayList<String> decryptedArrayList = new ArrayList<String>();

        byte[] bytes = msg.getBytes();
        for(int i=0;i<msg.length();i++){
            int transformedVal=bytes[i];
            BigInteger bigInteger = BigInteger.valueOf(transformedVal);

            BigInteger encryptedmsg= FAST.Fast(bigInteger,publicKey,n);
            System.out.println("encrypted message:"+encryptedmsg);
            encryptedArrayList.add(encryptedmsg);

            BigInteger decryptedMsg = FAST.Fast(encryptedmsg,privateKey,n);
            int decryptedMsg1 =decryptedMsg.intValue();
            String abc = Character.toString((char)decryptedMsg1);
            decryptedArrayList.add(abc);

            System.out.println("Decryped message:"+Character.toString((char)decryptedMsg1));
        }
        System.out.println("Encrypted message:");
        System.out.println(encryptedArrayList);
        System.out.println("Decrypted message:");
        System.out.println(String.join("",decryptedArrayList));//Delete the "," between elements (join with nothing)
    }



}
