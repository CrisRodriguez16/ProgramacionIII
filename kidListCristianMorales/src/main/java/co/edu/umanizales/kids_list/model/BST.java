package co.edu.umanizales.kids_list.model;

import java.util.List;
import java.util.ArrayList;

public class BST {
    private NodeBST root;

    // Insertar un niño en el árbol
    public void insert(Kid kid) {
        root = insertRec(root, kid);
    }

    private NodeBST insertRec(NodeBST root, Kid kid) {
        // Si el árbol está vacío, crea el nodo con el niño
        if (root == null) {
            root = new NodeBST(kid);
            return root;
        }

        // Si el ID del niño es menor, va al subárbol izquierdo
        if (kid.getId() < root.getKid().getId()) {
            root.setLeft(insertRec(root.getLeft(), kid));
        }
        // Si el ID del niño es mayor, va al subárbol derecho
        else if (kid.getId() > root.getKid().getId()) {
            root.setRight(insertRec(root.getRight(), kid));
        }

        return root;
    }

    // Eliminar un niño del árbol por ID
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private NodeBST deleteRec(NodeBST root, int id) {
        if (root == null) return null;

        // Recorre el árbol buscando el nodo a eliminar
        if (id < root.getKid().getId()) {
            root.setLeft(deleteRec(root.getLeft(), id));
        } else if (id > root.getKid().getId()) {
            root.setRight(deleteRec(root.getRight(), id));
        } else {
            // Nodo con un solo hijo o sin hijos
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();

            // Nodo con dos hijos: obtener el sucesor en orden
            root.setKid(minValue(root.getRight()));

            // Elimina el sucesor
            root.setRight(deleteRec(root.getRight(), root.getKid().getId()));
        }

        return root;
    }

    // Encuentra el valor mínimo en el subárbol derecho
    private Kid minValue(NodeBST root) {
        Kid minv = root.getKid();
        while (root.getLeft() != null) {
            minv = root.getLeft().getKid();
            root = root.getLeft();
        }
        return minv;
    }

    // Recorrido en orden para devolver la lista de niños
    public List<Kid> inOrder() {
        List<Kid> kids = new ArrayList<>();  // Asegúrate de inicializar la lista
        inOrderRec(root, kids);
        return kids;
    }

    // Método auxiliar recursivo para realizar el recorrido en orden
    private void inOrderRec(NodeBST root, List<Kid> kids) {
        if (root != null) {
            inOrderRec(root.getLeft(), kids);   // Recorrido por el subárbol izquierdo
            kids.add(root.getKid());            // Agrega el nodo actual
            inOrderRec(root.getRight(), kids);  // Recorrido por el subárbol derecho
        }
    }
}
