package casino.maquinacasino;

import java.util.Random;

public class SlotmachineModel {
    private final String[] symbols = {"sereza.png", "limon.png", "7.png", "trebol.png"};
    private final Random random = new Random();

    public String spin() {
        return symbols[random.nextInt(symbols.length)];
    }
}
