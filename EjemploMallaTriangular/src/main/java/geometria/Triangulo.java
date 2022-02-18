package geometria;

/*
 * Clase usada para guardar los índices de tres vértices que forman un triangulo.
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
 * vértices son compartidos por dos triángulos (v1 y v2). Por tanto, la lista de vértices (que se
 * almacenará en un estructura fuera de la clase triángulo, p.e. MallaTriangular) contendrá las
 * coordenadas de estos 4 vértices. En cambio, tendremos dos objetos (instancias) de la clase
 * Triángulo, uno almacenará índices a los vértices (vert1=0, vert2=2, vert3=1) (o una permutación
 * de estos) y el otro almacenará índices a los vértices (vert1=2, vert2=3, vert3=1) (o una
 * permutación de estos).
 */
public class Triangulo {
  /** vert1, v2 y v3 son índices a los tres vértices que forman el triangulo. */
  private int vert1;

  private int vert2;
  private int vert3;

  /** Constructor de la clase. */
  public Triangulo() {
    this.vert1 = this.vert2 = this.vert3 = 0;
  }

  /**
   * Constructor de la clase con asignación de los valores vert1, vert2 y vert3.
   *
   * @param v1 el valor a asignar a vert1
   * @param v2 el valor a asignar a vert2
   * @param v3 el valor a asignar a vert3
   */
  public Triangulo(int v1, int v2, int v3) {
    this.vert1 = v1;
    this.vert2 = v2;
    this.vert3 = v3;
  }

  /**
   * Constructor de la clase por cópia.
   *
   * @param otro el triángulo a copiar.
   */
  public Triangulo(Triangulo otro) {
    this.vert1 = otro.vert1;
    this.vert2 = otro.vert2;
    this.vert3 = otro.vert3;
  }

  /** @return the vert1 */
  public int getVert1() {
    return vert1;
  }

  /** @param v1 el valor a asignar a vert1 */
  public void setVert1(int v1) {
    this.vert1 = v1;
  }

  /** @return the v2 */
  public int getVert2() {
    return vert2;
  }

  /** @param v2 el valor a asignar a v2 */
  public void setVert2(int v2) {
    this.vert2 = v2;
  }

  /** @return the v3 */
  public int getVert3() {
    return vert3;
  }

  /** @param v3 el valor a asignar a vert3 */
  public void setVert3(int v3) {
    this.vert3 = v3;
  }

  /**
   * @return los tres índices de los vértices que forman el triangulo concatenados en una cadena de
   *     caracteres.
   */
  @Override
  public String toString() {
    return this.vert1 + " " + this.vert2 + " " + this.vert3;
  }
}
