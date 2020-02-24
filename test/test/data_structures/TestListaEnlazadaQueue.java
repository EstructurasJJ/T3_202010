package test.data_structures;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import model.data_structures.ListaEnlazadaQueue;
import model.logic.Comparendo;
import model.logic.Modelo;

public class TestListaEnlazadaQueue 
{
	private ListaEnlazadaQueue cola;

	private Modelo modelo;
	private Comparable[] arreglo1;
	private Comparable[] arreglo2;
	private Comparable[] arreglo3;

	public void setUp()
	{
		modelo= new Modelo();
		cola= new ListaEnlazadaQueue<Integer>();
	}


	public void setUp1()
	{
		modelo = new Modelo();
		modelo.leerGeoJson(Controller.JUEGUEMOS);

		cola = new ListaEnlazadaQueue<Integer>();

		for (int i = 0; i<100; i++)
		{
			Comparendo nuevo = new Comparendo();
			nuevo.asignarObjectid(i);

			cola.enqueue(nuevo);
		}
	}
	
	public void setUp2()
	{
		modelo = new Modelo();
		
		arreglo1 = new Comparable[100];
		arreglo2 = new Comparable[100];
		arreglo3 = new Comparable[100];
		
		//Arreglo aleatorio
		for (int i = 0; i < 100; i++)
		{
			double dato = Math.random();
			arreglo1[i] = dato; 
		}
		
		//Arreglo ordenado ascendentemente
		for (int i = 0; i < 100; i++)
		{
			arreglo2[i] = i; 
		}
		
		//Arreglo ordenado descendentemente
		for (int i = 99; i >= 0; i--)
		{
			arreglo3[i] = i; 
		}
	}

	@Test
	public void testEnqueue()
	{
		setUp();
		Comparendo nuevo= new Comparendo(), seg=new Comparendo(), ter=new Comparendo();
		nuevo.asignarObjectid(1);
		cola.enqueue(nuevo);
		assertEquals("No es el esperado", 1, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());
		assertEquals("No es el esperado", 1, cola.darUltimoElemento().darInfoDelComparendo().darObjectid());

		seg.asignarObjectid(2);
		cola.enqueue(seg);

		assertEquals("No es el esperado", 2, cola.darUltimoElemento().darInfoDelComparendo().darObjectid());
		assertEquals("No es el esperado", 1, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());

		ter.asignarObjectid(3);
		cola.enqueue(ter);

		assertEquals("No es el esperado", 3, cola.darUltimoElemento().darInfoDelComparendo().darObjectid());
		assertEquals("No es el esperado", 1, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());
	}

	@Test
	public void testDequeue()
	{
		setUp();
		Comparendo nuevo= new Comparendo(), seg=new Comparendo(), ter=new Comparendo();
		nuevo.asignarObjectid(1);
		cola.enqueue(nuevo);
		seg.asignarObjectid(2);
		cola.enqueue(seg);
		ter.asignarObjectid(3);
		cola.enqueue(ter);

		assertEquals(1, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());

		cola.dequeue();

		assertEquals(2, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());

		cola.dequeue();

		assertEquals(3, cola.darPrimerElemento().darInfoDelComparendo().darObjectid());
	}


	@Test
	public void testCalcularTamanio()
	{
		setUp1();
		assertEquals("No es el esperado", 100, cola.darTamanio());
	}

	@Test
	public void emptyList()
	{
		setUp();
		assertTrue("No es el esperado", cola.emptyList());
		setUp1();
		assertFalse("No es el esperado", cola.emptyList());

	}

	@Test
	public void testCargaDeDatos()
	{
		setUp1();
		assertTrue(modelo.darDatos()!=null);
		assertEquals(20, modelo.darTamanio());
	}
	
	@Test
	public void testProbarNodoCorrecto()
	{
		setUp1();
		assertTrue(modelo.darDatos().darPrimerElemento()!=null);
		assertTrue(cola.darPrimerElemento()!=null);
	}
	
	//Ordenamientos
	
	@Test
	public void testShell()
	{
		setUp2();
		Boolean ordenado = true;
		
		modelo.shell_sort(arreglo1);
		
		for(int i = 0; i < arreglo1.length-1; i++)
		{
			Double dato1 = (Double) arreglo1[i];
			Double dato2 = (Double) arreglo1[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.shell_sort(arreglo2);
		
		for(int i = 0; i < arreglo2.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo2[i];
			Integer dato2 = (Integer) arreglo2[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.shell_sort(arreglo3);
		
		for(int i = 0; i < arreglo3.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo3[i];
			Integer dato2 = (Integer) arreglo3[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
	}
	
	
	@Test
	public void testMerge()
	{
		setUp2();
		Boolean ordenado = true;
		
		modelo.MergeSort(arreglo1);
		
		for(int i = 0; i < arreglo1.length-1; i++)
		{
			Double dato1 = (Double) arreglo1[i];
			Double dato2 = (Double) arreglo1[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.MergeSort(arreglo2);
		
		for(int i = 0; i < arreglo2.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo2[i];
			Integer dato2 = (Integer) arreglo2[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.MergeSort(arreglo3);
		
		for(int i = 0; i < arreglo3.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo3[i];
			Integer dato2 = (Integer) arreglo3[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
	}
	
	@Test
	public void testQuick()
	{
		setUp2();
		Boolean ordenado = true;
		
		modelo.ordenamientoPorQuickSort(arreglo1);
		
		for(int i = 0; i < arreglo1.length-1; i++)
		{
			Double dato1 = (Double) arreglo1[i];
			Double dato2 = (Double) arreglo1[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.ordenamientoPorQuickSort(arreglo2);
		
		for(int i = 0; i < arreglo2.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo2[i];
			Integer dato2 = (Integer) arreglo2[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
		modelo.ordenamientoPorQuickSort(arreglo3);
		
		for(int i = 0; i < arreglo3.length-1; i++)
		{
			Integer dato1 = (Integer) arreglo3[i];
			Integer dato2 = (Integer) arreglo3[i+1];
			
			if (dato1 > dato2)
			{
				ordenado = false;
			}
		}
		
		assertTrue(ordenado);
		
	}
}
