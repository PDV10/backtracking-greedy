package back;

public class ej2 {
	public Estado estado;
	public Solucion mejorSolucion;
	public Matriz matriz;
	
	public void back(Casillero origen, Casillero destino) { 	// donde cada casillero contiene un valor natural 
		estado = new Estado();									// y 4 booleanos que indican a donde puede desplazarse
		matriz = new Matriz();									// matriz conoce la poss de todos los casilleros
		estado.setCasilleroActual(origen);
		estado.setCasilleroDestino(destino);
		estado.getSolucionActual().add(origen); 				// agregamos el origen a la solucion actual en la inicializacion
		backtracking(estado);
	}
	
	public void backtracking(Estado estado) { 									// donde estado cuenta con casillero de origen , destino y una solucion parcial
		if(estado.getCasillero().equals(estado.getDestino())) { 				// si el casillero actual es igual que el de destino
			if(estado.getSolucionActual().total() < mejorSolucion.total()) {  	// total es la suma de los valores de la solucion
				 mejorSolucion = estado.getSolucionActual(); 
			}
		}else {
			if(!estado.getVisitados().contains(estado.getCasillero())){
				Casillero casilleroAnterior = estado.getCasillero();  
				iterator<Casillero> casillerosAdyacentes = matriz.getCasillerosAdyacentes(casilleroAnterior); // chequea con los booleanos del casillero los adyacentes posibles
				while(casillerosAdyacentes.hasnext()){	
					Casillero casillero = casillerosAdyacentes.next();
					if(!estado.getSolucionActual().contains(casillero)) {
						estado.getSolucionActual().add(casillero); 					// trabajo con casillero o con casilleroAnterior ????
						estado.setCasilleroActual(casillero);  						// actualiza el valor del casillero actual para que avance el backtracking 
						//if(matriz.puedeAvanzar(casilleroAnterior, casillero)) { 	// verifica que el casillero pueda avanzar al siguiente ( que exista, que no este visitado )
						if(estado.getSolucionActual().total() < mejorSolucion.total()) { // si el la solucion actual sigue siendo menor que la mejor solucion avanza
							backtracking(estado);
						}
						estado.getSolucionActual().remove(casillero);				// deshacemos los cambios
						estado.setCasillero(casilleroAnterior); 					// no es necesario porque se pisan unos con otros
						}															// solo se deshace si se van acumulando
					}
			}
		}
	}
}
