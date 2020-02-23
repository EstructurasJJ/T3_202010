package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

import model.data_structures.ListaEnlazadaQueue;
import model.data_structures.Node;


public class Modelo 
{
	private String parteDelComparendo; 
	private Comparendo compaAgregar;
	private boolean coordenadas = false;
	
	private double minLatitud = 1000000000;
	private double minLongitud = 1000000000;
	private double maxLatitud = -1000000000;
	private double maxLongitud = -1000000000;
	
	private ListaEnlazadaQueue<Comparendo> booty = new ListaEnlazadaQueue<Comparendo>();

	public Modelo()
	{
		parteDelComparendo = "";
		booty = new ListaEnlazadaQueue<Comparendo>();
	}
	
	
	public ListaEnlazadaQueue<Comparendo> darDatos()
	{
		return booty;
	}
	
	public int darTamanio()
	{
		return booty.darTamanio();
	}
	
	public double darMinLatitud()
	{
		return minLatitud;
	}
	public double darMinLongitud()
	{
		return minLongitud;
	}
	public double darMaxLatitud()
	{
		return maxLatitud;
	}
	public double darMaxLongitud()
	{
		return maxLongitud;
	}
	
	public Comparendo PrimerComparendo()
	{
		return booty.darPrimerElemento().darInfoDelComparendo();
	}
	
	public Comparendo UltimoComparendo()
	{
		return booty.darUltimoElemento().darInfoDelComparendo();
	}
	
