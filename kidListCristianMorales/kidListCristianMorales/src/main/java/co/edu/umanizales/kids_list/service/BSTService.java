package co.edu.umanizales.kids_list.service;

import co.edu.umanizales.kids_list.model.BST;
import co.edu.umanizales.kids_list.model.Kid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {
    private final BST bst;

    // Constructor para inicializar el árbol binario
    public BSTService() {
        this.bst = new BST();
    }

    // Mostrar todos los niños en orden (recorrido inorden)
    public List<Kid> showKidsInOrder() {
        return bst.getPostOrder(); // Delegamos al método getInOrder en BST
    }

    // Agregar un niño al árbol
    public void addKid(Kid kid) {
        bst.insert(kid);
    }

    // Eliminar un niño por ID
    public void removeKidById(int id) {
        bst.delete(id);
    }

    // Obtener lista de niños en recorrido postorden
    public List<Kid> getPostOrderKids() {
        return bst.getPostOrder(); // Delegamos al método getPostOrder en BST
    }

    // Buscar un niño por su ID
    public Kid searchKidById(int id) {
        return bst.search(id); // Delegamos al método search en BST
    }
}