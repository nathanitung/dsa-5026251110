package lw06.prelab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        } else if (root.data > target) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));
        ArrayList<Integer> data = new ArrayList<>();
        while (sc.hasNext()){
            data.add(sc.nextInt());
        }

        Node root = null;
        root = insert(root, data.get(0));
        for (int i = 1; i< data.size()-1; i++){
            insert(root, data.get(i));
        }


        System.out.print("Preorder  : ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder   : ");
        inorder(root);
        System.out.println();
        System.out.print("Postorder : ");
        postorder(root);
        System.out.println();

        int target = data.get(data.size()-1);
        System.out.println("Search "+ target + " : " + search(root, target));


        sc.close();
    }
}
