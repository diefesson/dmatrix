package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Historico;
import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.HistoricoView;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class HistoricoControl {

    private final HistoricoView view;
    private final DMatrixControl dmControl;
    private Historico historico = new Historico(new Matriz(1, 1));
    private String nome = "";

    public HistoricoControl(DMatrixControl dmControl, HistoricoView view) {
        if (dmControl == null) {
            throw new NullPointerException("dmControl não pode ser null");
        }

        this.dmControl = dmControl;
        this.view = view;
    }

    public Historico obterHistorico() {
        return historico;
    }

    public String obterNome() {
        return nome;
    }

    public void carregar(String nome) {
        if (nome == null) {
            throw new NullPointerException("o nome não pode ser null");
        }

        Matriz m = dmControl.obterMatriz(nome);
        this.nome = nome;
        historico = m.obterHistorico();

        if (view != null) {
            view.aoCarregar();
        }
    }

    public void carregar(String nome, Historico historico) {
        if (nome == null || historico == null) {
            throw new NullPointerException("nem o nome nem o historico podem ser null");
        }

        this.historico = historico;

        if (view != null) {
            view.aoCarregar();
        }
    }

}
