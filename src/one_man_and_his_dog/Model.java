package one_man_and_his_dog;

import java.util.ArrayList;

public class Model
{
	
    ArrayList<Sheep> sheep = new ArrayList<Sheep>();
	
    Model()
    {
        for (int i =0; i <10; ++i){
            sheep.add(new Sheep(new Vec2(
                    (float)Math.random() * View.WIDTH, 
                    (float)Math.random() * View.HEIGHT)));
        }
    }
    
    ArrayList<Sheep> getSheep()
    {
    	return sheep;
    }
    
    void updateAll()
    {
        
        
    	for(Sheep s : sheep){
            s.checkFlee(Globals.mousePos);                 
            s.update();
        }
    		
    }
}
