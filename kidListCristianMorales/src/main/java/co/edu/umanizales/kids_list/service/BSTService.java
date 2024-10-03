package co.edu.umanizales.kids_list.service;

import co.edu.umanizales.kids_list.model.BST;
import co.edu.umanizales.kids_list.model.Kid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BSTService {
    private final BST bst;

    public BSTService() {
        this.bst = new BST();  // Inicializa el árbol binario de búsqueda
    }

    // Mostrar todos los niños en orden
    public List<Kid> showKids() {
        return bst.inOrder();
    }

    // Agregar un niño al árbol
    public void addKid(Kid kid) {
        bst.insert(kid);
    }

    // Eliminar un niño por ID
    public void removeKidById(int id) {
        bst.delete(id);
    }
}
