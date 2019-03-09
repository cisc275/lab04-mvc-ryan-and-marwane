/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {
	int direction;
    int xloc = 0;
    int yloc = 0;
    int yMult = 1;
    int xMult = 1;
    int xIncr = 1;
    int yIncr = 1;
    private int frameWidth = 500;
    private int frameHeight = 300;
    private int imageWidth = 165;
    private int imageHeight = 165;
    private final int height, width;
    private int SOUTHEAST = 5;
    private int NORTHWEST = 3;
    private int SOUTHWEST = 6;
    private int NORTHEAST = 2;
	
	public Model(int height, int width, int imageHeight, int imageWidth) {
		this.height = height;
		this.width = width;
		this.imageHeight = imageHeight;
		this.imageWidth = imageWidth;
	}
	
	public void updateLocationAndDirection() {
		//collisions
		xloc*=(xMult*xIncr);
		yloc*=(yMult*yIncr);
		if (xloc + imageWidth >= frameWidth)	{
    		xMult = -1;
    	}
    	if (xloc <= 0)	{
    		xMult = 1;
    	}
    	if (yloc + imageHeight >= frameHeight)	{
    		yMult = -1;
    	}
    	if (yloc <= 0)	{
    		yMult = 1;
    	}
    	if (yMult == 1 && xMult == 1)	{
    		this.direction = SOUTHEAST;
    	} 
    	if (yMult == -1 && xMult == -1)	{
    		this.direction = NORTHWEST;
    	}
    	if (yMult == 1 && xMult == -1)	{
    		this.direction = SOUTHWEST;
    	}
    	if (yMult == -1 && xMult == 1)	{
    		this.direction = NORTHEAST;
    	}
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public int getImageWidth() {
		return imageWidth;
	}
	
	public int getX()	{
		return xloc;
	}
	
	public int getY()	{
		return yloc;
	}

	public int getDirect()	{
		return direction;
	}
}