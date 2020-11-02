package br.com.projeto.pag.contasbancarias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank (message = "Nome não pode estar em branco")
	private String contaNome;
	
	@NotBlank (message = "Número da conta não pode estar em branco")
	@PositiveOrZero (message = "Necessário ser um número")
	@Column(unique=true)
	private String contaNumero;
	
	@NotBlank (message = "Agência não pode estar em branco")
	@PositiveOrZero (message = "Necessário ser um número")
	private String agencia;
	
	private String chequeEspecialLiberado;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 100.00")
	@NotNull
	private String saldo;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 100.00")
	@NotNull
	private String chequeEspecial;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 1.99")
	@NotNull
	private String taxa;
	
	private String juros;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContaNome() {
		return contaNome;
	}
	public void setContaNome(String contaNome) {
		this.contaNome = contaNome;
	}
	public String getContaNumero() {
		return contaNumero;
	}
	public void setContaNumero(String contaNumero) {
		this.contaNumero = contaNumero;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getChequeEspecialLiberado() {
		return chequeEspecialLiberado;
	}
	public void setChequeEspecialLiberado(String chequeEspecialLiberado) {
		this.chequeEspecialLiberado = chequeEspecialLiberado;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getChequeEspecial() {
		return chequeEspecial;
	}
	public void setChequeEspecial(String chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}
	public String getTaxa() {
		return taxa;
	}
	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}
	public String getJuros() {
		return juros;
	}
	public void setJuros(String juros) {
		this.juros = juros;
	}
	
}