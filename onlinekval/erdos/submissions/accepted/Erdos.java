import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.OutputStream;

public class Erdos {

	static Map<String, Integer> strToId = new HashMap<String, Integer>();
	static Map<Integer, String> idToStr = new HashMap<Integer, String>();
	static Map<String, Integer> strToErdos = new TreeMap<String, Integer>();

	public static int getId(String writer){
		if(strToId.get(writer) == null){
			idToStr.put(strToId.size(), writer);
			strToId.put(writer, strToId.size());
		}
		return strToId.get(writer);
	}

	static Set<Integer>[] adjs = new Set[5000];

	public static void main(String... args){
		getId("ERDOS");
		Kattio sc = new Kattio(System.in);
		int n = sc.getInt(), m = sc.getInt();
		for(int i = 0; i<n; i++) adjs[i] = new HashSet<Integer>();
		for(int i = 0; i<m; i++){
			int nums = sc.getInt();
			int[] writers = new int[nums];
			for(int j = 0; j<nums; j++){
				writers[j] = getId(sc.getWord());
				for(int k = 0; k<j; k++){
					adjs[writers[j]].add(writers[k]);
					adjs[writers[k]].add(writers[j]);
				}
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		int[] dist = new int[n];
		boolean[] seen = new boolean[n];
		Arrays.fill(dist, 1000000);
		dist[0] = 0;
		seen[0] = true;
		while(!q.isEmpty()){
			int next = q.poll();
			strToErdos.put(idToStr.get(next), dist[next]);
			for(int x : adjs[next]){
				if(!seen[x]){
					seen[x] = true;
					q.add(x);
					dist[x] = dist[next]+1;
				}
			}
		}
		for(Map.Entry<String, Integer> entry : strToErdos.entrySet())
			sc.println(entry.getKey()+" "+entry.getValue());
		sc.close();
	}

	static class Kattio extends PrintWriter {
		public Kattio(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
		}
		public Kattio(InputStream i, OutputStream o) {
			super(new BufferedOutputStream(o));
			r = new BufferedReader(new InputStreamReader(i));
		}

		public boolean hasMoreTokens() {
			return peekToken() != null;
		}

		public int getInt() {
			return Integer.parseInt(nextToken());
		}

		public double getDouble() { 
			return Double.parseDouble(nextToken());
		}

		public long getLong() {
			return Long.parseLong(nextToken());
		}

		public String getWord() {
			return nextToken();
		}



		private BufferedReader r;
		private String line;
		private StringTokenizer st;
		private String token;

		private String peekToken() {
			if (token == null) 
				try {
					while (st == null || !st.hasMoreTokens()) {
						line = r.readLine();
						if (line == null) return null;
						st = new StringTokenizer(line);
					}
					token = st.nextToken();
				} catch (IOException e) { }
			return token;
		}

		private String nextToken() {
			String ans = peekToken();
			token = null;
			return ans;
		}
	}
}
