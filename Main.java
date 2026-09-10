public class Main { // clase principal

    /*
     * metodo de busqueda
     * recibe:
     * datos: el arreglo donde se va a buscar
     * buscado: el número que se quiere encontrar
     * devuelve:
     * la posición donde se encuentra el número
     * -1 si el número no se encuentra
     */
    public static int busquedaBinaria(int[] datos, int buscado) {

        // la búsqueda comienza desde la posición 0 del arreglo.
        int limInf = 0;

        /*
         * length indica la cantidad de elementos que tiene el arreglo
         * como las posiciones en Java comienzan en 0,
         * la última posición es length - 1
         * ejemplo:
         * si hay 10 elementos:
         * length = 10
         * última posición = 10 - 1 = 9
         */
        int limSup = datos.length - 1;

        /*
         * mientras el límite inferior no sea mayor, que el límite superior, sigue buscando
         */
        while (limInf <= limSup) {

            /*
             * se calcula la posición que queda en medio
             * ejemplo:
             * limInf = 0
             * limSup = 9
             * mid = (0 + 9) / 2
             * mid = 4
             */
            int mid = (limInf + limSup) / 2;

            /*
             * se compara el dato que está en la posición
             * del medio con el número que esta buscando
             * si son iguales, encuentra el dato
             */
            if (datos[mid] == buscado) {
                return mid; // regresa a la posición donde se encontro
            }

            /*
             * si el número buscado es menor que el dato del medio,
             * significa que debe buscar hacia la izquierda
             *
             * Por eso mueve el límite superior.
             */
            if (buscado < datos[mid]) {
                limSup = mid - 1;

            } else {

                /*
                 * si el número buscado es mayor que el dato del medio,
                 * debem buscar hacia la derecha.
                 *
                 * Por eso mueve el límite inferior.
                 */
                limInf = mid + 1;
            }
        }

        /*
         * Si llega aquí significa que revisa
         * las posibilidades y no encontro el número
         * -1 se utiliza para indicar que no se encontró
         */
        return -1;
    }


    public static void main(String[] args) {

        /*
         * estos son los tamaños de arreglo que pidió
         * para realizar las pruebas:
         * 10
         * 100
         * 1000
         * 10000
         * 100000
         * 1000000
         */
        int[] valoresN = {
                10,
                100,
                1000,
                10000,
                100000,
                1000000
        };


        /*
         * este ciclo toma cada uno de los tamaños
         * de la lista anterior.
         * primero n = 10,
         * después n = 100,
         * después n = 1000,
         * y así sucesivamente.
         */
        for (int n : valoresN) {

            /*
             * crea un arreglo de tamaño n
             * por ejemplo:
             * si n = 10, se crea un arreglo de 10 posiciones
             * si n = 100, se crea uno de 100 posiciones
             */
            int[] datos = new int[n];


            /*
             * Llena el arreglo con números
             * que aumentan de 5 en 5
             * ejemplo cuando n = 10:
             *
             * [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
             *
             * el arreglo queda ordenado de menor a mayor,
             * y esto es necesario para utilizar búsqueda binaria.
             */
            for (int i = 0; i < n; i++) {
                datos[i] = (i + 1) * 5;
            }


            /*
             * se elige como dato buscado el último valor
             * que tiene el arreglo
             *
             * ejemplo:
             * Si n = 10:
             * buscado = 10 * 5 = 50
             *
             * Si n = 100:
             * buscado = 100 * 5 = 500
             */
            int buscado = n * 5;


            /*
             * Llama al metodo de busuqeda
             * le envia
             * datos: el arreglo donde se quiere buscar
             * buscado: el número que se quiere encontrar
             * El metodo devuelve la posicion
             */
            int posicion = busquedaBinaria(datos, buscado);


            // muestra el tamaño del arreglo
            System.out.println("n = " + n);

            // muestra el número que esta buscando
            System.out.println("Buscando: " + buscado);


            /*
             * si la posición es diferente de -1,
             * significa que el dato sí fue encontrado.
             */
            if (posicion != -1) {

                System.out.println(
                        "Encontrado en la posición: " + posicion
                );

            } else {

                /*
                 * si la posición es -1,
                 * significa que el dato no fue encontrado.
                 */
                System.out.println("No encontrado");
            }


            // línea para separar cada prueba 
            System.out.println("-------------------------");
        }
    }
}
