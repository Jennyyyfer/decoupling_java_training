package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long  numberToGuess;

    public Simulation(Player player) {
        this.player = player;

    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long value = player.askNextGuess();

        if(value > numberToGuess) { player.respond(false);}

        else if  (value < numberToGuess) {player.respond(true);}

        else{ logger.log("The player have guessed the right number"); return true;}

        return false;
    }

    public void loopUntilPlayerSucceed(long limit) {

        boolean gameFinal = false;
        long timeStarting = System.currentTimeMillis();
        long i = 0;

        while (gameFinal && i < limit){
            gameFinal = nextRound();
            i++;
        }
        long duringTime = System.currentTimeMillis() - timeStarting;
        Date time = new Date(duringTime);
        DateFormat df = new SimpleDateFormat("mm:ss.SSS");
        logger.log("During time: " + df.format(time));

        if (gameFinal) {
            logger.log("The player has found the number guess in "+i+ " iterations");}
        else{
            logger.log("The player hasn't found the number guess within "+limit+ " iterations");
        }

    }
}
