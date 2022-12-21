//estas controlan el tamaño de la fuente.
import java.awt.*;
import java.applet.*;
//Dar el color al fondo.
import java.awt.Color;
import java.awt.event.*;
//estas controlan el estilo visual del JFrame.
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.x500.X500Principal;
//estas controlan los elementos de los botones.
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//Necesaria para la tbxOutput de texto.
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
//desplegar mensajes.
import javax.swing.JOptionPane;

public class Calculadora extends JFrame
{
    JPanel panel_principal = new JPanel();
    JPanel panel_botones = new JPanel();
    JTextField tbxOutput = new JTextField();
    JTextField tbxSalto = new JTextField();

    public Calculadora()
    {
        //Titulo.
        setTitle("Proyecto: Calculadora");
        //Dimenciones
        setSize(750,450);
        //Minimizar deshabilitado o no.
        setResizable(true);
        //Locacion
        setLocationRelativeTo(null);
        //Cerrar el programa.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //creamos la interfaz y llamamos los dos paneles.
        Panel();
        //El JFrame es visible.
        setVisible(true);
        //Para dar un color de cabecera.
        setBackground(Color.red);
    }
 
    private void Panel() 
    {
        panel_principal.setLayout(new BorderLayout());
        //Ubicamos la tbx al tope del Jframe.
        panel_principal.add("North",tbxOutput);
        //Para poder usar propiedades en la tbxOutput
            //------------------------------------------
        panel_principal.add("North",tbxSalto);
        tbxSalto.setText("Proyecto Final: Tópico Selecto (Java). \t\t Desarrollador por: Arroyo Núñez, José Luis");
        tbxSalto.setEditable(false);
        tbxSalto.setBackground(Color.gray);
            //La tbxSalto actua como señuelo del BorderLayout.
            //------------------------------------------
        //Color de fondo para el panel principal
        panel_principal.setBackground(Color.gray);
        //Tamaño del BorderLayout
        panel_principal.setBorder(new EmptyBorder(70, 10, 20, 10));
        //El GRIDLAYOUT RECIBE COMO PARAMETROS: FILAS,COLUMNAS, ESPACIADO ENTRE FILAS, ESPACIADO ENTRE COLUMNAS
        panel_botones.setLayout(new GridLayout(5,5,8,8));
        //le damos color al panel de los botones.
        panel_botones.setBackground(Color.black);

        //Elemento de la caja de texto.
            //Tamaño
        tbxOutput.setBounds(new Rectangle(7, 20, 735, 45));
            //Fuente.
        Font fuente = new Font("Dialog", Font.ROMAN_BASELINE, 22);
        tbxOutput.setFont(fuente);
            //Edicion
        tbxOutput.setEditable(false);
            //Alineacion
        tbxOutput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            //borde
        tbxOutput.setBorder(new EmptyBorder(10, 10, 30, 10));
            //Color de Borde
        tbxOutput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
 
        //Elementos relacionados a los botones.
        //Mandamos a llamar a los botones.
        Botones();
        //Centramos los botones 
        panel_principal.add("Center", panel_botones);
        //agregamos el panel principal.
        getContentPane().add(panel_principal);     
   }
    
    public static void main(String args[])
    {
        //CREAMOS UN NUEVO OBJETO Calculadora
        new Calculadora();
    }

    JButton boton[];
    double Num1=0, Num2=0;  //Inicializamos en cero.
    String Operacion="";
    boolean nueva=true;

