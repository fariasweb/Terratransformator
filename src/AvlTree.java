import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class is the complete and tested implementation of an AVL-tree.
 */
public class AvlTree<T extends Entity> {
 
 private AvlNode<T> root; // the root node
 private int size = 0;
 
/***************************** Core Functions ************************************/

  /**
  * Add a new item it into the tree.
  * 
  * @param it
  *            The item of the new node.
  */
  public void insert(T it) {
    // create new node
    AvlNode<T> n = new AvlNode<T>(it);
    // start recursive procedure for inserting the node
    insertAVL(this.root,n);
  }
 
  /**
  * Removes a node from the tree, if it is existent.
  */
  public void remove(String q) {
    // First we must find the node, after this we can delete it.
    removeAVL(this.root,q);
  }
 
  public void clear(){
    while(root != null)
      removeFoundNode(root);
  }
 
  public int size(){
    return size;
  }

  public boolean findByKey(String q) {
    return findByKeyAVL(this.root, q);
  }

/***************************** Helper Functions ************************************/
   
  /**
    * Recursive method to insert a node into a tree.
    * 
    * @param p The node currently compared, usually you start with the root.
    * @param q The node to be inserted.
    */
  private void insertAVL(AvlNode<T> p, AvlNode<T> q) {
    // If  node to compare is null, the node is inserted. If the root is null, it is the root of the tree.
    if(p==null){ this.root=q; q.height = height(q); }
    else {
     // If compare node is smaller, continue with the left node
     if(q.item.getKey().compareToIgnoreCase(p.item.getKey()) < 0) {
      if(p.left==null) {
       p.left = q;
       q.parent = p;
       p.height = height(p);
       q.height = height(q);       
       // Node is inserted now, continue checking the balance
       recursiveBalance(p);
      } else {
       insertAVL(p.left,q);
      }
      
     } else if(q.item.getKey().compareToIgnoreCase(p.item.getKey()) > 0) {
      if(p.right==null) {
       p.right = q;
       q.parent = p;
       p.height = height(p);
       q.height = height(q);

       // Node is inserted now, continue checking the balance
       recursiveBalance(p);
      } else {
       insertAVL(p.right,q);
      }
     } else --size;
      // do nothing: This node already exists
    }
    ++size;
  }


  /**
    * Check the balance for each node recursivly and call required methods for balancing the tree until the root is reached.
    * 
    * @param cur : The node to check the balance for, usually you start with the parent of a leaf.
    */
  private void recursiveBalance(AvlNode<T> cur) {
    
    // we do not use the balance in this class, but the store it anyway
    setBalance(cur);
    int balance = cur.balance;
    
    // check the balance
    if(balance==-2) {
     
     if(height(cur.left.left)>=height(cur.left.right)) {
      cur = rotateRight(cur);
     } else {
      cur = doubleRotateLeftRight(cur);
     }
    } else if(balance==2) {
     if(height(cur.right.right)>=height(cur.right.left)) {
      cur = rotateLeft(cur);
     } else {
      cur = doubleRotateRightLeft(cur);
     }
    }
    
    // we did not reach the root yet
    if(cur.parent!=null) {
     recursiveBalance(cur.parent);
    } else {
     this.root = cur;
     //System.out.println("------------ Balancing finished ----------------");
    }
   }

  /**
  * Finds a node and calls a method to remove the node.
  * 
  * @param p The node to start the search.
  * @param q The KEY of node to remove.
  */
  private void removeAVL(AvlNode<T> p,String q) {
    if(p==null) return;
    else {
      if(p.item.getKey().compareToIgnoreCase(q) > 0){
      removeAVL(p.left,q);
      } else if(p.item.getKey().compareToIgnoreCase(q) < 0) {
        removeAVL(p.right,q);
      } else
        // we found the node in the tree.. now lets go on!
        removeFoundNode(p);
    }
  }

   /**
    * Removes a node from a AVL-Tree, while balancing will be done if necessary.
    * 
    * @param q The node to be removed.
    */
  private void removeFoundNode(AvlNode<T> q) {
    AvlNode<T> r;
    // at least one child of q, q will be removed directly
    if(q.left==null || q.right==null) {
     // the root is deleted
     if(q.parent==null) {
      this.root=null;
      q=null;
      return;
     }
     r = q;
    } else {
     // q has two children --> will be replaced by successor
     r = successor(q);
     q.item = r.item;
    }
    
    AvlNode<T> p;
    if(r.left!=null) {
     p = r.left;
    } else {
     p = r.right;
    }
    
    if(p!=null) {
     p.parent = r.parent;
    }
    
    if(r.parent==null) {
     this.root = p;
    } else {
     if(r==r.parent.left) {
      r.parent.left=p;
     } else {
      r.parent.right = p;
     }
     // balancing must be done until the root is reached.
     recursiveBalance(r.parent);
    }
    r = null;
    --size;
   }

