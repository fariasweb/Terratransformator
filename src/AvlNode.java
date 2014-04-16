public class AvlNode<T extends Entity> {
 public AvlNode<T> left;
 public AvlNode<T> right;
 public AvlNode<T> parent;
 public T item;
 public int balance;
 public int height;

 public AvlNode(T it) {
  left = right = parent = null;
  balance = 0;
  height = 0;
  item = it;
 }
 public String toString() {
  return "" + item;
 }

 public T getEntity(){
 	return item;
 }
 
}