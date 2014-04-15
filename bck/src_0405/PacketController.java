/**
 * GalaxyController
 * 
 * @author farias
 *
 */

import java.util.ArrayList;
import java.util.List;

public class PacketController extends AbstractController{

	PacketCollection PacketClt;
		
	/**
	 * 
	 */
	public PacketController() {
		PacketClt = new PacketCollection();
	}
	
	/**
	 * Crea un paquete en el sistema
	 * Post: Se crea un paquete en el sistema, devuelve el identificar asignado
	 * 
	 * @return int
	 */
	public int create() {
		//TODO Validaciones
		//if (PacketClt.existByName(name)) throw new Exception(1, "Fran");
		
		Packet g = new Packet();
		PacketClt.add(g);
		
		return g.getId();
	}
	
	/**
	 * Devuelve un listado con los identificadores de paquetes
	 * TODO: Como lo hago para devolmes mas campos????
	 * @return List<Integer>
	 */
	public List<Integer> getAll() {
		
		List<Integer> list = new ArrayList<Integer>();
		
		//Comprobamos que exista algo en el array
		if(PacketClt.size() > 0){
			for(Packet i : PacketClt.getAll()){
				list.add(i.getId());
			}
		}
		
		return list;
	}
	
}
