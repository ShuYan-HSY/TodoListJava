//import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todoList;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		task1 = new Task ("desc 1");
		task2 = new Task ("desc 2");
		task3 = new Task ("desc 3");
		
		todoList = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		task1 = null;
		task2 = null;
		task3 = null;
		
		todoList = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(1, todoList.getAllTasks().size());
		Task temp1 = todoList.getTask(task1.getDescription());
		assertEquals(temp1, task1);
		todoList.addTask(task2);
		assertEquals(2, todoList.getAllTasks().size());
		Task temp2 = todoList.getTask(task2.getDescription());
		assertEquals(temp2, task2);
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.completeTask(task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		todoList.addTask(task2);
		assertEquals(2, todoList.getAllTasks().size());
		todoList.removeTask(task1.getDescription());
		assertEquals(1, todoList.getAllTasks().size());
		assertNull(todoList.getTask(task1.getDescription()));	
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		task3.setComplete(true);
		todoList.addTask(task1);
		todoList.addTask(task2);
		todoList.addTask(task3);
		
		Collection<Task> tasks = todoList.getCompletedTasks();
		assertEquals(2, tasks.size());
	}
	@Test
	public void testEditTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(task1, todoList.getTask(task1.getDescription()));
		todoList.editTask(task1.getDescription(),task2);
		Task updatedTask = todoList.getTask(task2.getDescription());
		assertSame(task2, updatedTask);
	}
	@Test
	public void testGetTask() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		Task task = todoList.getTask("desc 1");
		assertNotNull(task);
		assertEquals(task, task1);
	}
	@Test
	public void testSetTaskPriority() {
		todoList.addTask(task1);
		task1.setPriority(1); 
		Task task = todoList.getTask("desc 1");
		assertNotNull(task);
		assertTrue("task priority is not equal to 0", task.getPriority() != 0);
		assertEquals(1, task.getPriority());
	}
	@Test
	public void testSetStatus() {
		assertNotNull(todoList);
		todoList.addTask(task1);
		assertEquals(false, todoList.getStatus(task1.getDescription()));
		todoList.updateTaskStatus(true,task1.getDescription());
		assertEquals(true, todoList.getStatus(task1.getDescription()));
		todoList.updateTaskStatus(false,task1.getDescription());
		assertEquals(false, todoList.getStatus(task1.getDescription()));
	}
}
