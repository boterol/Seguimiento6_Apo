package ui;

import java.util.Scanner;

import model.mainController;

public class Main {
	
	static Scanner sc=new Scanner(System.in);
	static mainController controller=new mainController();
	public static void main(String[] args) throws Exception {
		controller.deSerializing();
		int option=0;
		do {
			System.out.println("(1)Importar datos CSV\n"+
					"(2)Agregar valla publicitaria\n"+
					"(3)Mostrar vallas\n"+
					"(4)Mostrar vallas peligrosas\n"+
					"(0)Salir");
			option=sc.nextInt();
			choiceSelection(option);
		}while(option!=0);
	}
	
	public static void choiceSelection(int option) throws Exception
	{
		switch(option)
		{
		case 1:
			sc.nextLine();
			String path;
			System.out.println("ingrese la ruta del archivo csv: ");
			path=sc.nextLine();
			controller.importData(path);
			break;
		case 2:
			sc.nextLine();
			String valla="";
			System.out.println("ingrese la información de la valla de la siguiente forma: \n"+
					"width++height++inUse++brand");
			valla=sc.nextLine();
			controller.addValla(valla);
			break;
		case 3: 
			System.out.println(controller.vallasList());
			break;
		case 4:
			controller.DangerousVallas();
			break;
		case 0:
			System.out.println("Bye");
			controller.serializing();
			break;
		}
	}

}
