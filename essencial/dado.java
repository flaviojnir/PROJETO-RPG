package essencial;

import java.util.Random;

class dado {
    private Random random;

    public dado() {
        random = new Random();
    }

    public int lancarDado() {
        return random.nextInt(6) + 1;
    }

    public void lancar() {
        System.out.println("Seu resultado foi: " + lancarDado());
    }
}
