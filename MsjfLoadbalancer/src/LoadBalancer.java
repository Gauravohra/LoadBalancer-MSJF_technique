import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
class LoadBalancer {
    private List<Server> servers;
    private int currentIndex;

    public LoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = 0;

        // Add servers with their weights
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 4));
        servers.add(new Server("Server3", 7));
    }

    public Server getNextServer() {
        // Implement MSJF (Minimum Slack Job First) algorithm
        Server selectedServer = servers.stream()
                .min(Comparator.comparingInt(Server::calculateSlackTime))
                .orElse(null);

        if (selectedServer != null) {
            selectedServer.increaseLoad(1); // Increase load for the selected server
            return selectedServer;
        }

        return null;
    }

    public void optimizeServerWeights() {
        // Implement dynamic optimization of server weights based on load, SLA, and energy
        // You could use more advanced algorithms, machine learning, or heuristics here
        // For example, you could adjust weights based on historical data or predicted load
    }
}