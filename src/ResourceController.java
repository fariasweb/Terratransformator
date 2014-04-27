import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class ResourceController extends AbstractController{

	private ResourceTST TST;

	//Contructs
	//---------------------------------------------

	/**
	 * Crea un resourceClt
	 * Pre: cierto
	 * Post: Existe un nuevo resourceClt
	 */
	public ResourceController() {
		TST = new ResourceTST();
	}


	

     /**
	 * Devuelve un listado de todos los recursos ordenados por nombre. Cada elemento es
	 * un recurso, y de cada elemento, el primer elemento es el nombre, el segundo el tipo
	 * en forma de String
	 * Pre: cierto
	 * Post: Devuelve un listado con los campos recursos ordenados por nombre
	 * @return List<String>
	 * @throws Exception
	 */
   /* public ArrayList<ArrayList<String>> getAll() throws Exception{   
        ArrayList<ArrayList<String>> listOfLists = new ArrayList<ArrayList<String>> ();
        List<String> list = new ArrayList<String>();

       	if(resourceTST.size() == 0) throw new Exception("No resources!");

        for(Resource i: resourceTST.values())
   	    	listOfLists.add(i.toString());

        return listOfLists;
    }*/


	


	


	//Save/load
	//---------------------------------------------

	public void save() throws Exception{

		String cache = TST.first().toString();
		ArrayList<Resource> list = TST.getMany(TST.firstKey(), 5);
		for(Resource r : list)
			cache += r.toString();
		//ResourceGD.save(cache);

		while(list.size() > 0){

			list = TST.getMany(list.get(list.size()-1).getName(),5);
			cache = "";
			for(Resource r : list)
				cache += r.toString();
			//ResourceGD.save(cache);
		}
	}

	public void load(){

	}

}



			// Iterator<List<String>> iter = listOlist.iterator();
			// while(iter.hasNext()){
			//     Iterator<String> siter = iter.next().iterator();
			//     while(siter.hasNext()){
			//          String s = siter.next();
			//          System.out.println(s);
			//      }
			// }
			// 