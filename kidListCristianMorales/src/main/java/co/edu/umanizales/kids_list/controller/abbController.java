package co.edu.umanizales.kids_list.controller;

import co.edu.umanizales.arbolbinario.service.ArbolBinarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arbol")
public class ArbolBinarioController {

    private final ArbolBinarioService arbolBinarioService;

    public ArbolBinarioController(ArbolBinarioService arbolBinarioService) {
        this.arbolBinarioService = arbolBinarioService;
    }

    // Insertar un valor en el árbol
    @PostMapping("/insertar")
    public String insertar(@RequestParam int valor) {
        arbolBinarioService.insertar(valor);
        return "Nodo con valor " + valor + " insertado exitosamente";
    }

    // Eliminar un nodo por valor
    @DeleteMapping("/eliminar")
    public String eliminar(@RequestParam int valor) {
        arbolBinarioService.eliminar(valor);
        return "Nodo con valor " + valor + " eliminado exitosamente";
    }

    // Podar el árbol (eliminar nodos hoja)
    @PostMapping("/podar")
    public String podar() {
        arbolBinarioService.podar();
        return "Árbol podado exitosamente";
    }

    // Mostrar recorrido en orden
    @GetMapping("/mostrar")
    public String mostrar() {
        arbolBinarioService.mostrar();
        return "Recorrido en orden ejecutado exitosamente";
    }

    // Mostrar recorrido en preorden
    @GetMapping("/preorden")
    public String preorden() {
        arbolBinarioService.preorden();
        return "Recorrido en preorden ejecutado exitosamente";
    }

    // Mostrar recorrido en postorden
    @GetMapping("/postorden")
    public String postorden() {
        arbolBinarioService.postorden();
        return "Recorrido en postorden ejecutado exitosamente";
    }

    // Verificar si el árbol es completo
    @GetMapping("/esCompleto")
    public String esCompleto() {
        boolean resultado = arbolBinarioService.esCompleto();
        return "¿El árbol es completo? " + resultado;
    }

    // Verificar si un nodo tiene hijos
    @GetMapping("/tieneHijos")
    public String tieneHijos(@RequestParam int valor) {
        boolean resultado = arbolBinarioService.tieneHijos(valor);
        return "¿El nodo " + valor + " tiene hijos? " + resultado;
    }

    // Obtener nodos de un nivel específico
    @GetMapping("/nivel")
    public String obtenerNodosPorNivel(@RequestParam int nivel) {
        arbolBinarioService.obtenerNodosPorNivel(nivel);
        return "Nodos en el nivel " + nivel + " obtenidos exitosamente";
    }
}
