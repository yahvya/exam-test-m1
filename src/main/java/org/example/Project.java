package org.example;

import java.util.ArrayList;

/**
 * gestion de projet
 */
public class Project {
    /**
     * Nom du projet
     */
    private final String name;

    private final ArrayList<TaskManager.TaskConfig> tasks;

    /**
     * Gestionnaire internne des tâches
     */
    private final TaskManager internalTaskManager;

    /**
     * @param name nom du projet
     * @throws Exception en cas de nom null
     */
    public Project(String name) throws Exception{
        if(name == null || name.isEmpty() ) throw new Exception("Nom null");

        this.name = name;
        this.tasks = new ArrayList<TaskManager.TaskConfig>();
        this.internalTaskManager = new TaskManager();
    }

    /**
     * Ajoute une tâche au projet
     * @param task la tâche à ajouter au projet
     * @return this
     * @throws Exception en cas d'erreur
     */
    public Project addTask(TaskManager.TaskConfig task) throws  Exception{
        if(!this.internalTaskManager.addTask(task.getTitle(),task.getDescription(),task.getDurationInSeconds() ) ) throw new Exception("Echec d'ajout de la tâche");

        this.tasks.add(task);

        return this;
    }

    /**
     *
     * @return le gestionnaire de tâche interne
     */
    public TaskManager getInternalTaskManager() {
        return internalTaskManager;
    }

    /**
     *
     * @return le nom du projet
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @return la liste des tâches du projets
     */
    public ArrayList<TaskManager.TaskConfig> getTasks(){
        return this.tasks;
    }

    /**
     *
     * @return la durée totale des tâches en secondes
     */
    public int calculateTotalDuration(){
        int sum = 0;

        for(TaskManager.TaskConfig task : this.tasks) sum += task.getDurationInSeconds();

        return sum;
    }
}
