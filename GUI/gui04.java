import java.awt.*;
import java.awt.event.*;

class gui03
{
    public static void main(String args[]){
    GUI gui_1=new GUI();
    }
}//Fin de la clase principal

class GUI{
    //Atributos
    Frame mi_frame;

    public GUI(){
        //Definir componentes
        Label etiqueta1=new Label("Etiqueta 1");
        Button boton1=new Button("Recuperar texto de textarea");
        Button boton2=new Button("Usar seleccion de checkbox");
        TextField cuadro_texto1=new TextField("0");
        TextField cuadro_texto2=new TextField("0");
        TextField cuadro_texto3=new TextField("Resultado");
        TextArea recuadro_texto1=new TextArea();
        CheckboxGroup checkbox_grupo1=new CheckboxGroup();
        Checkbox caja1=new Checkbox("opcion 1", checkbox_grupo1, true);
        Checkbox caja2=new Checkbox("opcion 2", checkbox_grupo1, false);
        Checkbox caja3=new Checkbox("opcion 3", checkbox_grupo1, true);
        /*Lista*/
        Choice seleccion=new Choice();
        seleccion.add("Item 1");
        seleccion.add("Item 2");
        seleccion.add("Item 3");
        seleccion.add("Item n");

        List listado=new List();
        for(int i=1; i<=10;i++){
            listado.add("Elemento "+i);
        }

        listado.select(0);

        //Crear el contenedor
        mi_frame=new Frame("Uso de componentes basicos");
        mi_frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));

        //Anadir los componentes al Frame
        mi_frame.add(etiqueta1);
        mi_frame.add(boton1);
        mi_frame.add(boton2);
        mi_frame.add(cuadro_texto1);
        mi_frame.add(cuadro_texto2);
        mi_frame.add(cuadro_texto3);
        mi_frame.add(recuadro_texto1);
        mi_frame.add(caja1);
        mi_frame.add(caja2);
        mi_frame.add(caja3);
        mi_frame.add(seleccion);
        mi_frame.add(listado);
        //Configuraciones adicionales del Frame
        mi_frame.setSize(800,400);
        mi_frame.setVisible(true);

        //Asignaar los metodos para atender los eventos necesarios
        /*checkbox_grupo1.addActionListener(
            new EjemploActionListener(checkbox_grupo1)
        );*/
        /*
        cuadro_texto1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    //System.out.println("Evento sobre cuadro_texto1");
                    int a,b,c;
                    a=Integer.valueOf(cuadro_texto1.getText());
                    b=Integer.valueOf(cuadro_texto2.getText());
                    c=a+b;
                    cuadro_texto3.setText(String.valueOf(c));
                }
            }
        );
        */
        recuadro_texto1.addTextListener(new EventoEnTextArea(recuadro_texto1));
        
        cuadro_texto1.addActionListener(new EventoEnterEnCuadroTexto(cuadro_texto1, cuadro_texto2, cuadro_texto3)
        );
        
        cuadro_texto2.addActionListener(new EventoEnterEnCuadroTexto(cuadro_texto1, cuadro_texto2, cuadro_texto3)
        );

        listado.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    System.out.println(listado.getSelectedItem());
                }
            }
        );

        seleccion.addItemListener(
            new EjemploItemListener(seleccion)
        );
        boton1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    System.out.println(recuadro_texto1.getText());
                    etiqueta1.setText(listado.getSelectedItem());
                }
            }
        );
        
        boton2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    //mi_frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    //etiqueta1.setText(seleccion.getSelectedItem());
                    System.out.println(checkbox_grupo1.getSelectedCheckbox()+"\n"+checkbox_grupo1.getSelectedCheckbox().getName()+"\n"+checkbox_grupo1.getSelectedCheckbox().getLabel());
                }
            }
        );


        //Asignar el metodo para atender el boton de cerrar ventana
        mi_frame.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent evt){
                    System.exit(0);
                }
        }
        );
    }//Fin del constructor GUI

    //Metodos

}//Fin de la clase GUI

class EventoEnTextArea implements TextListener{
    TextArea obj_text_area;

    public EventoEnTextArea(TextArea ref_obj_text_area){
        obj_text_area=ref_obj_text_area;
    }

    public void textValueChanged(TextEvent evt){
        System.out.println("Se ha modificado el texto en el recuadro de texto");
    }
}

class EventoEnterEnCuadroTexto implements ActionListener{
    TextField obj_ct1;
    TextField obj_ct2;
    TextField obj_ct3;

    public EventoEnterEnCuadroTexto(TextField ref_ct1, TextField ref_ct2,TextField ref_ct3){
        obj_ct1=ref_ct1;
        obj_ct2=ref_ct2;
        obj_ct3=ref_ct3;
    }

    public void actionPerformed(ActionEvent evt){
        //System.out.println("Evento sobre cuadro_texto2");
        int a,b,c;
        a=Integer.valueOf(obj_ct1.getText());
        b=Integer.valueOf(obj_ct2.getText());
        c=a+b;
        obj_ct3.setText(String.valueOf(c));
    }
}

class EjemploActionListener implements ActionListener{
    CheckboxGroup obj_checkbox_grupo;

    public EjemploActionListener(CheckboxGroup ref_a_obj_checkboc_grupo){
       obj_checkbox_grupo=ref_a_obj_checkboc_grupo; 
    }
    public void actionPerformed(ActionEvent evt){
        System.out.println(obj_checkbox_grupo.getSelectedCheckbox().getName()+" "+obj_checkbox_grupo.getSelectedCheckbox()+" "+obj_checkbox_grupo.getSelectedCheckbox().getLabel());
    }
}//Fin de la clase EjemploActionListener

class EjemploItemListener implements ItemListener{
    Choice obj_choice;

    public EjemploItemListener(Choice choice){
        obj_choice=choice;
    }

    public void itemStateChanged(ItemEvent evt){
        System.out.println(obj_choice.getSelectedItem());
    }
}//Fin de la clase EjemploItemListener