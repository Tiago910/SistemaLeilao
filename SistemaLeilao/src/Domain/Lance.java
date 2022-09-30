package Domain;

public class Lance {
	
 private Usuario usuario;
 
 private Double valor;
 
 public Lance(Usuario usuario, Double valor) {
   this.usuario = usuario;
   this.valor = valor;
 
 }
 
   public Double getValor() {
   return valor;
 
 }
 
   public Usuario getUsuario() {
   return usuario;
 
 }
 
   public void setUsuario(Usuario usuario) {
   this.usuario = usuario;
 
 }
 
   public void setValor(Double valor) {
   this.valor = valor;
 
   }
 
}