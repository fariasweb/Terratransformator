import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class TST<Value> {
	private int N; // size
	private Node root; // root of TST

	//Lo necesito para lo de Cache
	///////////////////////////////////////////////////////
	private int current;
	//////////////////////////////////////////////////////
	private class Node {
		private char c; // character
		private Node left, mid, right; // left, middle, and right subtries
		private Value val; // value associated with string
	}

	// return number of key-value pairs
	public int size() {
		return N;
	}

	/**************************************************************
	 * Is string key in the symbol table?
	 **************************************************************/
	public boolean contains(String key) {
		if (key == null || key.length() == 0) return false;
		try{
			return get(key.toLowerCase()) != null;
		}
		catch (Exception e) {
			Console.print("Exception: ");
			e.printStackTrace();
		}
		return false;
	}

	//if not present returns null
	public Value get(String key) throws Exception{

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		Node x = get(root, key.toLowerCase(), 0);
		if (x == null)
			return null;
		return x.val;
	}

	// return subtrie corresponding to given key
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

	/**************************************************************
	 * Insert string s into the symbol table.
	 * @throws Exception 
	 **************************************************************/
	public void put(String s, Value val) throws Exception {
		// if (!contains(s)) N++;
		root = put(root, s.toLowerCase(), val, 0);
	}

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

	/**************************************************************
	 * Find and return longest prefix of s in TST
	 **************************************************************/
	public String longestPrefixOf(String s) {
		s = s.toLowerCase();
		
		if (s == null || s.length() == 0)
			return null;
		int length = 0;
		Node x = root;
		int i = 0;
		while (x != null && i < s.length()) {
			char c = s.charAt(i);
			if (c < x.c)
				x = x.left;
			else if (c > x.c)
				x = x.right;
			else {
				i++;
				if (x.val != null)
					length = i;
				x = x.mid;
			}
		}
		return s.substring(0, length);
	}

	// all keys in symbol table
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}

	// all keys starting with given prefix
	public Iterable<String> prefixMatch(String prefix) {
		prefix = prefix.toLowerCase();
		
		Queue<String> queue = new LinkedList<String>();
		Node x = get(root, prefix, 0);
		if (x == null)
			return queue;
		if (x.val != null)
			queue.add(prefix);
		collect(x.mid, prefix, queue);
		return queue;
	}

	// all keys in subtrie rooted at x with given prefix
	private void collect(Node x, String prefix, Queue<String> queue) {		
		if (x == null)
			return;
		collect(x.left, prefix, queue);
		if (x.val != null)
			queue.add(prefix + x.c);
		collect(x.mid, prefix + x.c, queue);
		collect(x.right, prefix, queue);
	}
	
	// all keys in symbol table
	public Iterable<Value> values() {
		Queue<Value> queue = new LinkedList<Value>();
		collectValues(root, "", queue);
		return queue;
	}
	
	// all keys in subtrie rooted at x with given prefix
	private void collectValues(Node x, String prefix, Queue<Value> queue) {		
		if (x == null)
			return;
		
		collectValues(x.left, prefix, queue);
		if (x.val != null)
			queue.add(x.val);
		
		collectValues(x.mid, prefix + x.c, queue);
		collectValues(x.right, prefix, queue);
	}
	// return all keys matching given wildcard pattern
	public Iterable<String> wildcardMatch(String pat) {
		pat = pat.toLowerCase();
		
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", 0, pat, queue);
		return queue;
	}

	private void collect(Node x, String prefix, int i, String pat,
			Queue<String> q) {
		if (x == null)
			return;
		char c = pat.charAt(i);
		if (c == '.' || c < x.c)
			collect(x.left, prefix, i, pat, q);
		if (c == '.' || c == x.c) {
			if (i == pat.length() - 1 && x.val != null)
				q.add(prefix + x.c);
			if (i < pat.length() - 1)
				collect(x.mid, prefix + x.c, i + 1, pat, q);
		}
		if (c == '.' || c > x.c)
			collect(x.right, prefix, i, pat, q);
	}
	
	///////////////////////////////////////////////////////////////////////////

	// all keys in subtrie rooted at x with given prefix; limited
	/*private void collectValuesCache(Node x, String prefix, ArrayList<Value> queue, int max) {		

		if (current > max || x == null) return;
		
		collectValuesCache(x.left, prefix, queue, max);
		if (x.val != null){
			queue.add(x.val);
			current++;
			System.out.printf("Current: %d\n", current);
		}
		
		collectValuesCache(x.mid, prefix + x.c, queue, max);
		collectValuesCache(x.right, prefix, queue, max);
	}

	public ArrayList<Value> valuesCache(String key, int max) throws Exception{
		
		if(max < 1) throw new Exception("Mandatory: max > 0");
		current = 1;
		Node x = get(root, key.toLowerCase(), 0);
		if(x == null) throw new Exception("Key not present");
		
		ArrayList<Value> queue = new ArrayList<Value>();

		//A partir de primera palabra, miro para abajo
		collectValuesCache(x.mid, ""+x.c, queue, max);
			System.out.printf("Current inter: %d\n", current);

		//A partir de primera palabra, miro para la derecha
		collectValuesCache(x.right, "", queue, max);
			System.out.printf("Current inter2: %d\n", current);

		//Saco última letra, y si no era un char...
		key = key.substring(0, key.length()-1);
			Console.print("KEY: "+key);
		if(!key.equals("") && current <= max){
			x = get(root, key.toLowerCase(), 0);
			if(x != null){ //&& x.mid != null ??

				Console.print("chivato");
				if(x.mid != null) Console.print("CHIVATO");  
				if(x.mid.val != null){ Console.print("---->"+x.mid.val.toString()); queue.add(x.mid.val); ++current; }
				collectValuesCache(x.mid.mid, "", queue, max);
				collectValuesCache(x.mid.right, "", queue, max);
			}
		}


		while(!key.equals("") && current <= max){

			x = get(root, key.toLowerCase(), 0);

			if(x != null){
				if(x.val != null){ queue.add(x.val); ++current; }
				if(current > max) break;
				collectValuesCache(x.right, "", queue, max);
			}

			key = key.substring(0, key.length()-1);
				Console.print("KEY: "+key);

		}

		return queue;
	}*/

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



	public Value first() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return first(root);
	}

	private Value first(Node x) throws Exception{
		
		//Testear!
		while(x.left != null) x = x.left;
		if(x.val != null) return x.val;
		else if(x.mid != null) return first(x.mid);
		//else if(x.val != null) return x.val;
		else throw new Exception("Debugging exception");
	}

	public String firstKey() throws Exception{
		if(N == 0) throw new Exception ("Empty TST!");
		return firstKey(root);
	}

	public String firstKey(Node x) throws Exception{

		//Testear!
		while(x.left != null) x = x.left;
		if(x.val != null) return ""+x.c;
		else if(x.mid != null) return x.c+firstKey(x.mid);
		//else if(x.val != null) return ""+x.c;
		else throw new Exception("Debugging exception");
	}

	///////////////////////////////////////////////////////////////////////

	/**************************************************************
	 * Remove
	 **************************************************************/

	public void clear() {
		root = null;
	}

	public void remove(String key) throws Exception {

		if(!Util.checkName(key)) throw new Exception(key + " is not valid");

		// Remove
		if (!remove(root, key.toLowerCase(), 0))
			throw new Exception("The key " + key + " doesn't exist");
	}

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