  private boolean findByKeyAVL(AvlNode<T> p, String q) {
      if(p != null) {
        if(p.item.getKey().compareToIgnoreCase(q) > 0){
          return findByKeyAVL(p.left,q);
        } else if(p.item.getKey().compareToIgnoreCase(q) < 0) {
          return findByKeyAVL(p.right,q);
        } else return true;
      }
      return false;
  }

 /**
    * Calculating the "height" of a node.
    * 
    * @param cur
    * @return The height of a node (-1, if node is not existent eg. NULL).
    */
public int height(AvlNode<T> cur) {
    if(cur==null) {
     return -1;
    }
    if(cur.left==null && cur.right==null) {
     return 0;
    } else if(cur.left==null) {
     return 1+cur.right.height;
    } else if(cur.right==null) {
     return 1+cur.left.height;
    } else {
     return 1+maximum(cur.left.height,cur.right.height);
    }
   }
   
 /**
    * Return the maximum of two integers.
    */
private int maximum(int a, int b) {
    if(a>=b) {
     return a;
    } else {
     return b;
    }
   }


  /**
    * Left rotation using the given node.
    * 
    * 
    * @param n
    *            The node for the rotation.
    * 
    * @return The root of the rotated tree.
    */
  private AvlNode<T> rotateLeft(AvlNode<T> n) {
    
    AvlNode<T> v = n.right;
    v.parent = n.parent;
    
    n.right = v.left;
    
    if(n.right!=null) {
     n.right.parent=n;
    }
    
    v.left = n;
    n.parent = v;
    
    if(v.parent!=null) {
     if(v.parent.right==n) {
      v.parent.right = v;
     } else if(v.parent.left==n) {
      v.parent.left = v;
     }
    }
    
    setBalance(n);
    setBalance(v);

    n.height = height(n);
    v.height = height(v);
   /* if(v.right != null) v.right.height = height(v.right);*/

    return v;
   }
   
   /**
    * Right rotation using the given node.
    * 
    * @param n
    *            The node for the rotation
    * 
    * @return The root of the new rotated tree.
    */
  private AvlNode<T> rotateRight(AvlNode<T> n) {
    
    AvlNode<T> v = n.left;
    v.parent = n.parent;
    
    n.left = v.right;
    
    if(n.left!=null) {
     n.left.parent=n;
    }
    
    v.right = n;
    n.parent = v;
    
    
    if(v.parent!=null) {
     if(v.parent.right==n) {
      v.parent.right = v;
     } else if(v.parent.left==n) {
      v.parent.left = v;
     }
    }
    
    setBalance(n);
    setBalance(v);

    n.height = height(n);
    v.height = height(v);
    /*if(v.right != null) v.right.height = height(v.right);*/
    
    return v;
   }
   /**
    * 
    * @param u The node for the rotation.
    * @return The root after the double rotation.
    */
  private AvlNode<T> doubleRotateLeftRight(AvlNode<T> u) {
    u.left = rotateLeft(u.left);
    return rotateRight(u);
   }
   
   /**
    * 
    * @param u The node for the rotation.
    * @return The root after the double rotation.
    */
  private AvlNode<T> doubleRotateRightLeft(AvlNode<T> u) {
    u.right = rotateRight(u.right);
    return rotateLeft(u);
   }

  /**
    * Returns the successor of a given node in the tree (search recursivly).
    * 
    * @param q The predecessor.
    * @return The successor of node q.
    */
  private AvlNode<T> successor(AvlNode<T> q) {
    if(q.right!=null) {
     AvlNode<T> r = q.right;
     while(r.left!=null) {
      r = r.left;
     }
     return r;
    } else {
     AvlNode<T> p = q.parent;
     while(p!=null && q==p.right) {
      q = p;
      p = q.parent;
     }
     return p;
    }
   }


  private void setBalance(AvlNode<T> cur) {
    cur.balance = height(cur.right)-height(cur.left);
  }
   
   /**
    * Calculates the Inorder traversal of this tree.
    * 
    * @return A Array-List of the tree in inorder traversal.
    */
  final protected ArrayList<AvlNode<T>> inorder() {
    ArrayList<AvlNode<T>> ret = new ArrayList<AvlNode<T>>();
    inorder(root, ret);
    return ret;
   }
   
   /**
    * Function to calculate inorder recursivly.
    * 
    * @param n
    *            The current node.
    * @param io
    *            The list to save the inorder traversal.
    */
   final protected void inorder(AvlNode<T> n, ArrayList<AvlNode<T>> io) {
    if (n == null) {
     return;
    }
    inorder(n.left, io);
    io.add(n);
    inorder(n.right, io);
   }

}