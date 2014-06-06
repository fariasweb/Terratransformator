
public class SaveThread implements Runnable{
	private AbstractController ac;
	private AbstractControllerView acv;
	private String path;
	private boolean append;

	SaveThread(AbstractController acp, AbstractControllerView acvp, String pathp,boolean appendp){
		ac = acp;
		path = pathp;
		acv = acvp;
		append = appendp;
	}
	
	/**
	 * 
	 */
	public void run() {
		try{
			ac.save(path,append);
		} catch(Exception e){
			acv.show_general_error("Error load", e.getMessage());
		}
	}

}