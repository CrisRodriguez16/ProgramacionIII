package co.edu.umanizales.kids_list.model;

import java.util.List;
import java.util.ArrayList;

public class BST {
    private NodeBST root; // Raíz del árbol binario

    // Método para obtener la raíz del árbol
    public NodeBST getRoot() {
        return root;
    }

    // Insertar un niño en el árbol
    public void insert(Kid kid) {
        root = insertRec(root, kid);
    }

    private NodeBST insertRec(NodeBST root, Kid kid) {
        // Si el árbol está vacío, crea un nodo con el niño
        if (root == null) {
            return new NodeBST(kid);
        }

        // Comparar el ID del niño para decidir dónde colocarlo
        if (kid.getId() < root.getKid().getId()) {
            root.setLeft(insertRec(root.getLeft(), kid));
        } else if (kid.getId() > root.getKid().getId()) {
            root.setRight(insertRec(root.getRight(), kid));
        }
        return root;
    }

    // Método para realizar un recorrido postorden y devolver la lista de niños
    public List<Kid> getPostOrder() {
        List<Kid> kids = new ArrayList<>();
        postOrderRec(root, kids); // Llamada recursiva
        return kids;
    }

    private void postOrderRec(NodeBST root, List<Kid> kids) {
        if (root != null) {
            // Recorrer subárbol izquierdo
            postOrderRec(root.getLeft(), kids);
            // Recorrer subárbol derecho
            postOrderRec(root.getRight(), kids);
            // Agregar el niño actual a la lista
            kids.add(root.getKid());
        }
    }

    // Método para buscar un niño por ID
    public Kid search(int id) {
        return searchRec(root, id);
    }

    private Kid searchRec(NodeBST root, int id) {
        if (root == null || root.getKid().getId() == id) {
            return (root != null) ? root.getKid() : null;
        }

        if (id < root.getKid().getId()) {
            return searchRec(root.getLeft(), id);
        } else {
            return searchRec(root.getRight(), id);
        }
    }

    // Método para eliminar un niño por ID
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private NodeBST deleteRec(NodeBST root, int id) {
        if (root == null) {
            return root;
        }

        if (id < root.getKid().getId()) {
            root.setLeft(deleteRec(root.getLeft(), id));
        } else if (id > root.getKid().getId()) {
            root.setRight(deleteRec(root.getRight(), id));
        } else {
            // Nodo con solo un hijo o sin hijos
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // Nodo con dos hijos: obtiene el sucesor (menor en el subárbol derecho)
            root.setKid(getMinValue(root.getRight()));
            // Elimina el sucesor
            root.setRight(deleteRec(root.getRight(), root.getKid().getId()));
        }
        return root;
    }

    private Kid getMinValue(NodeBST root) {
        Kid minValue = root.getKid();
        while (root.getLeft() != null) {
            root = root.getLeft();
            minValue = root.getKid();
        }
        return minValue;
    }
}