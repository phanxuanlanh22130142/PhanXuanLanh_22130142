package Tree;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    // Add element e into BST
    public void add(E e) {
        if (root == null) {
            this.root = new BNode<E>(e);
        } else {
            this.root.add(e);
        }
    }

    // Add a collection of elements col into BST
    public void add(Collection<E> col) {
        for (E e : col) {
            add(e);
        }
    }

    // Calculate the depth of a node in the BST
    public int depth(E node) {
        if (node == null) {
            return -1; // Node not found, return a sentinel value
        }
        return root.calculateDepth(node, 0);
    }

    // Calculate the height of the BST
    public int height() {
        return root.calculateHeight();
    }

    // Get the size of the BST
    public int size() {
        return root.calculateSize();
    }

    // Check if the BST contains element e
    public boolean contains(E e) {
        return root.contains(e);
    }

    // Find the minimum element in the BST
    public E findMin() {
        if (root == null) {
            return null; // Handle the case where the tree is empty
        }
        return root.findMin();
    }

    // Find the maximum element in the BST
    public E findMax() {
        if (root == null) {
            return null; // Handle the case where the tree is empty
        }
        return root.findMax();
    }

    // Remove element e from the BST
    public boolean remove(E e) {
        if (root == null) {
            return false;  // Handle the case where the tree is empty
        }
        // Create an array to hold the reference to the deleted node
        BNode<E>[] deletedNode = new BNode[]{null};
        // Remove the node with element e and update the root if necessary
        root = removeNode(root, e, deletedNode);
        return deletedNode[0] != null;
    }

    private BNode<E> removeNode(BNode<E> current, E e, BNode<E>[] deletedNode) {
        if (current == null) {
            return null;  // Base case: the element is not found
        }
        if (e.compareTo(current.data) < 0) {
            current.left = removeNode(current.left, e, deletedNode);
        } else if (e.compareTo(current.data) > 0) {
            current.right = removeNode(current.right, e, deletedNode);
        } else {
            // Element is found, and we need to remove it
            deletedNode[0] = current;  // Set the reference to the deleted node
            if (current.left == null) {
                return current.right;  // Case with only right child or no child
            } else if (current.right == null) {
                return current.left;  // Case with only left child
            } else {
                // Case with both left and right children
                BNode<E> minNode = findMinNode(current.right); // Find the smallest node in the right subtree
                current.data = minNode.data; // Replace the current node's data with the minNode's data
                current.right = removeNode(current.right, minNode.data, deletedNode); // Remove the minNode
            }
        }
        return current;
    }

    private BNode<E> findMinNode(BNode<E> node) {
        while (node.left != null) {
            node = node.left; // Traverse to the leftmost node to find the smallest node
        }
        return node;
    }

    // Get the descendants of a given node in the BST
    public List<E> descendants(E data) {
        if (root == null) {
            return new ArrayList<>();
        }
        return root.descendants(data);
    }

    // Get the ancestors of a given node in the BST
    public List<E> ancestors(E data) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<E> ancestorsList = new ArrayList<>();
        root.ancestors(data, ancestorsList);
        return ancestorsList;
    }
    public void inorder() {
        inorderTraversal(root);
    }

    // display BST using preorder approach
    public void preorder() {
        preorderTraversal(root);
    }

    // display BST using postorder approach
    public void postorder() {
        postorderTraversal(root);
    }

    private void inorderTraversal(BNode<E> node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    private void preorderTraversal(BNode<E> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private void postorderTraversal(BNode<E> node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(50);
        bst.add(30);
        bst.add(20);
        bst.add(40);
        bst.add(70);
        bst.add(60);
        bst.add(80);

        Integer nodeToFind = 30;
        List<Integer> ancestors = bst.ancestors(nodeToFind);
        List<Integer> descendants = bst.descendants(nodeToFind);

        System.out.println("Ancestors of node " + nodeToFind + " are: " + ancestors);
        System.out.println("Descendants of node " + nodeToFind + " are: " + descendants);
        System.out.println("Inorder traversal:");
        bst.inorder();

        // Display the BST using preorder traversal
        System.out.println("\nPreorder traversal:");
        bst.preorder();

        // Display the BST using postorder traversal
        System.out.println("\nPostorder traversal:");
        bst.postorder();
    }
 
 // Add elements to the BST

 // Display the BST using inorder traversal
 
}