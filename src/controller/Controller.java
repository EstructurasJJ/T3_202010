package controller;

import java.util.Scanner;



import model.data_structures.ListaEnlazadaQueue;
import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;
	private View view;
	public final static String RUTAGEOJASON = "./data/comparendos_dei_2018.geojson";
	public final static String JUEGUEMOS = "./data/comparendos_dei_2018_small.geojson";

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		Comparable[] arreglo = null;

		while( !fin )
		{
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{
			case 1:

				//Cargar el archivo

				modelo.leerGeoJson(RUTAGEOJASON);

				view.printMessage("Archivo GeoJSon Cargado");
				view.printMessage("Numero actual de comparendos " + modelo.darTamanio() + "\n----------");

				//Primer Comparendo

				view.printMessage("La información del primer Object Id es: ");
				view.printMessage("Object Id: " + modelo.PrimerComparendo().darObjectid());
				view.printMessage("Fecha Hora: " + modelo.PrimerComparendo().darFecha_Hora());
				view.printMessage("Infracción: " + modelo.PrimerComparendo().darInfraccion());
				view.printMessage("Clase Vehiculo: " + modelo.PrimerComparendo().darClase_Vehi());
				view.printMessage("Tipo Servicio: " + modelo.PrimerComparendo().darTipo_Servicio());
				view.printMessage("Localidad: " + modelo.PrimerComparendo().darLocalidad() + "\n----------");

				//Último Comparendo

				view.printMessage("La información del último Object Id es: ");
				view.printMessage("Object Id: " + modelo.UltimoComparendo().darObjectid());
				view.printMessage("Fecha Hora: " + modelo.UltimoComparendo().darFecha_Hora());
				view.printMessage("Infracción: " + modelo.UltimoComparendo().darInfraccion());
				view.printMessage("Clase Vehiculo: " + modelo.UltimoComparendo().darClase_Vehi());
				view.printMessage("Tipo Servicio: " + modelo.UltimoComparendo().darTipo_Servicio());
				view.printMessage("Localidad: " + modelo.UltimoComparendo().darLocalidad() + "\n----------");
				

				
			break;

			case 2:
				
				//Cargar Copia
				
				arreglo = null;
				arreglo = modelo.copiarComparendos();

				//Ordenar los datos de forma acendente por Shell Sort y medir tiempo.

				long tiempoComienzo=System.currentTimeMillis();
				modelo.shell_sort(arreglo);
				long tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				int conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) arreglo[conta]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				int conti = arreglo.length-1;
				while (conti >  arreglo.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) arreglo[conti]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conti]).darObjectid());
					conti--;
				}

				System.out.println("---------------------");

				//Imprimir tiempo

				System.out.println("Se demoró: " + tiempo + " milisegundos en hacer la operación");
				System.out.println("---------------------");

				break;

			case 3:
				
				//Cargar Copia
				
				arreglo = null;
				arreglo = modelo.copiarComparendos();
				
				//Ordenar los datos de forma acendente por Merge Sort y medir tiempo.

				tiempoComienzo=System.currentTimeMillis();
				modelo.MergeSort(arreglo);
				tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) arreglo[conta]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				conti = arreglo.length-1;
				while (conti >  arreglo.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) arreglo[conti]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conti]).darObjectid());
					conti--;
				}

				System.out.println("---------------------");

				//Imprimir tiempo

				System.out.println("Se demoró: " + tiempo + " milisegundos en hacer la operación");
				System.out.println("---------------------");

				break;

			case 4:
				
				//Cargar Copia
				
				arreglo = null;
				arreglo = modelo.copiarComparendos();
				
				//Cargar Copia

				arreglo = modelo.copiarComparendos();

				//Ordenar los datos de forma acendente por Quick Sort y medir tiempo.

				tiempoComienzo=System.currentTimeMillis();
				modelo.ordenamientoPorQuickSort(arreglo);
				tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) arreglo[conta]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				conti = arreglo.length-1;
				while (conti >  arreglo.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) arreglo[conti]).darFecha_Hora() + " , " + ((Comparendo) arreglo[conti]).darObjectid());
					conti--;
				}

				System.out.println("---------------------");

				//Imprimir tiempo

				System.out.println("Se demoró: " + tiempo + " milisegundos en hacer la operación");
				System.out.println("---------------------");

				break;
				
			case 5:
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opción Invalida !! \n---------");
				break;
			}
		}

	}	
}
