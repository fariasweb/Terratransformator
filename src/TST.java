import java.util.*;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

/**
 * TST<Value>
 * @param <Value>
 */
public class TST<Value> {
	
	//Atributos generales
	private int N; // tamano
	private Node root; // raiz del TST
	private int current; // variable auxiliar global para el metodo collectValuesCache
	
	/**
	 * Node
	 * Usada para crear el arbol
	 * Nodo generico sin valor asociado
	 */
	private class Node{
		protected char c; // caracter del nodo
		protected Node left, mid, right; // left, middle, y right subtries

		public Node(char ch, Node l, Node m, Node r){
			c = ch;
			left = l;
			mid = m;
			right = r;
		}

		public Node(){
			c = '\0';
			left = null;
			mid = null;
			right = null;
		}
		
		public Value getValue() {
			return null;
		}
		
		public char getC() {
			return c;
		}

		/*public boolean equals(Node aThat){
			return (this.getC() == (aThat.getC()));
		}*/
	}

	/**
	 * FinalInner
	 * Usada para crear el arbol
	 * Nodo que marca final de palabra y tiene valor asociado
	 */
	private class FinalNode extends Node {
		private Value val; // valor asociado con el string que acaba en este nodo

		public FinalNode(char ch, Node l, Node m, Node r){
			c = ch;
			left = l;
			mid = m;
			right = r;
		}

		public FinalNode(){
			c = '\0';
			left = null;
			mid = null;
			right = null;
		}
		
		public Value getValue() {
			return val;
		}
	}
	
	/**
	 * 
	 * @param x
	 * @return
	 */
	private boolean is_Node(Node x) {
		return x.getClass().getSimpleName().equals("Node");
	}

	/**
	 * Pre: True 
	 * Post: Devuelve el numero de elementos del TST
	 * @return int
	 */
	public int size() {
		return N;
	}

	/**
	 * Pre: True 
	 * Post: Devuelve true o false si existe o no un valor asociado
	 * a la clave key
	 * @param key
	 * @return boolean
	 */
	public boolean contains(String key) {
		if (key == null || key.length() == 0) return false;
		
		try{
			return get(key.toLowerCase()) != null;
		}
		catch (Exception e) {
			return false;
		}
	}

	//if not present returns null
	/**
	 * Devuelve el contendo de la llave indicada
	 * Pre: key debe ser un  nombre valido
	 * Post: En caso de existir devuelve el objeto asociado.
	 * 		En caso de no existir devuelve null.
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Value get(String key) throws Exception{

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");
		Value n = get(root, key.toLowerCase(), 0);
		
		if (n == null) throw new Exception (key+" does not exist");
		
		return n;
	}

	/**
	 * Auxiliar de get(String key)
	 * Pre: True
	 * Post: En caso de existir devuelve el objeto asociado.
	 * 		En caso de no existir devuelve null.
	 * @param x
	 * @param key
	 * @param d
	 * @return Node
	 */
	private Value get(Node x, String key, int d) throws Exception {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else{
			return x.getValue();
		}
	}

/*	private Node getNode(Node x, String key, int d) throws Exception {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return getNode(x.left, key, d);
		else if (c > x.c)
			return getNode(x.right, key, d);
		else if (d < key.length() - 1)
			return getNode(x.mid, key, d + 1);
		else{
			return x;
		}
	}*/

	/**
	 * Pre: s es un string valido
	 * Post: Inserta el elemento val con la clave s
	 * @param s
	 * @param val
	 * @return
	 * @throws Exception
	 */
	public void put(String s, Value val) throws Exception {
		root = put(root, s.toLowerCase(), val, 0);
	}

	/**
	 * Pre: x no debe ser nulo, s es un string valido
	 * Post: Crea un nuevo nodo con la infomacion de val; si ya existe un nodo con
	 * nombre key, lo sobrescribe con el nuevo valor de val
	 * @param x
	 * @param s
	 * @param val
	 * @param d
	 * @return Node
	 * @throws Exception
	 */
	private Node put(Node x, String s, Value val, int d) throws Exception {
		char c = s.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		if (c < x.c)
			x.left = put(x.left, s, val, d);
		else if (c > x.c)
			x.right = put(x.right, s, val, d);
		else if (d < s.length() - 1)
			x.mid = put(x.mid, s, val, d + 1);
		else {
			if (x.getClass().getSimpleName().equals("Node")){
				N++; x = new FinalNode(x.c, x.left, x.mid, x.right); 
			}
			
			((FinalNode)x).val = val;
		}
		return x;
	}


