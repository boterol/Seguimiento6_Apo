package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class mainController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<VallaPublicitaria> lista=new ArrayList<>();
	
	public void importData(String path) throws IOException
	{
			File file = new File(path); 
			FileReader fr = new FileReader(file);
			BufferedReader input = new BufferedReader(fr);
			input.readLine();
			while (input.ready()) { 
				String line = input.readLine();
				String [] objInfo = line.split("\\|");
				VallaPublicitaria valla = new VallaPublicitaria(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]), Boolean.parseBoolean(objInfo[2]), objInfo[3]);
				lista.add(valla);
			}
			input.close();
			fr.close();
	}
	
	public void addValla(String userInput)
	{
		try {
			String[] objInfo=userInput.split("\\+\\+");
			VallaPublicitaria valla = new VallaPublicitaria(Integer.parseInt(objInfo[0]), Integer.parseInt(objInfo[1]), Boolean.parseBoolean(objInfo[2]), objInfo[3]);
			lista.add(valla);
		}catch(Exception e)
		{
			System.out.println("no se pudo registrar, asegurese de haber ingresado bien los datos");
		}
	}
	
	public String vallasList()
	{
		String out="";
		for(int i=0; i<lista.size(); i++)
		{
			out+=lista.get(i).toString();
		}
		return out;
	}
	
	public void DangerousVallas() throws IOException
	{
		ArrayList<VallaPublicitaria> danger=new ArrayList<>();
		String text="==================\n";
		text+="DANGEROUS REPORT\n";
		text+="==================\n";
		int inter=0;
		for(int i=0; i<lista.size();i++)
		{
			inter=lista.get(i).getHeight()*lista.get(i).getWidth();
			if(inter>=200000)
			{
				text+=lista.get(i).toString2();
			}
		}
		//System.out.println(text);
		FileWriter fw=new FileWriter("files\\ListaVallasPeligrosas.txt");
		BufferedWriter output = new BufferedWriter(fw);
		output.write(text);
		output.close();
		fw.close();
	}
	
	public void serializing() throws IOException
	{
		FileOutputStream fileOut=new FileOutputStream("files\\ListaVallas.txt");
		ObjectOutputStream out=new ObjectOutputStream(fileOut);
		out.writeObject(lista);
		out.close();
		fileOut.close();
	}
	
	@SuppressWarnings("unchecked")
	public void deSerializing() throws IOException, ClassNotFoundException
	{
		File file=new File("files\\ListaVallas.txt");
		FileInputStream fileIn=new FileInputStream(file);
		ObjectInputStream in=new ObjectInputStream(fileIn);
		lista.addAll((ArrayList<VallaPublicitaria>) in.readObject());
		fileIn.close();
		in.close();
		System.out.println("hizo la deserialización");
	}
}
