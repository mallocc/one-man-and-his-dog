package one_man_and_his_dog;

public class Sheep
{
    public static int SIZE = 25;
    
    Vec2 pos, vel;
    int acc;
    
    // initialise the sheep
    Sheep(){
         pos = new Vec2();
         vel = new Vec2();
    }
    Sheep(Vec2 pos){
        this.pos = pos;
        this.vel = new Vec2();
    }
    
    // adds the velocity to the position 
    void update(){    	
        vel.scale(Globals.friction);
        pos.add(vel.scaled(Globals.dt));
    }
    
    void checkFlee(Vec2 dogPos){
        Vec2 dog2pos = new Vec2(pos.x,pos.y); 
        dog2pos.sub(dogPos);
        float distance = dog2pos.magnitude();
        
        float scale = 0;
        if (distance < 100)
            scale = Math.abs(50/distance);       
        
        dog2pos.scale(scale);
        vel.add(dog2pos);            
    }
}
