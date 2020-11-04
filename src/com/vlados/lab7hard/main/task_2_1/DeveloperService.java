package com.vlados.lab7hard.main.task_2_1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by olenasyrota on 6/28/16.
 */
public class DeveloperService {

    public static List<String> getLanguages(List<Developer> team) {
        return team.stream()
                .map(developer -> developer.getLanguages())
                .flatMap(languages -> languages.stream())
                .collect(Collectors.toList());
    }


}
