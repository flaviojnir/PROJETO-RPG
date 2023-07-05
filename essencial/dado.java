package essencial;

import java.util.Random;

class dado {
    int die;
    private Random random;

    public dado(int die) {
        random = new Random();
        this.die = die;
    }

    public int lancarDado() {
        return random.nextInt(die) + 1;
    }

    public void lancar() {
        System.out.println("Seu resultado foi: " + lancarDado());
    }
}
