public class LoadThread implements Runnable{
	private AbstractController ac;
	private AbstractControllerView acv;
	private String path;

	LoadThread(AbstractController acp, AbstractControllerView acvp, String pathp){
		ac = acp;
		acv = acvp;
		path = pathp;
	}

	public void run() {
		try{
			
			//Cargar datos en controlador de dominio
			ac.load(path);
			//Mostrar datos en tabla
			acv.reloadTable();
		}
		catch(Exception e){
			acv.show_general_error("Error load", e.getMessage());
		}
	}
}