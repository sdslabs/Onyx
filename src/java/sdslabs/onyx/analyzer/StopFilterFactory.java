packsge sdslabs.onyx.analyzer;

public class StopFilterFactory {

  private static boolean enablePositonIncrement = false;
  private static boolean ignoreCase = true;

  public static TokenStream create( Map<String,String> params, TokenStream tkStream){
   
   if(params.containsKey("enablePositionIncrement")){
     if(params.get("enablePositionIcrement") == "true"){
       enablePositionIncrement = true;
     }
   }
   if(params.containsKey("ignoreCase") && params.get("ignoreCase") == "false"){
     ignoreCase = false;
   }
    
   FileInputStream fstream = new FileInputStream(params.get("stopWords"));
   DataInputStrem in = new DataInputStream(fstream);
   BufferedReader buf = new BufferedReader(new InputStreamReader(in));
   
   String stopWord;
   List<String> stopWords = new ArrayList<String>();
   while((stopWord = buf.readLine()) != null){
     stopWords.add(stopWord);
   }

   return new StopFilter(enablePositionIncrement, tkStream, StopFilter.makeStopSet(stopWords, ignoreCase), 
               ignoreCase);   
  }

}
