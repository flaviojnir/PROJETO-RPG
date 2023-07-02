package lugares;
import estruturas.*;

public class cidade {
    String nome;
    Object[]estrs;
    ferreiro f;
    hotel h;
    taverna t;

    public cidade(String nome){
        this.nome = nome;
        f = new ferreiro(5);
        h = new hotel();
        t = new taverna();
        estrs = new Object[]{f,h,t};
    }

    public String get_nome(){
        return nome;
    }

    public ferreiro get_ferreiro(){
        return f;
    }

    public hotel get_hotel(){
        return h;
    }

    public taverna get_taverna(){
        return t;
    }
}
