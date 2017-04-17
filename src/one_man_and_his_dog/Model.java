package one_man_and_his_dog;

import java.util.ArrayList;

public class Model
{
	
	ArrayList<Sheep> sheep = new ArrayList<Sheep>();
	
    Model()
    {
        
    }
    
    ArrayList<Sheep> getSheep()
    {
    	return sheep;
    }
    
    void updateAll()
    {
    	for(Sheep s : sheep)
    		s.update();
    }
}
