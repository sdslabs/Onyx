package sdslabs.onyx.analyzer;

public class WordTokenFilterFactory {
  public static TokenStream create(Map<String,String> params, TokenStream tkStream){
    return new WordTokenFilter(tkStream);
  }
}
