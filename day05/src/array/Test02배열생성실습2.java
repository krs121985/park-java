package array;

public class Test02배열생성실습2 {
	public static void main(String[] args) {
//		[1] 30, 50, 20, 10, 40 = int 5개
		int[] a = new int[] {30, 50, 20, 10, 40};
		for(int i=0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
//		[2] 10f, 1.25f, 3.1f, 4.6f = float 4개
		float[] b = new float[] {10f, 1.25f, 3.1f, 4.6f};
		for(int i=0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
//		[3] 1.234, 3.14, 1.5, 6.77, 8.25 = double 5개
		double[] c = new double[] {1.234, 3.14, 1.5, 6.77, 8.25};
		for(int i=0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
//		[4] 아반떼, 소나타, 니로, 말리부, 엑소 = String 5개
		String[] d = new String[] {"아반떼", "소나타", "니로", "말리부", "엑소"};
		for(int i=0; i < d.length; i++) {
			System.out.println(d[i]);
		}
		
	}
}
