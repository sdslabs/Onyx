package sdslabs.onyx.analyzer;

public class PorterStemFilterFactory {

  public static TokenStream create(Map<String,String> params, TokenStream tkStream){
    return new PorterStemFilter(tkStream);
  }
}
