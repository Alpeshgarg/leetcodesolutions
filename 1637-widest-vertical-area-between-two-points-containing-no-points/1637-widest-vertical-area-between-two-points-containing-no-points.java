class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {

        int[] xs = Arrays.stream(points)
                    .mapToInt(point -> point[0])
                    .sorted()
                    .toArray();
        
        int maxWidth = 0;
        for (int i = 1; i < xs.length; i++) {
            maxWidth = Math.max(maxWidth, xs[i] - xs[i - 1]);
        }

        return maxWidth;
    }
}