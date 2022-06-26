package array;

import java.io.Serializable;

import osoba.Clovek;

//Array na uchovanie roznych typov tried

/**
 * A generic array for use in the project
 * @author vidaf
 * 
 * @param <T>
 */
public class GenericArray<T> implements Serializable{
	//private T[] zoznamRegistrovanych = new T[100];
	private Object[] arr;
	private int velkostPola;
	
	public GenericArray(int velkostPola)
	{
		arr = new Object[velkostPola];
		this.velkostPola = velkostPola;
	}
	
	public T getObjektNaIndexe(int i)
	{
		T e = (T)arr[i];
		return e;
	}
	
	public void setObjektNaIndexe(int i, T t)
	{
		arr[i] = t ;
	}
}
