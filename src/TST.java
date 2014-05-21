import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * TST<Value>
 * @param <Value>
 */
public class TST<Value> {
	
	//Atributos generales
	private int N; // size
	private Node root; // root of TST
	private int current;
	
	/**
	 * Node
	 * Usada para crear el arbol
	 */
	private class Node {
		private char c; // character
		private Node left, mid, right; // left, middle, and right subtries
		private Value val; // value associated with string
	}

	/**
	 * Devuelve el numero de elementos
	 * @return int
	 */
	public int size() {
		return N;
	}

	/**
	 * Post: Indica si existe o no valor en la clave indicada
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
	 * Pre: key debe ser un nombre valido
	 * Post: En caso de existir devuelve el objeto asociado
	 * 		En caso de no exisiter devuelve null;
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public Value get(String key) throws Exception{

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		Node x = get(root, key.toLowerCase(), 0);
		
		return x.val;
	}

	/**
	 * 
	 * @param x
	 * @param key
	 * @param d
	 * @return Node
	 */
	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		char c = key.charAt(d);
		if (c < x.c)
			return get(x.left, key, d);
		else if (c > x.c)
			return get(x.right, key, d);
		else if (d < key.length() - 1)
			return get(x.mid, key, d + 1);
		else
			return x;
	}

	/**
	 * Post: Inserta el elemento val con la llave s
	 * @param s
	 * @param val
	 * @throws Exception
	 */
	public void put(String s, Value val) throws Exception {
		root = put(root, s.toLowerCase(), val, 0);
	}

	/**
	 * Pre: x no debe ser nulo
	 * Post: Crea un nuevo nodo con la infomacion de val
	 * @param x
	 * @param s
	 * @param val
	 * @param d
	 * @return
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
			if (x.val == null) {
				
				N++;
				x.val = val;
			} else {
				throw new Exception("The key " + s + " exists");
			}
		}
		return x;
	}


	/**
	 * Devuelve todas las llaves del TST ordenadas
	 * @return
	 */
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}

	/**
	 * Pre: X no debe ser nulo
	 * @param x
	 * @param prefix
	 * @param queue
	 */
	private void collect(Node x, String prefix, Queue<String> queue) {		
		if (x == null)
			return;
		collect(x.left, prefix, queue);
		if (x.val != null)
			queue.add(prefix + x.c);
		collect(x.mid, prefix + x.c, queue);
		collect(x.right, prefix, queue);
	}
	
	/**
	 * Devuelve todos los objetos almacenados en el TST
	 * @return
	 */
	public Iterable<Value> values() {
		Queue<Value> queue = new LinkedList<Value>();
		collectValues(root, "", queue);
		return queue;
	}
	
	/**
	 * Pre: x no debe ser nulo
	 * Post: Guarda en queue los objetos del TST
	 * @param x
	 * @param prefix
	 * @param queue
	 */
	private void collectValues(Node x, String prefix, Queue<Value> queue) {		
		if (x == null)
			return;
		
		collectValues(x.left, prefix, queue);
		if (x.val != null)
			queue.add(x.val);
		
		collectValues(x.mid, prefix + x.c, queue);
		collectValues(x.right, prefix, queue);
	}
	
	
	/**
	 * Devuelve los elementos del TST limitados por un max y un min
	 * Pre: X no debe ser nulo
	 * 		current <= max
	 * Post: Alamcena en queue los emenetos que cumplan los cirterios
	 * @param x
	 * @param prefix
	 * @param key
	 * @param queue
	 * @param max
	 */
	private void collectValuesCache(Node x, String prefix, String key, ArrayList<Value> queue, int max) {

		if (x == null || current > max)
			return;
		
		//Chivato
		//Console.print("Key: " + key + "  Prefix: " + prefix + x.c);

		collectValuesCache(x.left, prefix, key, queue, max);

		if (x.val != null && current <= max && key.compareTo(prefix+x.c) < 0){
			queue.add(x.val);
			
			//Chivato
			//Console.print("--->"+x.val.toString());
			++current;
			//Chivato
			//Console.print("--->Current: " + Integer.valueOf(current).toString());
		}
		
		collectValuesCache(x.mid, prefix + x.c, key, queue, max);
		collectValuesCache(x.right, prefix, key, queue, max);

	}

	/**
	 * 
	 * @param key
	 * @param max
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Value> valuesCache(String key, int max) throws Exception{

		if(max < 1) throw new Exception("Mandatory: max > 0");
		Node x = get(root, key.toLowerCase(), 0);
		if(x == null) throw new Exception("Key not present");
		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		current = 1;
		ArrayList<Value> queue = new ArrayList<Value>();
		collectValuesCache(root, "", key, queue, max);
		return queue;
	}


	/**
	 * Devuelve el primer elemento del TST
	 * Pre: El TST debe tener algun valor
	 * @return
	 * @throws Exception
	 */
	public Value first() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return first(root);
	}

	/**
	 * 
	 * @param x
	 * @return
	 * @throws Exception
	 */
	private Value first(Node x) throws Exception{
		
		//Testear!
		while(x.left != null) x = x.left;
		if(x.val != null) return x.val;
		else if(x.mid != null) return first(x.mid);
		//else if(x.val != null) return x.val;
		else throw new Exception("Debugging exception");
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String firstKey() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return firstKey(root);
	}

	/**
	 * 
	 * @param x
	 * @return
	 * @throws Exception
	 */
	public String firstKey(Node x) throws Exception{

		//Testear!
		while(x.left != null) x = x.left;
		if(x.val != null) return ""+x.c;
		else if(x.mid != null) return x.c+firstKey(x.mid);
		//else if(x.val != null) return ""+x.c;
		else throw new Exception("Debugging exception");
	}

	/**
	 * Post: Elimina todo el arbol y el contador
	 */
	public void clear() {
		root = null;
		N = 0;
	}

	/**
	 * Pre: Key debe ser un nombre valido
	 * Post: Elimina el valor asociado a esa key y todas las key inecesarias
	 * @param key
	 * @throws Exception
	 */
	public void remove(String key) throws Exception {

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		// Remove
		if (!remove(root, key.toLowerCase(), 0))
			throw new Exception("The key " + key + " doesn't exist");
	}

	/**
	 * Pre: X no debe ser nulo
	 * @param x
	 * @param key
	 * @param d
	 * @return
	 */
	private boolean remove(Node x, String key, int d) {
		if (x == null)
			return false;

		char c = key.charAt(d);
		boolean del = false;

		if (c < x.c)
			del = remove(x.left, key, d);
		else if (c > x.c)
			del = remove(x.right, key, d);
		else if (d < key.length() - 1)
			del = remove(x.mid, key, d + 1);
		else {
			del = (x.val != null);
			x.val = null;
			del = true;
			N--;
		}

		return del;
	}
}