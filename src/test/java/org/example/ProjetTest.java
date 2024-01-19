package org.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class de test de projet
 */
public class ProjetTest {
    @Test
    public void testNullProject(){
        // on vérifie qu'un projet ne puisse pas prendre de nom null
        Assert.assertThrows(Exception.class,() -> new Project(null) );
        Assert.assertThrows(Exception.class,() -> new Project("") );
    }

    @Test
    public void testInterraction() throws Exception{
        Project testProject = new Project("Projet de test");

        // on vérifie qu'un projet est bien initialisé à 0 tâches
        Assert.assertTrue(testProject.getTasks().isEmpty() );

        // on vérifie l'ajout de tâche null
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig("tache",null,10) ) );
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig(null,"description",10) ) );
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig(null,null,10) ) );

        // on vérifie l'ajout de tâche
        testProject.addTask(new TaskManager.TaskConfig("tache","description",10) );

        // on vérifie que la taille de la liste aie bien changé
        Assert.assertEquals(1, testProject.getTasks().size());

        // on vérifie qu'on ne peut pas ajouter 2 tâche
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig("tache","autre description",10) ) );

        // on vérifie l'ajout d'une tâche à mauvaise durée
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig("tache","autre description",-1) ) );
    }

    @Test
    public void testDuration() throws Exception{
        // test la gestion de durée totale
        Project testProject = new Project("Projet");


        Assert.assertEquals(0,testProject.calculateTotalDuration() );
        Assert.assertThrows(Exception.class,() -> testProject.addTask(new TaskManager.TaskConfig("tache 1","description",-1) ) );

        testProject.addTask(new TaskManager.TaskConfig("tache 1","description",40) );
        testProject.addTask(new TaskManager.TaskConfig("tache 2","description",60) );

        Assert.assertEquals(100,testProject.calculateTotalDuration() );
    }
}

