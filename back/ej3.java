package back;

import java.util.ArrayList;
import java.util.Iterator;

public class ej3 {
	public Estado estado;
	public ArrayList<Conjunto> solucion;
	public Total solucion_parcial;
	
	public ArrayList<Conjunto> back(Conjunto conjunto, int total) { 	//conjunto cuenta con un conjunto valores del tipo valor que dentro tiene un valor positivo y un booleano de si se uso
		estado = new Estado(); 											// y total conoce el valor a encontrar en un subconjunto del conjunto
		estado.setConjunto(conjunto);									// y la poss actual 
		estado.setTotal(total);
		estado.setPosActual(0);
		backtracking(estado);
		return this.solucion;
	}
	/* [6,4,2,1,3] 
		solucion parcial = [6]
		size() = 4
		poss = 2
	*	valor actual = 	6 false
	*					4 false
	*					2 true
	*/
	public void backtracking(Estado estado) { 
		if(estado.getPosActual() == estado.getConjunto().size()) {  
			if(estado.getSolucionParcial().suma() == estado.getTotal()) {
				solucion.add(estado.getSolucionParcial());
				// solucion parcial se vacia
				// poss actual = 0;
				// como sigo? 
			}
		}else {
			Iterator<Valor> valores = estado.getConjunto().iteracion(); 			// iteracion() devuelve un iterator de los valores de tipo Valor del conjunto
			int posActual = estado.getPosActual();
			while(valores.hasNext()) {
				Valor valor = valores.next();
				if(!estado.getSolucionParcial().contains(valor)) {
					if(valor.NoloUso()) {													// retora true si se desea usar 	
						estado.getSolucionParcial().add(valor);	
						estado.setPosActual(posActual++);
						valor.setUso(false);												// se cambia el valor de usado
						if(estado.getSolucionParcial().suma() <= estado.getTotal()) {		//poda (si la solucion parcial sigue siendo menor que el resultado buscado)
							backtracking(estado);
						}
						estado.getSolucionParcial().remove(valor);
						estado.setPosActual(posActual--);
					}
					estado.setPosActual(posActual++);
					backtracking(estado);
					estado.setPosActual(posActual--);
				}
				
			}
 		}
	}
}
