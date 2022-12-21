//Crear una interface
import java.util.Scanner;

//La interface solo define comportamientos
	//No puede contener constructores 
public interface Producto
{
	//funciones de cabecera.
	public void SetId(int Number);

	public void SetCaducidad(String Label);

	public void CapturaProducto();
	public void ShowInfo();

	public String GetCaducidad();

	public int GetId();
}
