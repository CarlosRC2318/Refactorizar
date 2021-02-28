import java.util.Scanner;

/**
 * Esta clase se usa para  generar todos los números primos de 1 hasta un número máximo especificado por el usuario
 * @author Carlos Ruedas
 *
 */
public class Criba
{
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("Introduce el número para la criba de Erastótenes:");
		
		int dato=teclado.nextInt();
		
		int vector[]=new int[dato];
		
		System.out.println("\nVector inicial hasta :"+dato);
	
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(i+1+"\t");
		}
		
		vector=generarPrimos(dato);
		
		System.out.println("\nVector de primos hasta:"+dato);
		
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(vector[i]+"\t");
		}
	
	teclado.close();
	
	}
	
	/**
	 * Metodo para generar los primos
	 * @param max. Este parámetro permite especificar el valor máximo
	 * @return
	 */
	private static int[] generaPrimos(int max) {
		if (max >= 2) {
			// Declaraciones
			int dim = max + 1; // Tamaño del array
			boolean[] esPrimo = new boolean[dim];
			// Inicializar el array
			iniciarArray(dim, esPrimo);
			// Eliminar el 0 y el 1, que no son primos
			eliminar1Y0(esPrimo);
			// Criba
			cribar(dim, esPrimo);
			// ¿Cuántos primos hay?
			int cuenta = cuantosPrimos(dim, esPrimo);
			// Rellenar el vector de números primos
			int[] primos = rellenarVector(dim, esPrimo, cuenta);
			return primos;
		} else { // max < 2
			return new int[0];
			// Vector vacío
		}
	}
	
	/**
	 * 
	 * @param dim
	 * @param esPrimo
	 * @param cuenta
	 * @return Devuelve el vector relleno
	 */
	private static int[] rellenarVector(int dim, boolean[] esPrimo, int cuenta) {
		int i;
		int j;
		int[] primos = new int[cuenta];
		for (i=0, j=0; i<dim; i++) {
			if (esPrimo[i])
				primos[j++] = i;
		}
		return primos;
	}
	
	/**
	 * 
	 * @param dim
	 * @param esPrimo
	 * @return cuantos primos hay
	 */
	private static int cuantosPrimos(int dim, boolean[] esPrimo) {
		int i;
		int cuenta = 0;
		for (i=0; i<dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		return cuenta;
	}
	
	/**
	 * Inicia el array
	 * @param dim
	 * @param esPrimo
	 */
	private static void iniciarArray(int dim, boolean[] esPrimo) {
		int i;
		for (i=0; i<dim; i++)
			esPrimo[i] = true;
	}
	
	/**
	 * 
	 * @param dim
	 * @param esPrimo
	 */
	private static void cribar(int dim, boolean[] esPrimo) {
		int i;
		int j;
		for (i=2; i<Math.sqrt(dim)+1; i++) {
			if (esPrimo[i]) {
				// Eliminar los múltiplos de i
				j = eliminarMulti1(i, dim, esPrimo);
			}
		}
	}
	
	/**
	 * Elimina los multiplos de 1
	 * @param i
	 * @param dim
	 * @param esPrimo
	 * @return
	 */
	private static int eliminarMulti1(int i, int dim, boolean[] esPrimo) {
		int j;
		for (j=2*i; j<dim; j+=i)
			esPrimo[j] = false;
		return j;
	}
	/**
	 * Elimina el 1 y el 0
	 * @param esPrimo
	 */
	private static void eliminar1Y0(boolean[] esPrimo) {
		esPrimo[0] = esPrimo[1] = false;
	}
	
	
	// Generar números primos de 1 a max
	public static int[] generarPrimos (int max)
	{
			return generaPrimos(max);
	}
}