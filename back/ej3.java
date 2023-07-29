package back;

import java.util.ArrayList;
import java.util.List;

public class ej3 {
	
	List<Integer> conjunto;
	List<List<Integer>> soluciones;
	int suma;
	
	public List<List<Integer>> crearEstadoInicial(int suma) {
		     // estado tiene camino parcial, sumaParcial, posActual
		     int posActual = 0;
		     int sumaParcial = 0;
		     this.suma = suma;
		     ArrayList <> caminoParcial = new ArrayList();
		     Estado estadoInicial = new Estado(posActual, sumaParcial, caminoParcial);
		     back(estadoInicial);
		     return this.soluciones;
		 }
		 
		 /* [1,3,2,5,10,12], total: 15, size(6)*/
		 /* Camino parcial [0,1,1,0,1,0] */
		 /* estado.sumaTotal = 6*/
		 /* PosActual = 3*/
		 public void back(Estado estado) {// el estado tiene el camino parcial, la posActual en el arreglo de conjunto y la suma parcial
		     if (estado.getPosActual() == conjunto.size()) {
		         if (estado.getSumaTotal() == this.suma) {
		             this.soluciones.add(estado.getCaminoParcial());
		         }
		         //Este metodo compara si 2 arreglos solucion tienen los mismos elementos, auqnue sea en diferente posicion
		         // lo agregamos a la solucion
		     } else {
		         int posActual = estado.getPosActual();// obtengo la posicion actual del conjunto en el estado
		         int numero = this.conjunto.get(posActual);//obtenemos el numero
		         if ((numero + estado.getSumaTotal()) <= this.suma) {//si lo podemos sumar a la solucion
		             estado.incrementarSumaParcial(numero);// incrementamos la suma
		             estado.getCaminoParcial().add(1);// agregamos un 1 al camino, ya que utilizamos
		             estado.setPosActual(posActual++);// avanzamos una posicion en el array de conjuntos
		             back(estado);
		             estado.setPosActual(posActual--);// volvemos una posicion atraz
		             estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1); //removemos el 1 de la solucion
		             estado.decrementarSumaParcial(numero);// restamos el numero de la suma parcial
		         }
		         estado.getCaminoParcial().add(0);// si no podemos sumar el numero a la solucion, agregamos un 0
		         estado.setPosActual(posActual++);// avanzamos una posicion en el array de conjuntos
		         back(estado);
		         estado.setPosActual(posActual--);// volvemos una posicion atraz
		         estado.getCaminoParcial().remove(estado.getCaminoParcial().size() - 1);
		    }
		 }
}
