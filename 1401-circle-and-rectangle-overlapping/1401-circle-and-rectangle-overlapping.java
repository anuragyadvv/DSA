class Solution {
    // question 836 is similar somewhat but there we have two rectangles 
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

    //   Intution - find a point on the rectangle which is nearest to the circle and calculate its ditance from the center if the distance is greater than radius then it is non overlapping (because the point on the rectangle we have taken is nearest to circle so all other points will be far as compare to that point )


    // finding nearest point on rectangle (xi, yi)(make diagram to visualize)

    int xi = 0;
     if(x1>xCenter) xi = x1;

     else if(x2<xCenter) xi = x2;

     else  xi = xCenter; // when xCenter is between x1 and x2 

     int yi =0;
     if(y1>yCenter) yi = y1;
     else if(y2<yCenter) yi = y2;
     else  yi = yCenter;  // when yCenter is between y1 and y2 

    //  now calculate distance from center 

     int distX = xCenter-xi;
     int distY = yCenter-yi;

    //  if  distance from center to nearest point is greater than radius means it is non overlapping so return false;
     if(((distX*distX)+(distY*distY)) > (radius*radius)){
        return false;
     }

     return true;
        
    }
}