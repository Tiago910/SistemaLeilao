package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Domain.Avaliado;
import Domain.Lance;
import Domain.Leilao;
import Domain.Usuario;

class AvaliadorTeste {
	
    @Test
	void deveEntenderLancesEmOrdemCrescente() {
		
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		Avaliado leiloeiro = new Avaliado();
		 leiloeiro.avalia(leilao);
		 
		 assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
	
	}
    
    @Test
    public void deveEntenderLancesEmOrdemDecrescente() {
    	
    	Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(maria, 400.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 250.0));
		
		Avaliado leiloeiro = new Avaliado();
		 leiloeiro.avalia(leilao);
		 
		 assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
    	
    }
    
    @Test
    public void deveEntenderLancesSemOrdemEspecífica() {
    	
    	Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 300.0));
		
		Avaliado leiloeiro = new Avaliado();
		 leiloeiro.avalia(leilao);
		 
		 assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
    
    }
    
    @Test
    public void deveEntenderListaLanceUnico() {
    	
    	Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(joao, 400.0));
		
		Avaliado leiloeiro = new Avaliado();
		 leiloeiro.avalia(leilao);
		 
		 assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(400, leiloeiro.getMenorLance(), 0.0001);
    	
    }
    
}
