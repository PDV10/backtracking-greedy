package back;

import java.util.ArrayList;
import java.util.Iterator;

public class ej1Tpback {
	
	Solucion solucion_final;
	Sala destino;
	
	
	public void back(Sala entrada) {
		Estado estado = new Estado();
		estado.setSalaActual(entrada);
		estado.getSalasVisitadas().add(entrada); 
		backtracking(estado);
	}
	
															
	private void backtracking(Estado estado) { // estado cuenta con : Sala salaActual , Solucion solucion_parcial y salas visitadas
																	
		if(estado.getSalaActual().equals(this.destino)) {
			if(estado.getSolucion().size() > this.solucion_final.size()) {
				this.solucion_final = estado.getSolucion();	
			}
		}else {
//			Iterator<Sala> salasAdyacentes = estado.getSalaActual().getSalasVecinas();
			Iterator<Puerta> puertas = estado.getSalaActual().getPuertas(); // puerta conoce sala de origen y sala de destino
		
			Sala salaAnterior = estado.getSalaActual(); // me quedo con la sala actual antes de avanzar a la siguiente
			while(puertas.hasNext()) {				
				
				Sala salaActual = puertas.next().getSalaDestino();  
				if(!estado.getSalasVisitadas().contains(salaActual)) {
					estado.setSalaActual(salaActual);		// se actualiza la sala actual del estado
					estado.getSalasVisitadas().add(salaActual); 
					estado.getSolucion().add(salaActual);  // agrega la sala al conjunto solucion parcial
					backtracking(estado);
					estado.getSolucion().remove(salaActual); // deshacemos los cambios 	
					estado.getSalasVisitadas().remove(salaActual);
					estado.setSalaActual(salaAnterior);
				}
			}
		}
	}
}
