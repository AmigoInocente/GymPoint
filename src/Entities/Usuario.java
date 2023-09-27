package Entities;

import Enums.Funcao;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.mindrot.jbcrypt.BCrypt;


@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "senha_hash")
    private String password_hash;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "funcao_usuario")
    private Funcao funcao_usuario;
    
    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;
    
    public Usuario() { }

    public Usuario(String nome, String email, String senha, Funcao funcao_usuario) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.password_hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        this.funcao_usuario = funcao_usuario;
        this.data_criacao = new Date();
    }

    

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public Funcao getFuncao_usuario() {
        return funcao_usuario;
    }

    public Date getData_criacao() {
        return data_criacao;
    }
    
    
}
