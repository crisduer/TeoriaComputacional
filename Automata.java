package automata;

public class Automata {
    //Cristian Rivera Bravo 160460 Automata que cumple la siguiente expresion regular b*(a+b)* en AFD
    int cont;
    boolean aceptada;//para guardar los caratcteres y los va ir separando
    char [] car;

    public static void main(String[]args){
        Automata aut= new Automata();
        String cadena = "b";
        aut.car=cadena.toCharArray();
        aut.inicio();
    }
    public void inicio (){ //metodo/
        cont = 0;
        aceptada = false;
        q0();/*irnos al codigo 0 */
    }
    public void q0(){
        System.out.println("En q0 cadena aceptada");//imprimimos y decimos que estamos en q0 y si la cadena es aceptada ya que es valida con solo un caracter
        if(cont < car.length){//validar el taaño del arreglo/
            if(car[cont]=='b'){//el arreglo car en el contador 0 lo vamos a comparar si es = b
                cont++;//incremento del contador
                q0();//si valida correcta la cadena regresa al mismo estado para volver a validar la siguiente cadena
            }else if (car[cont]=='a'){//si es una a se mueve al siguiente metodo para continuar validando la cadena
                cont++;//incremento del contador
                q1();//nos mueve a otro estado para validar los siguientes caracteres de la cadena
            }else if(car[cont]!='a' || car[cont]!='b'){//Valida si los aracteres son distintos a los permitidos
                qError();//nos manda al estado de error ya que no pertenece la cadena al Lenguage 
            }
        }
    }     
    public void q1(){
        System.out.println("En q2 cadena aceptada");//cadena aceptada
        if(cont < car.length){//mide el tamaño del arreglo
            if(car[cont]=='a' || car[cont]=='b'){//se valida si la cadena es a o b
                cont++;//incrementa el contador
                q1();//si el caracter esta dentro del lenguaje y cumple con la expresion regresa al mismo estado para seguir validando
            }else if (car[cont]!='a' || car[cont]!='b'){//Valida si los aracteres son distintos a los permitidos
                qError();//nos manda al estado de error ya que no pertenece la cadena al Lenguage 
            }
        }
     }
     
    public void qError(){
        System.out.println("Error");
        aceptada = false;//restablecemos nuestra bandera
        return;//regresamos
    }
}