

import java.util.LinkedList;
import java.util.Queue;

public class QAPBaBTree {
	QAPBaBTreeNode Node;

    public QAPBaBTree() // constructor
    {
        Node =  new QAPBaBTreeNode();
        
    }

    //el nodo principal de arbro sera nulla
    //al hora de insertar un nodo n con el padre p que tiene valor(en caso de nodo principal no hace falta,
    //el n tiene k tener un signaficado mayor o posterior que sus hermonos anteriores
    
    
    private QAPBaBTreeNode posicion(int[] va,int level) {
    	QAPBaBTreeNode focusNode = Node;
    	
    	for(int i = 0; i < level; i++) {
        	int p = va[i];
        	if(focusNode.FirstSon == null) focusNode.FirstSon = new QAPBaBTreeNode();
        	focusNode = focusNode.FirstSon;
        	while(focusNode.sp != null && p > focusNode.sp.va[i]) {
	    		if(focusNode.RightBro == null) focusNode.RightBro = new QAPBaBTreeNode();
	    		focusNode = focusNode.RightBro ;
	    	}
    	}
    	return focusNode;
    }
    
    public void addNode (QAPTNSolucion sp) {
    	posicion(sp.va, sp.level).sp = sp;
    }
    

    public double getcost(int[] va,int level) {
    	return posicion(va, level).sp.min;
    }
    
    
    public void WriteBFS () {
    	
    	
    	QAPBaBTreeNode focusNode = Node.FirstSon;

		
		
		Queue<QAPBaBTreeNode> q = new LinkedList<QAPBaBTreeNode>();
		q.offer(focusNode);
		while(!q.isEmpty()) {
			focusNode = q.poll();

			while(focusNode != null) {
				if(focusNode.FirstSon != null) {
					q.offer(focusNode.FirstSon);
				}
				focusNode.sp.show();
				
				focusNode = focusNode.RightBro;
			}
		}
    }
}
