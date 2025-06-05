import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean rept = true;
        while(rept){
            String ingreso;

            do {//INGRESO Y VALIDACIÓN DE DATOS A ANAÑIZAR
                System.out.println("Ingrese al menos 2 números separados por ; sin dejar espacios y use . para los decimales");
                ingreso = input.nextLine();
                if (!validarCaracteres(ingreso) || convertirArray(ingreso).length < 2) {
                    System.out.println("Entrada inválida o insuficiente, inténtalo de nuevo");
                }
            } while (!validarCaracteres(ingreso) || convertirArray(ingreso).length < 2);
            double[] datos = convertirArray(ingreso);
            mostrarMenu();
            double[] opciones = new double[0];
            do {
                String opcionesIngresadas = input.nextLine();
                opciones = convertirArray(opcionesIngresadas);
                if (!validarOpciones(opciones)) {
                    System.out.println("Las opciones seleccionadas no son válidas, inténtalo de nuevo");
                }
            } while (!validarOpciones(opciones));
            Object[] clavesYfrecuenciaAbsoluta = calcularFrecuenciaAbsoluta(datos);
            double[] clavesOrdenadas = (double[]) clavesYfrecuenciaAbsoluta[0];

            for (int i = 0; i < opciones.length; i++) {
                if (opciones[i] == 1) {
                    double media = calcularMedia(datos);
                    System.out.println("La media es: " + media);
                    System.out.println();
                }
                if (opciones[i] == 2) {
                    double mediana = calcularMediana(datos);
                    System.out.println("La mediana es: " + mediana);
                    System.out.println();
                }
                if (opciones[i] == 3) {
                    double[] modas = calcularModa(datos);
                    System.out.print("La(s) moda(s) es/son: ");
                    for (int j = 0; j < modas.length; j++) {
                        System.out.print(modas[j]);
                        if (j < modas.length - 1) {
                            System.out.print(", ");
                        }
                    }
                    System.out.println();
                    System.out.println();
                }
                if (opciones[i] == 4) {
                    double[] cuartiles = calcularCuartil(datos);
                    System.out.println("Q1: " + cuartiles[0]);
                    System.out.println("Q2 (Mediana): " + cuartiles[1]);
                    System.out.println("Q3: " + cuartiles[2]);
                }
                if (opciones[i] == 5) {
                    double rango = calcularRango(datos);
                    System.out.println("El rango es: " + rango);
                    System.out.println();
                }
                if (opciones[i] == 6) {
                    double[] varianzas = calcularVarianzas(datos);
                    System.out.println("  (Varianza Poblacional)---> " + varianzas[0]);
                    System.out.println("  (Varianza Muestral)---> " + varianzas[1]);
                    System.out.println();
                }
                if (opciones[i] == 7) {
                    double[] desviaciones = calcularDesviaciones(datos);
                    System.out.println("    (Desviación estándar poblacional)---> " + desviaciones[0]);
                    System.out.println("    (Desviación estándar muestral)---> " + desviaciones[1]);
                    System.out.println();
                }

                if (opciones[i] == 8) {
                    int[] frecuenciaAbsoluta = (int[]) clavesYfrecuenciaAbsoluta[1];
                    System.out.println("Frecuencia absoluta:");
                    for (int j = 0; j < frecuenciaAbsoluta.length; j++) {
                        System.out.println(clavesOrdenadas[j] + "  (FrecuenciaAbsoluta)---> " + frecuenciaAbsoluta[j]);
                    }
                    System.out.println();
                }
                if (opciones[i] == 9) {
                    double[] frecuenciaRelativa = calcularFrecuenciaRelativa(datos,clavesYfrecuenciaAbsoluta);
                    for(int l = 0; l<frecuenciaRelativa.length; l++){
                        System.out.println(clavesOrdenadas[l]+"--(Fr.Relativa)--> "+frecuenciaRelativa[l]);
                    }
                    System.out.println();
                }
                if (opciones[i] == 10) {
                    double[] frecuenciaRelativa = calcularFrecuenciaRelativa(datos, clavesYfrecuenciaAbsoluta);
                    double[] frecuenciaRelativaAcumulada = calcularFrecuenciaRelativaAcumulada(frecuenciaRelativa);

                    System.out.println("Frecuencia relativa acumulada:");
                    for (int j = 0; j < frecuenciaRelativaAcumulada.length; j++) {
                        System.out.println(clavesOrdenadas[j] + "   (FrecuenciaRelativa) --> " + frecuenciaRelativa[j] +
                                "   (FrecuenciaRelativaAcumulada) --> " + frecuenciaRelativaAcumulada[j]);
                    }
                    System.out.println();
                }
                if (opciones[i] == 11) {
                    int[] frecuenciaAbsoluta = (int[]) clavesYfrecuenciaAbsoluta[1];
                    int[] frecuenciaAcumulada = calcularFrecuenciaAbsolutaAcumulada(frecuenciaAbsoluta);
                    for (int j = 0; j < frecuenciaAcumulada.length; j++) {
                        System.out.println(clavesOrdenadas[j] + "   (FrecuenciaAbsoluta)---> " + frecuenciaAbsoluta[j] + "     (FrecuenciaAbsolutaAcumulada)---> " + frecuenciaAcumulada[j]);
                    }
                    System.out.println();
                }
                if (opciones[i] == 12) {
                    double[] frecuenciaPorcentual = calcularFrecuenciaPorcentual(datos, clavesYfrecuenciaAbsoluta);
                    int[] frecuenciaAbsoluta = (int[]) clavesYfrecuenciaAbsoluta[1];
                    for(int q =0;q<frecuenciaPorcentual.length;q++){
                        System.out.println(clavesOrdenadas[q]+" --(Fr.Absoluta)--> "+frecuenciaAbsoluta[q]+" --(Fr.Porcentual)--> "+ frecuenciaPorcentual[q]+"%");
                    }
                    System.out.println();
                }
                if (opciones[i] == 13) {
                    double[] frPorcentualAcumulada = calcularFrecuenciaPorcentualAcumulada(datos, clavesYfrecuenciaAbsoluta);
                    int[] frecuenciaAbsoluta = (int[]) clavesYfrecuenciaAbsoluta[1];
                    for(int y =0;y<frPorcentualAcumulada.length;y++){
                        System.out.println(clavesOrdenadas[y]+" --(Fr.Absoluta)--> "+frecuenciaAbsoluta[y]+" --(Fr.Porcentual)--> "+ frPorcentualAcumulada[y]+"%");
                    }
                    System.out.println();
                }
                if(opciones[i] == 14){
                    mostrarTablaFrecuenciaCompleta(datos);
                }

                System.out.println();
            }

            rept =repetirPrograma(input, rept);
        }
    }
    static boolean repetirPrograma(Scanner input, boolean rept){
        while (true) {
            System.out.println("¿Deseás seguir con el programa? sí/no");
            String resp = input.nextLine();

            if (resp.equalsIgnoreCase("si")){
                break;
            } else if (resp.equalsIgnoreCase("no")) {
                rept = false;
                break;
            } else {
                System.out.println("Entrada inválida. Por favor escribí 'sí' o 'no'.");
            }
        }
        return rept;
    }
    static boolean validarCaracteres(String ingreso) {
        boolean esInicioNumero = true; // Indica si estamos al inicio de un número

        for (int i = 0; i < ingreso.length(); i++) {
            char c = ingreso.charAt(i);
            if (!Character.isDigit(c) && c != '.' && c != ';' && c != '-') {
                return false;
            }
            if (c == '-') {
                if (i == ingreso.length() - 1 || (!esInicioNumero && ingreso.charAt(i - 1) != ';')) {
                    return false;
                }
            }
            esInicioNumero = (c == ';');
        }

        return true;
    }
    static double[] convertirArray(String opcionesIngresadas){
        String[] opciones = opcionesIngresadas.split(";");
        double[] numeros = new double[opciones.length];
        for(int i=0; i<opciones.length; i++){
            numeros[i]= Double.parseDouble(opciones[i]);
        }
        return numeros;
    }
    static void mostrarMenu(){
        System.out.println("Ingrese los cálculos a realizar separados por ;");
        System.out.println
                ("---MEDIDAS DE POSICION---\n" +
                        "1 --> Calcular media\n" +
                        "2 --> Calcular mediana\n" +
                        "3 --> Calcular moda\n" +
                        "4 --> Calcular cuartiles\n" +
                        "---MEDIDAS DE DISPERSION---\n" +
                        "5 --> Calcular rango\n" +
                        "6 --> Calcular varianza\n" +
                        "7 --> Calcular desviación estándar\n" +
                        "---FRECUENCIAS---\n" +
                        "8 --> Calcular frecuencia absoluta\n" +
                        "9 --> Calcular frecuencia relativa\n" +
                        "10 --> Calcular frecuencia relativa acumulada\n" +
                        "11 --> Calcular frecuencia absoluta acumulada\n" +
                        "12 --> Calcular frecuencia porcentual\n" +
                        "13 --> Calcular frecuencia porcentual acumulada\n"+
                        "14 --> Calcular tabla completa de frecuencias\n");
    }
    static boolean validarOpciones(double[] opciones){
        for(double num : opciones){
            if(num % 1 !=0){
                return false;
            }
            else{
                if(num < 1 || num >14){
                    return false;
                }
            }
        }
        return true;
    }
    static Object[] calcularFrecuenciaAbsoluta(double[] datos){
        HashMap<Double, Integer> frecuencia = new HashMap<>();
        int contadorActual;
        for(double num : datos){
            if(frecuencia.containsKey(num)){
                contadorActual = frecuencia.get(num);
                frecuencia.put(num, contadorActual+1);
            }
            else{
                frecuencia.put(num, 1);
            }
        }
        List<Double> clavesOrdenadas = new ArrayList<>(frecuencia.keySet());
        Collections.sort(clavesOrdenadas);
        double[] numerosSinRepetir = new double[clavesOrdenadas.size()];
        // Crear y llenar el array de frecuencias absolutas
        int[] frecuenciasArray = new int[clavesOrdenadas.size()];
        for (int i = 0; i < clavesOrdenadas.size(); i++) {
            numerosSinRepetir[i] = clavesOrdenadas.get(i);
            frecuenciasArray[i] = frecuencia.get(clavesOrdenadas.get(i));
        }


        return new Object[]{numerosSinRepetir, frecuenciasArray};

    }
    static double calcularMedia(double[] datos) {
        double suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma += datos[i]; // suma los datos
        }
        return suma / datos.length; // divide la suma entre la cantidad de datos
    }
    static double calcularMediana(double[] datos){
        int n = datos.length;
        double medianaCalculada;
        Arrays.sort(datos); // Ordenar los datos
        if(n % 2 == 1){// Si la cantidad es impar, la mediana es el elemento del medio
            medianaCalculada = datos[(n-1)/2];
        }
        else{// Si la cantidad es par, se promedian los dos valores centrales
            double medianaCalculada1 = datos[n/2 - 1];
            double medianaCalculada2 = datos[n/2];
            medianaCalculada = (medianaCalculada1+medianaCalculada2)/2;
        }
        return medianaCalculada;
    }
    public static double[] calcularModa(double[] datos) {
        HashMap<Double, Integer> frecuencia = new HashMap<>();
        int maxFrecuencia = 0;

        // Contar frecuencia de cada número
        for (double num : datos) {
            int count = frecuencia.getOrDefault(num, 0) + 1;
            frecuencia.put(num, count);
            if (count > maxFrecuencia) {
                maxFrecuencia = count;
            }
        }

        // Recopilar todos los números que tienen frecuencia máxima
        List<Double> modas = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() == maxFrecuencia) {
                modas.add(entry.getKey());
            }
        }

        // Convertir lista a arreglo de double
        double[] resultado = new double[modas.size()];
        for (int i = 0; i < modas.size(); i++) {
            resultado[i] = modas.get(i);
        }

        return resultado;
    }
    public static double[] calcularCuartil(double[] datos) {
        double[] cuartiles = new double[3];
        Arrays.sort(datos);

        for (int i = 0; i < 3; i++) {
            int cantidad = i + 1;
            double posicion = (cantidad * (datos.length + 1)) / 4.0;
            int indiceEntero = (int) posicion;
            double parteDecimal = posicion - indiceEntero;

            if (cantidad == 2 && datos.length % 2 == 0) { // Caso especial para la mediana con n par
                cuartiles[i] = (datos[datos.length / 2 - 1] + datos[datos.length / 2]) / 2.0;
            } else {
                cuartiles[i] = calcularInterpolado(datos, indiceEntero, parteDecimal);
            }
        }

        return cuartiles;
    }
    public static double calcularInterpolado(double[] datos, int indice, double parteDecimal) {
        if (indice + 1 < datos.length) {
            return datos[indice] + parteDecimal * (datos[indice + 1] - datos[indice]);
        }
        return datos[datos.length - 1]; // Si la posición calculada es mayor al tamaño del arreglo
    }
    public static double calcularRango(double[] datos) {
        Arrays.sort(datos);
        return datos[datos.length - 1] - datos[0];
    }
    public static double [] calcularVarianzas(double[] datos){
        double sumcuadrado = 0;
        double mediav = calcularMedia(datos);
        for (int i = 0; i < datos.length; i++) {
            double restav = datos[i] - mediav;
            sumcuadrado = sumcuadrado + (restav * restav);
        }
        double varianzapoblacional = sumcuadrado / datos.length;
        double varianzamuestral = sumcuadrado / (datos.length-1);

        return new double[]{varianzapoblacional, varianzamuestral};
    }
    public static double[] calcularDesviaciones(double[] datos) {
        double[] varianzas = calcularVarianzas(datos);
        double desvPoblacional = Math.sqrt(varianzas[0]);
        double desvMuestral = Math.sqrt(varianzas[1]);
        //para hacer raiz
        return new double[]{desvPoblacional, desvMuestral};
    }
    public static double[] calcularFrecuenciaRelativa(double[] datos, Object[] resultado) {
        int[] frAbsoluta = (int[]) resultado[1];
        double[] frRelativa = new double[frAbsoluta.length];

        for (int i = 0; i < frAbsoluta.length; i++) {
            frRelativa[i] = (double) frAbsoluta[i] / datos.length;
        }

        return frRelativa;
    }
    public static double [] calcularFrecuenciaRelativaAcumulada(double [] frecuenciarelativa) {
        double sumr = 0;
        double [] acumuladar = new double [frecuenciarelativa.length];
        for (int i = 0; i < frecuenciarelativa.length; i ++)
        {
            sumr = sumr + frecuenciarelativa[i];
            acumuladar[i] = sumr;
        }
        return acumuladar;
    }
    public static int [] calcularFrecuenciaAbsolutaAcumulada(int[] frecuenciaAbsoluta) {
        int [] acumulada = new int [frecuenciaAbsoluta.length];
        int suma = 0;
        for (int i = 0; i < frecuenciaAbsoluta.length; i ++) {
            suma = suma + frecuenciaAbsoluta[i];
            acumulada[i] = suma;
        }
        return acumulada;
    }
    public static <object> double[] calcularFrecuenciaPorcentual(double[] datos, object[] resultado){
        double[] frRelativa = calcularFrecuenciaRelativa(datos, resultado);
        double[] frPorcentual = new double[frRelativa.length];
        for(int j = 0; j< frRelativa.length;j++){
            frPorcentual[j] = frRelativa[j] * 100;
        }
        return frPorcentual;
    }
    public static <object> double[] calcularFrecuenciaPorcentualAcumulada(double[] datos, object[] resultado){
        double[] frPorcentual = calcularFrecuenciaPorcentual(datos, resultado);
        double[] frPorcentualAcu = new double[frPorcentual.length];
        for (int i=0;i<frPorcentual.length;i++){
            if(i == 0){
                frPorcentualAcu[i] = frPorcentualAcu[i] + frPorcentual[i];
            }
            else{
                frPorcentualAcu[i] = frPorcentualAcu[i-1] + frPorcentual[i];
            }
        }
        return frPorcentualAcu;
    }
    public static void mostrarTablaFrecuenciaCompleta(double[] datos) {
        Object[] resultado = calcularFrecuenciaAbsoluta(datos);
        double[] valores = (double[]) resultado[0];
        int[] fAbs = (int[]) resultado[1];
        int[] fAbsAcum = calcularFrecuenciaAbsolutaAcumulada(fAbs);
        double[] fRel = calcularFrecuenciaRelativa(datos, resultado);
        double[] fRelAcum = calcularFrecuenciaRelativaAcumulada(fRel);
        double[] fPorcentual = calcularFrecuenciaPorcentual(datos, resultado);
        double[] fPorcentualAcum = calcularFrecuenciaPorcentualAcumulada(datos, resultado);

        System.out.printf("%-10s%-10s%-10s%-15s%-15s%-10s%-15s%n",
                "Valor", "F abs", "F acum", "F relativa", "F rel acum", "%", "% acum");

        for (int i = 0; i < valores.length; i++) {
            System.out.printf("%-10.2f%-10d%-10d%-15.2f%-15.2f%-10.2f%-15.2f%n",
                    valores[i], fAbs[i], fAbsAcum[i], fRel[i], fRelAcum[i], fPorcentual[i], fPorcentualAcum[i]);
        }
    }
}
