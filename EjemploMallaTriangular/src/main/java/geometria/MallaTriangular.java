package geometria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Clase usada para los datos de una malla triangular.
 * Por ejemplo:
 *             ∧   v1 = (1, 1, 0)      Lista de vértices:     Lista de triángulos:
 *            /|\                      v0 (0, 0, 0)           t0 0 2 1
 *           / | \                     v1 (1, 1, 0)           t1 2 3 1
 * v0 =     /  |t1\  v3 =              v2 (1, -1, 0)
 *  (0,0,0) \t0|  /    (2, 0, 0)       v3 (2, 0, 0)
 *           \ | /
 *            \|/
 *             v   v2 = (1, -1, 0)
 * En este ejemplo tenemos dos triángulos formados mediante 4 vértices (v0, v1, v2 y v3). Dos de los
 * vértices son compartidos por dos triángulos (v1 y v2). Por tanto, una lista de vértices con
 * cuatro vértices (v0, v1, v2 y v3) y dos triángulos (t0 y t1).
 */
public class MallaTriangular {
  /** Array de vértices 3D. */
  private Punto3D vertices[];

  /** Array de triángulos (índices a vértices). */
  private Triangulo triangulos[];

  /** Constructor de la clase. */
  public MallaTriangular() {}

  /** @return the vertices */
  public Punto3D[] getVertices() {
    return vertices;
  }

  /** @param vertices el valor para asignar a this.vertices */
  public void setVertices(Punto3D[] vertices) {
    this.vertices = vertices;
  }

  /** @return the triangulos */
  public Triangulo[] getTriangulos() {
    return triangulos;
  }

  /** @param triangulos el valor para asignar a this.triangulos */
  public void setTriangulos(Triangulo[] triangulos) {
    this.triangulos = triangulos;
  }

  /**
   * Función que lee un fichero OBJ y cuenta cuántos vértices y triangulo contiene. Estas cantidades
   * se usan para inicializar los arrays this.vertices y this.triangulos.
   *
   * @param archivo nombre del fichero obj.
   * @throws FileNotFoundException si no se encuentra el fichero.
   * @throws IOException si hay algún problema de lectura del fichero.
   */
  private void inicializarArrays(String archivo) throws IOException {
    // Usaremos un buffer como wrapper del FileReader, que permite agrupar los caracteres que van
    // llegando a la espera de que el programa los vaya reclamando. De esta manera, se reduce el
    // número de accesos a disco (mejora la eficiencia) y podemos leer líneas enteras.
    BufferedReader buffer = new BufferedReader(new FileReader(archivo));

    // Inicializamos los contadores de vértices y triańgulos a 0.
    int numeroVertices = 0;
    int numeroTriangulos = 0;

    String line = buffer.readLine();
    // Iremos leyendo líneas hasta que buffer.readLine() retorne null (no queden más líneas a leer).
    while (line != null) {
      // Dividiremos cada línea en palabras separadas por espacios.
      String valores[] = line.split(" ");
      if (valores[0].equals("v")) { // Si la línea empieza con "v", codifica un vértice.
        ++numeroVertices;
      } else if (valores[0].equals("f")) { // Si la línea empieza con "f", codifica un triángulo.
        ++numeroTriangulos;
      }

      line = buffer.readLine();
    }

    // Al acabar de leer el archivo, cerramos la conexión con el disco y liberamos los recursos.
    buffer.close();

    // Usando el número de vértices y caras contados, inicializamos los arrays.
    this.vertices = new Punto3D[numeroVertices];
    this.triangulos = new Triangulo[numeroTriangulos];
  }

