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

    // Obtener todos los niños en orden
    @GetMapping
    public List<Kid> getListChildren() {
        return bstService.showKids();
    }

    // Agregar un niño
    @PostMapping
    public String addKid(@RequestBody Kid kid) {
        bstService.addKid(kid);
        return "Adicionado exitosamente";
    }

    // Eliminar un niño por su ID
    @DeleteMapping("/removebyid")
    public String removeKidById(@RequestParam int id) {
        bstService.removeKidById(id);
        return "Niño con ID " + id + " ha sido eliminado";
    }
}
