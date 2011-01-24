package sdslabs.onyx.analyzer;

class OnyxAnalyzer extends Analyzer{

  private TokenStream tkStream;
  private String name;
  private String fieldName;
  private String fieldClass;
  private String positionIncrementGap = 0;
  private String tokenizer;
  private List<HashMap<String,String>> filterList;
  private boolean initialized = false;
  private enum Filter {
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

  private enum Tokenizer {
    StandardTokenizer;
    CharTokenizer,
    KeywordTokenizer,
    LetterTokenizer,
    LowerCaseTokenizer,
    WhitesapceTokenizer,
    WikipediaTokenizer,
    SentenceTokenizer,
    NGramTokenizer,
    EdgeNGramTokenizer,
  }

  public OnyxAnalyzer(OnyxConfig config){
    tokenizer = config.get("tokenizer");      
    filterList = new ArrayList<HashMap<String,String>>();
  }

  public void addFilter(String filter, HashMap<String,String> params){
    params.put("filter", filter);
    filterList.add(params);
    initialized = false;
  }

  public void removeFilter(String  filter){
    for(int i = 0; i < filterList.size(); i++){
      if(filterList.get(i).get("filter") == filter){
        filterList.remove(i);
        break;
      }
    }
    initialized = false;
  }

  public void setTokenizer(String tokenizer){
    this.tokenizer = tokenizer;
    initialized = false;
  }

  public TokenStream tokenStream(String fieldName, Reader reader){
    iniOptions(reader);  
    return tkStream;
  }

  private void iniOptions(Reader reader){
    if( initialized == true)
      return;

    Tokenizer tokenizer = Tokenizer.valueof(tokenizer);
    switch(tokenizer){
      case StandardTokenizer: 
        tkStream = new StandardTokenizer(reader);
        break;
      case CharTokenizer: 
        tkStream = new CharTokenizer(reader);
        break;
      case KeywordTokenizer: 
        tkStream = new KeywordTokenizer(reader);
        break;
      case LetterTokenizer: 
        tkStream = new LetterTokenizer(reader);
        break;
      case LowerCaseTokenizer: 
        tkStream = new LowerCaseTokenizer(reader);
        break;
      case WhiteSpaceTokenizer: 
        tkStream = new WhiteSpaceTokenizer(reader);
        break;
      case WikipediaTokenizer: 
        tkStream = new WikipediaTokenizer(reader);
        break;
      case SentenceTokenizer: 
        tkStream = new SentenceTokenizer(reader);
        break;
      case NGramTokenizer: 
        tkStrean = new NGramTokenizer(reader);
        break;
      case EdgeNGramTokenizer:
        tkStream = new EdgeNGramTokenizer(reader);
        break;
      default:
         tkStream = new StandardTokenizer(reader);
         break;
    }

    for( int i = 0; i < filterList.size(); i++){
      Filter filter = Filter.valueOf(filterList.get(i).get("filter"));
      switch(filter){
        case ASCIIFoldingFilter:
          tkStream = new ASCIIFoldingFilter(tkStream);
          break;
        case BaseCharFilter:
          tkStream = new BaseCharFilter(tkStream);
          break;
        case CachingTokenFilter:
          tkStream = new CachingTokenFilter(tkStream);
          break;
        case CharFilter:
          tkStream = new CharFilter(tkStream);
          break;
        case LengthFilter:
          tkStream = new LengthFilter(tkStream);
          break;
        case LowerCaseFilter:
          tkStream = new LowerCaseFilter(tkStream);
          break;
        case MappingCharFilter:
          tkStream = new MappingCharFilter(tkStream);
          break;
        case PorterStemFilter:
          tkStream = new PorterStemFilter(tkStream);
          break;
        case StopFilter:
          tkStream = new StopFilter(tkStream);
          break;
        case TeeSinkTokenFilter:
          tkStream = new TeeSinkTokenFilter(tkStream);
          break;
        case TokenFilter:
          tkStream = new TokenFilter(tkStream);
          break;
        case KeywordMarkerFilter:
          tkStream = new KeywordMarkerFilter(tkStream);
          break;
        case PorterStemFilter:
          tkStream = new PorterStemFilter(tkStream);
          break;
        default:
          break;

      }
    }
    initialized = true;        
       
  }


}