  /**
   * Función que lee un fichero OBJ y guarda los vértices y triangulos encontrados en las
   * estructuras this.vertices y this.triangulos.
   *
   * @param archivo nombre del fichero obj.
   * @throws FileNotFoundException si no se encuentra el fichero.
   * @throws IOException si hay algún problema de lectura del fichero.
   */
  private void rellenarArrays(String archivo) throws IOException {
    // Usaremos un buffer como wrapper del FileReader, que permite agrupar los caracteres que van
    // llegando a la espera de que el programa los vaya reclamando. De esta manera, se reduce el
    // número de accesos a disco (mejora la eficiencia) y podemos leer líneas enteras.
    BufferedReader buffer = new BufferedReader(new FileReader(archivo));

    int indiceVertices = 0;
    int indiceTriangulos = 0;

    String line = buffer.readLine();
    // Iremos leyendo líneas hasta que buffer.readLine() retorne null (no queden más líneas a leer).
    while (line != null) {
      // Dividiremos cada línea en palabras separadas por espacios.
      String valores[] = line.split(" ");
      if (valores[0].equals("v")) { // Si la línea empieza con "v", codifica un vértice.
        // Parseamos los valores de las coordenadas de los vértices. Es decir, convertimos cadenas
        // de caracteres que representan un valor en coma flotante a valores double.
        final double X = Double.parseDouble(valores[1]);
        final double Y = Double.parseDouble(valores[2]);
        final double Z = Double.parseDouble(valores[3]);

        // Creamos el punto con las coordenadas parseadas.
        Punto3D vertice = new Punto3D(X, Y, Z);
        // Asignamos el vértice a la primera posición libre y incrementamos el índice en 1.
        this.vertices[indiceVertices++] = vertice;

      } else if (valores[0].equals("f")) { // Si la línea empieza con "f", codifica un triángulo.
        // Parseamos los índices de los vértices que forman un triángulo. Es decir, convertimos
        // cadenas de caracteres que representan un índice a valores integer.
        final int V1 = Integer.parseInt(valores[1]);
        final int V2 = Integer.parseInt(valores[2]);
        final int V3 = Integer.parseInt(valores[3]);

        // Creamos el triángulo con los índics parseados.
        Triangulo triangulo = new Triangulo(V1, V2, V3);
        // Asignamos el triángulo a la primera posición libre y incrementamos el índice en 1.
        this.triangulos[indiceTriangulos++] = triangulo;
      }

      line = buffer.readLine();
    }

    // Al acabar de leer el archivo, cerramos la conexión con el disco y liberamos los recursos.
    buffer.close();
  }

  /**
   * Función que lee una MallaTriangular de un fichero OBJ.
   *
   * @param archivo nombre del fichero obj.
   * @throws FileNotFoundException si no se encuentra el fichero.
   * @throws IOException si hay algún problema de lectura del fichero.
   */
  public void leerDeFicheroOBJ(String archivo) throws IOException {
    inicializarArrays(archivo);
    rellenarArrays(archivo);
  }

  /**
   * Función que escribe una MallaTriangular a un fichero OBJ.
   *
   * @param archivo nombre del fichero obj.
   * @throws FileNotFoundException si no se encuentra el fichero (p.e. el directorio no existe).
   * @throws IOException si hay algún problema durante la escritura del fichero.
   */
  public void escribirAFicheroOBJ(String archivo) throws IOException {
    // Usaremos un buffer como wrapper del FileWriter, que permite agrupar los caracteres que se van
    // escribiendo a la espera de volcarlos a disco (flush). De esta manera, se reduce el número de
    // accesos a disco (mejora la eficiencia).
    BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));

    // Iteramos para cada vértice en la lista de vértices, y lo escribimos en el archivo.
    for (Punto3D vertice : this.vertices) {
      buffer.write("v " + vertice.toString());
      buffer.newLine();
    }

    // Iteramos para cada triángulo en la lista de triángulos, y lo escribimos en el archivo.
    for (Triangulo triangulo : this.triangulos) {
      buffer.write("f " + triangulo.toString());
      buffer.newLine();
    }

    // Al acabar de escribir el archivo, cerramos la conexión con el disco y liberamos los recursos.
    buffer.close();
  }
}
