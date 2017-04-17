package one_man_and_his_dog;

public class Sheep
{
    Vec2 pos, vel;
    int acc;
    
    // initialise the sheep
    Sheep(){
        Vec2 pos = new Vec2();
        Vec2 vel = new Vec2();
    }
    
    // adds the velocity to the position 
    void update(){
        pos.x += vel.x;
        pos.y += vel.y;
    }
    
    void flee(Vec2 dogPos){
        Vec2 dog2pos = new Vec2(pos.x,pos.y); 
        dog2pos.sub(dogPos);
        float distance = dog2pos.magnitude();
        
        if (distance < 300){
            if (acc < 50){
                acc += 10;     
            }
            else if(acc < 100){
                acc += 7;
            }
            else if(acc<300){
                acc += 3;        
            }
        }
        else{
            acc -= 5;
        }
        float scale = Math.abs(acc/distance)/100;
        
        dog2pos.scale(scale);
        vel.add(dog2pos);            
    }
}
