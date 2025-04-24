package com.estudante.dao;

import com.estudante.model.Aluno;
import com.estudante.model.Disciplina;
import com.estudante.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    
    public void inserir(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno (nome, telefone, cpf, endereco) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        try {
        	conn = DatabaseConnection.getConnection();
        
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getEndereco());
            
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    aluno.setId(rs.getLong(1));
                }
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
    }
    
    public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setEndereco(rs.getString("endereco"));
                alunos.add(aluno);
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
        return alunos;
    }
    
    public Aluno buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM aluno WHERE nome = ?";
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cpf);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getLong("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setEndereco(rs.getString("endereco"));
                    return aluno;
                }
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
        return null;
    }
    
    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET nome = ?, telefone = ?, endereco = ? WHERE id = ?";
        
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getEndereco());
            stmt.setLong(4, aluno.getId());
            
            stmt.executeUpdate();
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
    }
    
    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM aluno WHERE id = ?";
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
    }
    
    public void matricularEmDisciplinas(Long alunoId, List<Long> disciplinaIds) throws SQLException {
        String sql = "INSERT INTO aluno_disciplina (aluno_id, disciplina_id) VALUES (?, ?)";
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
            
            for (Long disciplinaId : disciplinaIds) {
                stmt.setLong(1, alunoId);
                stmt.setLong(2, disciplinaId);
                stmt.executeUpdate();
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
    }
    
    public List<Disciplina> getDisciplinasDoAluno(Long alunoId) throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT d.* FROM disciplina d " +
                    "JOIN aluno_disciplina ad ON d.id = ad.disciplina_id " +
                    "WHERE ad.aluno_id = ?";
        
        Connection conn = null;
        
        try {
        	conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, alunoId);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Disciplina disciplina = new Disciplina();
                    disciplina.setId(rs.getLong("id"));
                    disciplina.setNome(rs.getString("nome"));
                    disciplina.setCodigo(rs.getString("codigo"));
                    disciplinas.add(disciplina);
                }
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
        return disciplinas;
    }
    
    public List<Disciplina> listarTodasDisciplinas() throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        Connection conn = null;
        
        try {
        	 conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(rs.getLong("id"));
                disciplina.setNome(rs.getString("nome"));
                disciplina.setCodigo(rs.getString("codigo"));
                disciplinas.add(disciplina);
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
        return disciplinas;
    }
    
    public Disciplina buscarDisciplinaPorCodigo(String codigo) throws SQLException {
        String sql = "SELECT * FROM disciplina WHERE codigo = ?";
        Connection conn = null;
        
        try {
        	conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, codigo);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Disciplina disciplina = new Disciplina();
                    disciplina.setId(rs.getLong("id"));
                    disciplina.setNome(rs.getString("nome"));
                    disciplina.setCodigo(rs.getString("codigo"));
                    return disciplina;
                }
            }
        } finally {
        	if(conn != null)
        		DatabaseConnection.desconectar(conn);
        }
        return null;
    }
} 