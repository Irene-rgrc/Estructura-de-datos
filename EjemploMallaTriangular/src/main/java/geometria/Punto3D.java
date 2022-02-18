package geometria;

/*
 * Clase usada para guardar las coordenadas de un vértices.
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
 * vértices son compartidos por dos triángulos (v1 y v2). Por tanto, tendremos cuatro objetos
 * (instancias) de la clase Punto3D y cada una almacenará la coordenadas de un vértice:
 * (x=0, y=0, z=0), (x=1, y=1, z=0), (x=1, y=-1, z=0) y (x=2, y=0, z=0).
 */
public class Punto3D {
  private double x;
  private double y;
  private double z;

  /**
   * Constructor de la clase.
   */
  public Punto3D() {
    this.x = this.y = this.z = 0;
  }

  /**
   * Constructor de la clase con asignación de los valores vert1, vert2 y vert3.
   *
   * @param x el valor a asignar a this.x.
   * @param y el valor a asignar a this.y.
   * @param z el valor a asignar a this.z.
   */
  public Punto3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Constructor de la clase por cópia.
   *
   * @param otro el punto a copiar.
   */
  public Punto3D(Punto3D otro) {
    this.x = otro.x;
    this.y = otro.y;
    this.z = otro.z;
  }

  /** @return the x */
  public double getX() {
    return x;
  }

  /** @param x el valor a asignar a this.x */
  public void setX(int x) {
    this.x = x;
  }

  /** @return the y */
  public double getY() {
    return y;
  }

  /** @param y el valor a asignar a this.y */
  public void setY(int y) {
    this.y = y;
  }

  /** @return the z */
  public double getZ() {
    return z;
  }

  /** @param z el valor a asignar a this.z */
  public void setZ(int z) {
    this.z = z;
  }

  /** @return las tres coordenadas del vértices concatenadas en una cadena de caracteres. */
  @Override
  public String toString() {
    return this.x + " " + this.y + " " + this.z;
  }
}
