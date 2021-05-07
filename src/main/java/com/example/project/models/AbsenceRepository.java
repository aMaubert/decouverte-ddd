package com.example.project.models;


import com.example.project.models.statistique.joueur.Absence;

import java.util.List;

public interface AbsenceRepository {
    List<Absence> recupereLesAbsences();
}