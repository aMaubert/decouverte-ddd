package com.example.project.models;

import java.util.List;
import java.util.stream.Collectors;

public class Joueur {
	public int id;

	public Joueur(int id) {
		this.id = id;
	}

	public long recupererMonNombreDAbsences(List<Absence> absences) {
		return absences.stream()
						.filter( absence -> absence.getJoueur().id == this.id)
						.count() ;
	}

	public long recupererMonNombreDEntrainments(List<Entrainement> entrainements) {
		return entrainements.stream()
							.filter(entrainement -> this.estPresent(entrainement.getJoueurs() ))
							.count();
	}
	public boolean estPresent(List<Joueur> joueurs) {
		return joueurs.stream()
				.anyMatch(joueur -> joueur.id == this.id);
	}

	public StatistiqueEntrainement computeEntrainement(List<Absence> absences, List<Entrainement> entrainements) {
		long nbAbsencesDuJoueur = this.recupererMonNombreDAbsences(absences);
		long nbEntrainement = this.recupererMonNombreDEntrainments(entrainements);

		return new StatistiqueEntrainement(this.id, nbAbsencesDuJoueur, nbEntrainement);
	}
}
