package greedy;

public class polen {
	public int MAXFLORES = 5;
	
	public conjunto<flor> greedy(Abeja abeja, conjunto<flor> flores) {	// abeja conoce las cant de flores visitadas (arranca en 0), y la posicion actual en donde esta
		conjunto<flor> solucion = new conjunto<flor>();
		this.ordenar(flores.getFlores()); 						// ordena las flores de mayor a menor segun la cantidad de polen que contenga cada flor
		
		while(abeja.getCantFloresVisitadas()<5) {
			Flor flor = flores.getFlores().get(0);				// obtengo la primera flor del arreglo
			
			if(abeja.getPoss() <= flor.getPoss()) {
			}
		}
		return solucion;
	}
}
