package org.example;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerTest {
    /**
     * Affiche toutes les tâches fournies
     * @param tasks liste des tâches
     */
    @GetMapping("/toutes-les-taches")
    public static ArrayList<String>  printTasks(ArrayList<TaskManager.TaskConfig> tasks){
        ArrayList<String> tasksList = new ArrayList<>();

        for(TaskManager.TaskConfig t : tasks) tasksList.add(t.toString() );

        return tasksList;
    }

    /**
     * Affiche les tâches sélectionnées
     * @param tasks iste des tâches
     * @param names nom des tâches à récupérer
     */
    @GetMapping("/taches-par-nom")
    public static ArrayList<String>  printTasksByName(ArrayList<TaskManager.TaskConfig> tasks, String ...names){
        ArrayList<String> tasksList = new ArrayList<>();

        var namesList = Arrays.asList(names);

        for(TaskManager.TaskConfig t : tasks){
            if(!namesList.contains(t.getTitle() ) ) continue;

            tasksList.add(t.toString() );
        }

        return tasksList;
    }
}
