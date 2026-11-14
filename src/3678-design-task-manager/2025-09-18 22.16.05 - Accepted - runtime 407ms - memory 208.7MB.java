class TaskManager {
    TreeMap<Integer, TreeMap<Integer, Task>> priorityMap;
    Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        priorityMap = new TreeMap<>(Collections.reverseOrder());
        for (List<Integer> task : tasks) {
            Task t = new Task(task.get(1), task.get(2), task.get(0));
            add(t);
        }
    }

    private void add(Task t) {
        priorityMap.computeIfAbsent(t.priority, p -> new TreeMap<>(Collections.reverseOrder())).put(t.task, t);
        taskMap.put(t.task, t);
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(taskId, priority, userId);
        add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);

        priorityMap.get(task.priority).remove(taskId);
        if (priorityMap.get(task.priority).isEmpty()) {
            priorityMap.remove(task.priority);
        }

        task.priority = newPriority;

        add(task);
    }

    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        taskMap.remove(taskId);
        priorityMap.get(task.priority).remove(taskId);
        if (priorityMap.get(task.priority).isEmpty()) {
            priorityMap.remove(task.priority);
        }
    }

    public int execTop() {
        if (priorityMap.isEmpty()) {
            return -1;
        }

        Task task = priorityMap.firstEntry().getValue().firstEntry().getValue();
        priorityMap.get(task.priority).remove(task.task);
        if (priorityMap.get(task.priority).isEmpty())
            priorityMap.remove(task.priority);

        taskMap.remove(task.task);

        return task.user;
    }

    class Task {
        int task;
        int priority;
        int user;

        public Task(int task, int priority, int user) {
            this.task = task;
            this.priority = priority;
            this.user = user;
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */