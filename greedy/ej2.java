package greedy;

public class ej2 {
	
	public int pesoMax = 20;
	
	public conjunto<Candidato> greedy(conjunto<Candidato> candidatos){ 	// Donde candidatos es un conjunto de objetos con un peso y un valor cada uno
		conjunto<Candidato> solucion = new conjunto<Candidato>();
		candidatos = OrdernarPorValor(candidatos);						// Criterio greedy: se ordenan segun el elemento con mayor valor
		while(!candidatos.isEmpty() && !this.cumple(solucion)) {   		// Donde cumple() comprueba que no se haya supere el peso maximo
 			Candidato objeto = candidatos.getPrimero();					// GetPrimero() retorna al primer candidato del conjunto de candidatos
 			candidatos.remove(objeto);
 			if(objeto.getPeso() < this.pesoMax) {
 				solucion.add(objeto);
 				this.pesoMax -= objeto.getPeso();
 			}else {
 				objeto.setPeso(obtenerFraccionMax(objeto));				// Este metodo actualiza la maxima fraccion del peso del objeto que entre en el peso max actual 
 				objeto.setValor(obtenerValor(objeto));					// Este metodo actualiza el valor del objeto en funcion del peso
 				solucion.add(objeto);
 			}
		}
		
		if(this.cumple(solucion)) {
			return solucion;
		}else {
			System.out.println("no hay solucion");
			return null;
		}
	}
}
