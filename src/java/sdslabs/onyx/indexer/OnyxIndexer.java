package sdslabs.onyx.indexer;

public class OnyxIndexer {
  
  private OnyxConfig indexerConfig;
  private HashMap<String, String> standardAnalysis;
  private IndexWriter writer;
  private boolean compound;
  private OnyxDocumentDirectory dir;
  
  public OnyxIndexer(OnyxConfig config){
    
    indexerConfig = config;
    iniAnalysis();
    dir = FSDirectory.getDirectory(config.indexDir);
    writer = new IndexWriter(dir, new StandardAnalyzer(), true);
    
  }
  
  private void iniAnalysis(){
       
         
  }

  public boolean addMetaData(HashMap<String,String> metaData){

    if( dir == null ){
      return false;
    }

  }

  public void addDocument( OnyxDocument doc ){
    
    dir = new OnyxDocumentDirectory();
    dir.addDocument(doc);
    
  }

  public void addDocuments(OnyxDocumentDirectory dir){
    this.dir = dir;
  }

  public void index(){
    
    writer.setUseCompoundFie(compound);
    for( OnyxDocument doc = dir.iterateDocument(); doc != null; doc = dir.iterateDocument()){
      writer.addDocument(doc.getDocument(), getAnalyzer(doc.getType()));
    }
    writer.optimize();
    writer.close();

  }

  public void customizeAnalysis(HashMap<String, String> config){
    sdf
  }
 
  private Analyzer getAnalyzer( String type ){
    sdf   
  }
  
}
