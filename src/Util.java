/**
 * 
 */

/**
 * @author farias
 *
 */
public class Util {

	public static boolean checkName(String namep) {
	
		boolean is_correct = true;
		int i = 0;
		
		while(is_correct && i < namep.length()) {
			if(!((namep.charAt(i) >= 'a') && (namep.charAt(i) <= 'z'))){
				if(!((namep.charAt(i) >= 'A') && (namep.charAt(i) <= 'Z'))){
					if((namep.charAt(i) >= '0') && (namep.charAt(i) <= '9')){
						is_correct = false;
					}
				}
			}
			
			++i;
		}	
		
		return is_correct;
	}
	
}