    private void Botones() 
    {
        //INICIALIZAMOS EL ARREGLO DE BOTONES
        boton = new JButton[25];
        //INICIALIZAMOS LOS BOTONES
        boton[0]=new JButton("Clear");
        boton[1]=new JButton("Sqrt");
        boton[2]=new JButton("1/x");
        boton[3]=new JButton("%");
        boton[4]=new JButton("e^x");
        boton[5]=new JButton("7");
        boton[6]=new JButton("8");
        boton[7]=new JButton("9");
        boton[8]=new JButton("/");
        boton[9]=new JButton("x^n");
        boton[10]=new JButton("4");
        boton[11]=new JButton("5");
        boton[12]=new JButton("6");
        boton[13]=new JButton("*");
        boton[14]=new JButton("e");
        boton[15]=new JButton("1");
        boton[16]=new JButton("2");
        boton[17]=new JButton("3");
        boton[18]=new JButton("-");
        boton[19]=new JButton("+/-");
        boton[20]=new JButton("0");
        boton[21]=new JButton(".");
        boton[22]=new JButton("=");
        boton[23]=new JButton("+");
        boton[24]=new JButton("Pi");
        
        //Agregamos los botones al panel.
        for(int i=0; i<25; i++)
        {
            panel_botones.add(boton[i]);
        }

        //Eventos de los numeros:
        boton[20].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"0");
            }
        });

        boton[15].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"1");
            }
        });

        boton[16].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"2");
            }
        });

        boton[17].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"3");
            }
        });

        boton[10].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"4");
            }
        });

        boton[11].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"5");
            }
        });

        boton[12].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"6");
            }
        });

        boton[5].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"7");
            }
        });

        boton[6].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"8");
            }
        });

        boton[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+"9");
            }
        });

        //Este es para el punto decimal.
        boton[21].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText(tbxOutput.getText()+".");
            }
        });

        //Aqui empiezan las operaciones basicas.
        boton[23].addActionListener(new ActionListener() //SUMA.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(Num1!=0)
                    {
                        Num1=Num1+Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1=Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="suma";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error interno, no se puede completar la operación.","Alerta",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[18].addActionListener(new ActionListener() //RESTA.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(Num1!=0)
                    {
                        Num1=Num1-Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1=Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="Resta";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error interno, no se puede completar la operación.","Alerta",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[13].addActionListener(new ActionListener() //MULTIPLIACION.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(Num1!=0)
                    {
                        Num1=Num1*Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1=Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="multiplicacion";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error interno, no se puede completar la operación.","Alerta",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[8].addActionListener(new ActionListener() //DIVISION.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(Num1!=0)
                    {
                        Num1=Num1/Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1=Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="division";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error interno, no se puede completar la operación.","Alerta",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[3].addActionListener(new ActionListener() //PORCENTAJE
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(Num1!=0)
                    {
                        Num1=Num1%Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1=Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="porcentaje";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error interno, no se puede completar la operación.","Alerta",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        //Aqui comienzan las operaciones de un solo parametro.
        boton[1].addActionListener(new ActionListener() //RAIZ CUADRADA.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(tbxOutput.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un numero para usar esta función.","Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if(Num1!=0)
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="Sqrt";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[2].addActionListener(new ActionListener() //uno sobre x
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(tbxOutput.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un numero para usar esta función.","Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if(Num1!=0)
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="UnoEntreX";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[4].addActionListener(new ActionListener() //e A LA X.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(tbxOutput.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un numero para usar esta función.","Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if(Num1!=0)
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="eX";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[9].addActionListener(new ActionListener() //X a la N.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(tbxOutput.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un numero para usar esta función.","Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if(Num1!=0)
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="xN";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[14].addActionListener(new ActionListener() //EULER
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    Double Resultado = Math.E;

                    if(tbxOutput.getText().length()==0)
                    {
                        tbxOutput.setText(Resultado.toString());
                    }
                    
                    Operacion="euler";
                    tbxOutput.setText(Resultado.toString());
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[19].addActionListener(new ActionListener() //Cambio de signo.
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    if(tbxOutput.getText().length()==0)
                    {
                        JOptionPane.showMessageDialog(null, "Debe de ingresar un numero para usar esta función.","Alerta",JOptionPane.WARNING_MESSAGE);
                    }

                    if(Num1!=0)
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    else
                    {
                        Num1 = Double.parseDouble(tbxOutput.getText());
                    }
                    Operacion="Cambio";
                    tbxOutput.setText("");
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        boton[24].addActionListener(new ActionListener() //PI
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    Double Resultado = Math.PI;

                    if(tbxOutput.getText().length()==0)
                    {
                        tbxOutput.setText(Resultado.toString());
                    }
                    
                    Operacion="Pi";
                    tbxOutput.setText(Resultado.toString());
                }
                catch(Exception err)
                {
                    JOptionPane.showMessageDialog(null, "Error lógico, dejo vacia la caja de texto.","No hay datos.",JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //El boton IGUAl controla lo que hay que hacer en cuanto a las operaciones.
        boton[22].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    Num2=Double.parseDouble(tbxOutput.getText());
                }
                catch(Exception err)
                {
                    //No es necesario codigo aqui.
                }

                if(Operacion.equals("suma"))
                {
                    double Resultado = Num1+Num2;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("Resta"))
                {
                    double Resultado = Num1-Num2;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("multiplicacion"))
                {
                    double Resultado = Num1*Num2;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("division"))
                {
                    double Resultado = Num1/Num2;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("porcentaje"))
                {
                    double Resultado = (Num1*Num2) / 100;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("Sqrt"))
                {
                    double Resultado = Math.sqrt(Num1);
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                else if(Operacion.equals("UnoEntreX"))
                {
                    double Resultado = (1 / Num1);
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                else if(Operacion.equals("eX"))
                {
                    double Resultado = Math.exp(Num1);
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                else if(Operacion.equals("xN"))
                {
                    double Resultado = Math.pow(Num1, Num2);
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=Num2=0;
                    Operacion="";
                }
                else if(Operacion.equals("euler"))
                {
                    double Resultado = Math.E * Num1;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                else if(Operacion.equals("Cambio"))
                {
                    double Resultado = (-1)*Num1;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                else if(Operacion.equals("Pi"))
                {
                    double Resultado= Math.PI * Num1;
                    tbxOutput.setText(String.valueOf(Resultado));
                    Num1=0;
                    Operacion="";
                }
                nueva=true;
            }
        });

        //Borrado.
        boton[0].addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                tbxOutput.setText("");
                Num1=Num2=0;
                Operacion="";
            }
        });
    }   
}