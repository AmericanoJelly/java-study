package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		//int[] a1 = {10, 20, 30, 40};
		//double[] d1 = ArrayUtil.intToDouble(a1);
		
		double[] d1 = ArrayUtil.intToDouble(new int[] {10, 20, 30, 40});
		System.out.print(Arrays.toString(d1));
		//for each문,  for( 각 요소 값 : 배열이나 컨테이너 값 )
		/* for(double d : d1) {
			System.out.print(d+" ");
		} */
	
		int[] a1 = ArrayUtil.doubleToDouble(new double[] {10.1, 20.2, 30.3, 40.4});
		System.out.print(Arrays.toString(a1));
		
		int[] a2 = ArrayUtil.concat(new int[] {1,2,3},new int[] {4,5,6});
		System.out.print(Arrays.toString(a2));
	}
}
