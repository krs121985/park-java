package array;

public class Test02배열생성실습 {
	public static void main(String[] args) {
//		[1] 30, 50, 20, 10, 40 = int 5개
		int[] a = new int[] {30, 50, 20, 10, 40};
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		
//		[2] 10f, 1.25f, 3.1f, 4.6f = float 4개
		float[] b = new float[] {10f, 1.25f, 3.1f, 4.6f};
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);
		System.out.println(b[3]);
		
//		[3] 1.234, 3.14, 1.5, 6.77, 8.25 = double 5개
		double[] c = new double[] {1.234, 3.14, 1.5, 6.77, 8.25};
		System.out.println(c[0]);
		System.out.println(c[1]);
		System.out.println(c[2]);
		System.out.println(c[3]);
		System.out.println(c[4]);
		
//		[4] 아반떼, 소나타, 니로, 말리부, 엑소 = String 5개
		String[] d = new String[] {"아반떼", "소나타", "니로", "말리부", "엑소"};
		System.out.println(d[0]);
		System.out.println(d[1]);
		System.out.println(d[2]);
		System.out.println(d[3]);
		System.out.println(d[4]);
		
	}
}
