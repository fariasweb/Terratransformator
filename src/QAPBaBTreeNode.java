import java.util.ArrayList;

public class QAPBaBTreeNode {
	
	
	 public QAPTNSolucion sp;
	
	 public QAPBaBTreeNode FirstSon;
	 public QAPBaBTreeNode RightBro;
	 
	 public QAPBaBTreeNode(QAPTNSolucion  s) {//constructor
		 	sp = s;

		   	FirstSon = null;
		   	RightBro = null;
	 }
	 
	
	 public QAPBaBTreeNode() {//constructor
	        sp = null;
		   	FirstSon = null;
		   	RightBro = null;
	 }
	 
	 

	  public void show() {
		  sp.show();
	  }
	  
	  public String toString() {
		  return sp.toString();
	  }
	 
	 public ArrayList<QAPBaBTreeNode> getSons() {
       QAPBaBTreeNode focusNode = FirstSon;
        ArrayList<QAPBaBTreeNode> aux = new ArrayList<QAPBaBTreeNode>();
        while(focusNode != null) {  
            aux.add(focusNode);
            focusNode = focusNode.RightBro;
        }
        return aux;
    }

}
