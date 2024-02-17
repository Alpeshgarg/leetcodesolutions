class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        if (n == 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max heap
        int i = 0;
        for (; i < n - 1; i++) {
            if (heights[i + 1] <= heights[i])
                continue;
            int diff = heights[i + 1] - heights[i];
            if (bricks >= diff) {
                bricks -= diff;
                pq.offer(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty()) {
                    int pastBricks = pq.peek();
                    if (pastBricks > diff) {
                        bricks += pastBricks;
                        pq.poll();
                        bricks -= diff;
                        pq.offer(diff);
                    }
                }
                ladders--;
            } else
                break;
        }
        return i;
    }
}