package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Matriz;

/**
 *
 * @author Diefesson de Sousa Silva
 */
@FunctionalInterface
public interface ListenerSalvar {

    public void emSalvar(String nome, Matriz matriz);

}
