import geometria.MallaTriangular;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    MallaTriangular malla = new MallaTriangular();
    while (true) {
      System.out.println("Introduce el nombre de un archivo OBJ.");
      String archivo = s.next();

      try {
        malla.leerDeFicheroOBJ(archivo);
        System.out.println("Lectura Exitosa.");
      } catch (FileNotFoundException ex) {
        System.out.println("No se ha encontrado el archivo.");
        continue;
      } catch (IOException ex) {
        System.out.println("No se ha podido leer correctamente el archivo.");
        continue;
      }

      break;
    }
    
    while (true) {
      System.out.println("Introduce del nuevo archivo OBJ.");
      String archivo = s.next();

      try {
        malla.escribirAFicheroOBJ(archivo);
        System.out.println("Escritura Exitosa.");
      } catch (FileNotFoundException ex) {
        System.out.println("No se ha podido crear el archivo.");
        continue;
      } catch (IOException ex) {
        System.out.println("No se ha podido escribir correctamente el archivo.");
        continue;
      }

      break;
    }
  }
}
