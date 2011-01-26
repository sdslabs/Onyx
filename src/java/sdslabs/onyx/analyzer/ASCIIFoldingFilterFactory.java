package sdslabs.onyx.analyzer;

public class ASCIIFoldingFilterFactory{

  public static TokenStream create(Map<String,String> params, TokenStream tkStream){
    return new ASCIIFoldingFilter(tkStream);
  }

}

