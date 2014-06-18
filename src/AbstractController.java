import java.util.Iterator;
import java.util.Stack;
import java.lang.String;

/**
 * AbstractController
 *
 */
public abstract class AbstractController {

	//Constants
	// protected final int _CACHE_NUM = 100;
	protected final int _CACHE_NUM = 1000;
	protected final String _SEPARATOR = ";";
	
	//Private and general
	protected TST<Entity> Clt;
	protected Iterator it1, it2, it3;
	protected Stack<Iterator> stackIte = new Stack<Iterator>();
	protected DataController dCont;
	protected String _last_key = "";

	/**
	 * Constructor
	 * Post: Inicializa el DataController
	 */
	public AbstractController() {
		dCont = new DataController();
	}
	
	
	/**
	 * Post: Guarda los datos de memoria a archivo
	 * @param path
	 * @param append
	 * @throws Exception
	 */
	protected void save(String path, boolean append) throws Exception {

		// Guardamos si existen datos
		if (size() > 0) {
			
			//Abrimos el archivo
			dCont.open(path, append);
			
			//Reinicimos para que encodeString empieze desde el incio

			Iterator it = getIterator();
			String cache;
			
			while(it.hasNext()){
				//Reset cache 
				cache = "";
				//Iteracion
				for(int i = 0; i < _CACHE_NUM && it.hasNext(); ++i)
					cache += (it.next().toString()+_SEPARATOR);

				dCont.write(cache);
			}

			dCont.close();

		}
	}

	/**
	 * Pre: El archivo path debe exisitir
	 * Post: Carga los datos del archvio a memoria
	 * @param path
	 * @throws Exception
	 */
	protected void load(String path) throws Exception {
		//Precondiciones a la carga
		preConditionLoad();

		// Llamar la funcion load de archivo
		dCont.open(path, true);

		// Bucle de lectura
		String cache;
		String error = "";
		String[] parseS;
		
		int total = 0;
		
		while ((cache = dCont.read()) != null) {
			parseS = cache.split(_SEPARATOR);

			// Descomponemos el objeto
			for (int i = 0; i < parseS.length; i++) {
				//Aumentamos el numero de registros leidos
				total += 1;
				
				//Lanzamos la decodificacion y carga
				try {
					decodeString(parseS[i]);
				} catch(Exception e) {
					error += "Record "+total+": "+e.getMessage()+"\n";
				}
			}

		}
		
		//Cerrar el archivo
		dCont.close();
		
		//En caso de haber errores en la carga, lanzamos 
		if (error.length() > 0) throw new Exception("Fail to load information\n"+error);
	}

	/**
	 * Debe indicarse en cada controlador
	 * Post: Pasa el String a memoria como objetos
	 * @param l
	 * @throws Exception
	 */
	protected abstract void decodeString(String l) throws Exception;

	/**
	 * Debe indicarse en cada controlador
	 * Post: Pasa el String a memoria como objetos
	 * @param l
	 * @throws Exception
	 */
	protected abstract String encodeString() throws Exception;

	
	/**
	 * Pre: Revisa las condiciones previas para hacer una carga de daatos
	 * Varia en funcion del controlador
	 * Puede estar vacia, si no existen precondicones
	 * @return
	 * @throws Exception
	 */

	protected String encodeStringPresentation(Entity e, int cache_size) throws Exception {
		//Prvisional, tiene que ser abstracta y que la implementen todas las Entity
		return "foo";
	}

	protected void preConditionLoad() throws Exception {}
	
	/**
	 * Post: Devuelve el tamano de la coleccion
	 * @return
	 */
	public abstract int size();
	
	/**
	 * 
	 * @return
	 */
	protected abstract Iterator getIterator();

	public String getByNameToString(String name) throws Exception{
		//Hacerla abstracta
		return "";
	}

	public void updateEntityNameByName(String oldName, String newName) throws Exception{
		//Hacerla abstracta
	}

	// ---------------------------------------------
	// Cache Presentacion
	// ---------------------------------------------

	public String forwards(){
		String ret = "";
		int count = 0;
		Iterator it;
		stackIte.push(it1);

		for (; it3.hasNext() && count < _CACHE_NUM; ++count){
			// if(it.next().toString() != "1")
				ret += it3.next().toString();	
				it1.next();
				it2.next();
		}

		if(ret == "") return ret;

		
		// it1 = it2;	it2 = it3;	it3 = it;
		return ret;
	}

	public String backwards(){
		String ret = "";
		int count = 0;
		Iterator it;
		if(stackIte.empty()) return "_EMPTY_STACK";

		for (it = stackIte.pop(); it.hasNext() && count < _CACHE_NUM; ++count)
			ret = (ret + it.next().toString());

		it1 = it2;	it2 = it3; it3 = it;

		return ret;
	}

	public String refreshFirstCache(){
		//Chivato

		String ret = new String();
		int count = 0;
		Iterator it;
		//Esta linea no hace falta luego (it1 ya tiene valor)
		it1 = getIterator();

		for (it = it1; it.hasNext() && count < _CACHE_NUM; ++count){
			String[] aux = it.next().toString().split(" ");
			ret += (aux[0]+" ");
		}

		it2 = it;
		return ret;
	}

	public String refreshSecondCache(){
		//Chivato

		String ret = new String();
		int count = 0;
		Iterator it;

		for (it = it2; it.hasNext() && count < _CACHE_NUM; ++count){
			String[] aux = it.next().toString().split(" ");
			ret += (aux[0]+" ");
		}

		it3 = it;
		return ret;
	}

	//Parece que no servira para nada al final
	/*public String initFirstCache(){
		Console.print("Init firstCache");

		String ret = new String();
		int count = 0;
		Iterator it;
		it1 = getIterator();

		for (it = it1; it.hasNext() && it != it2 && count < _CACHE_NUM; ++count){
			String[] aux = it.next().toString().split(" ");
			ret += (aux[0]+" ");
		}

		it2 = it;
		return ret;

	}*/
/*
	public String initSecondCache(){
		Console.print("Init secondCache");

		String ret = new String();
		int count = 0;
		Iterator it;
		
		for (it = it2; it.hasNext() && it != it3 && count < _CACHE_NUM; ++count){
			String[] aux = it.next().toString().split(" ");
			ret += (aux[0]+" ");
		}

		it3 = it;
		return ret;

	}
*/
	public boolean needsRefreshing(String s){
		Iterator it_1 = it1;
		Iterator it_2 = it2;
		Iterator it_3 = it3;
		if(it_1.next().toString().compareToIgnoreCase(s) <= 0 && it_2.next().toString().compareToIgnoreCase(s) >= 0) return true;
		if(it_2.next().toString().compareToIgnoreCase(s) <= 0 && it_3.next().toString().compareToIgnoreCase(s)>= 0) return true;
		return false;

	}
}
