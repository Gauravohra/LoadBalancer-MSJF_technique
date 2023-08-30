class Server {
    String name;
    int weight;
    int currentLoad;

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.currentLoad = 0;
    }

    public double estimateEnergyConsumption() {
        return weight * 10.0;
    }

    public void adjustWeight(int newWeight) {
        this.weight = newWeight;
    }

    public void increaseLoad(int load) {
        currentLoad += load;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    // Implement SLA adherence check based on response time
    public boolean isSLAAdhered(int responseTime) {
        return responseTime <= 200;
    }

    // Calculate slack time based on current load and weight
    public int calculateSlackTime() {
        return (weight - currentLoad);
    }
}
