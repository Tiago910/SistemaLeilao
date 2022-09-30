package Domain;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	
   private String objeto; //objeto a ser leiloado
 
   private List<Lance> lances = new ArrayList<>(); //lista dos lances
 
   public Leilao(String objeto) {
    this.objeto = objeto;
 
 }
 
   public String getObjeto() {
   return objeto;
 
 }
 
   public void setObjeto(String objeto) {
   this.objeto = objeto;
 
 }
 
   public List<Lance> getLances() {
   return lances;
 
 }
 
   public void setLances(List<Lance> lances) {
   this.lances = lances;
 
 }
 
   public void propoe(Lance lance) {
   lances.add(lance);
 
    }
 
}