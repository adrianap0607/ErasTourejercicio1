public class Comprador {
  private String nombre;
  private String email;
  private int numBoletos;
  private int presupuesto;

  public Comprador(String nombre, String email, int numBoletos, int presupuesto) {
      this.nombre = nombre;
      this.email = email;
      this.numBoletos = numBoletos;
      this.presupuesto = presupuesto;
  }

  // Getters
  public String getNombre() {
      return nombre;
  }

  public String getEmail() {
      return email;
  }

  public int getNumBoletos() {
      return numBoletos;
  }

  public int getPresupuesto() {
      return presupuesto;
  }

  // Setters
  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public void setNumBoletos(int numBoletos) {
      this.numBoletos = numBoletos;
  }

  public void setPresupuesto(int presupuesto) {
      this.presupuesto = presupuesto;
  }
}  







