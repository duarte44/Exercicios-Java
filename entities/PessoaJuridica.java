package entities;

public class PessoaJuridica extends Pessoa {
	
	private int quantidade;
	
	public PessoaJuridica() {
		
	}	
	
	public PessoaJuridica(String nome, double rendaAnual, int quantidade) {
		super(nome, rendaAnual);
		this.quantidade = quantidade;
	}


	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public double renda() {
		if(this.quantidade > 10) {
			return (super.getRendaAnual() * 0.14);
		}
		else {
		return (super.getRendaAnual() * 0.16);
		
		}
	}
}
