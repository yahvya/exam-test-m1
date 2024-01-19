package org.example;

import java.util.HashMap;

/**
 * Gestionnaire de tâche
 * @attention n'autorise pas les valeurs null
 */
public class TaskManager {
    /**
     * liste des tâches
     */
    HashMap<String,TaskConfig> tasks;

    public TaskManager(){
        this.tasks = new HashMap<String,TaskConfig>();
    }

    /**
     * Ajoute une nouvelle tâche si elle n'existe pas déjà
     * @param title titre de la tâche
     * @param description description de la tâche
     * @param taskDurationInSeconds durée de la tâche en secondes
     * @return si la tâche a bien été ajouté
     */
    public boolean addTask(String title, String description,int taskDurationInSeconds){
        if(
            title == null ||
            description == null ||
            this.tasks.containsKey(title) ||
            taskDurationInSeconds < 0
        ) return false;

        this.tasks.put(title, new TaskConfig(title,description,taskDurationInSeconds) );

        return true;
    }

    /**
     * Marque une tâche comme complété si elle ne l'est pas déjà
     * @param title titre de la tâche
     * @return si la tâche a bien été marquée comme complétée
     */
    public boolean completeTask(String title){
        if(
            title == null ||
            !this.tasks.containsKey(title)
        ) return false;

        TaskConfig task = this.tasks.get(title);

        if(task.isComplete) return false;

        task.complete();

        return true;
    }

    /**
     * Vérifie si une tâche est terminée
     * @param title titre de la tâche
     * @return si la tâche est complétée
     * @throws Exception en cas de tâche inexistante
     */
    public boolean verifyTask(String title) throws Exception{
        if(title == null || !this.tasks.containsKey(title) ) throw new Exception("La tâche n'existe pas");

        return this.tasks.get(title).isComplete;
    }

    /**
     * configuration d'une tâche
     * @attention autorise les valeurs nulls
     */
    public static class TaskConfig {

        /**
         * Etat de complétion de la tâche
         */
        private boolean isComplete;

        /**
         * Description de la tâche
         */
        private final String description;

        /**
         * Titre de la tâche
         */
        private final String title;

        /**
         * Durée en seconees de la tâche
         */
        private final int durationInSeconds;

        /**
         * Crée une tâche non complétée par défaut
         * @param title titre de la tâche
         * @param description description de la tâche
         * @param taskDurationInSeconds durée de la tâche
         */
        public TaskConfig(String title,String description,int taskDurationInSeconds){
            this.isComplete = false;
            this.description = description;
            this.title = title;
            this.durationInSeconds = taskDurationInSeconds;
        }

        /**
         * Déclare la tâche comme complétée
         */
        public void complete(){
            this.isComplete = true;
        }

        /**
         *
         * @return la description de la tâche
         */
        public String getDescription(){
            return this.description;
        }

        /**
         *
         * @return si la tâche est complétée
         */
        public boolean getIsComplete(){
            return this.isComplete;
        }

        /**
         *
         * @return le titre de la tâche
         */
        public String getTitle(){
            return this.title;
        }

        /**
         *
         * @return durée de la tâche
         */
        public int getDurationInSeconds(){
            return this.durationInSeconds;
        }
    }
}
