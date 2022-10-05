package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Domain.Avaliado;
import Domain.CriadorLeilao;
import Domain.Lance;
import Domain.Leilao;
import Domain.Usuario;

class AvaliadorTeste {
	
	private Avaliado leiloeiro;
	private Usuario maria; 
	private Usuario joao;
	private Usuario jose;
	
	@BeforeEach
	private void criaAvaliador() {
	  this.leiloeiro = new Avaliado();
	  this.joao = new Usuario("João");
	  this.jose = new Usuario("José");
	  this.maria = new Usuario("Maria");

}
	
	//Aula dia 27/09/2022
    
    @Test
    public void deveEntenderLancesEmOrdemDecrescente() {
    	
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
    	
		Leilao leilao = new Leilao("Playstation 5");
		
		leilao.propoe(new Lance(joao, 400.0));
		
		Avaliado leiloeiro = new Avaliado();
		 leiloeiro.avalia(leilao);
		 
		 assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
		 assertEquals(400, leiloeiro.getMenorLance(), 0.0001);
    	
    }
    
      //Aula dia 04/10/2022
    
	@Test
    public void deveEncontrarOsTresMaioresLances() {
    	
				
        Leilao leilao = new CriadorLeilao()
        		.para("Playstation 3 Novo")
        		.lance(joao, 100.0)
        		.lance(maria, 200.0)
        		.lance(joao, 300.0)
        		.lance(maria, 400.0)
        		.constroi();

    
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }
	
	@Test
    public void deveEncontrarListaOrdenada() {
    	
        
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 100.0)
				.lance(maria, 200.0)
				.lance(joao, 300.0)
				.lance(maria, 400.0)
				.constroi();
    
		criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }
	
	@Test
    public void deveEncontrarInversamenteOrdenada() {
    	
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 400.0)
				.lance(maria, 300.0)
				.lance(joao, 200.0)
				.lance(maria, 100.0)
				.constroi();
    
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }
    
	@Test
    public void deveEncontrarRandômica() {
    	
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.lance(maria, 100.0)
				.lance(joao, 400.0)
				.lance(maria, 300.0)
				.constroi();
    
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(300, maiores.get(1).getValor(), 0.00001);
        assertEquals(200, maiores.get(2).getValor(), 0.00001);
    }
	
	
	
	@Test
    public void deveEncontrarCom1Elemento() {
    	
        
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.constroi();
    
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(1, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        
    }
	
	@Test
    public void deveEncontrarCom2Elementos() {
    	
   
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.lance(maria, 100.0)
				.constroi();
    
        
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(2, maiores.size());
        assertEquals(200, maiores.get(0).getValor(), 0.00001);
        assertEquals(100, maiores.get(1).getValor(), 0.00001);
    }
	
	@Test
    public void deveEncontrarCom3Elementos() {
    	
   
		Leilao leilao = new CriadorLeilao()
				.para("Playstation 3 Novo")
				.lance(joao, 200.0)
				.lance(maria, 100.0)
				.lance(joao, 400.0)
				.constroi();
    
      
        criaAvaliador();
        leiloeiro.avalia(leilao);
        List<Lance> maiores = leiloeiro.getTresMaiores();
        
        assertEquals(3, maiores.size());
        assertEquals(400, maiores.get(0).getValor(), 0.00001);
        assertEquals(200, maiores.get(1).getValor(), 0.00001);
        assertEquals(100, maiores.get(2).getValor(), 0.00001);
    }
	
	
    @Test
	void deveEntenderLancesEmOrdemCrescente() {
		
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
    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
    	
    Leilao leilao = new CriadorLeilao()
    .para("Playstation 3 Novo")
    .constroi();
    assertThrows(RuntimeException.class, () ->leiloeiro.avalia(leilao));
    
      }
    
}
