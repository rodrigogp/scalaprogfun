package objsets

object Objsets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val tweettest = new Tweet("rodrigogpgb", "working on scala assignment", 0)
                                                  //> tweettest  : objsets.Tweet = User: rodrigogpgb
                                                  //| Text: working on scala assignment [0]

  val set1 = new Empty                            //> set1  : objsets.Empty = objsets.Empty@47315d34
  val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@596e1fb1
  val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@16bdb503{User: b
                                                  //| Text: b body [20]}objsets.Empty@b6e39f
  val c = new Tweet("c", "c body", 7)             //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
  val d = new Tweet("d", "d body", 9)             //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
  val set4c = set3.incl(c)                        //> set4c  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@16bdb503{User: b
                                                  //| Text: b body [20]}objsets.Empty@6719dc16{User: c
                                                  //| Text: c body [7]}objsets.Empty@52c05d3b
  val set4d = set3.incl(d)                        //> set4d  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@16bdb503{User: b
                                                  //| Text: b body [20]}objsets.Empty@5328f6ee{User: d
                                                  //| Text: d body [9]}objsets.Empty@266bade9
  val set5 = set4c.incl(d)                        //> set5  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@16bdb503{User: b
                                                  //| Text: b body [20]}objsets.Empty@6719dc16{User: c
                                                  //| Text: c body [7]}objsets.Empty@6766afb3{User: d
                                                  //| Text: d body [9]}objsets.Empty@69945ce

  set5.filter(tw => tw.user == "d")               //> res0: objsets.TweetSet = objsets.Empty@2b2d96f2{User: d
                                                  //| Text: d body [9]}objsets.Empty@3e110003
  set5.filter(tw => tw.user == "e")               //> res1: objsets.TweetSet = objsets.Empty@2adb1d4
  set5.filter(tw => tw.user == "a")               //> res2: objsets.TweetSet = objsets.Empty@4760a26f{User: a
                                                  //| Text: a body [20]}objsets.Empty@19484a05
  set4d.filter(tw => tw.user == "c")              //> res3: objsets.TweetSet = objsets.Empty@61542a75

  set5.mostRetweeted                              //> res4: objsets.Tweet = User: a
                                                  //| Text: a body [20]
  val e = new Tweet("e", "e body", 25)            //> e  : objsets.Tweet = User: e
                                                  //| Text: e body [25]
  val set6 = set5.incl(e)                         //> set6  : objsets.TweetSet = objsets.Empty@676bd8ea{User: a
                                                  //| Text: a body [20]}objsets.Empty@16bdb503{User: b
                                                  //| Text: b body [20]}objsets.Empty@6719dc16{User: c
                                                  //| Text: c body [7]}objsets.Empty@6766afb3{User: d
                                                  //| Text: d body [9]}objsets.Empty@5caf993e{User: e
                                                  //| Text: e body [25]}objsets.Empty@c75e4fc
  set6.mostRetweeted                              //> res5: objsets.Tweet = User: e
                                                  //| Text: e body [25]
  set6.descendingByRetweet.head                   //> res6: objsets.Tweet = User: e
                                                  //| Text: e body [25]

  GoogleVsApple.trending.foreach(println)         //> User: gizmodo
                                                  //| Text: iPhone 5's brain dissected. Guess what, it's made by Samsung. http://t
                                                  //| .co/wSyjvpDc [321]
                                                  //| User: gizmodo
                                                  //| Text: Warning: Security bug can wipe out your Android phone just by visiting
                                                  //|  a web page-not only limited to Samsung http://t.co/0y6vnOKw [290]
                                                  //| User: mashable
                                                  //| Text: Our iPhones Are Depleting the Earth's Resources [INFOGRAPHIC] http://t
                                                  //| .co/XnTLqe0p [205]
                                                  //| User: gizmodo
                                                  //| Text: The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp8
                                                  //| D [202]
                                                  //| User: mashable
                                                  //| Text: iPad 4 Has Carbon Fiber Body, Flexible Display [REPORT] http://t.co/Df
                                                  //| t5VoXD via @tabtimes [198]
                                                  //| User: gizmodo
                                                  //| Text: The definitive comparison of iOS 5 Google Maps vs iOS 6 Apple Maps in 
                                                  //| one single image: http://t.co/fTwTfVMy [191]
                                                  //| User: mashable
                                                  //| Text: iOS 6 Users Complain About Wi-Fi, Connectivity Issues - http://t.co/io
                                                  //| gRstNn [180]
                                                  //| User: CNET
                                                  //| Text: RT @CNETNews: Apple "fell short" with iOS 6 maps, and
                                                  //| Output exceeds cutoff limit.
}