package com.example.project.use_cases;

import com.example.project.mocks.MockFaitDeJeuxRepository;
import com.example.project.models.FaitDeJeu;
import com.example.project.models.FaitDeJeuRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculerStatistiquesMatchTest extends TestCase {

	private CalculerStatistiquesMatch calculerStatistiquesMatch;
	private FaitDeJeuRepository faitDeJeuRepository;

	@Before
	public void init(){
		FaitDeJeuRepository faitDeJeuRepository = new MockFaitDeJeuxRepository();
	}

	@Test
	public void testCalcul() {

	}
}