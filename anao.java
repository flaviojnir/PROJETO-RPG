class anao {
    private String nome;
    private int idade;
    private String altura;
    public double desl = 7.5;

    public anao(String nome, int idade, String altura, float desl) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Idade:").append(this.getIdade()).append("\n");
        sb.append("Altura: ").append(this.getAltura());
        if (desl != 0 && !Double.isNaN(desl)) {
            sb.append("\nDeslocamento: " + desl);
        } else {
            System.out.println("Erro no deslocamento!");
        }
        return altura;
    }
}
