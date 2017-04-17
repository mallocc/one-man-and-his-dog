package one_man_and_his_dog;

public class Vec2
{
	public float x = 0, y = 0;
	
	Vec2()
	{
	}
	
	Vec2(float _x, float _y)
	{
		x = _x;
		y = _y;
	}
	
	float magnitude()
	{
		return (float) Math.sqrt(x*x + y*y);
	}
	
	void add(Vec2 a)
	{
		x += a.x;
		y += a.y;
	}
	
	void sub(Vec2 a)
	{
		x -= a.x;
		y -= a.y;
	}
        
        void scale(float a){
            x *= a;
            y *= a;
        }
}
