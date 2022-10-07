package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }


    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
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
