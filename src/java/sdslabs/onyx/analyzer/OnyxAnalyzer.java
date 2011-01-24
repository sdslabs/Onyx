package sdslabs.onyx.analyzer;

class OnyxAnalyzer extends Analyzer{

  private TokenStream tkStream;
  private String name;
  private List<String> fieldName
  private List<String> fieldClass;
  private List<String> tokenizer;
  private List<List<Map<String,String>>> filterList;

  public OnyxAnalyzer(OnyxConfig config, String name){
    this.name = name;
    fieldName = new ArrayList<String>();
    fieldClass = new ArrayList<String>();
    filterList = new ArrayList<List<Map<String,String>>();
    ini(config);
  }
  
  public void ini(OnyxConfig config){
    config.chooseAnalyzer(name);
    for( int i = 0; i < config.numAnalyzerEntry(); i++){
      fieldName.add(config.getField(i)[0]);
      fieldClass.add(config.getField(i)[1]);
      tokenizer.add(i, config.getTokenizer(i));
      filterList.add(i, config.getFilters(i));
    }
  }

  public TokenStream tokenStream(String fieldName, Reader reader){
    iniOptions(fieldName, reader);  
    return tkStream;
  }

  private void iniOptions(String fieldName, Reader reader){
    int index = this.fieldName.indexOf(fieldName);
    passThroughTokenizer(reader, this.tokenizer.get(i));
    List<Map<String,String>> filters = filterList.get(index);
    for( int i = 0; i < filters.size(); i++){
      OnyxFilterFactory.filter(filters.get(i), tkStream);
    }
  }
  
  private void passThroughTokenizer(Reader reader, String tokenizer){
    try {
      Class<TokenStream> c = Class<TokenStream>.forName(tokenizer);
      java.lang.reflect.Constructor co = c.getConstructor(new Class[]{Reader.class});
      tkStream = co.newInstance(new Object[]{reader});
    }catch(Excception e){
      e.printStackTrace();
    }
  }

}
