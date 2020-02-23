package model.logic;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

//TODO Ambos

public class Comparendo implements Comparable<Comparendo>
{	
	private int OBJECTID;
	private String FECHA_HORA;
	private String MEDIO_DETE;
	private String CLASE_VEHI;
	private String TIPO_SERVI;
	private String INFRACCION;
	private String DES_INFRAC;
	private String LOCALIDAD;
	
	private double latitud;
	private double longitud; 
	
	public Comparendo ()
	{
		OBJECTID = 0;
		FECHA_HORA = "";
		MEDIO_DETE = "";
		CLASE_VEHI = "";
		TIPO_SERVI = "";
		INFRACCION = "";
		DES_INFRAC = "";
		LOCALIDAD = "";
	}
	
	public int darObjectid()
	{
		return OBJECTID;
	}
	public String darFecha_Hora()
	{
		return FECHA_HORA;
	}
	public String darMedio_Dete()
	{
		return MEDIO_DETE;
	}
	public String darClase_Vehi()
	{
		return CLASE_VEHI;
	}
	public String darTipo_Servicio()
	{
		return TIPO_SERVI;
	}
	public String darInfraccion()
	{
		return INFRACCION;
	}
	public String darDes_Infrac()
	{
		return DES_INFRAC;
	}
	public String darLocalidad()
	{
		return LOCALIDAD;
	}
	
	public void asignarObjectid(int i)
	{
		OBJECTID = i;
	}
	public void asignarFecha_Hora(String i)
	{
		FECHA_HORA = i;
	}
	public void asignarMedio_Dete(String i)
	{
		MEDIO_DETE = i;
	}
	public void asignarClase_Vehi(String i)
	{
		CLASE_VEHI = i;
	}
	public void asignarTipo_Servicio(String i)
	{
		TIPO_SERVI = i;
	}
	public void asignarInfraccion(String i)
	{
		INFRACCION = i;
	}
	public void asignarDes_Infrac(String i)
	{
		DES_INFRAC = i;
	}
	public void asignarLocalidad(String i)
	{
		LOCALIDAD = i;
	}
	
	public double darLatitud()
	{
		return latitud;
	}
	public double darLongitud()
	{
		return longitud;
	}
	public void asignarLatitud(double i)
	{
		latitud = i;
	}
	public void asignarLongitud(double i)
	{
		longitud = i; 
	}
	
	
	
	//TODO NUEVO TALLER 3
	
	public int compareTo(Comparendo compi) 
	{
		int a�o1 = Integer.parseInt(FECHA_HORA.split("/")[0]);
		int mes1 = Integer.parseInt(FECHA_HORA.split("/")[1]);
		int dia1 = Integer.parseInt(FECHA_HORA.split("/")[2]);

		int a�o2 = Integer.parseInt(compi.darFecha_Hora().split("/")[0]);
		int mes2 = Integer.parseInt(compi.darFecha_Hora().split("/")[1]);
		int dia2 = Integer.parseInt(compi.darFecha_Hora().split("/")[2]);
		
		if(a�o1 > a�o2)
		{
			return 1;
		}
		else if(a�o1 < a�o2)
		{
			return -1;
		}
		else if(mes1 > mes2)
		{
			return 1;
		}
		else if(mes1 < mes2)
		{
			return -1;
		}
		else if(dia1 > dia2)
		{
			return 1;
		}
		else if(dia1 < dia2)
		{
			return -1;
		}
		else
		{
			if(OBJECTID > compi.darObjectid())
			{
				return 1;
			}
			else
			{
				return -1;
			}
		}
		
	}
	
}
