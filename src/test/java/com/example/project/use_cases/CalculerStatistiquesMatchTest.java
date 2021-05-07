package com.example.project.use_cases;

import com.example.project.mocks.MockFaitDeJeuRepository;
import com.example.project.mocks.MockMatchRepository;
import com.example.project.models.*;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
//public class CalculerStatistiquesMatchTest extends TestCase {
//
//	private CalculerStatistiquesMatch calculerStatistiquesMatch;
//	private MockFaitDeJeuRepository mockFaitDeJeuRepository;
//	private MockMatchRepository mockMatchRepository;
//
//	@Before
//	public void init(){
//		this.mockFaitDeJeuRepository = new MockFaitDeJeuRepository();
//		this.mockMatchRepository = new MockMatchRepository();
//	}
//
//	/*@Test
//	public void testCalcul() {
//		calculerStatistiquesMatch = new CalculerStatistiquesMatch(mockFaitDeJeuRepository);
//		List<Match> matchs = Arrays.asList(new Match(1), new Match(2));
//
//		var statistiquesMatch = calculerStatistiquesMatch.calcul(matchs);
//		Assert.assertTrue(!statistiquesMatch.isEmpty());
//	}*/
//
//	/*@Test
//	public void devraitAvoir2FaitsDeJeuPour1Match() {
//		//Given:
//		List<FaitDeJeu> faitDeJeuListMatch = Arrays.asList(new FaitDeJeu(FaitDeJeuType.BUT_MARQUE), new FaitDeJeu(FaitDeJeuType.CARTON_JAUNE));
//		Equipe equipe = new Equipe(1);
//		Match match = new Match(1, faitDeJeuListMatch, equipe );
//		var matchs = Arrays.asList(new Match(1, faitDeJeuListMatch, equipe));
//	}
//*/
//}