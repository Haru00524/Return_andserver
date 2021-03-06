package zarazio.travel.android.util;

import java.util.List;

import scala.collection.Seq;

import com.twitter.penguin.korean.TwitterKoreanProcessor;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;


public class TwitterTextAnalysis {
	public List<String> TextAnalysis(String text){

	    // Normalize
	    CharSequence normalized = TwitterKoreanProcessorJava.normalize(text);
	    System.out.println(normalized);
	    // 廃厩嬢研 坦軒馬澗 森獣脊艦陥せせ #廃厩嬢


	    // Tokenize
	    Seq<KoreanTokenizer.KoreanToken> tokens = TwitterKoreanProcessorJava.tokenize(normalized);
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(tokens));
	    List<String> analysis = TwitterKoreanProcessorJava.tokensToJavaStringList(tokens);
	  /*  // [廃厩嬢, 研, 坦軒, 馬澗, 森獣, 脊艦, 陥, せせ, #廃厩嬢]
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens));
	    // [廃厩嬢(Noun: 0, 3), 研(Josa: 3, 1),  (Space: 4, 1), 坦軒(Noun: 5, 2), 馬澗(Verb: 7, 2),  (Space: 9, 1), 森獣(Noun: 10, 2), 脊艦(Adjective: 12, 2), 陥(Eomi: 14, 1), せせ(KoreanParticle: 15, 2),  (Space: 17, 1), #廃厩嬢(Hashtag: 18, 4)]


	    // Stemming
	    Seq<KoreanTokenizer.KoreanToken> stemmed = TwitterKoreanProcessorJava.stem(tokens);
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaStringList(stemmed));
	    // [廃厩嬢, 研, 坦軒, 馬陥, 森獣, 戚陥, せせ, #廃厩嬢]
	    System.out.println(TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(stemmed));
	    // [廃厩嬢(Noun: 0, 3), 研(Josa: 3, 1),  (Space: 4, 1), 坦軒(Noun: 5, 2), 馬陥(Verb: 7, 2),  (Space: 9, 1), 森獣(Noun: 10, 2), 戚陥(Adjective: 12, 3), せせ(KoreanParticle: 15, 2),  (Space: 17, 1), #廃厩嬢(Hashtag: 18, 4)]


	    // Phrase extraction
	    List<KoreanPhraseExtractor.KoreanPhrase> phrases = TwitterKoreanProcessorJava.extractPhrases(tokens, true, true);
	    System.out.println(phrases);
	    // [廃厩嬢(Noun: 0, 3), 坦軒(Noun: 5, 2), 坦軒馬澗 森獣(Noun: 5, 7), 森獣(Noun: 10, 2), #廃厩嬢(Hashtag: 18, 4)]
*/
	    return analysis;
	}
}
