package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class de test de la class GestionTaches
 */
public class GestionTachesTest {
    @Test
    public void test() throws Exception{
        GestionTaches taskManager = new GestionTaches();

        // on tente de compléter une tâche inexistante
        Assert.assertFalse(taskManager.completerTache("inexistant") );
        Assert.assertFalse(taskManager.completerTache(null) );

        // on tente de vérifier une tâche qui n'existe pas
        Assert.assertThrows(Exception.class,() -> taskManager.verifierTache("inexistant") );
        Assert.assertThrows(Exception.class,() -> taskManager.verifierTache(null) );

        // on ajoute une tâche
        Assert.assertTrue(taskManager.ajouterTache("tache","description") );

        // on tente d'ajouter une tâche déjà existante
        Assert.assertFalse(taskManager.ajouterTache("tache","description differente") );

        // on tente d'ajouter une tâche à élément null
        Assert.assertFalse(taskManager.ajouterTache(null,null) );
        Assert.assertFalse(taskManager.ajouterTache("tache2",null) );
        Assert.assertFalse(taskManager.ajouterTache(null,"description2") );

        // on vérifie que la tâche ajoutée soit bien incomplète et sans exception
        Assert.assertFalse(taskManager.verifierTache("tache") );

        // on vérifie que la tâche puisse bien être complétée
        Assert.assertTrue(taskManager.completerTache("tache") );

        // on vérifie que la tâche est bien complétée
        Assert.assertTrue(taskManager.verifierTache("tache") );
    }
}
