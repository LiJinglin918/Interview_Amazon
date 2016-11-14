//     c,d                 g,h
// a,b                  e,f

/*
Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rec1 = (C - A) * (D - B);
        int rec2 = (G - E) * (H - F);
        int cover = 0;
        if(E > C || F > D || A > G || B > H)
            cover = 0;
        else
            cover = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return rec1 + rec2 - cover;
    }
}
