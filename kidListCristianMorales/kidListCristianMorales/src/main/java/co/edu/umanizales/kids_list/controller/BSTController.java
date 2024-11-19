package co.edu.umanizales.kids_list.controller;

import co.edu.umanizales.kids_list.model.Kid;
import co.edu.umanizales.kids_list.service.BSTService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bst")
public class BSTController {
    private final BSTService bstService;

    public BSTController(BSTService bstService) {
        this.bstService = bstService;
    }

    // Obtener todos los niños en recorrido inorden
    @GetMapping("/inorder")
    public List<Kid> getKidsInOrder() {
        return bstService.showKidsInOrder(); // Llama al método del servicio para obtener niños en orden
    }

    // Agregar un niño al árbol
    @PostMapping("/add")
    public String addKid(@RequestBody Kid kid) {
        bstService.addKid(kid);
        return "Niño agregado exitosamente";
    }

    // Eliminar un niño por ID
    @DeleteMapping("/remove")
    public String removeKidById(@RequestParam int id) {
        bstService.removeKidById(id);
        return "Niño con ID " + id + " ha sido eliminado exitosamente";
    }

    // Obtener la lista de niños en recorrido postorden
    @GetMapping("/postorder")
    public List<Kid> getKidsPostOrder() {
        return bstService.getPostOrderKids();
    }

    // Buscar un niño por su ID
    @GetMapping("/search")
    public Kid searchKidById(@RequestParam int id) {
        Kid kid = bstService.searchKidById(id);
        if (kid != null) {
            return kid;
        } else {
            throw new IllegalArgumentException("Niño con ID " + id + " no encontrado");
        }
    }
}