package diffiehellman.generator;

import java.math.BigInteger;
import java.util.Random;

public class NumbersGenerator {
    private BigInteger primeNumberN; 
    private BigInteger primitiveRootG; 

    private static final int NUMBER_LENGTH_IN_BITS = 512; 
    private static final int PROBABLE_PRIME_CERTAINTY = 100; 
    private final Random random = new Random(); 

    public NumbersGenerator() {
        primeNumberN = generatePrimeNumber(); 
        primitiveRootG = new BigInteger(NUMBER_LENGTH_IN_BITS, random); 
    }

    private BigInteger generatePrimeNumber() {
        BigInteger primeNumber = BigInteger.probablePrime(NUMBER_LENGTH_IN_BITS, random); 

        while(!primeNumber.isProbablePrime(PROBABLE_PRIME_CERTAINTY) || 
        !((primeNumber.subtract(BigInteger.ONE)).divide(BigInteger.TWO)).isProbablePrime(PROBABLE_PRIME_CERTAINTY)) {
            primeNumber = BigInteger.probablePrime(NUMBER_LENGTH_IN_BITS, random); 
        }

        return primeNumber; 
    }

    public BigInteger getN() {
        return primeNumberN; 
    }

    public BigInteger getG() {
        return primitiveRootG; 
    }
}