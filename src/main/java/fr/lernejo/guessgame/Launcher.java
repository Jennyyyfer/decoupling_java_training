package fr.lernejo.guessgame;

import fr.lernejo.HumanPlayer;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100);

        if (args[0].equals("-interactive")) {
            Simulation sm = new Simulation(new HumanPlayer());
            sm.initialize(randomNumber);
            sm.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        else if(args[0].equals("-auto")){
            Simulation sm = new Simulation(new ComputerPlayer());
            sm.initialize(Long.parseLong(args[1]));
            sm.loopUntilPlayerSucceed(1000);
        }

        else {
            System.out.println("L'Ãge du Capitain\n");
            System.out.println("There is two methods to launch the program.\n");
            System.out.println("Please enter one of the desired methods: \n");
            System.out.println("1) -interactive : guess by yourself  in limit of attempt by the computer.\n");
            System.out.println("2) -auto: enter a number and let the computer to guess it.");
        }

    }
}
