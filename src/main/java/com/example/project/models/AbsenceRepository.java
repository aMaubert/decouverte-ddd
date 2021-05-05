package com.example.project.models;

import com.example.project.models.Absence;
import com.example.project.models.Entrainement;

import java.util.List;

public interface AbsenceRepository {
    int recupereNombreAbsenceDunJoueur(int joueurId);
}