	public void leerGeoJson(String pRuta) 
	{	
        JsonParser parser = new JsonParser();
        FileReader fr = null;
        
		try 
		{
			fr = new FileReader(pRuta);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
        JsonElement datos = parser.parse(fr);
        dumpJSONElement(datos);

	}
	
	private void dumpJSONElement(JsonElement elemento) 
	{
		
		
		if (elemento.isJsonObject()) 
		{
			
	        JsonObject obj = elemento.getAsJsonObject();
	        
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        
	        while (iter.hasNext()) 
	        {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	            componentesDelComparendo(entrada.getKey());	            

	            dumpJSONElement(entrada.getValue());
	        }

	    }
		else if (elemento.isJsonArray()) 
		{			
	        JsonArray array = elemento.getAsJsonArray();
	        java.util.Iterator<JsonElement> iter = array.iterator();
	        
	        while (iter.hasNext()) 
	        {
	            JsonElement entrada = iter.next();
	            dumpJSONElement(entrada);
	        }

	    } 
		else if (elemento.isJsonPrimitive()) 
		{
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        
	        if(compaAgregar == null)
	        {
	    		compaAgregar = new Comparendo();
	        }
	        
	        if(parteDelComparendo.equals("OBJECTID"))
	        {
	        	compaAgregar.asignarObjectid(valor.getAsInt());
	        	//System.out.println(valor);
	        }
	        else if (parteDelComparendo.equals("FECHA_HORA"))
			{
	        	compaAgregar.asignarFecha_Hora(valor.getAsString());
				//System.out.println(valor);
			}
			else if (parteDelComparendo.equals("MEDIO_DETE"))
			{
				compaAgregar.asignarMedio_Dete(valor.getAsString());
				//System.out.println(valor);
			}
			else if (parteDelComparendo.equals("CLASE_VEHI"))
			{
				compaAgregar.asignarClase_Vehi(valor.getAsString());
				//System.out.println(valor);
			}
			else if (parteDelComparendo.equals("TIPO_SERVI"))
			{
				compaAgregar.asignarTipo_Servicio(valor.getAsString());
				//System.out.println(valor);
			}
			else if (parteDelComparendo.equals("INFRACCION"))
			{
				compaAgregar.asignarInfraccion(valor.getAsString());
				//System.out.println(valor);
			}
			else if (parteDelComparendo.equals("DES_INFRAC"))
			{
				compaAgregar.asignarDes_Infrac(valor.getAsString());
				//System.out.println(valor);
				
			}
			else if (parteDelComparendo.equals("LOCALIDAD"))
			{				
				compaAgregar.asignarLocalidad(valor.getAsString());
				//System.out.println(valor);	
				parteDelComparendo = "";
			}
			else if (parteDelComparendo.equals("coordinates"))
			{
				agregarCoordenada(valor.getAsDouble());				
			}

	    } 
		else if (elemento.isJsonNull()) 
		{
	        System.out.println("Es NULL");
	    } 
		else 
		{
	        System.out.println("Es otra cosa");
	    }
		
	}
	
	public void componentesDelComparendo(String palabra)
	{
		if (palabra.equals("OBJECTID"))
		{
			parteDelComparendo = "OBJECTID";
		}
		else if (palabra.equals("FECHA_HORA"))
		{
			parteDelComparendo = "FECHA_HORA";
		}
		else if (palabra.equals("MEDIO_DETE"))
		{
			parteDelComparendo = "MEDIO_DETE";
		}
		else if (palabra.equals("CLASE_VEHI"))
		{
			parteDelComparendo = "CLASE_VEHI";
		}
		else if (palabra.equals("TIPO_SERVI"))
		{
			parteDelComparendo = "TIPO_SERVI";
		}
		else if (palabra.equals("INFRACCION"))
		{
			parteDelComparendo = "INFRACCION";
		}
		else if (palabra.equals("DES_INFRAC"))
		{
			parteDelComparendo = "DES_INFRAC";
		}
		else if (palabra.equals("LOCALIDAD"))
		{
			parteDelComparendo = "LOCALIDAD";
		}
		else if (palabra.equals("coordinates"))
		{
			parteDelComparendo = "coordinates";
		}
	}
	
	public void agregarCoordenada(double pCor)
	{
		if(coordenadas == false)
		{
			compaAgregar.asignarLongitud(pCor);
			//System.out.println("Longitud: " + pCor);
			
			if (pCor < minLongitud)
			{
				minLongitud = pCor;
			}
			else if (pCor > maxLongitud)
			{
				maxLongitud = pCor;
			}
			
			coordenadas = true;
		}

		else
		{
			compaAgregar.asignarLatitud(pCor);
			//System.out.println("Latitud: " + pCor);
			
			if (pCor < minLatitud)
			{
				minLatitud = pCor;
			}
			else if (pCor > maxLatitud)
			{
				maxLatitud = pCor;
			}
			
			//AGREGAR//
			
			coordenadas = false;
			parteDelComparendo = "";
			
			booty.enqueue(compaAgregar);
			compaAgregar = null;
			
			//System.out.println("///AGREGADO///");
			
		}

	}
	
	
	//TODO NUEVO TALLER 3
	
	//Generar copia.
	
	public Comparable[] copiarComparendos()
	{
		Comparable[] comparendosCopia = new Comparable[booty.darTamanio()];
		int contador = 0;
		
		while(booty.darTamanio()>0)
		{
			Comparendo compi = booty.dequeue();
			
			comparendosCopia[contador] = compi;
			
//			Comparendo prueba = (Comparendo) comparendosCopia[contador];
//			int id = prueba.darObjectid();
//			System.out.println(id);
			
			contador++;
			
		}
		
		return comparendosCopia;
	}
	
	//Menor
	
	public static boolean less(Comparable compi1, Comparable compi2)
	{
		return compi1.compareTo(compi2) < 0;
	}
	
	//Intercambio
	
	public static void exchange(Comparable[] copia, int pos1, int pos2)
	{
		Comparable tempo = copia[pos1];
		copia[pos1] = copia[pos2];
		copia[pos2] = tempo;
	}
	
	//Shell sort
	
	public Comparable[] shell_sort(Comparable[] copia)
	{
		int N = copia.length;
		int h = 1;
		
		while(h < N/3)
		{
			h = 3*h +1;
		}
		
		while(h>=1)
		{
			for (int i = h; i < N; i++)
			{
				for(int j = i; j>=h && less(copia[j], copia[j-h]); j = j -h)
				{
					exchange(copia,j,j-h);
				}
			}
			
			h = h/3;
		}
		
		return copia;
		
	}
	
	//Merge Sort
	
	public Comparable[] MergeSort(Comparable[] copia)
	{
		Comparable[] auxiliar = new Comparable[copia.length];
		
		sort_subpartes(copia, 0, copia.length-1, auxiliar);
		
		return copia;
	}

	//Ordenar sub partes.
	private static void sort_subpartes(Comparable[] copia, int low, int height, Comparable[] auxiliar) 
	{
		//Salir de la recursión.
		if(height <= low)
			return;
		
		//Definir las mitades.
		int mid = low + (height-low)/2;
		
		//Lado derecho.
		sort_subpartes(copia, low, mid, auxiliar);
		
		//Lado izquierdo.
		sort_subpartes(copia, mid+1, height, auxiliar);
		
		//Unir todo.
		merge(copia, low, mid, height, auxiliar);
	}

	//Unir todas las subpartes.
	private static void merge(Comparable[] copia, int low, int mid, int height, Comparable[] auxiliar) 
	{
		int i = low;
		int j = mid+1;
		
		for (int k = low; k <= height; k++)
		{
			auxiliar[k] = copia[k];
		}
		
		for (int k = low; k <= height; k++)
		{
			if(i > mid)
			{
				copia[k] = auxiliar[j++];
			}
			else if(j > height)
			{
				copia[k] = auxiliar[i++];
			}
			else if(less(auxiliar[j], auxiliar[i]))
			{
				copia[k] = auxiliar[j++];
			}
			else
			{
				copia[k] = auxiliar[i++];
			}
		}
		
	}
	
}
