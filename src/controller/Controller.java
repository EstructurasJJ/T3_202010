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

				//Segundo Comparendo

				view.printMessage("La información del último Object Id es: ");
				view.printMessage("Object Id: " + modelo.UltimoComparendo().darObjectid());
				view.printMessage("Fecha Hora: " + modelo.UltimoComparendo().darFecha_Hora());
				view.printMessage("Infracción: " + modelo.UltimoComparendo().darInfraccion());
				view.printMessage("Clase Vehiculo: " + modelo.UltimoComparendo().darClase_Vehi());
				view.printMessage("Tipo Servicio: " + modelo.UltimoComparendo().darTipo_Servicio());
				view.printMessage("Localidad: " + modelo.UltimoComparendo().darLocalidad() + "\n----------");
				
				//Cargar Copia
				
				arreglo = null;
				arreglo = modelo.copiarComparendos();
				
			break;

			case 2:
				
				Comparable[] copia = arreglo;

				//Ordenar los datos de forma acendente por Shell Sort y medir tiempo.

				long tiempoComienzo=System.currentTimeMillis();
				modelo.shell_sort(copia);
				long tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				int conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) copia[conta]).darFecha_Hora() + " , " + ((Comparendo) copia[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				int conti = copia.length-1;
				while (conti >  copia.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) copia[conti]).darFecha_Hora() + " , " + ((Comparendo) copia[conti]).darObjectid());
					conti--;
				}

				System.out.println("---------------------");

				//Imprimir tiempo

				System.out.println("Se demoró: " + tiempo + " milisegundos en hacer la operación");
				System.out.println("---------------------");

				break;

			case 3:
				
				Comparable[] copia1 = arreglo;
				
				//Ordenar los datos de forma acendente por Merge Sort y medir tiempo.

				tiempoComienzo=System.currentTimeMillis();
				modelo.MergeSort(copia1);
				tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) copia1[conta]).darFecha_Hora() + " , " + ((Comparendo) copia1[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				conti = copia1.length-1;
				while (conti >  copia1.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) copia1[conti]).darFecha_Hora() + " , " + ((Comparendo) copia1[conti]).darObjectid());
					conti--;
				}

				System.out.println("---------------------");

				//Imprimir tiempo

				System.out.println("Se demoró: " + tiempo + " milisegundos en hacer la operación");
				System.out.println("---------------------");

				break;

			case 4:
				
				Comparable[] copia2 = arreglo;
				
				//Cargar Copia

				arreglo = modelo.copiarComparendos();

				//Ordenar los datos de forma acendente por Quick Sort y medir tiempo.

				tiempoComienzo=System.currentTimeMillis();
				//modelo.shell_sort(copia2);
				tiempo= System.currentTimeMillis()-tiempoComienzo;

				//Imprimir primeros 10

				conta = 0;
				while (conta < 10)
				{
					System.out.println(conta + ". " + ((Comparendo) copia2[conta]).darFecha_Hora() + " , " + ((Comparendo) copia2[conta]).darObjectid());
					conta++;
				}

				System.out.println("---------------------");

				//Imprimir ultimos 10

				conti = copia2.length-1;
				while (conti >  copia2.length-11)
				{
					System.out.println(conti+1 + ". " + ((Comparendo) copia2[conti]).darFecha_Hora() + " , " + ((Comparendo) copia2[conti]).darObjectid());
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
