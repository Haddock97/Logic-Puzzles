import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.List;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    public static ArrayList<Integer> freqQuery(ArrayList<int[]> queries) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        int op = 0;
        int key = 0;
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>(); 

        for (int i = 0; i < queries.size(); i++) {
            int[] temp = new int[2];
            temp = queries.get(i);
            op = temp[0];
            key = temp[1];

            if (op == 1) {
                if (freq.containsKey(key))
                    freq.put(key, freq.get(key) + 1);
                else 
                    freq.put(key, 1);
            } else if (op == 2 && freq.containsKey(key)) {
                freq.put(key, freq.get(key) - 1);
                freq.remove(key, 0);
            } else if (op == 3) {
                if(freq.containsValue(key))
                    output.add(1);
                else 
                    output.add(0);
            }
        }
        return output;
    }
	
	public static void main(String[] args) {
		ArrayList<int[]> list = new ArrayList<int[]>();
		int[] temp1 = {1, 5};
		list.add(temp1);
		int[] temp2 = {1, 6};
		list.add(temp2);
		int[] temp3 = {3, 2};
		list.add(temp3);
		int[] temp4 = {1, 10};
		list.add(temp4);
		int[] temp5 = {1, 10};
		list.add(temp5);
		int[] temp6 = {1, 6};
		list.add(temp6);
		int[] temp7 = {2, 5};
		list.add(temp7);
		int[] temp8 = {3, 2};
		list.add(temp8);
		System.out.print("\n\nSample: \n");
		//System.out.print("\n1 5\n1 6\n3 2\n1 10\n1 10\n1 6\n2 5\n3 2");
		for (int[] arr : list)
			System.out.println(arr[0] + " " + arr[1]);
		System.out.print("\nOur result should be a list: 0 1");
		
		ArrayList<Integer> solution = freqQuery(list);
		System.out.print("\nOur program output: ");
		for (int a : solution)
			System.out.print(a + " ");
	
	}
}