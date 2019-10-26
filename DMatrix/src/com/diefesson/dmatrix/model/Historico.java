package com.diefesson.dmatrix.model;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Historico implements Iterable<Registro> {

    private final List<Registro> registros = new LinkedList<>();

    public Historico(Matriz inicial) {
        registros.add(new Registro(inicial));
    }

    public void registrar(Matriz matriz) {
        registros.add(new Registro(matriz));
    }

    public void adcionarDescricao(String descricao) {
        registros.get(registros.size() - 1).adcionarDescricao(descricao);
    }
    
    public Registro obterRegistro(int indice){
        return registros.get(indice);
    }
    
    public int obterQuantidade(){
        return registros.size();
    }

    @Override
    public Iterator<Registro> iterator() {
        return registros.iterator();
    }

}
