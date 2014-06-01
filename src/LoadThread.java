public class LoadThread implements Runnable{
	private AbstractController ac;
	private String path;

	LoadThread(AbstractController acp,String pathp){
		ac = acp;
		path = pathp;
	}

	public void run() {
		try{
			System.out.println("You are in the thread LOAD method!:D");
			ac.load(path);  
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}