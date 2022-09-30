package Domain;

class TesteDoAvaliador {

	public static void main(String[] args) {
		
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		Avaliado leiloeiro = new Avaliado();
		
		leiloeiro.avalia(leilao);
		
		System.out.println(leiloeiro.getMaiorLance());
		
		System.out.println(leiloeiro.getMenorLance());
	}
}
