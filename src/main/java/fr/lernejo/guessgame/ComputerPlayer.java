package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    private final Logger logger =  LoggerFactory.getLogger("player");
    private long max = Long.MAX_VALUE;
    private long min = Long.MIN_VALUE;

    @Override
    public long askNextGuess() {
        logger.log(String.valueOf((min + max) / 2));
        return (min + max) / 2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater){
            max = (min + max)/2;
            logger.log("Smaller !");
        }
        else{
            min = (min + max)/2;
            logger.log("bigger !");
        }

    }

}
