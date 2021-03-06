import chen.cmap;

/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                https://algs4.cs.princeton.edu/22mergesort/words3.txt
 *   
 *  Sorts a sequence of strings from standard input using mergesort.
 *   
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *    
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *  
 *  % java Merge < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *  
 ******************************************************************************/



/**
 *  The {@code Merge} class provides static methods for sorting an
 *  array using a top-down, recursive version of <em>mergesort</em>.
 *  <p>
 *  This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 *  to sort any array of length <em>n</em> (assuming comparisons
 *  take constant time). It makes between
 *  ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 *  ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 *  <p>
 *  This sorting algorithm is stable.
 *  It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *  For an optimized version, see {@link MergeX}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Merge {

    // This class should not be instantiated.
    private Merge() { }

    public static void show_all(Comparable[] a)
    {
    	int n = a.length;
    	try {
 			Thread.currentThread().sleep(1000) ;
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	  StdDraw.clear();
    	  double y = 0.0;
//    	  double width = 0.0;
          double high = 0.0;
          
    	  for (int num = 0; num <  n; ++num)
          {
              double x = 1.0 * num /n +0.05;
              
              
            	  y = 0.5; 
            	  high =   Integer.valueOf(cmap.get_value((String) a[num]))  / 500.000; 
            	  StdDraw.setPenColor(StdDraw.GREEN); //设置成红色
             
               
              
   
              double width = 0.5 / (n +1) ;  
             
              System.out.println("x =" + x + ", y =" + y + ",width =" + width + ", high=" + high);
              StdDraw.filledRectangle_bottom(x, y, width, high);
              StdDraw.setPenColor(StdDraw.YELLOW);
        
             
             StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) a[num]));
             
               
             
          }
          StdDraw.show();
    	
    }
    public static void show(Comparable[] a, Comparable[] aux, int lo, int mid, int hi, int show_num, int lox_ , int mid_y)
    {
    	System.out.println("lo =" + lo + ",mid =" + mid + ",hi =" + hi + ", show_num=" + show_num );
    	int n = a.length;
    	
    	  StdDraw.clear();
    	  double y = 0.0;
          double high = 0.0;
          boolean show = false;
          int temp_show_num = show_num;
    	  for (int num = 0; num <  n; ++num)
          {
              double x = 1.0 * num /n +0.05;
              show = false;
              // 1. 没有参与合并数
              // 2. 参与合并的数 
              // 2.1  参与合并的数中在已经排序到mid左边了
              // 2.2  参与合并的数中已经在排序到mid右边了
              // 2.4  参与合并的数在临时数组中
              if (num < lo || num > hi)
              {
            	  StdDraw.setPenColor(StdDraw.RED); //设置成红色
            	  //设置y  , height
            	  y = 0.5; 
            	  high =   Integer.valueOf(cmap.get_value((String) a[num]))  / 500.000; 
            	  show = true;
              }
              else 
              {
            	  if (temp_show_num > 0)
            	  {
            		  StdDraw.setPenColor(StdDraw.GREEN); 
//                	  //设置y  , height
                	  y = 0.5; 
                	  high =   Integer.valueOf(cmap.get_value((String) a[num]))  / 500.000; 
                	  System.out.println("show_num = num " + num + ", value ="+ cmap.get_value((String) a[num]));
                	  show = true;
                	  --temp_show_num;
            	  }
              }
              double width = 0.5 / (n +1) ;  
       
             if (show)
             {
            	// System.out.println("x =" + x + ", y =" + y + ",width =" + width + ", high=" + high);
                 StdDraw.filledRectangle_bottom(x, y, width, high);
                 StdDraw.setPenColor(StdDraw.YELLOW);
                 StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) a[num]));
             }
 
          }
    	  temp_show_num = show_num;
//    	  System.out.println("temp_show_num = temp_show_num " + temp_show_num );
//    	 
    	  
//    	for (int down = mid;mid>0&& (lox_ +down) > mid; --down)
//    	{
//    		if (aux[down] == null)
//    		{
//    			 System.out.println("down = null, down =" + down );
//    			break;
//    		}
//    		 System.out.println("lox_ = " + lox_  + ", down =" + down + ", str =" + aux[lo +down]);
//			  double x = 1.0 * down /n +0.05;
//    		   y = 0.0;
//    		   double width = 0.5 / (n +1) ;  
//    		   StdDraw.setPenColor(StdDraw.BLUE);
//        	  high =   Integer.valueOf(cmap.get_value((String) aux[down]))  / 500.000; 
//        	  System.out.println("blue = down " + down + ", value ="+ cmap.get_value((String) aux[down]));
//        	  StdDraw.filledRectangle_bottom(x, y, width, high);
//              StdDraw.setPenColor(StdDraw.YELLOW);
//              StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) aux[down]));
//		  }
////    		 
////    	  
////    	
//		  for (int down = mid_y; (hi-mid > 0)&&down < (hi-mid) ; ++down)
//		  {
//			  if (aux[lo +mid+down] == null)
//	    		{
//				  System.out.println("down = null, lo +mid+down+1 =" + lo +mid+down+1 );
//	    			break;
//	    		}
//			  double x = 1.0 * (lo +mid+down) /n +0.05;
//    		   y = 0.0;
//    		   double width = 0.5 / (n +1) ;
//    		   StdDraw.setPenColor(StdDraw.BLUE);
//        	  high =   Integer.valueOf(cmap.get_value((String) aux[lo+mid+down]))  / 500.000; 
//        	  System.out.println("down = lo+down " + down + ", value ="+ cmap.get_value((String) aux[lo+mid+down]));
//        	  StdDraw.filledRectangle_bottom(x, y, width, high);
//              StdDraw.setPenColor(StdDraw.YELLOW);
//              StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) aux[lo+mid+down]));
//		  }
		  for (int down = lo; down <= hi ; ++down)
		  {
			  if (aux[down] == null)
	    		{
				  System.out.println("down = null,down =" + down );
	    			break;
	    		}
			if (down < lox_)
			{
				 double x = 1.0 * (down) /n +0.05;
	    		   y = 0.0;
	    		   double width = 0.5 / (n +1) ;
	    		   StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	        	  high =   Integer.valueOf(cmap.get_value((String) aux[down]))  / 500.000; 
	        	  System.out.println("down = lo+down " + down + ", value ="+ cmap.get_value((String) aux[down]));
	        	  StdDraw.filledRectangle_bottom(x, y, width, high);
	              StdDraw.setPenColor(StdDraw.YELLOW);
	              StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) aux[down]));
			}
			else if (mid < down && down < mid_y )
			{
				 double x = 1.0 * (down) /n +0.05;
	    		   y = 0.0;
	    		   double width = 0.5 / (n +1) ;
	    		   StdDraw.setPenColor(StdDraw.MAGENTA);
	        	  high =   Integer.valueOf(cmap.get_value((String) aux[down]))  / 500.000; 
	        	  System.out.println("down = lo+down " + down + ", value ="+ cmap.get_value((String) aux[down]));
	        	  StdDraw.filledRectangle_bottom(x, y, width, high);
	              StdDraw.setPenColor(StdDraw.YELLOW);
	              StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) aux[down]));
			}
			else 
			{
				  double x = 1.0 * (down) /n +0.05;
	    		   y = 0.0;
	    		   double width = 0.5 / (n +1) ;
	    		   StdDraw.setPenColor(StdDraw.BLUE);
	        	  high =   Integer.valueOf(cmap.get_value((String) aux[down]))  / 500.000; 
	        	  System.out.println("down = lo+down " + down + ", value ="+ cmap.get_value((String) aux[down]));
	        	  StdDraw.filledRectangle_bottom(x, y, width, high);
	              StdDraw.setPenColor(StdDraw.YELLOW);
	              StdDraw.text(x, ( y+(high/2)<=0.1)? (y+0.1): (y+(high/2)), cmap.get_value((String) aux[down]));
			}
		  }
          StdDraw.show();
          try {
   			Thread.currentThread().sleep(1000) ;
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
    	
    }
    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) 
    {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // copy to aux[]
        for (int k = lo; k <= hi; k++) 
        {
            aux[k] = a[k]; 
        }

        //show(a, aux, lo, mid, hi, 0);
        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
        	 show(a, aux, lo, mid, hi,    (j -mid -1)+(  i-lo), i, j);
        	//判断i> mid 和 j > hi是有可能  
            if      (i > mid)              
            {
            	a[k] = aux[j++];
            }
            else if (j > hi)               
            {
            	a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) 
            {
            	a[k] = aux[j++];
            }
            else                           
            {
            	a[k] = aux[i++];
            }
           // show(a, aux, lo, mid, hi, i-lo, j -mid -1);
        }
        show(a, aux, lo, mid, hi,  (j -mid -1)+(  i-lo), i, j);
        // postcondition: a[lo .. hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo)
        {
        	 return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
        
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
       
        assert isSorted(a);
    }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


   /***************************************************************************
    *  Index mergesort.
    ***************************************************************************/
    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, int[] index, int[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = index[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                    index[k] = aux[j++];
            else if (j > hi)                     index[k] = aux[i++];
            else if (less(a[aux[j]], a[aux[i]])) index[k] = aux[j++];
            else                                 index[k] = aux[i++];
        }
    }

    /**
     * Returns a permutation that gives the elements in the array in ascending order.
     * @param a the array
     * @return a permutation {@code p[]} such that {@code a[p[0]]}, {@code a[p[1]]},
     *    ..., {@code a[p[N-1]]} are in ascending order
     */
    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        int[] aux = new int[n];
        sort(a, index, aux, 0, n-1);
        return index;
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, int[] index, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, index, aux, lo, mid);
        sort(a, index, aux, mid + 1, hi);
        merge(a, index, aux, lo, mid, hi);
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(cmap.get_value((String) a[i] ) + "   ");
        }
        StdOut.println();
    }

    /**
     * Reads in a sequence of strings from standard input; mergesorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        String[] a = StdIn.readAllStrings();
    	 String[] a = new String[10] ;
    	 a[0] = "a";
       	 a[1] = "M";
       	 a[2] = "W";
       	 a[3] = "I";
       	 a[4] = "!";
       	 a[5] = "z";
       	 a[6] = "Q";
       	 a[7] = "B";
       	 a[8] = "6";
       	 a[9] = "&";
       	 cmap.init();
    	 show_all(a);
       	 show(a);
        Merge.sort(a);
        show_all(a);
        show(a);
    }
}

/******************************************************************************
 *  Copyright 2002-2020, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/
