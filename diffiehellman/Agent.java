package diffiehellman;

import java.math.BigInteger;
import java.util.Random;

public class Agent {
    private static final int NUMBER_LENGTH_IN_BITS = 512; 
    private final Random random = new Random(); 

    private BigInteger moduloN; 
    private BigInteger baseG;
    private BigInteger exponentX; 

    public Agent(BigInteger g, BigInteger n) {
        baseG = g; 
        moduloN = n; 
        exponentX = generateNumber(); 
    }

    private BigInteger generateNumber() {
        BigInteger number = new BigInteger(NUMBER_LENGTH_IN_BITS, random); 
        return number; 
    }

    public BigInteger calculateToSend() {
        BigInteger result = baseG.modPow(exponentX, moduloN); 
        return result; 
    }

    public BigInteger calculateKey(BigInteger recivedNumber) {
        BigInteger key = recivedNumber.modPow(exponentX, moduloN); 
        return key; 
    }

}