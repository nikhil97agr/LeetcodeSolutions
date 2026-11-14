package design_a_todo_list_2688;

import java.util.*;
class TodoList {
    int id;
    Map<Integer, Task> taskMap;
    Map<String, List<Task>> tagMap;
    Map<Integer, List<Task>> userMap;
    public TodoList() {
        id = 1;
        taskMap = new HashMap<>();
        tagMap = new HashMap<>();
        userMap = new HashMap<>();
    }
    
    public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
        Task task =new Task(taskDescription, dueDate, tags, userId);
        taskMap.put(id++, task);
        userMap.compute(userId, (key, val) ->{
            if(val == null){
                val = new ArrayList<>();
            }

            int index = search(val, dueDate);

            if(index == val.size()){
                val.add(task);
            }else{
                val.add(index, task);
            }

            return val;
        });

        return id - 1;
    }
    
    private int search(List<Task> list, int date){
        int start = 0;
        int end = list.size() - 1;
        if(list.isEmpty()){
            return 0;
        }

        if(date < list.get(0).date){
            return 0;
        }

        if(date > list.get(end).date){
            return list.size();
        }
        int ind = list.size();
        while(start <= end){
            int mid = (start + end)/2;

            if(list.get(mid).date < date){
               start = mid + 1;
            }else if(list.get(mid).date > date){
                end = mid - 1;
                ind = mid;
            }else{
                return mid;
            }
        }

        return ind;

        
    }
    public List<String> getAllTasks(int userId) {
        return userMap.getOrDefault(userId, new ArrayList<>()).stream().map(x -> x.des).toList();
    }
    
    public List<String> getTasksForTag(int userId, String tag) {
        return userMap.getOrDefault(userId, new ArrayList<>()).stream().filter(t -> t.tags.contains(tag)).map(x -> x.des).toList();
    }
    
    public void completeTask(int userId, int taskId) {
        Task task = taskMap.get(taskId);
        if(task == null || task.userId != userId || task.status ) return;

        task.status = true;
        userMap.get(userId).remove(task);
    }

    class Task{
        String des;
        int date;
        boolean status;
        List<String> tags;
        int userId;
        public Task(String des, int date, List<String> tags, int userId){
            this.des = des;
            this.date = date;
            status = false;
            this.tags = tags;
            this.userId = userId;
        }
    }
}

/**
 * Your TodoList object will be instantiated and called as such:
 * TodoList obj = new TodoList();
 * int param_1 = obj.addTask(userId,taskDescription,dueDate,tags);
 * List<String> param_2 = obj.getAllTasks(userId);
 * List<String> param_3 = obj.getTasksForTag(userId,tag);
 * obj.completeTask(userId,taskId);
 */