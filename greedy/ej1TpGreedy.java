package greedy;

public class ej1TpGreedy {
	public int monto = 389;
	public int montoAux = monto;
	public Candidato valorActual;
	
	public Conjunto<Candidato> greedy(Conjunto<Candidato> candidatos) {
		Conjunto<Candidato> solucion = new Conjunto<Candidato>();
	
		while(!candidatos.getCandidatos().isEmpty() && !esSolucion(solucion)) {  			// Donde esSolucion() comprueba que la suma de los candidatos dentro de la solucion 
																			// Sea igual al monto total 																							
 			valorActual = candidatos.getCandidatos().getPrimero();			// GetPrimero() retorna al primer candidato
			if(esFactible(valorActual)) {									// Retorna true si el valor Actual es menor que el monto, se actualzia el montoAux
				solucion.add(valorActual);
			}else {
				candidatos.getCandidatos().remove(valorActual);
			}
		}
		if(esSolucion(solucion)) {
			return solucion;
		}else {
			System.out.println("no hay solucion");
			return null;
		}
	}
}