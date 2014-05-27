
public class SaveThread implements Runnable{
	private AbstractController ac;
	private String path;
	private boolean append;

	SaveThread(AbstractController acp,String pathp,boolean appendp){
		ac = acp;
		path = pathp;
		append = appendp;
	}
	public void run() {
		try{
			Console.log("You are in the thread SAVE method!:D");
			ac.save(path,append);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}