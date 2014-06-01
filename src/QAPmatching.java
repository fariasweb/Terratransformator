import java.util.*;

public class QAPmatching {
	private int maxN1;
	private int maxN2;
	private int maxM;
	private int edges;
	private int n1, n2, last[], prev[], head[];
	private int matching[], dist[], Q[];
	private boolean used[], vis[];
	
	QAPmatching(int n) {
		n1 = n;
		n2 = n;
		maxN1 = n*n;
		maxN2 = n*n;
		maxM = maxN1+maxN2;

		last = new int[maxN1];
		prev = new int[maxM];
		head = new int[maxM];
		matching = new int[maxN2];
		dist = new int[maxN1];
		Q = new int[maxN1];
		vis = new boolean[maxN1];
		used = new boolean[maxN1];
	}
	public void init() {
		
		for(int i = 0; i < n1; i++) {
			last[i] = -1;
			matching[i] = 0;
			dist[i] = 0;
			Q[i] = 0;
			vis[i] = false;
			used[i] = false;
			prev[i] = 0;
			head[i] = 0;
		}
		for(int i = n1; i < maxM; i++) {
			prev[i] = 0;
			head[i] = 0;
		}
		edges = 0;
		
		
	}

	public void addEdge(int u, int v) {
		head[edges] = v;
		prev[edges] = last[u];
		last[u] = edges++;
	}

	private void bfs() {
		int i;
		for (i = 0; i < n1; ++i)
			dist[i] = -1;
		int sizeQ = 0;
		for (int u = 0; u < n1; ++u) {
			if (!used[u]) {
				Q[sizeQ++] = u;
				dist[u] = 0;
			}
		}
		for (i = 0; i < sizeQ; i++) {
			int u1 = Q[i];
			for (int e = last[u1]; e >= 0; e = prev[e]) {
				int u2 = matching[head[e]];
				if (u2 >= 0 && dist[u2] < 0) {
					dist[u2] = dist[u1] + 1;
					Q[sizeQ++] = u2;
				}
			}
		}
	}

	private boolean dfs(int u1) {
		vis[u1] = true;
		for (int e = last[u1]; e >= 0; e = prev[e]) {
			int v = head[e];
			int u2 = matching[v];
			if (u2 < 0 || !vis[u2] && dist[u2] == dist[u1] + 1 && dfs(u2)) {
				matching[v] = u1;
				used[u1] = true;
				return true;
			}
		}
		return false;
	}

	public int maxMatching() {
		int i;
		for (i = 0; i < n1; ++i)
			used[i] = false;
		for (i = 0; i < n2; ++i)
			matching[i] = -1;
		for (int res = 0;;) {
			bfs();
			for (i = 0; i < n1; ++i)
				vis[i] = false;
			int f = 0;
			for (int u = 0; u < n1; ++u)
				if (!used[u] && dfs(u))
					++f;
			if (f == 0)
				return res;
			res += f;
		}
	}


	public int[] getMatchingList() {
		return matching;
	}
}