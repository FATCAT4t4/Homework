public class WordAnalyzerTesterBum
{
   public static void main(String[] args)    //changed Main to main for proper syntax, Java is case-sensitive
   {
      test("aardvark"); // expect: a
      test("roommate"); // expect: o (not m, o appears first)     //added more detail to comment
      test("matte"); // expect: t      //corrected comment, expects t because t is duplicate
      test("mate"); // expect 0 (no duplicates)
      test("test"); // expect: 0 (the t isn't repeating)
   }

   public static void test(String s)
   {
      WordAnalyzer wa = new WordAnalyzer(s);    //added new before WordAnalyzer(s) for proper syntax, must declare a new instance of the method
      char result = wa.firstRepeatedCharacter();
      if (result == 0)     //changed = to == for proper syntax, = is for setting something equal to while == is for comparing two values
         System.out.println("No repeated character.");
      else
         System.out.println("First repeated character = " + result);
   }
}