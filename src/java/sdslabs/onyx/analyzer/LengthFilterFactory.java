package sdslabs.ony.analyzer;

public class LengthFilterFactory{
  public static TokenStream create(Map<String,String> params, TokenStream tkStream){
    int min = Integer.parseInt(params.get("min"));
    int max = Integer.parseInt(params.get("max"));
    return new LengthFilter(tkStream, min, max);
  }
}
