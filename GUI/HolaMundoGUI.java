import java.awt.*; //Importamos todos los paquetes necesarios.
import java.awt.event.*;

class HolaMundo
{
	public static void main(String args[])
	{
		GUI gui1 = new GUI(); //creamos el objeto de la clase GUI para relavionar la clase principal con GUI.
	}
}

class GUI
{
	//Atributos.
	Frame miFrame;

	public GUI()
	{
		miFrame = new Frame("Hola Mundo");
		miFrame.setLayout(new FlowLayout() );

		//Añadir los componentes al frame.

		//Cofiguraciones adicionales
		miFrame.setSize(800, 300);
		miFrame.setVisible(true);

		//Asignar los metodos para atender los eventos necesarios.


		//Asignar el metodo para atender el boton de cerrar ventana.
		miFrame.addWindowListener(new WindowAdapter()
									{
										public void windowClosing(WindowEvent evt)
										{
											System.exit(0);
										}
									}
								);
	}
	//Metodos
}