package com.estudante;

import com.estudante.service.AlunoService;

import javax.swing.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        // Configurar o look and feel para o sistema operacional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao definir o LookAndFeel do sistema.", e);
        }

        while (true) {
            String[] opcoes = {
                    "Cadastro de Aluno",
                    "Alterar aluno",
                    "Exibir aluno",
                    "Remover aluno",
                    "Matricular aluno",
                    "Listar Todos os Alunos",
                    "Sair"
            };
            
            int opcao = JOptionPane.showOptionDialog(
                null,
                "Sistema de Cadastro de Alunos",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );
            
            // Se o usuário fechar a janela, encerrar o programa
            if (opcao == -1) {
                System.exit(0);
            }
            
            try {
                switch (opcao) {
                    case 0:
                        AlunoService.cadastrarAluno();
                        break;
                    case 1:
                        AlunoService.alterarAluno();
                        break;
                    case 2:
                        AlunoService.exibirAluno();
                        break;
                    case 3:
                        AlunoService.removerAluno();
                        break;
                    case 4:
                        AlunoService.matricularAluno();
                        break;
                    case 5:
                        AlunoService.listarTodosAlunos();
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saindo do sistema...", "Sair", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage(), 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} 