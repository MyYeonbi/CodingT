
import java.util.*;

 public class networkDelay {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 그래프를 인접 리스트 형태로 초기화
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] time : times) {
                int u = time[0], v = time[1], w = time[2];
                graph.get(u).add(new int[]{v, w});
            }

            // 시작 노드에서 각 노드까지의 최소 시간을 기록하는 배열
            int[] minTime = new int[n + 1];
            Arrays.fill(minTime, Integer.MAX_VALUE);
            minTime[k] = 0;

            // 다익스트라 알고리즘을 위해 우선순위 큐(힙) 초기화
            PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            heap.offer(new int[]{0, k}); // (걸린 시간, 노드)

            while (!heap.isEmpty()) {
                int[] current = heap.poll();
                int currentTime = current[0], node = current[1];

                // 이미 계산된 최소 시간보다 더 큰 시간이 나온 경우는 스킵
                if (currentTime > minTime[node]) continue;

                // 현재 노드에서 연결된 노드들의 최단 시간 갱신
                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0], time = neighbor[1];
                    int newTime = currentTime + time;
                    if (newTime < minTime[nextNode]) {
                        minTime[nextNode] = newTime;
                        heap.offer(new int[]{newTime, nextNode});
                    }
                }
            }

            // 모든 노드에 도달 가능한지 확인
            int maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (minTime[i] == Integer.MAX_VALUE) {
                    return -1; // 도달할 수 없는 노드가 있음
                }
                maxTime = Math.max(maxTime, minTime[i]);
            }

            return maxTime;
        }
    }

