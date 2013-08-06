package org.monarchnc.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utilities for working with Java Server Faces views.
 */

public final class ViewUtils
{

   public static <T> List<T> asList(Collection<T> collection)
   {

      if (collection == null)
      {
         return null;
      }

      return new ArrayList<T>(collection);
   }

   private ViewUtils()
   {

      // Can never be called
   }
   
   public static String status(Integer i){
	   String result = "not assigned";
	   
	   if(i == 1){
		   result="in progress";
	   } else if (i == 2) {
		   result = "complete";
	   } else if (i == 3 ) {
		   result = "deferred";
	   }
	   
	   
	   return result;
   }
}
