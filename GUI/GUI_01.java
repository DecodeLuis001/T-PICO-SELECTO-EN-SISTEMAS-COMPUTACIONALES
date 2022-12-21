import java.awt.*; //Importamos todos los paquetes necesarios.
import java.awt.event.*;

class GUI_01
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

		//Definir componentes
		Label Etiqueta1 = new Label("Esta es la etiqueta 1");
		Label Etiqueta2 = new Label("Esta es la etiqueta 2");
		Label Etiqueta3 = new Label("Esta es la etiqueta 3");
		Label Etiqueta4 = new Label("Esta es la etiqueta 4");
		Label Etiqueta5 = new Label("Esta es la etiqueta 5");
		Label Etiqueta6 = new Label("Esta es la etiqueta 6");

		Button Boton1 = new Button("Mandar Mensaje");
		Button Boton2 = new Button("Cambia cursor");

		TextField Texto1 = new TextField("Escribe una palabra");
		TextArea TextoArea1 = new TextArea();

		CheckboxGroup Grupo1 = new CheckboxGroup();
		Checkbox Caja1 = new Checkbox("opcion1", Grupo1, true);
		Checkbox Caja2 = new Checkbox("opcion2", Grupo1, true);
		Checkbox Caja3 = new Checkbox("opcion3", Grupo1, true);
		Checkbox Caja4 = new Checkbox("opcion4", Grupo1, false);

		Choice Selection = new Choice();
		Selection.add("Item 1");
		Selection.add("Item 2");
		Selection.add("Item 3");
		Selection.add("Item 4");

		//crear el contenedor.
		miFrame = new Frame("Uso de compoentes basicos");
		miFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 50 /*vERTICAL*/, 100 /*hORIZONAL*/) );
			//Le asigna una forma automatica de acomodo a los componentes.

		/*
		FlowLayout
		BorderLayout
		GridLayout
		CardLayout
		*/

		//Añadir los componentes al frame.
		miFrame.add(Etiqueta1);
		miFrame.add(Etiqueta2);
		miFrame.add(Etiqueta3);
		miFrame.add(Etiqueta4);
		miFrame.add(Etiqueta5);
		miFrame.add(Etiqueta6);

		miFrame.add(Boton1);
		miFrame.add(Boton2);

		miFrame.add(Texto1);
		miFrame.add(TextoArea1);

		miFrame.add(Caja1);
		miFrame.add(Caja2);
		miFrame.add(Caja3);
		miFrame.add(Caja4);

		miFrame.add(Selection);

		//Cofiguraciones adicionales
		miFrame.setSize(1800, 800);
		miFrame.setVisible(true);

		//Asignar los metodos para atender los eventos necesarios.
		Boton1.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						System.out.println("El boton funciona");
					}
				}
			);
			//Asignamos los eventos a los diferentes componentes.

		Boton2.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						miFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
				}
			);

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