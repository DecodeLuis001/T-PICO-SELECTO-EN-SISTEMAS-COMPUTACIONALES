import java.awt.*; //Importamos todos los paquetes necesarios.
import java.awt.event.*;

import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;

class GUI_02
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

		Button Boton1 = new Button("Calcular");
		Button Boton2 = new Button("Cambia cursor");

		TextField Texto1 = new TextField("Numero entero");
		TextField Texto2 = new TextField("Numero entero");
		TextField Texto3 = new TextField("Resultado");
		TextArea TextoArea1 = new TextArea();
		TextArea TextoArea2 = new TextArea();
		TextArea TextoArea3 = new TextArea();

		TextArea RecuadroTexto1 = new TextArea();

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

		List Listado = new List();
		for(int i=0; i<=10; i++)
			Listado.add("Elemento: "+i);
		Listado.select(1);

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

		//Anadir los componentes al frame.
		miFrame.add(Etiqueta1);
		miFrame.add(Etiqueta2);
		miFrame.add(Etiqueta3);
		miFrame.add(Etiqueta4);
		miFrame.add(Etiqueta5);
		miFrame.add(Etiqueta6);

		miFrame.add(Boton1);
		miFrame.add(Boton2);

		miFrame.add(Texto1);
		miFrame.add(Texto2);
		miFrame.add(Texto3);
		miFrame.add(TextoArea1);
		miFrame.add(TextoArea2);
		miFrame.add(TextoArea3);

		miFrame.add(Caja1);
		miFrame.add(Caja2);
		miFrame.add(Caja3);
		miFrame.add(Caja4);

		miFrame.add(Selection);

		//Cofiguraciones adicionales
		miFrame.setSize(1800, 1800);
		miFrame.setVisible(true);

		miFrame.add(RecuadroTexto1);
		//Asignar los metodos para atender los eventos necesarios.
		//CheckboxGroup.addActionListener(new EjemploActionListener(CheckboxGroup));
		RecuadroTexto1.addTextListener(new EventoEnRecuadroDeTexto(RecuadroTexto1));

		Texto1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				int a,b, c;
				a = Integer.valueOf(Texto1.getText());
				b = Integer.valueOf(Texto2.getText());
				c = a + b;
				Texto3.setText(String.valueOf(c));
				//System.out.println("Evento sobre el cuadro");
			}
		}
		);

		Texto2.addActionListener(new EventoEnCuadroDeTexto1(Texto1, Texto2, Texto3));

		Selection.addItemListener(new EjemploItemListener( Selection ));

		Boton1.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						int a,b,c;
						a = Integer.valueOf(Texto1.getText());
						b = Integer.valueOf(Texto2.getText());
						c = a + b;
						Texto3.setText(String.valueOf(c));
						//System.out.println("El boton funciona");

					}
				}
			);
			//Asignamos los eventos a los diferentes componentes.

		Boton2.addActionListener( new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						//miFrame.setCursor(new Cursor(Cursor.HAND_CURSOR));
						//Etiqueta1.setText(Selection.getSelectedItem());
						System.out.println(Grupo1.getSelectedCheckbox());
						System.out.println(Grupo1.getSelectedCheckbox().getName());
						System.out.println(Grupo1.getSelectedCheckbox().getLabel());
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

class EventoEnRecuadroDeTexto implements TextListener
{
	TextArea objRecuadroTexto;

	//Este es el constructor.
	public EventoEnRecuadroDeTexto(TextArea ref_a_ObjRecuadroTexto)
	{
		objRecuadroTexto = ref_a_ObjRecuadroTexto;
	}

	public void textValueChanged(TextEvent evt)
	{
		System.out.println("Se ha modificado algo");
	}
}

class EventoEnCuadroDeTexto1 implements ActionListener
{
	TextField objCT1;
	TextField objCT2;
	TextField objCT3;

	public EventoEnCuadroDeTexto1(TextField ref_CT1, TextField ref_CT2, TextField ref_CT3)
	{
		objCT1 = ref_CT1;
		objCT2 = ref_CT2;
		objCT3 = ref_CT3;
	}

	public void actionPerformed(ActionEvent evt)
	{
		int a, b, c;
		a = Integer.valueOf(objCT1.getText());
		b = Integer.valueOf(objCT2.getText());
		c = a + b;
		objCT3.setText(String.valueOf(c));
	}
}

class EjemploActionListener implements ActionListener
{
	CheckboxGroup ObjCheckBoxGroup;

	public EjemploActionListener(CheckboxGroup ref_a_ObjCheckBoxGroup)
	{
		ObjCheckBoxGroup = ref_a_ObjCheckBoxGroup;
	}

	public void actionPerformed(ActionEvent evt)
	{
		System.out.println( ObjCheckBoxGroup.getSelectedCheckbox().getName() +" "+ ObjCheckBoxGroup.getSelectedCheckbox().getLabel() );
	}
}

class EjemploItemListener implements ItemListener
{
	Choice ObjChoice;

	//Metodo constructor
	public EjemploItemListener(Choice choice)
	{
		ObjChoice = choice;
	}

	public void itemStateChanged(ItemEvent evt)
	{
		System.out.println(ObjChoice.getSelectedItem());
	}
}