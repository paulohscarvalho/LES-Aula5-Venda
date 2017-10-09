package edu.entidade;

import java.util.Date;

public class Venda {
	
	private String nomeCliente = "";
	private String plataforma = "";
	private Date data = new Date();
	private float valor;
	private String descricao = "";
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Nome Cliente : " + getNomeCliente() + "\n");
		sb.append("Plataforma : " + getPlataforma() + "\n");
		sb.append("Data : " + getData() + "\n");
		sb.append("Valor : " + getValor() + "\n");
		return sb.toString();
	}
}
