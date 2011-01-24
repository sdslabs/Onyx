package sdslabs.onyx.analyzer;

public class OnyxFilterFactory {
  
 enum FilterFactory {
   ASCIIFoldingFilterFactory,
   CachingTokenFilterFactory,
   CollationKeyFilterFactory,
   DelimitedPayloadTokenFilterFactory,
   EdgeNGramTokenFilterFactory,
   ElisionFilterFactory,
   LengthFilterFactory,
   LowerCaseFilterFactory,
   NGramTokenFilterFactory,
   NumericPayloadTokenFilterFactory,
   PorterStemFilterFactory,
   PositionS=FilterFactory,
   ReverseStringFilterFactory,
   ShingleFilterFactory,
   SnowballflterFactory,
   StandardFilterFactory,
   StopFilterFactory,
   SynonymTokenFilterFactory,
   TeeSinkTokenFilterFactory,
   TokenOffsetPayloadTokenFilterFactory,
   TypeAsPayLoadTokenFilterFactory,
   WordTokenFilterFactory
 }

 public static TokenStream filter(Map<String,String> params, TokenStream tkStream){
   FilterFactory filterfac = FilterFactory.valueOf(params.get("name"));
   switch(filterfac){
     case ASCIIFoldingFilterFactory:
       return ASCIIFoldingFilterFactory.create(params, tkStream);
     case CachingTokenFilterFactory:
       return CachingTokenFilterFactory.create(params, tkStream);
     case CollationKeyFilterFactory:
       return CollationKeyFilterFactory.create(params, tkStream);
     case DelimitedPayloadTokenFilterFactory:
       return DelimitedPayloadTokenFilterFactory.create(params, tkStream);
     case EdgeNGramTokenFilterFacctory:
       return  EdgeNGramTokenFilterFacctory(params, tkStream);
     case ElisionFilterFactory:
       return ElisionFilterFactory(params, tkStream);
     case LengthFilterFactory:
       return LengthFilterFactory(params, tkStream);
     case LowerCaseFilterFactory:
       return LowerCaseFilterFactory(params, tkStream);
     case NGramTokenFilterFactory:
       return NGramTokenFilterFactory(params, tkStream);
     case NumericPayloadTokenFilterFactory:
       return NumericPayloadTokenFilerFactory(params, tkStream);
     case PorterStemFilterFactory:
       return PorterStemFilterFactory(params, tkStream);
     case PositionS=FilterFactory:
       return PositionFilterFactory(params, tkStream);
     case ReverseStringFilterFactory:
       return ReverseStringFilterFactory(params, tkStream);
     case ShingleFilterFactory:
       return ShingleFilterFactory(params, tkStream);
     case SnowballFilterFactory:
       return SnowballFilterFactory(params, tkStream);
     case StandardFilterFactory:
       return StandardFilterFactory(params, tkStream);
     case StopFilterFactory:
       return StopFilterFactory(params, tkStream);
     case SynonymTokenFilterFactory:
       return SynonymTokenFilterFactory(params, tkStream);
     case TeeSinkTokenFilterFactory:
       return TeeSinkTokenFilterFactory(params, tkStream);
     case TokenOffsetPayloadTokenFilterFactory:
       return TokenOffsetPayloadTokenFilterFactory(params, tkStream);
     case TypeAsPayLoadTokenFilterFactory:
       return TypePayloadTokenFilterFactor(params, tkStream);
     case WordTokenFilterFactory:
       return WordTokenFilterFactory(params, tkStream);
   }    
 }
  
}
