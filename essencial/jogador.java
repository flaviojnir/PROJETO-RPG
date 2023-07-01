package essencial;

class jogador{
private String nome;
    private int idade;
    private float altura;
    private double desl;
    private String raca;



    public jogador(String nome, int idade, float altura,int tipo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        switch(tipo){
            case 1:
                raca = "Anao";
                desl = 7.5;
                break;
            case 2:
                raca = "Elfo";
                desl = 5.0;
                break;
            case 3:
                raca = "Halfling";
                desl = 5.0;
                break;
            case 4:
                raca = "Humano";
                desl = 5.0;
                break;
            case 5:
                raca = "Draconato";
                desl = 6.0;
                break;
            case 6:
                raca = "Gnomo";
                desl = 7.5;
                break;
            default: 
                System.out.println("Opcao de raca invalida");
                break;
        }
    }

    public String getRaca(){
        return raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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
