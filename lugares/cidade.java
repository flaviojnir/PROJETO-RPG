package lugares;
import estruturas.*;
import java.util.ArrayList;

public class cidade implements lugares_interface {
    private String nome;
    ferreiro f;
    hotel h;
    taverna t;

    public cidade(String nome){
        this.nome = nome;
        f = new ferreiro(3);
        h = new hotel();
        t = new taverna();
    }

    @Override
    public String getNome(){
        return nome;
    }

    public ferreiro get_Ferreiro(){
        return f;
    }

    public hotel get_Hotel(){
        return h;
    }

    public taverna get_Taverna(){
        return t;
    }
}
