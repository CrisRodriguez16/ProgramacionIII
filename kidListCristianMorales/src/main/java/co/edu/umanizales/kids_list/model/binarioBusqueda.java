class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class ArbolBinario {
    Nodo raiz;

    // Insertar un nodo en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    // Mostrar los nodos en el árbol (recorrido en orden)
    public void mostrar() {
        recorridoEnOrden(raiz);
        System.out.println();
    }

    private void recorridoEnOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoEnOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            recorridoEnOrden(nodo.derecho);
        }
    }

    // Eliminar un nodo del árbol
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor == nodo.valor) {
            // Nodo a eliminar encontrado
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
            int valorMenor = obtenerValorMenor(nodo.derecho);
            nodo.valor = valorMenor;
            nodo.derecho = eliminarRecursivo(nodo.derecho, valorMenor);
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        }

        return nodo;
    }

    private int obtenerValorMenor(Nodo nodo) {
        return nodo.izquierdo == null ? nodo.valor : obtenerValorMenor(nodo.izquierdo);
    }

    // Podar el árbol (eliminar nodos hoja)
    public void podar() {
        raiz = podarRecursivo(raiz);
    }

    private Nodo podarRecursivo(Nodo nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.izquierdo == null && nodo.derecho == null) {
            return null;
        }
        nodo.izquierdo = podarRecursivo(nodo.izquierdo);
        nodo.derecho = podarRecursivo(nodo.derecho);
        return nodo;
    }

    // Obtener los nodos de un nivel específico
    public void obtenerNodosPorNivel(int nivel) {
        imprimirNivel(raiz, nivel, 1);
    }

    private void imprimirNivel(Nodo nodo, int nivelObjetivo, int nivelActual) {
        if (nodo == null) {
            return;
        }
        if (nivelActual == nivelObjetivo) {
            System.out.print(nodo.valor + " ");
        }
        imprimirNivel(nodo.izquierdo, nivelObjetivo, nivelActual + 1);
        imprimirNivel(nodo.derecho, nivelObjetivo, nivelActual + 1);
    }

    // Recorrido en preorden
    public void preorden() {
        recorridoPreorden(raiz);
        System.out.println();
    }

    private void recorridoPreorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            recorridoPreorden(nodo.izquierdo);
            recorridoPreorden(nodo.derecho);
        }
    }

    // Recorrido en postorden
    public void postorden() {
        recorridoPostorden(raiz);
        System.out.println();
    }

    private void recorridoPostorden(Nodo nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.izquierdo);
            recorridoPostorden(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    // Verificar si el árbol es completo
    public boolean esCompleto() {
        return esArbolCompleto(raiz, 0, contarNodos(raiz));
    }

    private boolean esArbolCompleto(Nodo nodo, int indice, int cantidadNodos) {
        if (nodo == null) {
            return true;
        }
        if (indice >= cantidadNodos) {
            return false;
        }
        return esArbolCompleto(nodo.izquierdo, 2 * indice + 1, cantidadNodos)
                && esArbolCompleto(nodo.derecho, 2 * indice + 2, cantidadNodos);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }

    // Verificar si un nodo tiene hijos
    public boolean tieneHijos(int valor) {
        Nodo nodo = buscarNodo(raiz, valor);
        return nodo != null && (nodo.izquierdo != null || nodo.derecho != null);
    }

    private Nodo buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }
        if (valor == nodo.valor) {
            return nodo;
        }
        return valor < nodo.valor ? buscarNodo(nodo.izquierdo, valor) : buscarNodo(nodo.derecho, valor);
    }

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(5);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);
        arbol.insertar(8);

        System.out.println("Recorrido en orden:");
        arbol.mostrar();

        System.out.println("Recorrido en preorden:");
        arbol.preorden();

        System.out.println("Recorrido en postorden:");
        arbol.postorden();

        System.out.println("¿Es el árbol completo? " + arbol.esCompleto());

        System.out.println("¿El nodo 7 tiene hijos? " + arbol.tieneHijos(7));

        System.out.println("Nodos en el nivel 2:");
        arbol.obtenerNodosPorNivel(2);

        arbol.eliminar(7);
        System.out.println("Árbol después de eliminar el nodo 7:");
        arbol.mostrar();

        arbol.podar();
        System.out.println("Árbol después de podar:");
        arbol.mostrar();
    }
}
