package sdslabs.onyx.analyzer;

class OnyxAnalyzer extends Analyzer{

  private TokenStream tkStream;
  private String name;
  private String fieldName;
  private String fieldClass;
  private String positionIncrementGap = 0;
  private String tokenizer;
  private List<HashMap<String,String>> filterList;
  public enum Filter {
      ASCIIFoldingFilter,
      BaseCharFilter,
      CachingTokenFilter,
      CharFilter,
      LengthFilter,
      LowerCaseFilter,
      MappingCharFilter,
      PorterStemFilter,
      StopFilter,
      TeeSinkTokenFilter,
      TokenFilter,
      KeywordMarkerFilter,
      PorterStemFilter
  };

  public OnyxAnalyzer(OnyxConfig config){
    tokenizer = config.get("tokenizer");      
    filterList = new ArrayList<HashMap<String,String>>();
  }

  public void addFilter(String filter, HashMap<String,String> params){
    params.put("filter", filter);
    filterList.add(params);
  }

  public void removeFilter(String  filter){

  }

  public void setTokenizer(String tokenizer){
    this.tokenizer = tokenizer;
  }

  public TokenStream tokenStream(String fieldName, Reader reader){
    iniOptions(reader);  
    return tkStream;
  }

  private void iniOptions(Reader reader){
    if(config.get("tokenizer") == "StandardTokenizer")
      tkStream = new StandardTokenizer(reader);
    
    for( int i = 0; i < filterList.size(); i++){
      Filter filter = Filter.valueOf(filterList.get(i).get("filter"));
      

            

      }
  }


}
