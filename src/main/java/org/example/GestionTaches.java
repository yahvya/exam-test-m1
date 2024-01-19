package org.example;

import java.util.HashMap;

/**
 * gestionnaire de tpache
 */
public class GestionTaches {
    /**
     * liste des tâches
     */
    HashMap<String,TaskConfig> tasks;

    public GestionTaches(){
        this.tasks = new HashMap<String,TaskConfig>();
    }

    /**
     * Ajoute une nouvelle tâche si elle n'existe pas déjà
     * @param title titre de la tâche
     * @param description description de la tâche
     * @return si la tâche a bien été ajouté
     */
    public boolean ajouterTache(String title,String description){
        if(
            this.tasks.containsKey(title) ||
            title == null || description == null
        ) return false;

        this.tasks.put(title, new TaskConfig(description));

        return true;
    }

    /**
     * Marque une tâche comme complété si elle ne l'est pas déjà
     * @param title titre de la tâche
     * @return si la tâche a bien été marquée comme complétée
     */
    public boolean completerTache(String title){
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
    public boolean verifierTache(String title) throws Exception{
        if(title == null || !this.tasks.containsKey(title) ) throw new Exception("La tâche n'existe pas");

        return this.tasks.get(title).isComplete;
    }

    /**
     * configuration d'une tâche
     */
    public static class TaskConfig{
        private boolean isComplete;

        private final String description;

        /**
         * Crée une tâche non complétée par défaut
         * @param description description de la tâche
         */
        public TaskConfig(String description){
            this.isComplete = false;
            this.description = description;
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
    }
}
