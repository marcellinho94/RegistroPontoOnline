package com.br.pontu.entity;

import com.br.pontu.enums.Departamento;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.br.pontu.enums.EstadoCivil;
import com.br.pontu.enums.Role;

/**
 * Entidade que é responsável pelo dados dos usuários Sendo eles de carater
 * administrador ou funcionários Sendo separados por niveis de acesso em suas
 * funções
 *
 * @author Alves
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //  Atributos Inicio   =========================================================================
    private Long id;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String carteiraDeTrabalho;
    private String rg;
    private String celular;
    private String fixo;
    private EstadoCivil estadoCivil;
    private String email;
    private String cargo;

//    private String senha;

    private Role acesso;
    private Adress endereco;
//        private List<PontoDataHora> ponto;
    private Departamento departamento;

    // FIM ========================================================================================
    /**
     * Getters And Setters Contendo as anotações de verificação
     * =======================================================
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 15)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 60)
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @NotNull
    @Column(name = "data_nascimento", nullable = false)
    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 13)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 20)
    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 20)
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 14)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    // Este Atributo pode ser opcional, sendo não é necessário
    // Validação
    @Column(length = 14)
    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @NotNull
    @NotEmpty
    @Email
    @Column(nullable = false, length = 90)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



//    @NotNull
//    @NotEmpty
//    @Column(nullable = false, length = 20)
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

//	 @NotNull
//	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	 public List<PontoDataHora> getPonto() {
//			return ponto;
//	}
//	public void setPonto(List<PontoDataHora> ponto) {
//			this.ponto = ponto;
//	}
    @Embedded
    public Adress getEndereco() {
        return endereco;
    }

    public void setEndereco(Adress endereco) {
        this.endereco = endereco;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public Role getAcesso() {
        return acesso;
    }

    public void setAcesso(Role acesso) {
        this.acesso = acesso;
    }

    @NotNull
    @NotEmpty
    @Column(name = "cargo")
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * FIM
     * ====================================================================================
     */
    // Equals and Hash Code -------------------------------------------------------------------
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
    //------------------------------------------------------------------------------------------

    /**
     * Métodos Auxiliares
     * ---------------------------------------------------------------------
     */
}
