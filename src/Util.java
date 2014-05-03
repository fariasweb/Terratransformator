/**
 * 
 */

/**
 * @author farias
 *
 */
public class Util {

	public static boolean checkName(String namep) {
	
		//Que no sea nulo
		if (namep == null) return false;
		
		//Que no este vacio
		if (namep.length() == 0) return false;
		
		//La primera debe de ser una letra
		if(!((namep.charAt(0) >= 'a') && (namep.charAt(0) <= 'z'))){
			if(!((namep.charAt(0) >= 'A') && (namep.charAt(0) <= 'Z'))){
				return false;
			}
		}
		
		//Miramos el resto de la cadena
		boolean is_correct = true;
		int i = 1;
		
		while(is_correct && i < namep.length()) {
			if(!((namep.charAt(i) >= 'a') && (namep.charAt(i) <= 'z'))){
				if(!((namep.charAt(i) >= 'A') && (namep.charAt(i) <= 'Z'))){
					if(!((namep.charAt(i) >= '0') && (namep.charAt(i) <= '9'))){
						is_correct = false;
					}
				}
			}
			
			++i;
		}	
		
		return is_correct;
	}
	
	public static double vectorialDistance(PairInt pair1, PairInt pair2){
		    return Math.sqrt(((pair1.getX() - pair2.getX())*((pair1.getX() - pair2.getX()) + (( pair1.getY() - pair2.getY())*( pair1.getY() - pair2.getY())))));
	}
}
