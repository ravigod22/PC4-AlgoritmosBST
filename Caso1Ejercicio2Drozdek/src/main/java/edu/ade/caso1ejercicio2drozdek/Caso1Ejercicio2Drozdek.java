
package edu.ade.caso1ejercicio2drozdek;

import java.util.Arrays;

public class Caso1Ejercicio2Drozdek {
    public static void main(String[] args) {
        //int[] data = {8, 20, 41, 7,2,10,25};
        int[] data = {8, 20, 41, 7,2};
        int h = (int) Math.ceil((Math.log(data.length)/ Math.log(2))) + 1;
        //System.out.println(h);
        int E = 42;
        System.out.println("Aqui tenemos la construccion de nuestro arbol");
        Node root = buildCompleteBinaryTree(data, h, E);
        dibujarArbolInOrder(root);
        //imprimirArbolCompleto(root);
        System.out.println("\n--------------------------------------------------------------------- "); 
        System.out.println("Sorted array:");
        int[] sortedArray = extractSortedArray(root, data.length);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static Node buildCompleteBinaryTree(int[] data, int height, int E) {
        Node root = new Node(data[0]);
        int n = data.length;
        for (int i = 1; i < n; i++) {
            System.out.println("------------------------------------------------------------");
            System.out.println("agregando los datos a mi binary tree tales como: "+ "el valor del nodo:" +root.value + " ,el valor del arreglo: " + data[i] + " ,altura: "+ height + " ,temporal: "+ E);
            insertElement(root, data[i],height, E);
        }
        return root;
    }
    
    private static void insertElement(Node root, int value, int height, int E) {
        Node current = root;
        int level = height-1; // Start at second-to-last level
        while (level >= 0) {
            System.out.println("------------------------------------------------");
            System.out.println("Empezamos por el nivel de: "+level);
            if (value < current.value) {
                System.out.println("El valor es: "+value +", y el valor actual es: "+current.value+" entonces es mayor el valor actual que el valor en si");
                if (current.left == null) {
                    System.out.println("mi valor del hijo izquierdo de mi valor actual es nulo");
                    current.left = new Node(value);
                    current = current.left;
                    System.out.println("mi valor del hijo izquierda de mi valor actual sera: "+current.value );
                } else {
                    System.out.println("mi valor hijo izquierda de mi valor actual es no  nulo");
                    current = current.left;
                    //insertElement(current, value, height, E);
                    System.out.println("mi valor del hijo izquierda de mi valor actual tomara el valor de este: "+current.value);
                }    
            }
            else if(value==current.value){ 
                System.out.println("El valor es: "+value +", y el valor actual es: "+current.value+" entonces es igual el valor actual que el valor en si");
                break;
            }
            else {
                System.out.println("El valor es: "+value +", y el valor actual es: "+current.value+" entonces es menor el valor actual que el valor en si");
                if (current.right == null) {
                    System.out.println("mi valor del hijo derecha de mi valor actual es nulo");
                    current.right = new Node(value);
                    current = current.right;
                    System.out.println("mi valor del hijo izquierda de mi valor actual sera: "+current.value );
                } else {
                    System.out.println("mi valor del hijo derecha de mi valor actual es no nulo");
                    current = current.right;
                    //insertElement(current, value, height, E);
                    System.out.println("mi valor del hijo derecha de mi valor actual tomara el valor de este: "+current.value);
                }
            }
            level--;
        }
        //System.out.println("------------------------------------------------");
        if(current.left == null){
            current.left = new Node(E);
            //System.out.println("tenemos el valor agregado si existe un nulo: " + current.left.value);
        }
        else{
            current.right = new Node(E);
            //System.out.println("tenemos el valor agregado si existe un nulo: " + current.right.value);
        }
        

    }
    
    private static int[] extractSortedArray(Node root, int n) {
        int[] sortedArray = new int[n+10];
        int index = 0;
        extractSortedArrayRec(root, sortedArray, index);
        System.out.println("Aqui finaliza y el termino llega a la raiz con el valor de: "+sortedArray[index]+", y el indice: "+index);
        return sortedArray;
    }
    private static int extractSortedArrayRec(Node root, int[] sortedArray, int index) {
        if (root == null) {
            return index;
        }
        
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Valor: "+root.value+ ", indice: "+ index+ " ");
        index = extractSortedArrayRec(root.left, sortedArray, index);
        //System.out.println("Valor: "+root.value+ ", indice: "+ index+ " ");
        sortedArray[index++] = root.value;
        //System.out.println("Valor: "+root.value+ ", indice: "+ index+ " ");
        //System.out.println(sortedArray[index]);
        index = extractSortedArrayRec(root.right,sortedArray,index);
        System.out.println("Valor: "+root.value+ ", indice: "+ index+ " ");
        return index;
    }
    
    public static void imprimirArbolCompleto(Node root) {
        System.out.println("Recorrido en orden del árbol completo:");
        inOrden(root);
    }

    private static void inOrden(Node nodo) {
        if (nodo != null) {
            inOrden(nodo.left);
            System.out.print(nodo.value + " ");
            inOrden(nodo.right);
        }
    }
    public static void dibujarArbolInOrder(Node root) {
        System.out.println("Representación gráfica del árbol:");
        dibujarInOrder(root, "");
    }

    private static void dibujarInOrder(Node nodo, String espacios) {
        if (nodo != null) {
            dibujarInOrder(nodo.right, espacios + "    ");
            System.out.println(espacios + "|-- " + nodo.value);
            dibujarInOrder(nodo.left, espacios + "    ");
        }
    }
    /*
    public class CompleteBinaryTree {
    private int[] tree;
    private int lastIndex;

        public CompleteBinaryTree(int size, int constant) {
            tree = new int[size];
            Arrays.fill(tree, constant);
            lastIndex = -1;
        }

        public void insert(int value) {
            if (lastIndex >= tree.length) {
                System.out.println("El árbol está lleno, no se puede insertar más elementos.");
                return;
            }

            lastIndex++;
            tree[lastIndex] = value;
        }

        public void printTree() {
            for (int i = 0; i <= lastIndex; i++) {
                System.out.print(tree[i] + " ");
            }
            System.out.println();
        }
    }

    */
}

