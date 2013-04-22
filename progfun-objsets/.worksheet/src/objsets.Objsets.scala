package objsets

object Objsets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(78); 

  val tweettest = new Tweet("rodrigogpgb", "working on scala assignment", 0);System.out.println("""tweettest  : objsets.Tweet = """ + $show(tweettest ));$skip(24); 

  val set1 = new Empty;System.out.println("""set1  : objsets.Empty = """ + $show(set1 ));$skip(53); 
  val set2 = set1.incl(new Tweet("a", "a body", 20));System.out.println("""set2  : objsets.TweetSet = """ + $show(set2 ));$skip(53); 
  val set3 = set2.incl(new Tweet("b", "b body", 20));System.out.println("""set3  : objsets.TweetSet = """ + $show(set3 ));$skip(38); 
  val c = new Tweet("c", "c body", 7);System.out.println("""c  : objsets.Tweet = """ + $show(c ));$skip(38); 
  val d = new Tweet("d", "d body", 9);System.out.println("""d  : objsets.Tweet = """ + $show(d ));$skip(27); 
  val set4c = set3.incl(c);System.out.println("""set4c  : objsets.TweetSet = """ + $show(set4c ));$skip(27); 
  val set4d = set3.incl(d);System.out.println("""set4d  : objsets.TweetSet = """ + $show(set4d ));$skip(27); 
  val set5 = set4c.incl(d);System.out.println("""set5  : objsets.TweetSet = """ + $show(set5 ));$skip(37); val res$0 = 

  set5.filter(tw => tw.user == "d");System.out.println("""res0: objsets.TweetSet = """ + $show(res$0));$skip(36); val res$1 = 
  set5.filter(tw => tw.user == "e");System.out.println("""res1: objsets.TweetSet = """ + $show(res$1));$skip(36); val res$2 = 
  set5.filter(tw => tw.user == "a");System.out.println("""res2: objsets.TweetSet = """ + $show(res$2));$skip(37); val res$3 = 
  set4d.filter(tw => tw.user == "c");System.out.println("""res3: objsets.TweetSet = """ + $show(res$3));$skip(22); val res$4 = 

  set5.mostRetweeted;System.out.println("""res4: objsets.Tweet = """ + $show(res$4));$skip(39); 
  val e = new Tweet("e", "e body", 25);System.out.println("""e  : objsets.Tweet = """ + $show(e ));$skip(26); 
  val set6 = set5.incl(e);System.out.println("""set6  : objsets.TweetSet = """ + $show(set6 ));$skip(21); val res$5 = 
  set6.mostRetweeted;System.out.println("""res5: objsets.Tweet = """ + $show(res$5));$skip(32); val res$6 = 
  set6.descendingByRetweet.head;System.out.println("""res6: objsets.Tweet = """ + $show(res$6));$skip(43); 

  GoogleVsApple.trending.foreach(println)}
}
