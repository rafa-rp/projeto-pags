package br.com.projeto.pag.contasbancarias.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import br.com.projeto.pag.contasbancarias.model.Conta;

public class RequisicaoNovaConta {
	
	private Integer contaId;
	
	@NotBlank (message = "Nome da conta não pode estar em branco")
	private String contaNome;
	
	@NotBlank (message = "Número da conta não pode estar em branco")
	@PositiveOrZero (message = "Necessário ser um número")
	@Column(unique=true)
	private String contaNumero;
	
	@NotBlank (message = "Agência não pode estar em branco")
	@PositiveOrZero (message = "Necessário ser um número")
	private String agencia;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 100.00")
	@NotNull
	private String saldo;
	
	private String chequeEspecialLiberado;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 100.00")
	@NotNull
	private String chequeEspecial;
	
	@Pattern(regexp = "^\\d+\\.\\d{2}$", message="O campo deve ser preenchido conforme modelo: 1.99")
	@NotNull
	private String taxa;
	
	
	public Integer getContaId() {
		return contaId;
	}
	public void setContaId(Integer contaId) {
		this.contaId = contaId;
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
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getChequeEspecialLiberado() {
		return chequeEspecialLiberado;
	}
	public void setChequeEspecialLiberado(String chequeEspecialLiberado) {
		this.chequeEspecialLiberado = chequeEspecialLiberado;
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
	
	public Conta toConta() {
		Conta conta = new Conta();
		conta.setContaNome(contaNome);
		conta.setContaNumero(contaNumero);
		conta.setAgencia(agencia);
		conta.setTaxa(taxa);
		conta.setSaldo(saldo);
		conta.setChequeEspecial(chequeEspecial);
		conta.setChequeEspecialLiberado(chequeEspecialLiberado);

		return conta;	
	}
}
