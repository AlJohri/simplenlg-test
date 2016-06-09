package hello;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;

// SimpleNLG Tutorial: https://github.com/simplenlg/simplenlg/wiki

public class SimpleNLGTest {
	public static void main(String[] args) {

		System.out.println("Example 1");

		Lexicon lexicon = Lexicon.getDefaultLexicon();
		NLGFactory nlgFactory = new NLGFactory(lexicon);
		Realiser realiser = new Realiser(lexicon);

		NLGElement s1 = nlgFactory.createSentence("my dog is happy");

		String output = realiser.realiseSentence(s1);
		System.out.println(output);

		/* ----------------------------------------------------------- */

		System.out.println("Example 2");

		SPhraseSpec p = nlgFactory.createClause();
		p.setSubject("Mary");
		p.setVerb("chase");
		p.setObject("the monkey");

		String output2 = realiser.realiseSentence(p); // Realiser created earlier.
		System.out.println(output2);

		/* ----------------------------------------------------------- */

		System.out.println("Example 3");

		NPPhraseSpec subject = nlgFactory.createNounPhrase("Mary");
		NPPhraseSpec object = nlgFactory.createNounPhrase("the monkey");
		VPPhraseSpec verb = nlgFactory.createVerbPhrase("chase");

		subject.addModifier("fast");

		p = nlgFactory.createClause();
		p.setSubject(subject);
		p.setObject(object);
		p.setVerb(verb);

		String output3 = realiser.realiseSentence(p); // Realiser created earlier.
		System.out.println(output3);

		/* ----------------------------------------------------------- */

		System.out.println("Example 4");

		p = nlgFactory.createClause("I", "be", "happy");
		SPhraseSpec q = nlgFactory.createClause("I", "eat", "fish");

		q.setFeature(Feature.COMPLEMENTISER, "because");
		q.setFeature(Feature.TENSE, Tense.PAST);
		p.addComplement(q);

		String output4 = realiser.realiseSentence(p);  //Realiser created earlier
		System.out.println(output4);


	}
}
