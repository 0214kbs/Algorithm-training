public class Main
{
	static int n, m;
	static int canLie = 0;
	static int[] parent;
	static int[][] parties;
	
	public static void main(String[] args) throws Exception
	{
		n = read(); m = read();
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		int t = read();
		
		if(t == 0)
		{
			System.out.print(m);
			return;
		}
		
		int truth = read();
		while(t-- > 1)
			union(truth, read());
		
		parties = new int[m][];
		for(int i=0; i<m; i++)
		{
			int p = read();
			int[] party = new int[p];
			
			party[0] = read();
			for(int j=1; j<p; j++)
			{
				party[j] = read();
				union(party[0], party[j]);
			}
			
			parties[i] = party;
		}
		
		label : for(int[] party : parties)
		{
			for(int p : party)
				if(find(truth) == find(p))
					continue label;
			
			canLie++;
		}
		
		System.out.print(canLie);
	}
	
	private static int find(int x)
	{
		if (x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y)
	{
		int px = find(x);
		int py = find(y);
		
		if (px == py) {
			return;
		}
		
		parent[py] = px;
	}
	
    private static int read() throws Exception
    {
	    int c, n = System.in.read() & 15;
	    while ((c = System.in.read()) > 32)
	    	n = (n << 3) + (n << 1) + (c & 15);
	    return n;
	}
}

