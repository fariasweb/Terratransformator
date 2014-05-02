/**
 * AbstractController
 *
 */
public abstract class AbstractController {

	//Constants
	protected final int _CACHE_NUM = 7;
	protected final String _SEPARATOR = ";";
	
	//Private and general
	protected TST<Entity> Clt;
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
			
			String cache;
			//Reinicimos para que encodeString empieze desde el incio
			_last_key = ""; 
			//Numero de vueltas
			int num = (int) Math
					.ceil((double) size() / (double) _CACHE_NUM);

			for (int i = 0; i < num; i++) {
				
				//Codificamos una parte - cache
				cache = encodeString();
				Console.log("Guardar :"+cache);
				
				// Gaurdamos en disco
				if (cache.length() > 0)
					dCont.write(cache);

				// Limpiamos el string
				cache = "";
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
		String[] parseS;
		while ((cache = dCont.read()) != null) {
			parseS = cache.split(_SEPARATOR);

			// Descomponemos el objeto
			for (int i = 0; i < parseS.length; i++) {
				parseString(parseS[i]);
			}

		}
		
		//Cerrar el archivo
		dCont.close();
	}

	/**
	 * Debe indicarse en cada controlador
	 * Post: Pasa el String a memoria como objetos
	 * @param l
	 * @throws Exception
	 */
	protected abstract void parseString(String l) throws Exception;

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
	protected void preConditionLoad() throws Exception {}
	
	/**
	 * Post: Devuelve el tama�o de la coleci�n
	 * @return
	 */
	protected abstract int size();

}
