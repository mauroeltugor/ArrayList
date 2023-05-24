

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Procesos {
	
	ArrayList<String> nombres = new ArrayList<String>();
	ArrayList<Integer> edades = new ArrayList<Integer>();
	
	
	
	public void iniciar() {
		System.out.println("Iniciar");
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Llenar Datos\n";
		menu+="2. Imprimir Datos\n";
		menu+="3. Mayores de edad\n";
		menu+="4. Menores de edad\n";
		menu+="5. Buscar por nombre\n";
		menu+="6. Buscar por edades\n";
		menu+="7. Salir\n";
		menu+="Ingrese una opcion:\n";

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=7);
		
		
	}
	
	public void validarMenu(int opc) {
			
			switch (opc) {
			case 1:
				llenarDatos();
				 	break;
			case 2:
				if (validarArreglo()) {
					imprimirDatos();	
				}
			 		break;
			case 5:
				if (nombres!=null) {
					buscarPorNombre();
				}else {
					System.out.println("Debe primero llenar datos");
				}
			 		break;
			case 3:
				if (validarArreglo()) {
					esMayor();	
				}
					break;
			case 4:
				if (validarArreglo()) {
					esMenor();	
				}
				break;
			case 6:
				if (validarArreglo()) {
					buscarPorEdad();	
				}
					break;
			case 7:
					System.out.println("Chao!");
			 		break;
			default:System.out.println("Ingrese una opcion valida");
					break;
			}
	}
	
	
	
	
	
	public boolean validarArreglo() {
		if (nombres!=null) {
			return true;
		}else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
	}
	
	
	public void llenarDatos() {
		System.out.println("llenar datos");
		
			nombres.add(JOptionPane.showInputDialog("Ingrese el nombre del estudiante "));
			edades.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad")));
		
	}
	
	
	
	public void esMayor() {
		System.out.println("Los estudiantes que son mayores de edad son: ");
		
		for(int i = 0; i < edades.size(); i +=1) {
			if(edades.get(i) >= 18) {
				System.out.println(nombres.get(i) +" con una edad de "+edades.get(i));
			}
		}
	}
	
	public void esMenor() {
		System.out.println("Los estudiantes que son menores son de edad son: ");
		
		for(int i = 0; i < edades.size(); i +=1) {
			if(edades.get(i) < 18) {
				System.out.println(nombres.get(i)+" con una edad de "+edades.get(i));
			}
		}
	}
	
	public void imprimirDatos() {
		System.out.println("Las lista de estudiantes son: ");
		for (int i = 0; i < nombres.size(); i+=1) {
			System.out.println(nombres.get(i)+" con una edad de: "+edades.get(i)+",");
		}
		
		int suma = 0;
		
		for(int i = 0; i < edades.size(); i += 1) {
			 suma += edades.get(i);
			 
		}
		
		double promedio = suma/edades.size();
		
		System.out.println("El promedio de las notas es de: "+promedio);
	}
	
	
	
	public void buscarPorNombre() {
		int cont=0;
		String nombreBuscar=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		
		for (int i = 0; i < nombres.size(); i+=1) {
			if (nombres.get(i).equalsIgnoreCase(nombreBuscar)) {
				System.out.println("Lo encontro en la pos: "+i);
				cont++;
			}
		}
		
		if (cont>0) {
			System.out.println("Encontro a "+nombreBuscar+" "+cont+" veces");
		}else {
			System.out.println("la persona "+nombreBuscar+" no fue registrada");
		}
	}
	
	public void buscarPorEdad() {
		int cont=0;
		int numeroBuscar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero que desea buscar"));
		
		for (int i = 0; i < edades.size(); i+=1) {
			if (edades.get(i) == numeroBuscar) {
				System.out.println("Lo encontro en la pos: "+i);
				cont++;
			}
		}
		
		if (cont>0) {
			System.out.println("Encontro a "+numeroBuscar+" "+cont+" veces");
		}else {
			System.out.println("El numero "+numeroBuscar+" no fue registrado");
		}
	}
	
}