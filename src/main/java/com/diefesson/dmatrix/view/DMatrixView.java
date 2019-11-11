package com.diefesson.dmatrix.view;

import com.diefesson.dmatrix.control.DMatrixControl;
import com.diefesson.dmatrix.control.EditorMatrizControl;
import com.diefesson.dmatrix.control.EditorNumeroControl;
import com.diefesson.dmatrix.control.HistoricoControl;
import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.model.TipoSistema;
import com.diefesson.dmatrix.model.Historico;
import com.diefesson.dmatrix.model.TipoBase;
import com.diefesson.dmatrix.model.TipoOrtogonalizacao;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrixView extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoMatrizes = new javax.swing.JLabel();
        textoNumeros = new javax.swing.JLabel();
        rolamentoMatrizes = new javax.swing.JScrollPane();
        listaMatrizes = new javax.swing.JList<>();
        rolamentoNumeros = new javax.swing.JScrollPane();
        tabelaEscalares = new javax.swing.JTable();
        barraDeMenu = new javax.swing.JMenuBar();
        menuDMatrix = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuMatrizes = new javax.swing.JMenu();
        menuNovaMatriz = new javax.swing.JMenuItem();
        menuRenomearMatriz = new javax.swing.JMenuItem();
        menuEditarMatriz = new javax.swing.JMenuItem();
        menuRemoverMatrizes = new javax.swing.JMenuItem();
        separadorMatriz1 = new javax.swing.JPopupMenu.Separator();
        menuArredontar = new javax.swing.JMenuItem();
        menuArredontarDelta = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menuSomarMatriz = new javax.swing.JMenuItem();
        menuSubtrairMatriz = new javax.swing.JMenuItem();
        menuMultiplicarMatriz = new javax.swing.JMenuItem();
        separadorMatriz2 = new javax.swing.JPopupMenu.Separator();
        menuTransposta = new javax.swing.JMenuItem();
        menuComplemento = new javax.swing.JMenuItem();
        menuCofatora = new javax.swing.JMenuItem();
        menuAdjunta = new javax.swing.JMenuItem();
        menuInversa = new javax.swing.JMenuItem();
        separadorMatriz3 = new javax.swing.JPopupMenu.Separator();
        menuMatrizTrocar = new javax.swing.JMenuItem();
        menuMatrizCima = new javax.swing.JMenuItem();
        menuMatrizBaixo = new javax.swing.JMenuItem();
        menuNumeros = new javax.swing.JMenu();
        menuNovoNumero = new javax.swing.JMenuItem();
        menuRenomearNumero = new javax.swing.JMenuItem();
        menuEditarNumero = new javax.swing.JMenuItem();
        menuRemoverNumeros = new javax.swing.JMenuItem();
        menuEscalarTrocar = new javax.swing.JMenuItem();
        menuEscalarCima = new javax.swing.JMenuItem();
        menuEscalarBaixo = new javax.swing.JMenuItem();
        menuHistorico = new javax.swing.JMenu();
        menuVerHistorico = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuHistoricoIniciar = new javax.swing.JMenuItem();
        menuHistoricoRemover = new javax.swing.JMenuItem();
        menuAmpliada = new javax.swing.JMenu();
        menuExtrairAmpliada = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuCriarAmpliada = new javax.swing.JMenuItem();
        menuRemover = new javax.swing.JMenuItem();
        menuOperacoes = new javax.swing.JMenu();
        menuSomaPorEscalar = new javax.swing.JMenuItem();
        menuSubstrairPorEscalar = new javax.swing.JMenuItem();
        menuMultiplicarPorEscalar = new javax.swing.JMenuItem();
        menuPotencia = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuDeterminante = new javax.swing.JMenuItem();
        menuPosto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuGauss = new javax.swing.JMenuItem();
        menuGaussJordan = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuClassificarSistema = new javax.swing.JMenuItem();
        menuResolverSistema = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuFatoracao = new javax.swing.JMenuItem();
        menuBasesVetoriais = new javax.swing.JMenu();
        menuBaseClassificar = new javax.swing.JMenuItem();
        menuBasePreparar = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        menuBaseOrtogonalizar = new javax.swing.JMenuItem();
        menuBaseNormalizar = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuClassificarOrtonormalizacao = new javax.swing.JMenuItem();
        menuScript = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DMatrix");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        textoMatrizes.setText("Matrizes");

        textoNumeros.setText("Escalares");

        listaMatrizes.setModel(new DefaultListModel<String>()
        );
        listaMatrizes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMatrizesMouseClicked(evt);
            }
        });
        rolamentoMatrizes.setViewportView(listaMatrizes);

        tabelaEscalares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chave", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEscalares.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        rolamentoNumeros.setViewportView(tabelaEscalares);

        menuDMatrix.setText("DMatrix");

        jMenuItem1.setText("Salvar");
        menuDMatrix.add(jMenuItem1);

        jMenuItem2.setText("Carregar");
        menuDMatrix.add(jMenuItem2);
        menuDMatrix.add(jSeparator1);

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuDMatrix.add(jMenuItem3);

        barraDeMenu.add(menuDMatrix);

        menuMatrizes.setText("Matrizes");

        menuNovaMatriz.setText("Nova");
        menuNovaMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovaMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuNovaMatriz);

        menuRenomearMatriz.setText("Renomear");
        menuRenomearMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRenomearMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuRenomearMatriz);

        menuEditarMatriz.setText("Editar selecionada");
        menuEditarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuEditarMatriz);

        menuRemoverMatrizes.setText("Remover selecionadas");
        menuRemoverMatrizes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverMatrizesActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuRemoverMatrizes);
        menuMatrizes.add(separadorMatriz1);

        menuArredontar.setText("Arredontar valores");
        menuArredontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArredontarActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuArredontar);

        menuArredontarDelta.setText("Arredontar valores com delta");
        menuArredontarDelta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArredontarDeltaActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuArredontarDelta);
        menuMatrizes.add(jSeparator10);

        menuSomarMatriz.setText("Somar");
        menuSomarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSomarMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuSomarMatriz);

        menuSubtrairMatriz.setText("Subtrair");
        menuSubtrairMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubtrairMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuSubtrairMatriz);

        menuMultiplicarMatriz.setText("Multiplicar");
        menuMultiplicarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMultiplicarMatrizActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuMultiplicarMatriz);
        menuMatrizes.add(separadorMatriz2);

        menuTransposta.setText("Transposta");
        menuTransposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTranspostaActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuTransposta);

        menuComplemento.setText("Complemento");
        menuComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuComplementoActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuComplemento);

        menuCofatora.setText("Cofatora");
        menuCofatora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCofatoraActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuCofatora);

        menuAdjunta.setText("Adjunta");
        menuAdjunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdjuntaActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuAdjunta);

        menuInversa.setText("Inversa");
        menuInversa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInversaActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuInversa);
        menuMatrizes.add(separadorMatriz3);

        menuMatrizTrocar.setText("Trocar");
        menuMatrizTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMatrizTrocarActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuMatrizTrocar);

        menuMatrizCima.setText("Mover para cima");
        menuMatrizCima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMatrizCimaActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuMatrizCima);

        menuMatrizBaixo.setText("Mover para baixo");
        menuMatrizBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMatrizBaixoActionPerformed(evt);
            }
        });
        menuMatrizes.add(menuMatrizBaixo);

        barraDeMenu.add(menuMatrizes);

        menuNumeros.setText("Escalares");

        menuNovoNumero.setText("Novo escalar");
        menuNovoNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNovoNumeroActionPerformed(evt);
            }
        });
        menuNumeros.add(menuNovoNumero);

        menuRenomearNumero.setText("Renomear");
        menuRenomearNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRenomearNumeroActionPerformed(evt);
            }
        });
        menuNumeros.add(menuRenomearNumero);

        menuEditarNumero.setText("Editar selecionado");
        menuEditarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEditarNumeroActionPerformed(evt);
            }
        });
        menuNumeros.add(menuEditarNumero);

        menuRemoverNumeros.setText("Remover selecionados");
        menuRemoverNumeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverNumerosActionPerformed(evt);
            }
        });
        menuNumeros.add(menuRemoverNumeros);

        menuEscalarTrocar.setText("Trocar");
        menuEscalarTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEscalarTrocarActionPerformed(evt);
            }
        });
        menuNumeros.add(menuEscalarTrocar);

        menuEscalarCima.setText("Mover para cima");
        menuEscalarCima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEscalarCimaActionPerformed(evt);
            }
        });
        menuNumeros.add(menuEscalarCima);

        menuEscalarBaixo.setText("Mover para baixo");
        menuEscalarBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEscalarBaixoActionPerformed(evt);
            }
        });
        menuNumeros.add(menuEscalarBaixo);

        barraDeMenu.add(menuNumeros);

        menuHistorico.setText("Historico");

        menuVerHistorico.setText("Ver Historico");
        menuVerHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerHistoricoActionPerformed(evt);
            }
        });
        menuHistorico.add(menuVerHistorico);
        menuHistorico.add(jSeparator5);

        menuHistoricoIniciar.setText("Iniciar/reiniciar");
        menuHistoricoIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistoricoIniciarActionPerformed(evt);
            }
        });
        menuHistorico.add(menuHistoricoIniciar);

        menuHistoricoRemover.setText("Remover");
        menuHistoricoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHistoricoRemoverActionPerformed(evt);
            }
        });
        menuHistorico.add(menuHistoricoRemover);

        barraDeMenu.add(menuHistorico);

        menuAmpliada.setText("Ampliada");

        menuExtrairAmpliada.setText("Extrair ampliada");
        menuExtrairAmpliada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExtrairAmpliadaActionPerformed(evt);
            }
        });
        menuAmpliada.add(menuExtrairAmpliada);
        menuAmpliada.add(jSeparator6);

        menuCriarAmpliada.setText("Criar/editar");
        menuCriarAmpliada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCriarAmpliadaActionPerformed(evt);
            }
        });
        menuAmpliada.add(menuCriarAmpliada);

        menuRemover.setText("Remover");
        menuRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRemoverActionPerformed(evt);
            }
        });
        menuAmpliada.add(menuRemover);

        barraDeMenu.add(menuAmpliada);

        menuOperacoes.setText("Operações");

        menuSomaPorEscalar.setText("Soma por escalar");
        menuSomaPorEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSomaPorEscalarActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuSomaPorEscalar);

        menuSubstrairPorEscalar.setText("Subtrair por escalar");
        menuSubstrairPorEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSubstrairPorEscalarActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuSubstrairPorEscalar);

        menuMultiplicarPorEscalar.setText("Multiplicar por escalar");
        menuMultiplicarPorEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMultiplicarPorEscalarActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuMultiplicarPorEscalar);

        menuPotencia.setText("Potencia");
        menuPotencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPotenciaActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuPotencia);
        menuOperacoes.add(jSeparator7);

        menuDeterminante.setText("Determinante");
        menuDeterminante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeterminanteActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuDeterminante);

        menuPosto.setText("Posto");
        menuPosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPostoActionPerformed(evt);
            }
        });
        menuOperacoes.add(menuPosto);

        barraDeMenu.add(menuOperacoes);

        jMenu1.setText("Sistemas");

        menuGauss.setText("Aplicar Gauss");
        menuGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGaussActionPerformed(evt);
            }
        });
        jMenu1.add(menuGauss);

        menuGaussJordan.setText("Aplicar Gauss-Jordan");
        menuGaussJordan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGaussJordanActionPerformed(evt);
            }
        });
        jMenu1.add(menuGaussJordan);
        jMenu1.add(jSeparator2);

        menuClassificarSistema.setText("Classificar sistema Escalonado");
        menuClassificarSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClassificarSistemaActionPerformed(evt);
            }
        });
        jMenu1.add(menuClassificarSistema);

        menuResolverSistema.setText("Resolver sistema Escalonado");
        menuResolverSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResolverSistemaActionPerformed(evt);
            }
        });
        jMenu1.add(menuResolverSistema);
        jMenu1.add(jSeparator4);

        menuFatoracao.setText("Fatoração PLU");
        menuFatoracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFatoracaoActionPerformed(evt);
            }
        });
        jMenu1.add(menuFatoracao);

        barraDeMenu.add(jMenu1);

        menuBasesVetoriais.setText("Bases vetoriais");

        menuBaseClassificar.setText("Classificar base");
        menuBaseClassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBaseClassificarActionPerformed(evt);
            }
        });
        menuBasesVetoriais.add(menuBaseClassificar);

        menuBasePreparar.setText("Preparar");
        menuBasePreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBasePrepararActionPerformed(evt);
            }
        });
        menuBasesVetoriais.add(menuBasePreparar);
        menuBasesVetoriais.add(jSeparator8);

        menuBaseOrtogonalizar.setText("Aplicar ortogonalização de Gram-Schmidt");
        menuBaseOrtogonalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBaseOrtogonalizarActionPerformed(evt);
            }
        });
        menuBasesVetoriais.add(menuBaseOrtogonalizar);

        menuBaseNormalizar.setText("Aplicar normalização");
        menuBaseNormalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBaseNormalizarActionPerformed(evt);
            }
        });
        menuBasesVetoriais.add(menuBaseNormalizar);
        menuBasesVetoriais.add(jSeparator9);

        menuClassificarOrtonormalizacao.setText("Classificar ortonormalização");
        menuClassificarOrtonormalizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuClassificarOrtonormalizacaoActionPerformed(evt);
            }
        });
        menuBasesVetoriais.add(menuClassificarOrtonormalizacao);

        barraDeMenu.add(menuBasesVetoriais);

        menuScript.setText("Script");
        menuScript.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuScriptMouseClicked(evt);
            }
        });
        barraDeMenu.add(menuScript);

        menuAjuda.setText("Ajuda");
        barraDeMenu.add(menuAjuda);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolamentoMatrizes, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoMatrizes)
                            .addComponent(textoNumeros)
                            .addComponent(rolamentoNumeros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textoMatrizes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolamentoMatrizes, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNumeros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolamentoNumeros, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNovaMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovaMatrizActionPerformed
        EditorMatrizView editor = new EditorMatrizView(control, true);
        editor.obterController().definirAoSalvar((nome, matriz) -> {
            control.adcionarMatriz(nome, matriz);
        });
        editor.setVisible(true);
    }//GEN-LAST:event_menuNovaMatrizActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        emSair();
    }//GEN-LAST:event_formWindowClosing

    private void menuRemoverMatrizesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverMatrizesActionPerformed
        int[] selecionados = listaMatrizes.getSelectedIndices();
        int quantidade = selecionados.length;

        String[] chaves = new String[quantidade];
        for (int i = 0; i < quantidade; i++) {
            chaves[i] = modeloMatrizes.getElementAt(selecionados[i]);
        }

        control.removerMatrizes(chaves);
    }//GEN-LAST:event_menuRemoverMatrizesActionPerformed

    private void menuEditarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarMatrizActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {//nenhuma matriz foi selecionada
            return;
        }
        String chave = modeloMatrizes.getElementAt(indice);
        EditorMatrizView ev = new EditorMatrizView(control, false);
        EditorMatrizControl ec = ev.obterController();
        ec.carregar(chave);
        ev.setVisible(true);
    }//GEN-LAST:event_menuEditarMatrizActionPerformed

    private void menuNovoNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNovoNumeroActionPerformed
        EditorNumeroView ev = new EditorNumeroView(control);
        ev.setVisible(true);
    }//GEN-LAST:event_menuNovoNumeroActionPerformed

    private void menuRemoverNumerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverNumerosActionPerformed
        int[] indices = tabelaEscalares.getSelectedRows();

        for (int i : indices) {
            String chave = (String) modeloEscalares.getValueAt(i, 0);
            control.removerNumero(chave);
        }
    }//GEN-LAST:event_menuRemoverNumerosActionPerformed

    private void menuEditarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEditarNumeroActionPerformed
        int indice = tabelaEscalares.getSelectedRow();
        if (indice == -1) {
            return;
        }

        String chave = (String) modeloEscalares.getValueAt(indice, 0);
        EditorNumeroView ev = new EditorNumeroView(control);
        EditorNumeroControl ec = ev.obterController();
        ec.carregar(chave);
        ev.setVisible(true);
    }//GEN-LAST:event_menuEditarNumeroActionPerformed

    private void menuDeterminanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeterminanteActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice != -1) {
            String nome = listaMatrizes.getSelectedValue();
            Matriz m = control.obterMatriz(nome);

            if (m.verificarQuadrada()) {
                control.adcionarNumero("determinante de " + nome, m.obterDeterminante());
            } else {
                JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma matriz primeiro");
        }
    }//GEN-LAST:event_menuDeterminanteActionPerformed

    private void menuMultiplicarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMultiplicarMatrizActionPerformed
        int[] indices = listaMatrizes.getSelectedIndices();
        if (indices.length < 2) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos duas matrizes");
            return;
        }

        String nome1 = modeloMatrizes.elementAt(indices[0]);
        String nome2 = modeloMatrizes.elementAt(indices[1]);

        Matriz m1 = control.obterMatriz(nome1);
        Matriz m2 = control.obterMatriz(nome2);

        if (m1.obterLargura() == m2.obterAltura()) {
            Matriz mul = m1.multiplicar(m2);
            control.adcionarMatriz((nome1 + " * " + nome2), mul);
        } else {
            JOptionPane.showMessageDialog(this, "As matrizes devem ter o mesmo tamanho");
        }
    }//GEN-LAST:event_menuMultiplicarMatrizActionPerformed

    private void menuRenomearMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRenomearMatrizActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.elementAt(indice);
        String novoNome = JOptionPane.showInputDialog(this, "novo nome de " + nome);

        if (novoNome == null) {
            return;
        }

        Matriz m = control.obterMatriz(nome);
        control.removerMatriz(nome);
        control.adcionarMatriz(novoNome, m);
    }//GEN-LAST:event_menuRenomearMatrizActionPerformed

    private void menuSomarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSomarMatrizActionPerformed
        int[] indices = listaMatrizes.getSelectedIndices();
        if (indices.length < 2) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos duas matrizes");
            return;
        }

        String nome1 = modeloMatrizes.elementAt(indices[0]);
        String nome2 = modeloMatrizes.elementAt(indices[1]);

        Matriz m1 = control.obterMatriz(nome1);
        Matriz m2 = control.obterMatriz(nome2);

        if (m1.obterAltura() == m2.obterAltura() && m1.obterLargura() == m2.obterLargura()) {
            Matriz soma = new Matriz(m1);
            soma.soma(m2);
            control.adcionarMatriz((nome1 + " + " + nome2), soma);
        } else {
            JOptionPane.showMessageDialog(this, "As matrizes devem ter o mesmo tamanho");
        }
    }//GEN-LAST:event_menuSomarMatrizActionPerformed

    private void menuTranspostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTranspostaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        Matriz t = m.obterTransposta();
        control.adcionarMatriz("transposta de " + nome, t);
    }//GEN-LAST:event_menuTranspostaActionPerformed

    private void menuComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuComplementoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        if (m.verificarQuadrada()) {
            Matriz c = m.obterMatrizComplemento();
            control.adcionarMatriz("complemento de " + nome, c);
        } else {
            JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
        }
    }//GEN-LAST:event_menuComplementoActionPerformed

    private void menuCofatoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCofatoraActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        if (m.verificarQuadrada()) {
            Matriz c = m.obterMatrizCofator();
            control.adcionarMatriz("cofatora de " + nome, c);
        } else {
            JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
        }
    }//GEN-LAST:event_menuCofatoraActionPerformed

    private void menuAdjuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdjuntaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        if (m.verificarQuadrada()) {
            Matriz a = m.obterAdjunta();
            control.adcionarMatriz("adjunta de " + nome, a);
        } else {
            JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
        }
    }//GEN-LAST:event_menuAdjuntaActionPerformed

    private void menuInversaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInversaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        if (m.verificarQuadrada()) {
            Matriz i = m.obterInversa();
            if (i != null) {
                control.adcionarMatriz("inversa de " + nome, i);
            } else {
                JOptionPane.showMessageDialog(this, "A matriz " + nome + " não tem inversa");
            }
        } else {
            JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
        }
    }//GEN-LAST:event_menuInversaActionPerformed

    private void menuFatoracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFatoracaoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos uma matriz");
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);

        Matriz u = new Matriz(m, false, true);//Não preciso da ampliada na fatoração
        Matriz[] ret = u.gauss(false, true);
        Matriz l = ret[0];
        Matriz p = ret[1];

        control.adcionarMatriz("fator p de " + nome, p);
        control.adcionarMatriz("fator l de " + nome, l);
        control.adcionarMatriz("fator u de " + nome, u);
    }//GEN-LAST:event_menuFatoracaoActionPerformed

    private void menuRenomearNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRenomearNumeroActionPerformed
        int indice = tabelaEscalares.getSelectedRow();
        if (indice == -1) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos um escalar");
            return;
        }

        String nome = (String) modeloEscalares.getValueAt(indice, 0);
        String novoNome = JOptionPane.showInputDialog(this, "Qual o novo de " + nome);

        if (novoNome != null) {
            double numero = control.obterNumero(nome);
            control.removerNumero(nome);
            control.adcionarNumero(novoNome, numero);
        }

    }//GEN-LAST:event_menuRenomearNumeroActionPerformed

    private void menuCriarAmpliadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCriarAmpliadaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        Matriz ampliada = matriz.obterAmpliada();
        if (ampliada == null) {
            ampliada = new Matriz(matriz.obterAltura(), 1);
            matriz.definirAmpliada(ampliada);
        }

        EditorMatrizView editor = new EditorMatrizView(control, false);
        EditorMatrizControl ceditor = editor.obterController();
        ceditor.carregar("ampliada de " + nome, ampliada);
        editor.setVisible(true);
    }//GEN-LAST:event_menuCriarAmpliadaActionPerformed

    private void menuRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRemoverActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        control.obterMatriz(nome).definirAmpliada(null);
    }//GEN-LAST:event_menuRemoverActionPerformed

    private void menuScriptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuScriptMouseClicked
        new GroovyView(control).setVisible(true);
    }//GEN-LAST:event_menuScriptMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        emSair();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuMatrizTrocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMatrizTrocarActionPerformed
        int[] indices = listaMatrizes.getSelectedIndices();
        if (indices.length < 2) {
            return;
        }

        trocarMatrizes(indices[0], indices[1]);
    }//GEN-LAST:event_menuMatrizTrocarActionPerformed

    private void menuMatrizCimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMatrizCimaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice < 1) {
            return;
        }

        trocarMatrizes(indice, --indice);
    }//GEN-LAST:event_menuMatrizCimaActionPerformed

    private void menuMatrizBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMatrizBaixoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1 || indice == modeloMatrizes.getSize() - 1) {
            return;
        }

        trocarMatrizes(indice, ++indice);
    }//GEN-LAST:event_menuMatrizBaixoActionPerformed

    private void menuEscalarTrocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscalarTrocarActionPerformed
        int[] indices = tabelaEscalares.getSelectedRows();
        if (indices.length < 2) {
            return;
        }

        trocarEscalares(indices[0], indices[1]);
    }//GEN-LAST:event_menuEscalarTrocarActionPerformed

    private void menuEscalarCimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscalarCimaActionPerformed
        int indice = tabelaEscalares.getSelectedRow();
        if (indice < 1) {
            return;
        }

        trocarEscalares(indice, --indice);
    }//GEN-LAST:event_menuEscalarCimaActionPerformed

    private void menuEscalarBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEscalarBaixoActionPerformed
        int indice = tabelaEscalares.getSelectedRow();
        if (indice == -1 || indice == tabelaEscalares.getRowCount() - 1) {
            return;
        }

        trocarEscalares(indice, ++indice);
    }//GEN-LAST:event_menuEscalarBaixoActionPerformed

    private void menuSubtrairMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubtrairMatrizActionPerformed
        int[] indices = listaMatrizes.getSelectedIndices();
        if (indices.length < 2) {
            JOptionPane.showMessageDialog(this, "Selecione ao menos duas matrizes");
            return;
        }

        String nome1 = modeloMatrizes.elementAt(indices[0]);
        String nome2 = modeloMatrizes.elementAt(indices[1]);

        Matriz m1 = control.obterMatriz(nome1);
        Matriz m2 = control.obterMatriz(nome2);

        if (m1.obterAltura() == m2.obterAltura() && m1.obterLargura() == m2.obterLargura()) {
            Matriz subtracao = new Matriz(m1);
            subtracao.subtrair(m2);
            control.adcionarMatriz((nome1 + " - " + nome2), subtracao);
        } else {
            JOptionPane.showMessageDialog(this, "As matrizes devem ter o mesmo tamanho");
        }
    }//GEN-LAST:event_menuSubtrairMatrizActionPerformed

    private void listaMatrizesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMatrizesMouseClicked
        int indice = listaMatrizes.getSelectedIndex();
        if (evt.getClickCount() < 2 || indice == -1) {
            return;
        }

        EditorMatrizView editor = new EditorMatrizView(control, false);
        EditorMatrizControl cEditor = editor.obterController();
        cEditor.carregar(modeloMatrizes.elementAt(indice));
        editor.setVisible(true);
    }//GEN-LAST:event_listaMatrizesMouseClicked

    private void menuGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGaussActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String chave = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(chave);

        if (m.obterAmpliada() != null) {
            Matriz a = m.obterAmpliada();
            if (a.obterAltura() != m.obterAltura()) {
                JOptionPane.showMessageDialog(this, "Redimensione a ampliada de forma que sejam representadas na mesma altura");
                return;
            }
        }

        Matriz g = new Matriz(m, true, true);
        g.gauss(false, false);

        control.adcionarMatriz("Escalonada de " + chave, g);
    }//GEN-LAST:event_menuGaussActionPerformed

    private void menuGaussJordanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGaussJordanActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String chave = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(chave);

        if (m.obterAmpliada() != null) {
            Matriz a = m.obterAmpliada();
            if (a.obterAltura() != m.obterAltura()) {
                JOptionPane.showMessageDialog(this, "Redimensione a ampliada de forma que sejam representadas na mesma altura");
                return;
            }
        }

        Matriz g = new Matriz(m, true, true);
        g.gauss(true, false);

        control.adcionarMatriz("Escalonada de " + chave, g);
    }//GEN-LAST:event_menuGaussJordanActionPerformed

    private void menuClassificarSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClassificarSistemaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String chave = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(chave);

        if (m.obterAmpliada() != null) {
            Matriz a = m.obterAmpliada();
            if (a.obterAltura() != m.obterAltura()) {
                JOptionPane.showMessageDialog(this, "Redimensione a ampliada de forma que sejam representadas na mesma altura");
                return;
            } else if (a.obterLargura() != 1) {
                JOptionPane.showMessageDialog(this, "A matriz ampliada deve ter largura 1");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Todo sistema deve ter uma ampliada");
            return;
        }

        TipoSistema ts = m.classificarSistema();

        String mensagem;
        switch (ts) {
            case POSSIVEL_DETERMINADO:
                mensagem = "Sistema possivel e determinado com " + m.quantidadeIncognitas() + " incognitas relevantes";
                break;
            case POSSIVEL_INDERMINADO:
                mensagem = "Sitema possivel, mas indeterminado";
                break;
            default:
                mensagem = "Sistema impossivel";
        }
        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_menuClassificarSistemaActionPerformed

    private void menuResolverSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResolverSistemaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String chave = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(chave);

        if (m.obterAmpliada() != null) {
            Matriz a = m.obterAmpliada();
            if (a.obterAltura() != m.obterAltura()) {
                JOptionPane.showMessageDialog(this, "Redimensione a ampliada de forma que sejam representadas na mesma altura");
                return;
            } else if (a.obterLargura() != 1) {
                JOptionPane.showMessageDialog(this, "A matriz ampliada deve ter largura 1");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Todo sistema deve ter uma ampliada");
            return;
        }

        switch (m.classificarSistema()) {
            case IMPOSSIVEL:
                JOptionPane.showMessageDialog(this, "Esse sistemas não tem solução");
                return;
            case POSSIVEL_INDERMINADO:
                JOptionPane.showMessageDialog(this, "O DMatrix não consegue resolver sistemas não triviais, ainda...");
                return;
        }

        Matriz solucao = m.solucionarSistema();
        control.adcionarMatriz("solução de " + chave, solucao);
    }//GEN-LAST:event_menuResolverSistemaActionPerformed

    private void menuHistoricoIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistoricoIniciarActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        control.obterMatriz(modeloMatrizes.get(indice)).iniciarHistorico();
    }//GEN-LAST:event_menuHistoricoIniciarActionPerformed

    private void menuHistoricoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHistoricoRemoverActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        control.obterMatriz(modeloMatrizes.get(indice)).removerHistorico();
    }//GEN-LAST:event_menuHistoricoRemoverActionPerformed

    private void menuVerHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerHistoricoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz m = control.obterMatriz(nome);
        Historico h = m.obterHistorico();

        if (h == null) {
            JOptionPane.showMessageDialog(this, "A matriz selecionada não tem um historico");
            return;
        }

        HistoricoView v = new HistoricoView(control);
        HistoricoControl c = v.obterControl();
        c.carregar(nome, h);
        v.setVisible(true);
    }//GEN-LAST:event_menuVerHistoricoActionPerformed

    private void menuExtrairAmpliadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExtrairAmpliadaActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        Matriz ampliada = matriz.obterAmpliada();

        if (ampliada == null) {
            JOptionPane.showMessageDialog(this, "A matriz selecionada não tem uma ampliada");
        }

        control.adcionarMatriz("ampliada de " + nome, new Matriz(ampliada, false));
    }//GEN-LAST:event_menuExtrairAmpliadaActionPerformed

    private void menuSomaPorEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSomaPorEscalarActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        int ie = tabelaEscalares.getSelectedRow();
        if (im == -1 || ie == -1) {
            return;
        }

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);

        matriz.soma((double) modeloEscalares.getValueAt(ie, 1));
    }//GEN-LAST:event_menuSomaPorEscalarActionPerformed

    private void menuSubstrairPorEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSubstrairPorEscalarActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        int ie = tabelaEscalares.getSelectedRow();
        if (im == -1 || ie == -1) {
            return;
        }

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);

        matriz.subtrair((double) modeloEscalares.getValueAt(ie, 1));
    }//GEN-LAST:event_menuSubstrairPorEscalarActionPerformed

    private void menuMultiplicarPorEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMultiplicarPorEscalarActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        int ie = tabelaEscalares.getSelectedRow();
        if (im == -1 || ie == -1) {
            return;
        }

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);

        matriz.multiplicar((double) modeloEscalares.getValueAt(ie, 1));
    }//GEN-LAST:event_menuMultiplicarPorEscalarActionPerformed

    private void menuPotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPotenciaActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        int ie = tabelaEscalares.getSelectedRow();
        if (im == -1 || ie == -1) {
            return;
        }

        int pot = (int) Math.floor((double) modeloEscalares.getValueAt(ie, 1));

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);

        if (pot < 0) {
            JOptionPane.showMessageDialog(this, "O expoente deve ser positivo");
        } else if (!matriz.verificarQuadrada()) {
            JOptionPane.showMessageDialog(this, "A matriz deve ser quadrada");
        }

        Matriz res = matriz.potencia(pot);
        control.adcionarMatriz(nome + " ^ " + pot, res);
    }//GEN-LAST:event_menuPotenciaActionPerformed

    private void menuBaseClassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBaseClassificarActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        TipoBase tb = matriz.classificarBase();

        String mensagem;
        switch (tb) {
            case DEPENDENTE:
                mensagem = "Base dependente, tem vetores dependentes";
                break;
            case INCOMPLETA:
                mensagem = "Base imcompleta não tem vetores indepentendes suficientes";
                break;
            default:
                mensagem = "Base independente, pronta para ser usada";
        }
        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_menuBaseClassificarActionPerformed

    private void menuBasePrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBasePrepararActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        Matriz preparada = new Matriz(matriz, false, true);
        preparada.prepararBase();

        control.adcionarMatriz("base de " + nome, preparada);
    }//GEN-LAST:event_menuBasePrepararActionPerformed

    private void menuBaseOrtogonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBaseOrtogonalizarActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        if (matriz.classificarBase() != TipoBase.INDEPENDENTE) {
            JOptionPane.showMessageDialog(this, "A base não é do tipo independente, por favor prepare a base primeiro");
        }

        Matriz ortogonal = new Matriz(matriz, false, true);
        ortogonal.ortogonalizar();
        control.adcionarMatriz("ortogonal de " + nome, ortogonal);
    }//GEN-LAST:event_menuBaseOrtogonalizarActionPerformed

    private void menuBaseNormalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBaseNormalizarActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        Matriz normal = new Matriz(matriz, false, true);
        normal.normalizar();

        control.adcionarMatriz("normal de " + nome, normal);
    }//GEN-LAST:event_menuBaseNormalizarActionPerformed

    private void menuClassificarOrtonormalizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuClassificarOrtonormalizacaoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if (indice == -1) {
            return;
        }

        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);

        TipoOrtogonalizacao to = matriz.classificarOrtogonalizacao();
        String mensagem;
        switch (to) {
            case ORTONORMAL:
                mensagem = "Base ortonormal";
                break;
            case ORTOGONAL:
                mensagem = "Base ortogonal";
                break;
            case NORMAL:
                mensagem = "Base normal";
                break;
            default:
                mensagem = "Base comum";
        }

        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_menuClassificarOrtonormalizacaoActionPerformed

    private void menuArredontarDeltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArredontarDeltaActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        int ie = tabelaEscalares.getSelectedRow();
        if (im == -1 || ie == -1) {
            return;
        }

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);
        double delta = (double) modeloEscalares.getValueAt(ie, 1);

        String mensagem = (matriz.arredontarImprecisao(delta)) ? "Valores arredontados" : "Nenhum valor arrendontado";
        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_menuArredontarDeltaActionPerformed

    private void menuArredontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArredontarActionPerformed
        int im = listaMatrizes.getSelectedIndex();
        if (im == -1) {
            return;
        }

        String nome = modeloMatrizes.get(im);
        Matriz matriz = control.obterMatriz(nome);

        String mensagem = (matriz.arredontarImprecisao()) ? "Valores arredontados" : "Nenhum valor arrendontado";
        JOptionPane.showMessageDialog(this, mensagem);
    }//GEN-LAST:event_menuArredontarActionPerformed

    private void menuPostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPostoActionPerformed
        int indice = listaMatrizes.getSelectedIndex();
        if(indice == -1){
            return;
        }
        
        String nome = modeloMatrizes.get(indice);
        Matriz matriz = control.obterMatriz(nome);
        
        Matriz g = new Matriz(matriz, true, false);
        g.gauss(false, false);
        
        control.adcionarNumero("posto de " + nome, g.linhasNaoNulas());
        Matriz a = g.obterAmpliada();
        if(a != null){
            control.adcionarNumero("posto da ampliada de " + nome, a.linhasNaoNulas());
        }
    }//GEN-LAST:event_menuPostoActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DMatrixView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DMatrixView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JList<String> listaMatrizes;
    private javax.swing.JMenuItem menuAdjunta;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuAmpliada;
    private javax.swing.JMenuItem menuArredontar;
    private javax.swing.JMenuItem menuArredontarDelta;
    private javax.swing.JMenuItem menuBaseClassificar;
    private javax.swing.JMenuItem menuBaseNormalizar;
    private javax.swing.JMenuItem menuBaseOrtogonalizar;
    private javax.swing.JMenuItem menuBasePreparar;
    private javax.swing.JMenu menuBasesVetoriais;
    private javax.swing.JMenuItem menuClassificarOrtonormalizacao;
    private javax.swing.JMenuItem menuClassificarSistema;
    private javax.swing.JMenuItem menuCofatora;
    private javax.swing.JMenuItem menuComplemento;
    private javax.swing.JMenuItem menuCriarAmpliada;
    private javax.swing.JMenu menuDMatrix;
    private javax.swing.JMenuItem menuDeterminante;
    private javax.swing.JMenuItem menuEditarMatriz;
    private javax.swing.JMenuItem menuEditarNumero;
    private javax.swing.JMenuItem menuEscalarBaixo;
    private javax.swing.JMenuItem menuEscalarCima;
    private javax.swing.JMenuItem menuEscalarTrocar;
    private javax.swing.JMenuItem menuExtrairAmpliada;
    private javax.swing.JMenuItem menuFatoracao;
    private javax.swing.JMenuItem menuGauss;
    private javax.swing.JMenuItem menuGaussJordan;
    private javax.swing.JMenu menuHistorico;
    private javax.swing.JMenuItem menuHistoricoIniciar;
    private javax.swing.JMenuItem menuHistoricoRemover;
    private javax.swing.JMenuItem menuInversa;
    private javax.swing.JMenuItem menuMatrizBaixo;
    private javax.swing.JMenuItem menuMatrizCima;
    private javax.swing.JMenuItem menuMatrizTrocar;
    private javax.swing.JMenu menuMatrizes;
    private javax.swing.JMenuItem menuMultiplicarMatriz;
    private javax.swing.JMenuItem menuMultiplicarPorEscalar;
    private javax.swing.JMenuItem menuNovaMatriz;
    private javax.swing.JMenuItem menuNovoNumero;
    private javax.swing.JMenu menuNumeros;
    private javax.swing.JMenu menuOperacoes;
    private javax.swing.JMenuItem menuPosto;
    private javax.swing.JMenuItem menuPotencia;
    private javax.swing.JMenuItem menuRemover;
    private javax.swing.JMenuItem menuRemoverMatrizes;
    private javax.swing.JMenuItem menuRemoverNumeros;
    private javax.swing.JMenuItem menuRenomearMatriz;
    private javax.swing.JMenuItem menuRenomearNumero;
    private javax.swing.JMenuItem menuResolverSistema;
    private javax.swing.JMenu menuScript;
    private javax.swing.JMenuItem menuSomaPorEscalar;
    private javax.swing.JMenuItem menuSomarMatriz;
    private javax.swing.JMenuItem menuSubstrairPorEscalar;
    private javax.swing.JMenuItem menuSubtrairMatriz;
    private javax.swing.JMenuItem menuTransposta;
    private javax.swing.JMenuItem menuVerHistorico;
    private javax.swing.JScrollPane rolamentoMatrizes;
    private javax.swing.JScrollPane rolamentoNumeros;
    private javax.swing.JPopupMenu.Separator separadorMatriz1;
    private javax.swing.JPopupMenu.Separator separadorMatriz2;
    private javax.swing.JPopupMenu.Separator separadorMatriz3;
    private javax.swing.JTable tabelaEscalares;
    private javax.swing.JLabel textoMatrizes;
    private javax.swing.JLabel textoNumeros;
    // End of variables declaration//GEN-END:variables

    private final DefaultListModel<String> modeloMatrizes;
    private final DefaultTableModel modeloEscalares;
    private final DMatrixControl control;

    public DMatrixView() {
        setUndecorated(true);
        initComponents();

        control = new DMatrixControl(this);
        modeloMatrizes = (DefaultListModel<String>) listaMatrizes.getModel();
        modeloEscalares = (DefaultTableModel) tabelaEscalares.getModel();

        setExtendedState(MAXIMIZED_BOTH);

    }

    public DMatrixControl getControl() {
        return control;
    }

    public void emMatrizAdcionada(String chave, Matriz matriz, Matriz velha) {
        if (velha != null) {//apenas uma atualização, não preciso atualizar a parte gráfica
            return;
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            modeloMatrizes.addElement(chave);
        });
    }

    public void emMatrizRemovida(String chave, Matriz matriz) {
        SwingUtilities.invokeLater(() -> {
            modeloMatrizes.removeElement(chave);
        });
    }

    public void emNumeroAdcionado(String chave, double numero, Double velho) {
        SwingUtilities.invokeLater(() -> {
            if (velho != null) {
                int indice = -1;
                int linhas = modeloEscalares.getRowCount();
                for (int i = 0; i < linhas; i++) {
                    if (chave.equals(modeloEscalares.getValueAt(i, 0))) {
                        indice = i;
                        break;
                    }
                }
                modeloEscalares.setValueAt(numero, indice, 1);
            } else {
                modeloEscalares.addRow(new Object[]{chave, numero});
            }
        });
    }

    public void emNumeroRemovido(String chave, Double numero) {
        SwingUtilities.invokeLater(() -> {
            for (int i = 0; i < modeloEscalares.getRowCount(); i++) {
                String c = (String) modeloEscalares.getValueAt(i, 0);
                if (c.equals(chave)) {
                    modeloEscalares.removeRow(i);
                    break;
                }
            }
        });
    }

    private void emSair() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void trocarMatrizes(int a, int b) {
        String t = modeloMatrizes.elementAt(a);
        modeloMatrizes.set(a, modeloMatrizes.get(b));
        modeloMatrizes.set(b, t);
    }

    private void trocarEscalares(int a, int b) {
        String t1 = (String) modeloEscalares.getValueAt(a, 0);
        double t2 = (double) modeloEscalares.getValueAt(a, 1);

        modeloEscalares.setValueAt(modeloEscalares.getValueAt(b, 0), a, 0);
        modeloEscalares.setValueAt(modeloEscalares.getValueAt(b, 1), a, 1);

        modeloEscalares.setValueAt(t1, b, 0);
        modeloEscalares.setValueAt(t2, b, 1);
    }
}
