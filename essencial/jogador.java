package essencial;

class jogador{
    private String nome;
    private int idade;
    private float altura;
    private double desl;
    private String raca;
    public int HP, Max_HP;
    public int XP, nivel;



    public jogador(String nome, int idade, float altura, int tipo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        XP = 0;
        nivel = 0;
        switch(tipo) {
            case 1:
                raca = "Anao";
                desl = 7.5;
                HP = 12;
                break;
            case 2:
                raca = "Elfo";
                desl = 5.0;
                HP = 15;
                break;
            case 3:
                raca = "Halfling";
                desl = 5.0;
                HP = 15;
                break;
            case 4:
                raca = "Humano";
                desl = 5.0;
                HP = 15;
                break;
            case 5:
                raca = "Draconato";
                desl = 6.0;
                HP = 17;
                break;
            case 6:
                raca = "Gnomo";
                desl = 7.5;
                HP = 12;
                break;
            default: 
                System.out.println("Opcao de raca invalida");
                break;
        }
        Max_HP = HP;
    }

    public String getRaca() {
        return raca;
    }

    public String getNome() {
        return nome;
    }

    public float getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    public int get_HP() {
        return HP;
    }

    public void set_HP(int new_HP) {
        HP = new_HP;
    }

    public int get_XP() {
        return XP;
    }

    public void increase_XP(int acr) {
        XP = XP + acr;
        if(XP >= 100) { //sobe de lvl 
            System.out.println("SUBIU DE NIVEL! + 5 HP");
            nivel++;
            Max_HP += 5;
            HP = Max_HP;
            XP = 0;
        }
    }

    public StringBuilder ToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Idade:").append(this.getIdade()).append("\n");
        sb.append("Altura: ").append(this.getAltura());
        if (desl != 0 && !Double.isNaN(desl)) {
            sb.append("\nDeslocamento: " + desl);
        } else {
            System.out.println("Erro no deslocamento!");
        }
        return sb;
    }
}
