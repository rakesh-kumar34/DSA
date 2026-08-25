class Solution {
    private LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null) return Collections.emptyList();

        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }
        dfs("JFK", adj);
        return result;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> adj) {
        /*
            HOU -> JFK
            SEA -> JFK
            JFK -> HOU, SEA
        */
        PriorityQueue<String> pq = adj.get(from);

        while (pq != null && !pq.isEmpty()) {
            String to = pq.poll();
            dfs(to, adj);
        }
        result.addFirst(from);
    }
}
