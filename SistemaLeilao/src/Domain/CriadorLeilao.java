package Domain;

public class CriadorLeilao {
	private Leilao leilao;

	public CriadorLeilao() {
		
	}

	public CriadorLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;

	}

	public CriadorLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
		
	}
	
}
