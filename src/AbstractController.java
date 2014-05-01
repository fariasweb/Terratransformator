import java.util.ArrayList;

public abstract class AbstractController {

	protected final int _CACHE_NUM = 5;
	TST<Entity> Clt;
	private DataController dCont;

	protected void save(String path) throws Exception{
		
		//Guardamos si existen datos
		if (Clt.size() > 0) {
			
			dCont.open(path);
			
			ArrayList<Entity> list;
			String cache;
			
			String last_key = Clt.firstKey();
			int num = Clt.size() / _CACHE_NUM; //Numero de iteraciones segun tama–o cache
			
			for (int i = 0; i < num; i++) {
				//
				cache = "";
				list = Clt.valuesCache(last_key, _CACHE_NUM);
				
				//Pasamos objetos a cache
				for(Entity p : list) {
					cache += p.toString()+";";
					last_key = p.getName();
				}
				
				//Gaurdamos en disco
				if (cache.length() > 0) dCont.write(cache);
			}
			
			dCont.close();
			
		}
	}
	
	protected void load(String path) throws Exception{
		//TODO: Con cache
		
		//preConditionLoad();
		
		//Llamar la funcion load de archivo
		
		//Bucle
		//...
			//Pasa de string a objeto
			//parseString("G1 5 6");
		//...
	}
	
	protected void parseString(String l) {
		//
	}
	
	protected boolean preConditionLoad() {
		return true;
	}
	
}
