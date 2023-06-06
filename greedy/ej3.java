package greedy;

public class ej3 {
	
	public conjunto<Actividad> greedy(Conjunto<Actividad> actividades){
		conjunto<Actividad> solucion = new conjunto<Actividad>();
		
		ordenarPorHoraInicio(actividades);
		
		while(!actividades.getActividades().isEmpty) {
			Actividad actividad= actividades.getActividades().getPrimera();		// obtengo la primera actividad de las actividades
			if(esCompatible(actividad,solucion)){				// es compatible retorna true, si la actividad no se suporpone con ninguna otra actividad 
				solucion.getActividades().add(actividad);			// Agrego la actividad a la solucion
			}
			actividades.getActividades().remove(actividad);
		}
		
		if(!solucion.getActividades().isEmpty()) {							// si existen actividades en la solucion la retorno
			return solucion;
		}else {
			System.out.println("no hay solucion");
			return null;
		}
	}
}