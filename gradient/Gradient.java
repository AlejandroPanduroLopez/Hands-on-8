/*Alejandro Panduro López 
Hands-on: 8
*/
package gradient;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
public class Gradient extends Agent{
    @Override
    public void setup(){
     System.out.println("Agente ejecutando");
            //Declaración 
        int x[]={23,26,30,34,43,48,52,57,58};
        int y[]={651,762,856,1063,1190,1298,1421,1440,1518};
        int n=9;
        double b0=0,b1=0,alpha=0.003,error = 0;
        
        //Declaración de Objetos
        Beta0 beta0 = new Beta0();
        Beta1 beta1 = new Beta1();
        Error err = new Error();
        
        //Declaración del Error
         error = err.Error1(x, y, b0, b1);
         double error2=error;
         //Variables Aux
         double b0aux=0,b1aux=0;
         
         //Ciclo que realiza el nuevo valor de B0 y B1
         while(error<=error2){
             b0aux=b0; b1aux=b1;
              b0 = b0-(alpha*(beta0.Cero(n, x, y, b0, b1)));
              b1 = b1-(alpha*(beta1.Uno(n, x, y, b0, b1)));
              error2=error;
              error = err.Error1(x, y, b0, b1);      
        }
         
         //Se muestra el valor de B0 y B1
         System.out.println("Beta 0: "+b0);
         System.out.println("Beta 1: "+b1);
         addBehaviour(new MyOneshotBehaviour());
         System.out.println("Agente Eliminado");
        
        
    }
        
    private class MyOneshotBehaviour extends OneShotBehaviour {

        @Override
        public void action() {
            
        }
        
        @Override
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
    }
}
