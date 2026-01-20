import java.util.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		
		int[][] matrix = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				matrix[i][j] = sc.nextInt();
		
		//바깥 테두리부터 회전
		for(int layer = 0; layer < Math.min(n, m) / 2; layer++) {
			List<Integer> list = new ArrayList<>();
			
			int top = layer;
			int bottom = n - 1 - layer;
			int left = layer;
			int right = m - 1 - layer;
			
			//왼쪽 줄
			for(int i = top; i < bottom; i++)
				list.add(matrix[i][left]);
			//아래 줄
			for(int i = left; i < right; i++)
				list.add(matrix[bottom][i]);
			//오른쪽 줄
			for(int i = bottom; i > top; i--)
				list.add(matrix[i][right]);
			//윗줄
			for(int i = right; i > left; i--)
				list.add(matrix[top][i]);
			
			//회전
			Collections.rotate(list, r % list.size());
			
			//다시 행렬에 채우기
			int idx = 0;
			for(int i = top; i < bottom; i++)
				matrix[i][left] = list.get(idx++);
			for(int i = left; i < right; i++)
				matrix[bottom][i] = list.get(idx++);
			for(int i = bottom; i > top; i--)
				matrix[i][right] = list.get(idx++);
			for(int i = right; i > left; i--)
				matrix[top][i] = list.get(idx++);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
}