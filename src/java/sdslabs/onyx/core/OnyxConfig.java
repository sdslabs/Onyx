package sdslabs.onyx.core;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
  <index indexDir="  ">
  <analyzer name=" ">
    <field name=" " class=" " tokenizer=" ">
       <filter name="  " params=" "/filter>
    </field>
  </analyzer>
 </index>
 */

public class OnyxConfig {

  private List<String> analyzers;
  private List<List<String>> fieldList;
  private List<List<String>> fieldClass;
  private List<List<String>> tokenizer;
  private List<List<List<Map<String,String>>>> filters; 
  private int chosenAnalyzer = 0;
  private String indexDir;

  public OnyxConfig( File configFile){
    
    DocumentBuilderFactory dbf = new DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(configFile);
    doc.getDocumentElement().normalize();
    
    Node index = (Node) doc;
    NamedNodeMap indexAttr = index.getAttributes();
    this.indexDir = indexAttr.item(0).getValue();

    analyzers = new ArrayList<String>();
    fieldList = new ArrayList<List<String>>();
    fielsClass = new ArrayList<List<String>>();
    tokenizer = new ArrayList<List<String>>();
    filters - new ArrayList<List<List<Map<String,String>>>>();

    NodeList analyzerList = doc.getElementsByTagName("analyzer");
    for( int i = 0; i < analyzerList.getLength(); i++){
      //get the name of analyzer
      Node analyzer = analyzerList.item(i);
      NamedNodeMap analyzerAttr = analyzer.getAttributes();
      Node analyzerNameAttr = analyzerAttr.item(0);
      String analyzerName = analyzerNameAttr.getValue();
      analyzers.add(i, analyzerName);
      fieldList.add(i, new ArrayList<String>());
      fieldClass.add(i, new ArrayList<String>());
      tokenizer.add(i, new ArrayList<String>());
      filters.add(i, new ArrayList<List<Map<String,String>>>();

      //get fieldList
      NodeList fieldList = analyzer.getChildNodes();
      //iterate through fields
      for( int j = 0; j < fieldList.getLength(); j++){
        Node field = fieldList.item(j);
        //store field name field class and tokenizer
        NamedNodeMap fieldAttr = field.getAttributes();
        String fieldName;
        String fieldClassName;
        String fieldTokenizer;
        for( int l = 0; l < fieldAttr.getLength(); l++){
          if(fieldAttr.item(l).getName() == "name"){
            fieldName = fieldAttr.item(l).getValue();
          }else if(fieldAttr.item(l).getName() == "class"){
            fieldClassName = fieldAttr.item(l).getValue();
          }else if(fieldAttr.item(l).getName() == "tokenizer"){
            fieldTokenizer = fieldAttr.item(l).getValue();
          }
        }
        fieldList.get(i).add(j, fieldName);
        fieldClass.get(i).add(j, fieldClassName);
        tokenizer.get(i).add(j, fieldTokenizer);
        filters.get(i).add(j, new ArrayList<Map<String,String>>();
        
        //get filter list
        NodeList filterList = field.getChildNodes();
        for(int k = 0; k < filterList.getLength(); k++){
          Node filter = filterList.item(k);
          filters.get(i).get(j).add(k, new HashMap<String,String>());
          //store name and all the params about the filter
          NamedNodeMap filterAttr = filter.getAttributes();
          for( int l = 0; l < filterAttr.getLength(); l++){
            String param = filterAttr.item(l).getName();
            String paramVal = filterAttr.item(l).getValue();
            filters.get(i).get(j).get(k).put(param, paramVal);
          }
        }
      }
    }
  }


  public void chooseAnalyzer(String name){
    chosenAnalyzer = analyzers.indexOf(name);
  }

  public List<String>  getField(int i){
    List<String> result = new ArrayList<String>();
    result.add(0, fielsList.get(choseAnalyzer).get(i));
    result.add(1, fieldClass.get(choseAnalyzer).get(i));
    result.add(2, tokenizer.get(choseAnalyzer).get(i));
    return result;
  }

  public String getTokenizer(int i){
    return tokenizer.get(chosenAnalyzer).get(i);
  }

  public List<Map<String,String>> getFilters(int i){
    return filterList.get(chosenAnalyzer).get(i);
  }

  public String getIndexDir(){
    return this.indexDir;
  }

  public int numAnalyzer(){
    return analyzers.size();
  }

  public String getAnalyzer(int i){
   return analyzers.get(i);
  }

  
}
