package diffiehellman;

import java.math.BigInteger;

import diffiehellman.generator.NumbersGenerator;

public class DiffieHellman {
    private static void twoAgents() {
        NumbersGenerator generator = new NumbersGenerator(); 

        System.out.println("G = " + generator.getG().toString());
        System.out.println("N = " + generator.getN().toString());
        System.out.println();

        Agent alice = new Agent(generator.getG(), generator.getN()); 
        Agent bob = new Agent(generator.getG(), generator.getN()); 

        BigInteger aliceNumber = alice.calculateToSend(); 
        BigInteger bobNumber = bob.calculateToSend(); 

        System.out.println("Alice is sending = " + aliceNumber.toString());
        System.out.println("Bob is sending = " + bobNumber.toString());
        System.out.println();

        BigInteger aliceKey = alice.calculateKey(bobNumber); 
        BigInteger bobKey = bob.calculateKey(aliceNumber);  

        System.out.println("Alice's key = " + aliceKey.toString());
        System.out.println("Bob's key = " + bobKey.toString());
        System.out.println();

        System.out.println((aliceKey.compareTo(bobKey) == 0) ? "Keys are equal" : "Keys ARE NOT equal");
    }

    private static void manInTheMiddle() {
        NumbersGenerator generator = new NumbersGenerator(); 

        System.out.println("G = " + generator.getG().toString());
        System.out.println("N = " + generator.getN().toString());
        System.out.println();

        Agent alice = new Agent(generator.getG(), generator.getN()); 
        Agent bob = new Agent(generator.getG(), generator.getN()); 
        Agent charlieInTheMiddle = new Agent(generator.getG(), generator.getN()); 

        BigInteger aliceNumber = alice.calculateToSend(); 
        BigInteger bobNumber = bob.calculateToSend(); 
        BigInteger charlieNumber = charlieInTheMiddle.calculateToSend(); 

        System.out.println("Charlie is sending = " + charlieNumber.toString());
        System.out.println("Alice is sending = " + aliceNumber.toString());
        System.out.println("Bob is sending = " + bobNumber.toString());
        System.out.println();

        BigInteger charlieAndAliceKey = charlieInTheMiddle.calculateKey(aliceNumber); 
        BigInteger charlieAndBobKey = charlieInTheMiddle.calculateKey(bobNumber); 
        BigInteger aliceKey = alice.calculateKey(charlieNumber); 
        BigInteger bobKey = bob.calculateKey(charlieNumber);  

        System.out.println("Charlie's and Alice's key = " + charlieAndAliceKey.toString());
        System.out.println("Charlie's and Bob's key = " + charlieAndBobKey.toString());
        System.out.println("Alice's key = " + aliceKey.toString());
        System.out.println("Bob's key = " + bobKey.toString());
        System.out.println();

        System.out.println((aliceKey.compareTo(charlieAndAliceKey) == 0 
        && bobKey.compareTo(charlieAndBobKey) == 0) ? "Keys are equal" : "Keys ARE NOT equal");
    }

    private static void threeAgents() {
        NumbersGenerator generator = new NumbersGenerator(); 

        System.out.println("G = " + generator.getG().toString());
        System.out.println("N = " + generator.getN().toString());
        System.out.println();

        Agent alice = new Agent(generator.getG(), generator.getN()); 
        Agent bob = new Agent(generator.getG(), generator.getN()); 
        Agent charlie = new Agent(generator.getG(), generator.getN()); 

        BigInteger aliceNumber = alice.calculateToSend(); 
        BigInteger bobNumber = bob.calculateToSend(); 
        BigInteger charlieNumber = charlie.calculateToSend(); 

        System.out.println("Alice is sending = " + aliceNumber.toString());
        System.out.println("Bob is sending = " + bobNumber.toString());
        System.out.println("Charlie is sending = " + charlieNumber.toString());
        System.out.println();

        BigInteger aliceNumberPrim = alice.calculateKey(charlieNumber); 
        BigInteger bobNumberPrim = bob.calculateKey(aliceNumber); 
        BigInteger charlieNumberPrim = charlie.calculateKey(bobNumber); 

        System.out.println("Alice is sending = " + aliceNumberPrim.toString());
        System.out.println("Bob is sending = " + bobNumberPrim.toString());
        System.out.println("Charlie is sending = " + charlieNumberPrim.toString());
        System.out.println();

        BigInteger aliceKey = alice.calculateKey(charlieNumberPrim); 
        BigInteger bobKey = bob.calculateKey(aliceNumberPrim);  
        BigInteger charlieKey = charlie.calculateKey(bobNumberPrim); 

        System.out.println("Alice's key = " + aliceKey.toString());
        System.out.println("Bob's key = " + bobKey.toString());
        System.out.println("Charlie's key = " + charlieKey.toString());
        System.out.println();

        System.out.println((aliceKey.compareTo(bobKey) == 0 
        && bobKey.compareTo(charlieKey) == 0) ? "Keys are equal" : "Keys ARE NOT equal");
    }

    public static void main(String[] args) {
        System.out.println("===ALICE AND BOB===");
        twoAgents();

        System.out.println("===MAN IN THE MIDDLE===");
        manInTheMiddle();

        System.out.println("===ALICE, BOB AND CHARLIE ===");
        threeAgents();

    }
}