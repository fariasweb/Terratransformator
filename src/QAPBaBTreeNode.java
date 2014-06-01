

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
	 
}
