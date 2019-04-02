public class BST <T extends Comparable <T>>{
	// our Node constructor that contain a maximum of two child Nodes (right and left)
	private class Node {
		private T data;
		private Node left_Child;
		private Node right_Child;

		//Node class constructor 
		public Node(T item){
			this.data = item;
			this.left_Child = null;
			this.right_Child= null;
		}
	}

	// our instances for the Binary Search Tree class
	private Node root_Node = null;

	// invokes our double-argument insert method 
	public void insert (T item){
		
		root_Node= insert(item, root_Node);

	}

	// inserts a value in the correct relative order in the Binary Search Tree
	public Node insert (T item, Node current_Node){

		Node new_Node = new Node(item);
		if (current_Node == null){
			return new_Node;
		}

		// if our value is less than our current node, we should turn to the left child
		 else if (item.compareTo(current_Node.data)<0){
			current_Node.left_Child = insert(item, current_Node.left_Child);
		} 

		// if our value is greater than our current node, we should turn to the right child
		else if (item.compareTo(current_Node.data)>0){
			current_Node.right_Child = insert(item, current_Node.right_Child);	
		}
		return current_Node;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////

	// invokes our double-argument find method 
	public boolean find (T item){
		return find(item, root_Node);
	}
	
	// find a value if located in Binary Search Tree
	public boolean find (T item, Node current_Node){

		if (current_Node != null){
			// if the value is the same as our current node data (we have found what we are looking for)
			if (item.compareTo(current_Node.data)==0){
				return true;
			}	

			// if our value is less than our current node, we should continue searching in the left subtree
			else if (item.compareTo(current_Node.data)<0){
				return find(item, current_Node.left_Child);
			} 

			// if our value is greater than our current node, we should continue searching in the right subtree
			else if (item.compareTo(current_Node.data)>0){
				return find(item, current_Node.right_Child);
			} 

		} 
		return false;

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////

	//invokes our double-argument delete method 
	protected void delete (T item){
		root_Node = delete (item, root_Node);
	}

	// eliminate a selected value from Binary Search Tree if found 
	protected Node delete (T item, Node current_Node){

		Node new_Node = new Node(item);
		if (current_Node != null){

			if (item.compareTo(current_Node.data)<0){
				current_Node.left_Child = delete(item,current_Node.left_Child);
			}
			else if (item.compareTo(current_Node.data)>0){
				current_Node.right_Child = delete(item,current_Node.right_Child);
			} 
			else{

				// if the value is the same as our current node data then we delete left node if our right node is null

				if (current_Node.left_Child == null){
					return current_Node.right_Child;
				}

				// if the value is the same as our current node data then we delete right node if our left node is null
				else if (current_Node.right_Child == null){
					return current_Node.left_Child;
				}

				/*if we have two children for the node that holds our selected value then we look for a successor in the 
				  right subtree the level that follows and we replace the value we would like to eliminate with the successor*/
				current_Node.data = minValue(current_Node.right_Child).data;
				current_Node.right_Child = delete(current_Node.data,current_Node.right_Child);

			}

		} 
		return null;

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
public Node minValue(Node current_Node){
	
	// return successor of tree/subtree (smallest value in right subtree)
	Node minVal = root_Node;
	while (root_Node.left_Child != null) {

		minVal = root_Node.left_Child;
	}
	return minVal;

}

////////////////////////////////////////////////////////////////////////////////////////////////////////

// invokes our single-argument print method 
public void print (){
	print(root_Node);
}

// here we are doing an In-Order iteration through our Binary Search Tree
public void print(Node current_Node){

	if (current_Node != null){

		// print through left subtree of root recursively until we reach root 
		// root is included in print
		print(current_Node.left_Child); 

		System.out.println(current_Node.data);

		// print through right subtree of root recursively until we have printed all leaf nodes 
		print(current_Node.right_Child); 

	}
	
}


}





