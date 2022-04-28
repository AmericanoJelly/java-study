package chapter03;

public class ArrayUtil {

	//int 배열을 double 배열로 변환
	public static double[] intToDouble(int[] a) {
		double[] result = new double[a.length];
		for(int i=0; i < a.length; i++) {
			result[i] = a[i];
		}
		return result;
	}

	//double 배열을 int 배열로 변환
	public static int[] doubleToDouble(double[] ds) {
		int[] result = new int[ds.length];
		for(int i=0; i < ds.length; i++) {
			result[i] = (int) Math.abs(ds[i]);
		}
		return result;
	}
	
	//int 배열 두개를 연결한 새로운 배열 리턴
	public static int[] concat(int[] is, int[] is2) {
		int[] result = new int[is.length + is2.length];
		System.arraycopy(is, 0, result, 0, is.length);
		System.arraycopy(is2, 0, result, is.length, is2.length);
		return result;
	}

}
