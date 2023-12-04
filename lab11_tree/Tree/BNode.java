package Tree;

import java.util.List;
import java.util.ArrayList;

class BNode<E extends Comparable<E>> {
    E data;
    BNode<E> left;
    BNode<E> right;

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public List<E> ancestors(E e, List<E> list) {
        if (data.equals(e)) {
            return list;
        }
        if (left != null && left.contains(e)) {
            list.add(data);
            return left.ancestors(e, list);
        }
        if (right != null && right.contains(e)) {
            list.add(data);
            return right.ancestors(e, list);
        }
        return new ArrayList<E>();
    }

    public boolean contains(E e) {
        if (data.equals(e)) {
            return true;
        }
        if (e.compareTo(data) < 0 && left != null) {
            return left.contains(e);
        }
        if (e.compareTo(data) > 0 && right != null) {
            return right.contains(e);
        }
        return false;
    }

    public void add(E e) {
        if (e.compareTo(data) < 0) {
            if (left == null) {
                left = new BNode<E>(e);
            } else {
                left.add(e);
            }
        } else if (e.compareTo(data) > 0) {
            if (right == null) {
                right = new BNode<E>(e);
            } else {
                right.add(e);
            }
        }
    }

    public List<E> descendants(E data) {
        List<E> descendantsList = new ArrayList<>();
        findDescendants(this, data, descendantsList);
        descendantsList.remove(data); // Remove the given node from descendants list if found
        return descendantsList;
    }

    private void findDescendants(BNode<E> node, E data, List<E> descendantsList) {
        if (node == null) {
            return;
        }
        if (node.data.equals(data)) {
            addDescendants(node.left, descendantsList);
            addDescendants(node.right, descendantsList);
            return;
        }
        if (node.data.compareTo(data) < 0) {
            findDescendants(node.right, data, descendantsList);
        } else {
            findDescendants(node.left, data, descendantsList);
        }
    }

    private void addDescendants(BNode<E> node, List<E> descendantsList) {
        if (node == null) {
            return;
        }
        descendantsList.add(node.data);
        addDescendants(node.left, descendantsList);
        addDescendants(node.right, descendantsList);
    }
    public int calculateDepth(E node, int depth) {
        if (data.equals(node)) {
            return depth;
        }
        if (node.compareTo(data) < 0 && left != null) {
            return left.calculateDepth(node, depth + 1);
        }
        if (node.compareTo(data) > 0 && right != null) {
            return right.calculateDepth(node, depth + 1);
        }
        return -1; // Node not found in the tree
    }
    public int calculateHeight() {
        return calculateHeight(this);
    }

    private int calculateHeight(BNode<E> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int calculateSize() {
        return calculateSize(this);
    }

    private int calculateSize(BNode<E> node) {
        if (node == null) {
            return 0;
        }
        int leftSize = calculateSize(node.left);
        int rightSize = calculateSize(node.right);

        return leftSize + rightSize + 1;
    }
    public E findMin() {
        if (left == null) {
            return data;
        } else {
            return left.findMin();
        }
    }
    public E findMax() {
        if (right == null) {
            return data;
        } else {
            return right.findMax();
        }
    }
    
    public void inorderTraversal() {
        if (left != null) {
            left.inorderTraversal();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.inorderTraversal();
        }
    }

    // method to perform preorder traversal
    public void preorderTraversal() {
        System.out.print(data + " ");
        if (left != null) {
            left.preorderTraversal();
        }
        if (right != null) {
            right.preorderTraversal();
        }
    }

    // method to perform postorder traversal
    public void postorderTraversal() {
        if (left != null) {
            left.postorderTraversal();
        }
        if (right != null) {
            right.postorderTraversal();
        }
        System.out.print(data + " ");
    }
	
	}
