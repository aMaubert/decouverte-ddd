package com.example.project.models.statistique.joueur;

import com.example.project.models.statistique.StatistiqueEntrainement;

import java.util.List;

public class Joueur {
	private int id;

	public Joueur(int id) {
		this.id = id;
	}

	public long recupererMonNombreDAbsences(List<Absence> absences) {
		return absences.stream()
						.filter( absence -> absence.getJoueur().getId() == this.getId())
						.count() ;
	}

	public long recupererMonNombreDEntrainments(List<Entrainement> entrainements) {
		return entrainements.stream()
							.filter(entrainement -> this.estPresent(entrainement.getJoueurs() ))
							.count();
	}
	public boolean estPresent(List<Joueur> joueurs) {
		return joueurs.stream()
				.anyMatch(joueur -> joueur.getId() == this.getId());
	}

	public StatistiqueEntrainement computeEntrainement(List<Absence> absences, List<Entrainement> entrainements) {
		long nbAbsencesDuJoueur = this.recupererMonNombreDAbsences(absences);
		long nbEntrainement = this.recupererMonNombreDEntrainments(entrainements);

		return new StatistiqueEntrainement(this.getId(), nbAbsencesDuJoueur, nbEntrainement);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
