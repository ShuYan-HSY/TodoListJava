import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {

	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask(Task task) {
		tasks.put(task.getDescription(), task);
	}

	public void completeTask(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			task.setComplete(true);
		}
		;
	}

	public boolean getStatus(String description) {
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			return task.isComplete();
<<<<<<< HEAD
		}
		;
=======
		}else {
>>>>>>> 335577f3ba630c2aba27a72a086020f7ca74e77a
		return false;
		}
	}

	public Task getTask(String description) {
	
			return tasks.get(description);	
	}

	public Task removeTask(String description) {
		return tasks.remove(description);
	}

	public Collection<Task> getAllTasks() {
		return tasks.values();
	}

	public Collection<Task> getCompletedTasks() {
		Collection<Task> completedTasks = new ArrayList<Task>();
		Collection<Task> allTasks = new ArrayList<Task>();
		allTasks = getAllTasks();
		for (Task task : allTasks)
			if (task.isComplete() == true)
				completedTasks.add(task);
		return completedTasks;
	}
	
	public void editTask(String description, Task newTask) {
		Task task = null;
		if ((task = tasks.get(description)) != null){
			tasks.remove(description);
			addTask(newTask);
		}
	}
}
