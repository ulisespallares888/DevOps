const BASE_URL = "http://localhost:8080/api/v1/tasks";

// 🔧 Normaliza la respuesta HAL en un objeto estándar {content, totalPages, ...}
export async function getAllTasks(page = 0, size = 10, sort = "id", direction = "asc") {
  try {
    const response = await fetch(
      `${BASE_URL}?page=${page}&size=${size}&sort=${sort},${direction}`
    );
    if (!response.ok) {
      throw new Error(`Failed to fetch tasks: ${response.status} ${response.statusText}`);
    }
    const data = await response.json();

    return {
      content: data._embedded ? data._embedded.taskResponseDTOList : [],
      totalPages: data.page.totalPages,
      totalElements: data.page.totalElements,
      size: data.page.size,
      number: data.page.number,
    };
  } catch (error) {
    console.error("Error fetching tasks:", error);
    throw error;
  }
}

export async function searchTasks(content, page = 0, size = 10, sort = "id", direction = "asc") {
  try {
    const response = await fetch(
      `${BASE_URL}/search?content=${encodeURIComponent(content)}&page=${page}&size=${size}&sort=${sort},${direction}`
    );
    if (!response.ok) {
      throw new Error(`Failed to search tasks: ${response.status} ${response.statusText}`);
    }
    const data = await response.json();

    return {
      content: data._embedded ? data._embedded.taskResponseDTOList : [],
      totalPages: data.page.totalPages,
      totalElements: data.page.totalElements,
      size: data.page.size,
      number: data.page.number,
    };
  } catch (error) {
    console.error("Error searching tasks:", error);
    throw error;
  }
}

export async function getTaskById(id) {
  try {
    const response = await fetch(`${BASE_URL}/${id}`);
    if (!response.ok) {
      throw new Error(`Failed to fetch task by ID: ${response.status} ${response.statusText}`);
    }
    return response.json();
  } catch (error) {
    console.error("Error fetching task by ID:", error);
    throw error;
  }
}

export async function createTask(task) {
  try {
    const response = await fetch(BASE_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(task),
    });
    if (!response.ok) {
      throw new Error(`Failed to create task: ${response.status} ${response.statusText}`);
    }
    return response.json();
  } catch (error) {
    console.error("Error creating task:", error);
    throw error;
  }
}

export async function deleteTask(id) {
  try {
    const response = await fetch(`${BASE_URL}/${id}`, { method: "DELETE" });
    if (!response.ok) {
      throw new Error(`Failed to delete task: ${response.status} ${response.statusText}`);
    }
    return response.ok;
  } catch (error) {
    console.error("Error deleting task:", error);
    throw error;
  }
}

export async function updateTask(id, task) {
  try {
    const response = await fetch(`${BASE_URL}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(task),
    });
    if (!response.ok) {
      throw new Error(`Failed to update task: ${response.status} ${response.statusText}`);
    }
    return response.json();
  } catch (error) {
    console.error("Error updating task:", error);
    throw error;
  }
}

export async function completeTask(id, completed) {
  try {
    const response = await fetch(
      `${BASE_URL}/${id}/complete?completed=${completed}`,
      { method: "PUT" }
    );
    if (!response.ok) {
      throw new Error(`Failed to complete task: ${response.status} ${response.statusText}`);
    }
    return response.json();
  } catch (error) {
    console.error("Error completing task:", error);
    throw error;
  }
}
