
public abstract class ViewForm extends ViewPanel {

	/**
	 * 
	 * @param c
	 */
	ViewForm(AbstractControllerView c) {
		super(c);
	}
	
	/**
	 * Funcion que valida los formularios
	 * @throws Exception
	 */
	public abstract void submit_form() throws Exception;
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	protected boolean validString(String s) {
		
		if (s == null) return false;
		if (s.equals("") || s.length() == 0) return false;
		
		return true;
	}
}