	/**
	 * Pre: True
	 * Post: Devuelve todas las llaves del TST ordenadas
	 * @return Iterable<String>
	 */
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}

	/**
	 * Auxiliar de keys()
	 * Pre: True
	 * Post: queue contiene todas las claves del TST ordenadas
	 * @param x
	 * @param prefix
	 * @param queue
	 * @return 
	 */
	private void collect(Node x, String prefix, Queue<String> queue) {		
		if (x == null) return;
		collect(x.left, prefix, queue);
		if (!is_Node(x))
			queue.add(prefix + x.c);
		collect(x.mid, prefix + x.c, queue);
		collect(x.right, prefix, queue);
	}
	
	/**
	 * Pre: True
	 * Post: Devuelve todos los objetos almacenados en el TST
	 * @return Iterable<String>
	 */
	public Iterable<Value> values() {
		Queue<Value> queue = new LinkedList<Value>();
		collectValues(root, "", queue);
		return queue;
	}
	
	/**
	 * Auxiliar de values()
	 * Pre: True
	 * Post: queue contiene todos los objetos del TST ordenados por su
	 * clave
	 * @param x
	 * @param prefix
	 * @param queue
	 * @return
	 */
	private void collectValues(Node x, String prefix, Queue<Value> queue) {		
		if (x == null) return;
		
		collectValues(x.left, prefix, queue);
		
		if (!is_Node(x))
			queue.add(x.getValue());
		
		collectValues(x.mid, prefix + x.c, queue);
		collectValues(x.right, prefix, queue);
	}
	
	
	/**
	 * Pre: True
	 * Post: Devuelve un numero max de objetos (o los que hayan si no hay max) 
	 * almacenados en el TST a partir de la clave key, no inclusive 
	 * @param key
	 * @param max
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Value> valuesCache(String key, int max) throws Exception{

		if(max < 1) throw new Exception("Mandatory: max > 0");
		if(!Util.checkName(key)) throw new Exception(key + " is not valid");
		Value v = get(root, key.toLowerCase(), 0);
		if(v == null) throw new Exception("Key not present");

		current = 1;
		ArrayList<Value> queue = new ArrayList<Value>();
		collectValuesCache(root, "", key, queue, max);
		return queue;
	}

	/**
	 * Auxiliar de valuesCache(String, int)
	 * Pre: True
	 * Post: queue contiene un numero max de objetos (o los que hayan si no hay max) 
	 * almacenados en el TST a partir de la clave key, no inclusive 
	 * @param x
	 * @param prefix
	 * @param key
	 * @param queue
	 * @param max
	 */
	private void collectValuesCache(Node x, String prefix, String key, ArrayList<Value> queue, int max) {

		if (x == null || current > max) return;
		
		//Chivato debug
		// Console.print("Key: " + key + "  Prefix: " + prefix + x.c);

		collectValuesCache(x.left, prefix, key, queue, max);

		//Chivato debug
		/*Console.echo("x.getClass().getSimpleName().equals("+"FinalNode"+"): ");
		if(x.getClass().getSimpleName().equals("FinalNode")) Console.print("TRUE");
		else Console.print("FALSE");
		Console.echo("current <= max: ");
		if(current <= max) Console.print("TRUE");
		else Console.print("FALSE");
		Console.echo("key.compareTo(" + prefix + x.c + ") < 0: ");
		if(key.compareTo(prefix+x.c) < 0) Console.print("TRUE");
		else Console.print("FALSE");*/

		if (!is_Node(x) && current <= max && key.compareTo(prefix+x.c) < 0){
			queue.add(((FinalNode)x).val);
			
			//Chivato debug
			// Console.print("--->"+((FinalNode)x).val.toString());
			++current;
			//Chivato debug
			// Console.print("--->Current: " + Integer.valueOf(current).toString());
		}
		
		collectValuesCache(x.mid, prefix + x.c, key, queue, max);
		collectValuesCache(x.right, prefix, key, queue, max);

	}


	/**
	 * Pre: El TST debe tener algun valor
	 * Post: Devuelve el primer elemento del TST
	 * @return
	 * @throws Exception
	 */
	public Value first() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return first(root);
	}

	/**
	 * Pre: True
	 * Post: Devuelve el primer elemento del TST
	 * @param x
	 * @return
	 * @throws Exception
	 */
	private Value first(Node x) throws Exception{
		
		//Testear!
		while(x.left != null) x = x.left;
		if(!is_Node(x)) return ((FinalNode)x).val;
		else if(x.mid != null) return first(x.mid);
		else throw new Exception("first: Debugging exception");
	}

	/**
 	 * Pre: El TST debe tener algun valor
	 * Post: Devuelve la primera clave con algun elemento asociado del TST
	 * @return
	 * @throws Exception
	 */
	public String firstKey() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return firstKey(root);
	}

	/**
	 * Pre: True
	 * Post: Devuelve la primera clave con algun elemento asociado del TST
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public String firstKey(Node x) throws Exception{

		//Testear!
		while(x.left != null) x = x.left;
		if(!is_Node(x)) return ""+x.c;
		else if(x.mid != null) return x.c+firstKey(x.mid);
		else throw new Exception("firstKey: Debugging exception");
	}

	/**
	 * Pre: True
	 * Post: Resetea el TST como si se acabara de crear
	 */
	public void clear() {
		root = null;
		N = 0;
	}

	/**
	 * Pre: Key debe ser un nombre valido y estar presente en el TST
	 * Post: Elimina el valor asociado a esa key
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public void remove(String key) throws Exception {

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		// Remove
		if (!remove(root, null, key.toLowerCase(), 0))
			throw new Exception("The key " + key + " doesn't exist");
	}

	/**
	 * Pre: True
	 * Post: Si existe un valor en el TST asociado a la clave key, elimina
	 * el valor y todos los nodos que ya no son necesarios debido a la eliminacion
	 * @param x
	 * @param key
	 * @param d
	 * @return boolean
	 */
	private boolean remove(Node x, Node aux, String key, int d) throws Exception{
		if (x == null) return false;

		char c = key.charAt(d);
		boolean del = false;

		if (c < x.c){
			del = remove(x.left, x, key, d);

			//Ayuda para debuggar
			/*Console.echo("Letra: "+x.c+" ");
			if(x.left == null) Console.echo("left ");
			if(x.mid == null) Console.echo("mid ");
			if(x.right == null) Console.echo("right ");
			if(aux != null) Console.echo("aux ");
			if(x.getClass().getSimpleName().equals("Node")) Console.echo("Node");
			Console.print("");*/
			//Fin ayuda para debuggar

			if(x.left == null && x.mid == null && x.right == null 
				&& aux != null && is_Node(x)) 
				aux.left = null;
		}
		else if (c > x.c){
			del = remove(x.right, x, key, d);

			//Ayuda para debuggar
			/*Console.echo("Letra: "+x.c+" ");
			if(x.left == null) Console.echo("left ");
			if(x.mid == null) Console.echo("mid ");
			if(x.right == null) Console.echo("right ");
			if(aux != null) Console.echo("aux ");
			if(x.getClass().getSimpleName().equals("Node")) Console.echo("Node");
			Console.print("");*/
			//Fin ayuda para debuggar

			if(x.left == null && x.mid == null && x.right == null 
				&& aux != null && is_Node(x)) 
				aux.right = null;

		}
		else if (d < key.length() - 1){
			del = remove(x.mid, x, key, d + 1);

			//Ayuda para debuggar
			/*Console.echo("Letra: "+x.c+" ");
			if(x.left == null) Console.echo("left ");
			if(x.mid == null) Console.echo("mid ");
			if(x.right == null) Console.echo("right ");
			if(aux != null) Console.echo("aux ");
			if(x.getClass().getSimpleName().equals("Node")) Console.echo("Node");
			Console.print("");*/
			//Fin ayuda para debuggar

			if(x.left == null && x.mid == null && x.right == null 
				&& aux != null && is_Node(x)) 
				{ 
					if(aux.left == x) aux.left = null;
					else if(aux.mid == x) aux.mid = null;
					else if(aux.right == x) aux.right = null;
					else throw new Exception("remove: Debugging Exception");
				}

		}
		else {
			if(x.is_Node()) return false;
			//Debug
			//Console.print("Delete");

			del = true;
			
			if(x.left == null && x.mid == null && x.right == null){
				if(aux.left == x) aux.left = null;
				else if(aux.mid == x) aux.mid = null;
				else if(aux.right == x) aux.right = null;
				else throw new Exception("remove: Debugging Exception");
			}
			else{ 
				Node y = new Node(x.c, x.left, x.mid, x.right);
				if(aux.left == x) aux.left = y;
				else if(aux.mid == x) aux.mid = y;
				else if(aux.right == x) aux.right = y;
				else throw new Exception("remove: Debugging Exception");
			}
			--N;
		}

		return del;
	}

	/**
	 * Utilidad exclusiva para debuggar, no tiene otro uso.
	 * Pre: Cierto
	 * Post: Vuelca por pantalla el TST para poder ver los nodos 
	 * y a donde apunta cada uno.
	 * @return
	 */
	public void dump(){
		dump(root, "");
	}

	private void dump(Node x, String prefix) {		
		if (x == null){ Console.print("null "); return; }
		Console.print(""+x.c);
		Console.print("left--->");
		dump(x.left, prefix);
		if (x.getClass().getSimpleName().equals("FinalNode"))
			Console.print("value: "+((FinalNode)x).val.toString());
		Console.print("..."+x.c);
		Console.print("mid--->");
		dump(x.mid, prefix + x.c);
		Console.print("..."+x.c);
		Console.print("right--->");
		dump(x.right, prefix);
	}
	
	
	/**
	 * Iterator TST
	 *
	 */
	private class TSTIterator implements Iterator<Value> {
		
		private Stack<Node> stack = new Stack<Node>();
		private Node current;
		

		/**
		 * 
		 */
	/*	public TSTIterator() {
			current = root;
		}*/

		/**
		 * 
		 * @param first
		 */
		public TSTIterator(Node x) {
			current = dfsAux(x);
		}
		
		/**
		 * 
		 */
		public boolean hasNext() {
			return (current != null);
		}
		
		/**
		 * 
		 */
		public Value next() {

		//>>>>>>>>>>>>>>>>NEXT ORIGINAL
		//Buscamos el siguiente nodo que sea una llave
			/*while (current != null && current.getValue() == null) {
			
				if (current.right != null)
					stack.push(current.right);
				if (current.mid != null)
					stack.push(current.mid);
				if (current.left != null)
					stack.push(current.left);

				current = stack.pop();
			}*/

			//Al encontar miramos los hijos por que seran los siguientes en mirarse
			/*if (current.right != null)
				stack.push(current.right);
			if (current.mid != null)
				stack.push(current.mid);
			if (current.left != null)
				stack.push(current.left);*/

			//Guardamos el valor actual
			/*Node node = current;*/

			//EN caso de no estar la pila vacia pasamos al sigueinte
			/*if (!stack.empty()) {
				current = stack.pop();
			} else {
				current = null;
			}*/

			/*
			 * current = current.left; stack.push(current.right);
			 * stack.push(current.mid);
			 */

/*			return node.getValue();*/

			//
			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		/*	Stack<Node> aux = new Stack<Node>();
			stack.copyInto(aux);
			while(!aux.empty()){
				Node a = aux.pop();
				String b = a.getValue().getName();
				Console.print(b);
			}*/
			

			//>>>>>>>>>>>>>>>>>>>NEXT NUEVO EN PROCESO

			Value v = current.getValue();
			stack.push(current);
			FinalNode ret = dfsAux(current.mid);
			
			if (ret != null){ current = ret; return v; }
			ret = dfsAux(current.right);
			if (ret != null) { current = ret; return v; }
				
			stack.pop();	
			if(ret == null) {
			Node n = stack.peek();
			Node rec = current;
			while(!stack.empty() && n!= null){
					// Console.print("HOLAAAAAA");
				//Warning!!!
				if(n.left != null && rec.equals(n.left)){
					 // Console.print("Esquerra");
					if(n != null && !is_Node(n)){
						current = stack.pop(); 
						return v;
					}

					if(n.mid != null){

						ret = dfsAux(n.mid);
						if (ret != null) {
						// Console.print("hyu");
					 
							// Console.print(""+n.mid.getC());
					
							current = ret; return v;}
					}

					ret = dfsAux(n.right);
					if (ret != null) { current = ret; return v;}

				} 
				
				if(n.mid != null && rec.equals(n.mid)){

					 // Console.print("Medio");
					ret = dfsAux(n.right);
					if (ret != null) { current = ret; return v;}
				}
				// else Console.print("Derecha");
				rec = stack.pop();
				if(!stack.empty()) n = stack.peek();
				
			}
		}
			current = null;
			return v;

			//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		}
		
		public void remove() {
			
		}

		private FinalNode dfsAux(Node n){

			if(n != null){
				stack.push(n);
				if(n.left != null)
					return dfsAux(n.left);

				if(!is_Node(n)){
					stack.pop();
					return (FinalNode) n;
				}
				
				if(n.mid != null)
					return dfsAux(n.mid);
				if(n.right != null)
					return dfsAux(n.right);
				stack.pop();
			}
			return null;
		}
		
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<Value> iterator() {
		return new TSTIterator(root);
	}
}


