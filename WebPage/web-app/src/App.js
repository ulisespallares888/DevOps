import React, { useState, useEffect } from "react";
import {
  getAllTasks,
  searchTasks,
  createTask,
  deleteTask,
  completeTask,
  updateTask,
} from "./api";
import "./App.css";
import { FaCheck, FaTrash } from "react-icons/fa";



function App() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState({ title: "", description: "" });
  const [searchQuery, setSearchQuery] = useState("");
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    fetchTasks();
  }, [page]);

  const fetchTasks = async () => {
    const data = await getAllTasks(page);
    setTasks(data.content);
    setTotalPages(data.totalPages);
  };

  const handleCreateTask = async () => {
    if (newTask.title && newTask.description) {
      await createTask(newTask);
      setNewTask({ title: "", description: "" });
      fetchTasks();
    }
  };

  const handleDeleteTask = async (id) => {
    await deleteTask(id);
    fetchTasks();
  };

  const handleCompleteTask = async (id, completed) => {
    await completeTask(id, completed);
    fetchTasks();
  };

  const handleSearch = async () => {
    if (searchQuery) {
      const data = await searchTasks(searchQuery, page);
      setTasks(data.content);
      setTotalPages(data.totalPages);
    } else {
      fetchTasks();
    }
  };

  const handlePageChange = (newPage) => {
    if (newPage >= 0 && newPage < totalPages) {
      setPage(newPage);
    }
  };

  // Estados para edición
  const [editingTaskId, setEditingTaskId] = useState(null);
  const [editingTaskData, setEditingTaskData] = useState({ title: "", description: "" });

  return (
    <div className="App">
      <h1>Task Manager</h1>

      <div className="search-bar">
        <input
          type="text"
          placeholder="Search tasks..."
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
        <button onClick={handleSearch}> 🔍</button>
      </div>

      <div className="create-task">
        <h2>Create Task</h2>
        <input
          type="text"
          placeholder="Title"
          value={newTask.title}
          onChange={(e) => setNewTask({ ...newTask, title: e.target.value })}
        />
        <input
          type="text"
          placeholder="Description"
          value={newTask.description}
          onChange={(e) =>
            setNewTask({ ...newTask, description: e.target.value })
          }
        />
        <button onClick={handleCreateTask}>Add Task</button>
      </div>

      <h2>Task List</h2>
      <div className="task-list">
       {tasks.map((task) => (
         <div className="task-card" key={task.id}>
           {editingTaskId === task.id ? (
             <>
               <input
                 type="text"
                 value={editingTaskData.title}
                 onChange={(e) =>
                   setEditingTaskData({ ...editingTaskData, title: e.target.value })
                 }
               />
               <input
                 type="text"
                 value={editingTaskData.description}
                 onChange={(e) =>
                   setEditingTaskData({ ...editingTaskData, description: e.target.value })
                 }
               />
               <div className="task-actions">
                 <button onClick={async () => {
                   await updateTask(task.id, editingTaskData);
                   setEditingTaskId(null);
                   fetchTasks();
                 }}>💾</button> {/* icono guardar */}
                 <button onClick={() => setEditingTaskId(null)}>❌</button> {/* cancelar */}
               </div>
             </>
           ) : (
             <>
               <h3 className={task.completed ? "completed" : ""}>{task.title}</h3>
               <p className={task.completed ? "completed" : ""}>{task.description}</p>
               <div className="task-actions">
                 <button onClick={() => handleCompleteTask(task.id, !task.completed)} title="Complete">
                   <FaCheck />
                 </button>
                 <button onClick={() => handleDeleteTask(task.id)} title="Delete">
                   <FaTrash />
                 </button>
                 <button onClick={() => {
                   setEditingTaskId(task.id);
                   setEditingTaskData({ title: task.title, description: task.description });
                 }} title="Edit">✏️</button>
               </div>
             </>
           )}
         </div>
       ))}

      </div>

      <div className="pagination">
        <button
          onClick={() => handlePageChange(page - 1)}
          disabled={page === 0}
        >
          Previous
        </button>

        <span>
          Page {page + 1} of {totalPages}
        </span>

        <button
          onClick={() => handlePageChange(page + 1)}
          disabled={page + 1 >= totalPages}
        >
          Next
        </button>
      </div>
    </div>
  );
}

export default App;
