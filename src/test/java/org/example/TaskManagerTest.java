package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class de test de la class GestionTaches
 */
public class TaskManagerTest {
    @Test
    public void test() throws Exception{
        TaskManager taskManager = new TaskManager();

        // on tente de compléter une tâche inexistante
        Assert.assertFalse(taskManager.completeTask("inexistant") );
        Assert.assertFalse(taskManager.completeTask(null) );

        // on tente de vérifier une tâche qui n'existe pas
        Assert.assertThrows(Exception.class,() -> taskManager.verifyTask("inexistant") );
        Assert.assertThrows(Exception.class,() -> taskManager.verifyTask(null) );

        // on ajoute une tâche
        Assert.assertTrue(taskManager.addTask("tache","description",10) );

        // on tente d'ajouter une tâche déjà existante
        Assert.assertFalse(taskManager.addTask("tache","description differente",10) );

        // on tente d'ajouter une tâche à élément null
        Assert.assertFalse(taskManager.addTask(null,null,10) );
        Assert.assertFalse(taskManager.addTask("tache2",null,10) );
        Assert.assertFalse(taskManager.addTask(null,"description2",10) );

        // on vérifie que la tâche ajoutée soit bien incomplète et sans exception
        Assert.assertFalse(taskManager.verifyTask("tache") );

        // on vérifie que la tâche puisse bien être complétée
        Assert.assertTrue(taskManager.completeTask("tache") );

        // on vérifie que la tâche est bien complétée
        Assert.assertTrue(taskManager.verifyTask("tache") );

        // ajout d'une tâche à mauvaise durée
        Assert.assertFalse(taskManager.addTask("nouvelle tâche","description de la nouvelle tâche",-1) );
    }
}
